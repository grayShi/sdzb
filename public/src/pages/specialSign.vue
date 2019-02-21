<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width : 90%">
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
              <el-form-item label="特殊符号" prop="sign">
                <el-input v-model="dialogTypeForm.sign" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveSpecialSign">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchSpecialSign = (condition) => axios.post('/api/specialSign', condition);
  const addSpecialSign = (specialSignForm) => axios.post('/api/specialSign', specialSignForm);
  const getSpecialSignById = (id) => axios.get('/api/specialSign', id);
  const modifySpecialSign = (specialSignForm) => axios.post('/api/specialSign', specialSignForm);
  const deleteSpecialSignById = (id) => axios.delete('/api/specialSign', id);


  export default {
    name: "specialSign",
    data () {
      return {
        loading: false,
        title: '特殊符号维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'sign',
            label: '特殊符号',
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
            sign:'±'
          }
        ],
        dialogTypeForm: {
          title: '添加特殊符号',
          isDelete: false,
          sign:''
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
        searchSpecialSign({condition}).then(data => {
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
        getSpecialSignById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            this.showDialogType = true;
            /*this.dialogTypeForm = {
              id: 1,
              title:'修改特殊符号',
              number:1,
              sign:'±'
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
          title: '添加特殊符号',
          isDelete: false,
          sign: ''
        };
      },
      saveSpecialSign () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifySpecialSign({specialSignForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addSpecialSign({specialSignForm: this.dialogTypeForm}).then(data => {
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
          deleteSpecialSignById({id: this.selectRow}).then(data => {
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
