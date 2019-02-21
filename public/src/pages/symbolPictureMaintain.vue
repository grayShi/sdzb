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
              <el-form-item label="标志名称" prop="symbolName">
                <el-input v-model="dialogTypeForm.symbolName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="标志路径" prop="symbolPath">
                <el-input v-model="dialogTypeForm.symbolPath" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="savePicture">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchPicture = (condition) => axios.post('/api/picture', condition);
  const addPicture = (handleForm) => axios.post('/api/picture', handleForm);
  const getPictureById = (id) => axios.get('/api/picture', id);
  const modifyPicture = (handleForm) => axios.post('/api/picture', handleForm);
  const deletePicture = (id) => axios.delete('/api/picture', id);

  export default {
    name: "symbolPictureMaintain",
    data () {
      return {
        loading: false,
        title: '标志图片维护',
        columns: [
          {
            prop: 'symbolName',
            label: '标志名称',
            width: '200'
          },
          {
            prop: 'symbolPath',
            label: '标志路径',
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
            symbolName: 'CMA',
            symbolPath: '/biaozimage/CMA.jpg '
          }
        ],
        selectRow: [],
        dialogTypeForm: {
          title: '添加标志图片',
          isDelete: false,
          symbolName:'',
          symbolPath:''
        },
        showDialogType: false,
        dialogTypeRules: {
          symbolName: [this.requiredInput('标志名称')],
          symbolPath: [this.requiredInput('标志路径')]
        }
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchPicture({condition}).then(data => {
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
          deletePicture({id: this.selectRow}).then(data => {
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
        getPictureById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            /*this.dialogTypeForm = {
              title: '修改标志图片',
              symbolName: 'CMA',
              symbolPath: '/biaozimage/CMA.jpg '
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
          title: '添加标志图片',
          isDelete: false,
          symbolName:'',
          symbolPath:''
        };
      },
      savePicture () {
        this.$refs.dialogTypeForm.valid((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyPicture({pictureForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addPicture({pictureForm: this.dialogTypeForm}).then(data => {
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
