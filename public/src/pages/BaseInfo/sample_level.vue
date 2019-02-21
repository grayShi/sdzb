<template>
  <page-main-body title="样品等级维护" :loading="loading">

    <!--<el-form :model="newData" label-width="140px">-->
      <!--<el-form-item label="样品等级名称">-->
        <!--<el-input v-model="newData.sample_level"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">保存</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 style="width: 100%" :need-index="true"
                 :addable="true" @on-add="addLevel"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :rowSelect="true" @select-row="getSelectRow"
    >
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="viewLevel(props.prop.id,'edit')">编辑</el-button>
        <!--<el-button size="mini" type="danger" style="margin-left: 10px" @click="viewLevel(props.prop.id,'delete')">删除</el-button>-->
      </template>
    </light-table>

    <el-dialog :visible.sync="showDialog"
               center
               width="50%"
               @close="closeDialog"
               :title="dialogForm.title">
      <el-form ref="dialogForm" :model="dialogForm" label-width="100px" :rules="dialogRules">
        <el-row>
          <el-col :span="12">
            <el-form-item label="样品等级" prop="detail">
              <el-input v-model="dialogForm.detail" :disabled="dialogForm.isDelete"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer">
        <el-button type="primary" v-if="!dialogForm.isDelete"  @click="saveLevel">保存</el-button>
        <!--<el-button type="danger" v-if="dialogForm.isDelete"  @click="showDialog=false">删除</el-button>-->
        <el-button @click="showDialog=false">取消</el-button>
      </span>
    </el-dialog>
  </page-main-body>
</template>

<script>

import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.post('', condition);
const getLevelList = (params) => axios.get('/api/dict/list/sample_level', {params});
const addNewLevel = (payload) => axios.post('/api/dict/sample_level', payload);
const getLevelById = (id) => axios.get(`/api/dict/${id}`);
// const modifyLevel = (id) => axios.post('/api/level', {data: id});
const deleteLevel = (id) => axios.delete('/api/dict', {data: id});
// const getInspectLevel = () => axios.post('/api/level');

export default {
  name: 'SampleLevel',
  data () {
    return {
      loading: false,
      dialogRules: {// 必填，是否合法
        // departName: [this.requiredInput('部门名称')],
      },
      column_desc: [
        {
          prop: 'detail',
          label: '样品等级'
        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      // table_data: [
      //   {
      //     detail: 'uuu'
      //   }
      // ],
      selectRow: [],
      showDialog: false,
      dialogForm: {
        id: '',
        isDelete: false,
        title: '添加样品等级',
        detail: ''
      }
    };
  },
  // mounted () {
  //   getInspectLevel().then(data => {
  //     if (data.data.code === '000') {
  //       this.showDialog = false;
  //     }
  //   });
  // },
  methods: {
    doQuery (searchCondition, pageIndex, pageSize) {
      this.loading = true;
      return getLevelList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    addLevel () {
      this.showDialog = true;
    },
    viewLevel (id, action) {
      this.loading = true;
      getLevelById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            id: data.data.datas[0].id,
            isDelete: false,
            title: '编辑样品等级',
            detail: data.data.datas[0].detail
          };
        } else {
          this.onAlertError('搜索失败');
        }
      // if (action === 'delete') {
      //   this.dialogForm.title = '删除样品等级';
      //   this.dialogForm.isDelete = true;
      // }
      });
    },
    closeDialog () {
      this.dialogForm = {
        id: '',
        isDelete: false,
        title: '添加样品等级',
        detail: ''
      };
    },
    saveLevel () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              id: this.dialogForm.id,
              detail: this.dialogForm.detail
            };
            addNewLevel(payload).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
                // this.dialogForm = data.data.datas;
                this.showDialog = false;
                this.onAlertSuccess('修改成功');
                this.$refs.table.doRemoteMethod();
              } else {
                this.onAlertError('修改失败');
              }
            });
          } else {
            const payload = {
              detail: this.dialogForm.detail
            };
            addNewLevel(payload).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
                this.$refs.dialogForm.resetFields();
                this.showDialog = false;
                this.onAlertSuccess('保存成功');
                this.$refs.table.doRemoteMethod();
              } else {
                this.onAlertError('保存失败1');
              }
            }).catch(err => {
              this.loading = false;
              console.log(err);
              this.onAlertError('保存失败');
            });
          }
        } else {
          this.onAlertError('请确认输入');
        }
      });
    },
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        deleteLevel({id: this.selectRow}).then(data => {
          if (data.data.code === '000') {
            this.onAlertSuccess('删除成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    }
  }
};
</script>

<style scoped>
</style>
