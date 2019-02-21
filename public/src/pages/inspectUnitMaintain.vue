<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table :data="searchData" :columns="columns"
                       :addable="true" @on-add="addType"
                       style="width: 100%" @on-search="searchTable"
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
            <el-col :span="8">
              <el-form-item label="检验单位名称" prop="unitName">
                <el-input v-model="dialogTypeForm.unitName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="16">
              <el-form-item label="检验单位英文名" prop="unitNameEnglish">
                <el-input v-model="dialogTypeForm.unitNameEnglish" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="检验单位类型" prop="unitType">
                <el-input v-model="dialogTypeForm.unitType" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveUnit">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  import _ from 'lodash';
  const deleteUnitById = (id) => axios.delete('/api/insUnit', id);
  const searchUnit = (condition) => axios.post('/api/insUnit', condition);
  const addUnit = (unitForm) => axios.post('/api/insUnit', unitForm);
  const getUnitById = (id) => axios.get('/api/insUnit', id);
  const modifyUnit = (unitForm) => axios.post('/api/insUnit', unitForm);
  export default {
    name: "inspectUnitMaintain",
    data () {
      return {
        loading: false,
        title: '检验单位维护',
        columns: [
          {
            prop: 'unitName',
            label: '检验单位名称',
            width: '200',
            type:{
              linkable: true,
              linkUrl:(row)=>{
                return '/#/inspectUnitSymbol'
              }
            }
          },
          {
            prop: 'unitNameEnglish',
            label: '检验单位英文名',
            width: '440'
          },
          {
            prop: 'unitType',
            label: '检验单位类型'
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
            unitName: '淄博市产品质量监督检验所',
            unitNameEnglish: 'Zibo Institute of Product Quality Supervision & Inspection',
            unitType: '淄质检'
          }
        ],
        dialogTypeForm: {
          title: '添加检验单位',
          isDelete: false,
          unitName:'',
          unitNameEnglish:'',
          unitType:''
        },
        showDialogType: false,
        dialogTypeRules: {
          unitName: [this.requiredInput('检验单位名称')]
        },
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchUnit({condition}).then(data => {
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
          deleteUnitById({id: this.selectRow}).then(data => {
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
        getUnitById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            /*this.dialogTypeForm = {
              title: '修改检验单位',
              unitName: '淄博市产品质量监督检验所',
              unitNameEnglish: 'Zibo Institute of Product Quality Supervision & Inspection',
              unitType: '淄质检'
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
          title: '添加检验单位',
          isDelete: false,
          unitName:'',
          unitNameEnglish:'',
          unitType:''
        };
      },
      saveUnit () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyUnit({unitForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addUnit({unitForm: this.dialogTypeForm}).then(data => {
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
