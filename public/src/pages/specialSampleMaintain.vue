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
              <el-form-item label="样品名称" prop="sampleName">
                <el-input v-model="dialogTypeForm.sampleName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="完成天数" prop="day">
                <el-input v-model="dialogTypeForm.day" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveSpecialSample">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchSpecialSample = (condition) => axios.post('/api/specialSample', condition);
  const addSpecialSample = (specialSampleForm) => axios.post('/api/specialSample', specialSampleForm);
  const getSpecialSampleById = (id) => axios.get('/api/specialSample', id);
  const modifySpecialSample = (specialSampleForm) => axios.post('/api/specialSample', specialSampleForm);
  const deleteSpecialSampleById = (id) => axios.delete('/api/specialSample', id);


  export default {
    name: "specialSampleMaintain",
    data () {
      return {
        loading: false,
        title: '特殊样品维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'sampleName',
            label: '样品名称',
            width: '200'
          },
          {
            prop: 'day',
            label: '完成天数',
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
            sampleName:'普通硅酸盐水泥',
            day:'54'
          }
        ],
        dialogTypeForm: {
          title: '添加特殊样品',
          isDelete: false,
          sampleName:'',
          day:''
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
        searchSpecialSample({condition}).then(data => {
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
        getSpecialSampleById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.dialogTypeForm = data.data.datas;
            this.showDialogType = true;
            // todo
            /*this.dialogTypeForm = {
              id: 1,
              title:'修改特殊样品',
              number:1,
              sampleName:'普通硅酸盐水泥',
              day:'54'
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
          title: '添加特殊样品',
          isDelete: false,
          sampleName:'',
          day:''
        };
      },
      saveSpecialSample () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifySpecialSample({specialSampleForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addSpecialSample({specialSampleForm: this.dialogTypeForm}).then(data => {
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
          deleteSpecialSampleById({id: this.selectRow}).then(data => {
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
