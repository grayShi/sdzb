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
              <el-form-item label="收款单位名称" prop="unitName">
                <el-input v-model="dialogTypeForm.unitName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveChargingUnit">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchChargingUnit = (condition) => axios.post('/api/chargingUnit', condition);
  const addChargingUnit = (chargingUnitForm) => axios.post('/api/chargingUnit', chargingUnitForm);
  const getChargingUnitById = (id) => axios.get('/api/chargingUnit', id);
  const modifyChargingUnit = (chargingUnitForm) => axios.post('/api/chargingUnit', chargingUnitForm);
  const deleteChargingUnitById = (id) => axios.delete('/api/chargingUnit', id);


  export default {
    name: "chargingUnitMaintain",
    data () {
      return {
        loading: false,
        title: '收款单位维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'unitName',
            label: '收款单位名称',
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
            unitName:'市质检所'
          }
        ],
        dialogTypeForm: {
          title: '添加收款单位',
          isDelete: false,
          unitName:''
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
        searchChargingUnit({condition}).then(data => {
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
        getChargingUnitById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            this.showDialogType = true;
            /*this.dialogTypeForm = {
              id: 1,
              title:'修改收款单位',
              number:1,
              unitName:'市质检所'
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
          title: '添加收款单位',
          isDelete: false,
          unitName: ''
        };
      },
      saveChargingUnit () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyChargingUnit({chargingUnitForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addChargingUnit({chargingUnitForm: this.dialogTypeForm}).then(data => {
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
          deleteChargingUnitById({id: this.selectRow}).then(data => {
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
