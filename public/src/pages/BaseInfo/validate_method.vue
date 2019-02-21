<template>
  <page-main-body title="检验类型维护" :loading="loading">
    <el-row style="width: 100%">
    <!--<el-form :model="newData" label-width="140px">-->
      <!--<el-form-item label="检验类型名称">-->
        <!--<el-input v-model="newData.name"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="类型对应模板">-->
        <!--<el-input type="file" v-model="newData.templatefile"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">保存</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 :need-index="true"
                 :addable="true" @on-add="addVali"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :row-select="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="viewValidate(props.prop.id,'edit')">编辑</el-button>
        <!--<el-button size="mini" type="danger" style="margin-left: 10px" @click="viewValidate(props.prop.id,'delete')">删除</el-button>-->
      </template>
    </light-table>
      <el-dialog :visible.sync="showDialog"
                 center
                 :title="dialogForm.title"
                 width="50%"
                 @close="closeDialog">
        <el-form label-width="100px" ref="dialogForm" :model="dialogForm" :rules="dialogRules">
          <el-row>
            <el-col :span="12">
              <el-form-item label="类型名称" prop="dict">
                <el-input v-model="dialogForm.dict" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="类型模板路径" prop="detail">
                <el-input v-model="dialogForm.detail" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer">
        <el-button type="primary" v-if="!dialogForm.isDelete"  @click="saveVali">保存</el-button>
        <!--<el-button type="danger" v-if="dialogForm.isDelete"  @click="showDialog=false">删除</el-button>-->
        <el-button @click="showDialog=false">取消</el-button>
      </span>
      </el-dialog>
    </el-row>
  </page-main-body>
</template>

<script>

import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.Valit('', condition);
const getValiList = (params) => axios.get('/api/dict/list/check_type', {params});
const addNewVali = (payload) => axios.post('/api/dict/check_type', payload);
const getValiById = (id) => axios.get(`/api/dict/${id}`);
// const modifyVali = (id) => axios.post('/api/vali', {data: id});
const deleteVali = (id) => axios.delete('/api/dict', {data: id});
// const getInspectVali = () => axios.post('/api/vali');

export default {
  name: 'ValidateMethod',
  data () {
    return {
      loading: false,
      selectRow: [],
      dialogRules: {},
      column_desc: [
        {
          prop: 'dict',
          label: '类型名称'

        },
        {
          prop: 'detail',
          label: '类型模板路径'
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
      //     dict: 'ad',
      //     detail: 'qwe'
      //   }
      // ],
      showDialog: false,
      dialogForm: {
        id: '',
        title: '添加检验类型',
        isDelete: false,
        dict: '',
        detail: ''
      }
    };
  },
  // mounted () {
  //   getInspectVali().then(data => {
  //     if (data.data.code === '000') {
  //       this.showDialog = false;
  //     }
  //   });
  // },
  methods: {
    addVali () {
      this.showDialog = true;
    },
    doQuery (searchCondition, pageIndex, pageSize) {
      this.loading = true;
      return getValiList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    viewValidate (id, action) {
      this.loading = true;
      getValiById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            title: '编辑检验类型',
            id: data.data.datas[0].id,
            isDelete: false,
            dict: data.data.datas[0].dict,
            detail: data.data.datas[0].detail
          };
        } else {
          this.onAlertError('搜索失败');
        }
      });

      // if (action === 'delete') {
      //   this.dialogForm.isDelete = true;
      //   this.dialogForm.title = '删除检验类型';
      // }
    },
    closeDialog () {
      this.dialogForm = {
        title: '添加检验类型',
        isDelete: false,
        dict: '',
        detail: ''
      };
    },
    saveVali () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              id: this.dialogForm.id,
              dict: this.dialogForm.dict,
              detail: this.dialogForm.detail
            };
            addNewVali(payload).then(data => {
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
              dict: this.dialogForm.dict,
              detail: this.dialogForm.detail
            };
            addNewVali(payload).then(data => {
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
        deleteVali({id: this.selectRow}).then(data => {
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
