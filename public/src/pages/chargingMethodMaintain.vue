<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table ref="table"
            :data="searchData" @on-search="searchTable"
            :columns="columns"
            :addable="true" @on-add="addType"
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
              <el-form-item label="收款方式名称" prop="methodName">
                <el-input v-model="dialogTypeForm.methodName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveChargingMethod">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchChargingMethod = (condition) => axios.post('/api/chargingMethod', condition);
  const addChargingMethod = (chargingMethodForm) => axios.post('/api/chargingMethod', chargingMethodForm);
  const getChargingMethodById = (id) => axios.get('/api/chargingMethod', id);
  const modifyChargingMethod = (chargingMethodForm) => axios.post('/api/chargingMethod', chargingMethodForm);
  const deleteChargingMethodById = (id) => axios.delete('/api/chargingMethod', id);


  export default {
    name: "chargingMethodMaintain",
    data () {
      return {
        loading:false,
        title: '收款方式维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'methodName',
            label: '收款方式名称',
            width: '200'
          },
          {
            prop: 'operation',
            label: '操作',
            type: {
              operate: true
            }
          }
        ],
        searchData:[
          {
            id:1,
            number:1,
            methodName:'现金'
          }
        ],
        dialogTypeForm:{
          title:'添加收款方式',
          isDelete: false,
          methodName:''
        },
        showDialogType: false,
        dialogTypeRules: {

        },
        selectRow:[]
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchChargingMethod({condition}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
          } else {
            this.onAlertError('搜索失败');
          }
        });
      },
      viewTypeDetail(id, action) {
        this.loading = true;
        getChargingMethodById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            this.showDialogType = true;
            /*this.dialogTypeForm = {
              id: 1,
              title:'修改收款方式',
              number:1,
              methodName:'现金'
            };*/
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
          title: '添加收款方式',
          isDelete: false,
          methodName: ''
        };
      },
      saveChargingMethod () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyChargingMethod({chargingMethodForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addChargingMethod({chargingMethodForm: this.dialogTypeForm}).then(data => {
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
      },
      goToDelete () {
        if (this.selectRow.length === 0) {
          this.onAlertError('选中数量为0条');
        } else {
          this.loading = true;
          deleteChargingMethodById({id: this.selectRow}).then(data => {
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
      }
    }
  }
</script>

<style scoped>

</style>
