<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table :data="searchData" :columns="columns"
                       @on-search="searchTable" :addable="true"
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
              <el-form-item label="委托单位名称" prop="name">
                <el-input v-model="dialogTypeForm.name" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托单位地址" prop="address">
                <el-input v-model="dialogTypeForm.address" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="委托单位邮编" prop="zipCode">
                <el-input v-model="dialogTypeForm.zipCode" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托单位电话" prop="telephone">
                <el-input v-model="dialogTypeForm.telephone" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="委托单位联系人" prop="person">
                <el-input v-model="dialogTypeForm.person" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
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
  const searchUnit = (condition) => axios.post('/api/client', condition);
  const addUnit = (name) => axios.post('/api/client', name);
  const getUnitById = (id) => axios.get('/api/client', id);
  const modifyUnit = (unitForm) => axios.post('/api/client', unitForm);
  const deleteUnit = (id) => axios.delete('/api/client', id);

  export default {
    name: "clientUnitMaintain",
    data () {
      return {
        loading: false,
        title: '委托单位维护',
        columns: [
          {
            prop: 'name',
            label: '委托单位名称',
            width: '150'
          },
          {
            prop: 'address',
            label: '委托单位地址',
            width: '200'
          },
          {
            prop: 'zipCode',
            label: '委托单位邮编',
          },
          {
            prop: 'telephone',
            label: '委托单位电话',
            width: '100'
          },
          {
            prop: 'person',
            label: '委托单位联系人',
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
            name:'淄博市质量技术监督局',
            address:'淄博市张店区共青团西路98号',
            zipCode:'255063',
            telephone:'2315945',
            person:'任建崇'
          }
        ],
        dialogTypeForm: {
          title: '添加委托单位',
          isDelete: false,
          name:'',
          address:'',
          zipCode:'',
          telephone:'',
          person:''
        },
        showDialogType: false,
        dialogTypeRules: {
          name: [this.requiredInput('委托单位名称')],
        }
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
          deleteUnit({id: this.selectRow}).then(data => {
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
              title: '修改委托单位',
              name:'淄博市质量技术监督局',
              address:'淄博市张店区共青团西路98号',
              zipCode:'255063',
              telephone:'2315945',
              person:'任建崇'
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
          title: '添加委托单位',
          isDelete: false,
          name:'',
          address:'',
          zipCode:'',
          telephone:'',
          person:''
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
