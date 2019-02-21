<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
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
              <el-form-item label="样品处理方式" prop="handleMethod">
                <el-select v-model="dialogTypeForm.handleMethod" :disabled="dialogTypeForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in handleMethodList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveHandle">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchHandle = (condition) => axios.post('/api/handle', condition);
  const addHandle = (handleForm) => axios.post('/api/handle', handleForm);
  const getHandleById = (id) => axios.get('/api/handle', id);
  const modifyHandle = (handleForm) => axios.post('/api/handle', handleForm);
  const deleteHandle = (id) => axios.delete('/api/handle', id);

  export default {
    name: "sampleHandleMaintain",
    data () {
      return {
        loading: false,
        title: '样品处理方式维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'handleMethod',
            label: '样品处理方式',
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
        searchData:[
          {
            id:1,
            number:1,
            handleMethod: '退样'
          }
        ],
        dialogTypeForm: {
          title: '添加样品处理方式',
          isDelete: false,
          handleMethod:''
        },
        showDialogType: false,
        dialogTypeRules: {
          handleMethod: [this.requiredInput('样品处理方式')]
        },
        selectRow: [],
        handleMethodList: [
          {
            label:'退样',
            value: '退样'
          },
          {
            label:'用完',
            value: '用完'
          },
          {
            label:'报废',
            value: '报废'
          },
          {
            label:'留样',
            value: '留样'
          },
          {
            label:'现场检验',
            value: '现场检验'
          },
        ]
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchHandle({condition}).then(data => {
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
          deleteHandle({id: this.selectRow}).then(data => {
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
        getHandleById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            /*this.dialogTypeForm = {
              title: '修改样品处理方式',
              handleMethod: '退样'
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
          title: '添加样品处理方式',
          isDelete: false,
          handleMethod: ''
        };
      },
      saveHandle () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyHandle({handleForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addHandle({handleForm: this.dialogTypeForm}).then(data => {
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
