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
              <el-form-item label="标题" prop="titleName">
                <el-input v-model="dialogTypeForm.titleName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :span="20">
            <el-form-item label="内容" prop="content">
              <el-input v-model="dialogTypeForm.content" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="发布人" prop="person">
                <el-input v-model="dialogTypeForm.person" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="时间" prop="time">
                <el-date-picker
                  v-model="dialogTypeForm.time"
                  type="datetime"
                  :disabled="dialogTypeForm.isDelete"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="saveNotice">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  import axios from 'axios';
  const searchNotice = (condition) => axios.post('/api/notice', condition);
  const addNotice = (noticeForm) => axios.post('/api/notice', noticeForm);
  const getNoticeById = (id) => axios.get('/api/notice', id);
  const modifyNotice = (noticeForm) => axios.post('api/notice', noticeForm);
  const deleteNoticeById = (id) => axios.delete('api/notice', id);

  export default {
    name: "noticeMaintain",
    data () {
      return {
        loading: false,
        title: '公告信息维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'titleName',
            label: '标题'
          },
          {
            prop: 'content',
            label: '内容'
          },
          {
            prop: 'person',
            label: '发布人'
          },
          {
            prop: 'time',
            label: '时间'
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
            titleName:'关于统计论文、专利等的通知',
            content:'接上级通知，需上报我所2018年论文、专利等的统计，现将统计表上传，望各科室认真填写，11月23日将此表电子版与复印件交于业务室。',
            person:'赵月宁',
            time:'2018-11-22 00:00'
          }
        ],
        dialogTypeForm:{
          title:"添加公告信息",
          isDelete: false,
          titleName:'',
          content:'',
          person:'',
          time:''
        },
        showDialogType: false,
        dialogTypeRules: {

        },
      };
    },
    methods:{
      searchTable (condition) {
        this.loading = true;
        searchNotice({condition}).then(data => {
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
        getNoticeById({id}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            // todo
            this.dialogTypeForm = data.data.datas;
            this.showDialogType = true;
            /*this.dialogTypeForm = {
              id: 1, //如果是后台写的就是id:data.data.id,这里是假数据
              title:'修改公告信息',
              number:1,
              titleName:'关于统计论文、专利等的通知',
              content:'接上级通知，需上报我所2018年论文、专利等的统计，现将统计表上传，望各科室认真填写，11月23日将此表电子版与复印件交于业务室。',
              person:'赵月宁',
              time:'2018-11-22 00:00'
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
          title: '添加公告信息',
          isDelete: false,
          titleName:'',
          content:'',
          person:'',
          time:''
        };
      },
      saveNotice () {
        this.$refs.dialogTypeForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            if (this.dialogTypeForm.id) {
              modifyNotice({noticeForm: this.dialogTypeForm}).then(data => {
                if (data.data.code === '000') {
                  this.showDialogType = false;
                }
              });
            } else {
              addNotice({noticeForm: this.dialogTypeForm}).then(data => {
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
          deleteNoticeById({id: this.selectRow}).then(data => {
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
