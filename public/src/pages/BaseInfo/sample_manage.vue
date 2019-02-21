<template>
  <page-main-body title="样品单号维护" :loading="loading">
    <!--<el-form :model="newSample" label-width="80px">-->
      <!--<el-form-item label="样品名称">-->
        <!--<el-input v-model="newSample.name"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="样品编号">-->
        <!--<el-input v-model="newSample.short"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">添加</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 @on-search="searchTable"
                 style="width: 100%" :need-index="true"
                 :addable="true" @on-add="addSample"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :rowSelect="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="viewSampleDetail(props.prop.id,'edit')">编辑</el-button>
        <!--<el-button size="mini" type="danger" style="margin-left: 10px" @click="viewSampleDetail(props.prop.id,'delete')">删除</el-button>-->
      </template>
    </light-table>
    <el-dialog :visible.sync="showDialog"
               width="50%"
               center
               :title="dialogForm.title"
               @close="closeDialog">
      <el-form ref="dialogForm" :model="dialogForm" label-width="100px" :rules="dialogRules">
        <el-row>
          <el-col :span="12">
            <el-form-item label="样品名称" prop="sampleName">
            <el-input v-model="dialogForm.sampleName" :disabled="dialogForm.isDelete">
            </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="样品编号" prop="sampleNo">
            <el-input v-model="dialogForm.sampleNo" :disabled="dialogForm.isDelete">
            </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer">
        <el-button v-if="!dialogForm.isDelete" type="primary" @click="saveManage">保存</el-button>
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
const getSampleManageList = (params) => axios.get('/api/sample_order', {params});
const addNewSampleManage = (payload) => axios.post('/api/sample_order', payload);
const getManageById = (id) => axios.get(`/api/sample_order/${id}`);
// const modifyManage = (id) => axios.post('/api/manage', {data: id});
const deleteManage = (id) => axios.delete('/api/sample_order', {data: id});
// const getInspectManage = () => axios.post('/api/manage');

export default {
  name: 'SampleManage',
  data () {
    return {
      loading: false,
      column_desc: [
        {
          prop: 'sampleName',
          label: '样品名称'

        },
        {
          prop: 'sampleNo',
          label: '样品编号'

        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      table_data: [
        {
          sampleName: 'abc'
        }
      ],
      dialogRules: {// 必填，是否合法
        // departName: [this.requiredInput('部门名称')],
      },
      selectRow: [],
      // newSample: {
      //   name: '',
      //   number: ''
      // },
      dialogForm: {
        id: '',
        isDelete: false,
        sampleName: '',
        sampleNo: '',
        title: '添加样品单号信息'
      },
      showDialog: false
    };
  },
  mounted () {
    // getInspectManage().then(data => {
    //   if (data.data.code === '000') {
    //     this.showDialog = false;
    //   }
    // });
  },
  methods: {
    doQuery (searchCondition, pageNumber, pageSize) {
      return getSampleManageList({ searchCondition, pageNumber, pageSize }).then(data => {
        this.loading = true;
        if (data.data.code === '000') {
          this.loading = false;
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    viewSampleDetail (id, action) {
      this.loading = true;
      getManageById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            id: data.data.datas[0].id,
            sampleName: data.data.datas[0].sampleName,
            sampleNo: data.data.datas[0].sampleNo,
            title: '样品单号信息编辑'
          };
        } else {
          this.onAlertError('搜索失败');
        }
        // if (action === 'delete') {
        //   this.dialogForm.isDelete = true;
        //   this.dialogForm.title = '删除样品单号信息';
        // }
      });
    },
    closeDialog () {
      this.dialogForm = {
        id: '',
        isDelete: false,
        sampleName: '',
        sampleNo: '',
        title: '添加样品单号信息'
      };
    },
    addSample () {
      this.showDialog = true;
    },
    saveManage () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              sampleName: this.dialogForm.sampleName,
              sampleNo: this.dialogForm.sampleNo,
              id: this.dialogForm.id
            };
            addNewSampleManage(payload).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
              //  this.dialogForm = data.data.datas;
                this.showDialog = false;
                this.onAlertSuccess('修改成功');
                this.$refs.table.doRemoteMethod();
              } else {
                this.onAlertError('修改失败');
                //return this.formatGetTableData(data.data.datas);
              }
            });
          } else {
            const payload = {
              sampleName: this.dialogForm.sampleName,
              sampleNo: this.dialogForm.sampleNo
              // id: this.dialogForm.id
            };
            addNewSampleManage(payload).then(data => {
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
        deleteManage({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.loading = false;
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
