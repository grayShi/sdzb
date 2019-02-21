<template>
  <page-main-body title="样品抽样地点维护" :loading="loading">
    <!--<el-form :model="newData" label-width="140px">-->
      <!--<el-form-item label="样品等级名称">-->
        <!--<el-input v-model="newData.pos"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">添加</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 :need-index="true" :addable="true" @on-add="addPos"
                 style="width: 100%"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :row-select="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button type="primary" @click="viewPos(props.prop.id,'edit')" size="mini">编辑</el-button>
        <!--<el-button type="danger" @click="viewPos(props.prop.id,'delete')" size="mini">删除</el-button>-->
      </template>
    </light-table>
    <el-dialog :visible.sync="showDialog"
               :title="dialogForm.title"
               center
               width="50%"
               @close="closeDialog">
      <el-form ref="dialogForm" :model="dialogForm" label-width="100px" :rules="dialogRules">
        <el-row>
          <el-col :span="12">
            <el-form-item label="样品抽样地点" prop="detail">
              <el-input v-model="dialogForm.detail" :disabled="dialogForm.isDelete"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer">
        <el-button v-if="!dialogForm.isDelete" type="primary" @click="savePos">保存</el-button>
        <!--<el-button v-if="dialogForm.isDelete" type="danger" @click="showDialog=false">删除</el-button>-->
        <el-button @click="showDialog=false">取消</el-button>
      </span>
    </el-dialog>
  </page-main-body>
</template>

<script>

import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.post('', condition);
const getPosList = (params) => axios.get('/api/dict/list/sample_place', {params});
const addNewPos = (payload) => axios.post('/api/dict/sample_place', payload);
const getPosById = (id) => axios.get(`/api/dict/${id}`);
// const modifyPos = (id) => axios.post('/api/pos', {data: id});
const deletePos = (id) => axios.delete('/api/dict', {data: id});
// const getInspectPos = () => axios.post('/api/pos');

export default {
  name: 'SamplingPos',
  data () {
    return {
      loading: false,
      selectRow: [],
      column_desc: [
        {
          prop: 'detail',
          label: '样品抽样地点'
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
      //     detail: 'abc'
      //   }
      // ],
      // newData: {
      //   pos: ''
      // },
      showDialog: false,
      dialogRules: {// 必填，是否合法
        // departName: [this.requiredInput('部门名称')],
      },
      dialogForm: {
        id: '',
        detail: '',
        isDelete: false,
        title: '添加样品抽样地点'
      }
    };
  },
  // mounted () {
  //   getInspectPos().then(data => {
  //     if (data.data.code === '000') {
  //       this.showDialog = false;
  //     }
  //   });
  // },
  methods: {
    addPos () {
      this.showDialog = true;
    },
    doQuery (searchCondition, pageIndex, pageSize) {
      this.loading = true;
      return getPosList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    viewPos (id, action) {
      this.loading = true;
      getPosById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            id: data.data.datas[0].id,
            detail: data.data.datas[0].detail,
            title: '编辑样品抽样地点'
          };
        } else {
          this.onAlertError('搜索失败');
        }
      });

      // if (action === 'delete') {
      //   this.dialogForm.title = '删除样品抽样地点';
      //   this.dialogForm.isDelete = true;
      // }
    },
    closeDialog () {
      this.dialogForm = {
        isDelete: false,
        detail: '',
        id: '',
        title: '添加样品抽样地点'};
    },
    savePos () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              id: this.dialogForm.id,
              detail: this.dialogForm.detail
            };
            addNewPos(payload).then(data => {
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
            addNewPos(payload).then(data => {
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
        this.loading = true;
        deletePos({id: this.selectRow}).then(data => {
          this.loading = false;
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
