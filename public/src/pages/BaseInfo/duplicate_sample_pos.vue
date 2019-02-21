<template>
  <page-main-body title="备样存放地点" :loading="loading">
    <!--<el-form :model="newData" label-width="140px">-->
      <!--<el-form-item label="备样存放地点">-->
        <!--<el-input v-model="newData.pos"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">添加</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 @on-search="searchTable"
                 style="width: 100%" :need-index="true"
                 :addable="true" @on-add="addDupli"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :rowSelect="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="viewDuplicateDetail(props.prop.id,'edit')">编辑</el-button>

      </template>
    </light-table>
    <el-dialog :visible.sync="showDialog"
               center
               width="50%"
               @close="closeDialog"
               :title="dialogForm.title">
      <el-form ref="dialogForm" :model="dialogForm" :rules="dialogRules" label-width="100px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="样品抽样地点" prop="detail">
            <el-input v-model="dialogForm.detail" :disabled="dialogForm.isDelete"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer">
        <el-button type="primary" v-if="!dialogForm.isDelete"  @click="saveDupli">保存</el-button>
        <!--<el-button type="danger" v-if="dialogForm.isDelete"  @click="delDupli">删除</el-button>-->
        <el-button @click="showDialog=false">取消</el-button>
      </span>
    </el-dialog>
  </page-main-body>
</template>

<script>
import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.post('', condition);
const getDupliList = (params) => axios.get('/api/dict/list/store_place', {params});
const addNewDupli = (payload) => axios.post('/api/dict/store_place', payload);
const getDupliById = (id) => axios.get(`/api/dict/${id}`);
// const modifyDupli = (id) => axios.post('/api/dupli', {data: id});
const deleteDupli = (id) => axios.delete('/api/dict', {data: id});
// const getInspectDupli = () => axios.post('/api/dupli');

export default {
  name: 'DuplicateSamplePos',
  data () {
    return {
      loading: false,
      column_desc: [
        {
          prop: 'detail',
          label: '样品抽样地点'
        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      selectRow: [],
      // table_data: [
      //   {
      //     id: '1',
      //     detail: 'aaz'
      //   }
      // ],
      // newData: {
      //   pos: ''
      // },
      dialogRules: {// 必填，是否合法
        // departName: [this.requiredInput('部门名称')],
      },
      showDialog: false,
      dialogForm: {
        id: '',
        title: '添加样品抽样地点信息',
        detail: '',
        isDelete: false
      }
    };
  },
  mounted () {
    // getInspectDupli().then(data => {
    //   if (data.data.code === '000') {
    //     this.showDialog = false;
    //   }
    // });
  },
  methods: {

    doQuery (searchCondition, pageIndex, pageSize) {
      return getDupliList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = true;
        if (data.data.code === '000') {
          this.loading = false;
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    viewDuplicateDetail (id) {
      this.loading = true;
      getDupliById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            id: data.data.datas[0].id,
            detail: data.data.datas[0].detail,
            title: '样品抽样地点编辑'
          };
        } else {
          this.onAlertError('搜索失败');
        }
      });
    },
    closeDialog () {
      this.dialogForm = {
        title: '添加样品抽样地点信息',
        detail: '',
        isDelete: false
      };
    },
    addDupli () {
      this.showDialog = true;
    },
    saveDupli () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              detail: this.dialogForm.detail,
              id: this.dialogForm.id
            };
            addNewDupli(payload).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
                // this.dialogForm = data.data.datas;
                this.showDialog = false;
                this.onAlertSuccess('修改成功');
                this.$refs.table.doRemoteMethod();
              } else {
                this.onAlertError('修改失败');
              }
            });
          } else {
            const payload = {
              detail: this.dialogForm.detail
              // id: this.dialogForm.id
            };
            addNewDupli(payload).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
                this.$refs.dialogForm.resetFields();
                this.showDialog = false;
                this.onAlertSuccess('保存成功');
                this.$refs.table.doRemoteMethod();
              } else {
                this.onAlertError('保存失败1');
              }
            }).catch(err => {
              this.loading = false;
              console.log(err);
              this.onAlertError('保存失败');
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
        deleteDupli({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.onAlertSuccess('删除成功');
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
};
</script>

<style scoped>
</style>
