<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table :data="searchData" @on-search="searchTable"
                       :columns="columns" :addable="true"
                       @on-add="addType" style="width: 100%"
                       :deleteable="true" @on-delete="goToDelete"
                       :rowSelect="true" @select-row="getSelectRow">
            <template slot="operation" slot-scope="props">
              <el-button size="mini" @click="viewTypeDetail(props.prop.id,'edit')">编辑</el-button>
            </template>
          </light-table>
        </el-col>
      </el-row>
      <el-dialog
        :title="dialogTypeForm.title"
        :visible.sync="showDialogType"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogTypeClose"
        center>
        <el-form :model="dialogTypeForm" :rules="dialogTypeRules" ref="dialogTypeForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品状态名称" prop="statusName">
                <el-input v-model="dialogTypeForm.statusName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveStatus">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
import axios from 'axios';
const searchStatus = (condition) => axios.post('/api/sampleStatus', condition);
const addStatus = (statusForm) => axios.post('/api/sampleStatus', statusForm);
const getStatusById = (id) => axios.get('/api/sampleStatus', id);
const modifyStatus = (statusForm) => axios.post('/api/sampleStatus', statusForm);
const deleteStatus = (id) => axios.delete('/api/sampleStatus', id);


  export default {
    name: "sampleStatusMaintain",
    data () {
      return {
        loading: false,
        title: '样品状态维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'statusName',
            label: '样品状态',
            width: '300'
          },
          {
            prop: 'operation',
            label: '操作',
            type: {
              operate: true
            }
          }
        ],
        selectRow: [],
        searchData:[
          {
            id:1,
            number:1,
            statusName: '破碎'
          }
        ],
        dialogTypeForm: {
          title: '添加样品状态',
          isDelete: false,
          statusName:''
        },
        showDialogType: false,
        dialogTypeRules: {
          statusName: [this.requiredInput('样品状态名称')]
        }
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchStatus({condition}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
          } else {
            this.onAlertError('搜索失败');
          }
        });
      },
      goToDelete () {
        if (this.selectRow.length === 0) {
          this.onAlertError('选中数量为0条');
        } else {
          this.loading = true;
          deleteStatus({id: this.selectRow}).then(data => {
            this.loading = false;
            if (data.data.code === '000') {
              this.onAlertError('删除成功');
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
      },
      viewTypeDetail(id, action) {
        this.loading = true;
        getStatusById({id}).then(data => {
            this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            /*this.dialogTypeForm = {
              title: '修改样品状态',
              statusName: '破碎'
            };*/
            this.showDialogType = true;
          } else {
            this.onAlertError('搜索失败');
          }
        });
      },
      addType() {
        this.showDialogType = true;
      },
      dialogTypeClose() {
        this.dialogTypeForm = {
          title: '添加样品状态',
          isDelete: false,
          statusName: ''
        };
      },
      saveStatus () {
        this.$refs.dialogTypeForm.validate((valid) => {//表单验证，必填字段是否填好
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyStatus({statusForm: this.dialogTypeForm}).then(data => {//更改
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addStatus({statusForm: this.dialogTypeForm}).then(data => {
                this.loading = false;
                if (data.data.code === '000') {
                  this.showDialogType = false;
                  this.onAlertSuccess('保存成功');
                } else {
                  this.onAlertError('保存失败');
                }
              });
            }
          } else {
            this.onAlertError('请确认输入');
          }
        });
      }
    }
  }
</script>

<style scoped>

</style>
