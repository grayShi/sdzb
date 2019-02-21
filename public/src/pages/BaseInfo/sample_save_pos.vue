<template>
  <page-main-body title="样品存放地点维护" :loading="loading">
    <el-row style="width: 100%">
    <!--<el-form :model="newData" label-width="140px">-->
      <!--<el-form-item label="存放地点名称">-->
        <!--<el-input v-model="newData.save_pos"></el-input>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="primary" @click="onSubmit">保存</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <light-table :columns="column_desc" ref="table"
                 style="width: 100%" :need-index="true"
                 :addable="true" @on-add="addSave"
                 :deleteable="true" @on-delete="goToDelete"
                 :remote="true" :remoteMethod="doQuery"
                 :row-select="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="viewSaveDetail(props.prop.id,'edit')">编辑</el-button>
        <!--<el-button size="mini" type="danger" style="margin-left: 10px" @click="viewSaveDetail(props.prop.id,'delete')">删除</el-button>-->
      </template>
    </light-table>
      <el-dialog :visible.sync="showDialog"
                 center
                 :title="dialogForm.title"
                 width="50%"
                 @close="closeDialog">
        <el-form label-width="100px" ref="dialogForm" :model="dialogForm" :rules="dialogRules">
          <el-row>
            <el-col :span="12">
              <el-form-item label="存放地点" prop="detail">
                <el-input v-model="dialogForm.detail" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer">
        <el-button type="primary" v-if="!dialogForm.isDelete"  @click="saveSamplePos">保存</el-button>
        <!--<el-button type="danger" v-if="dialogForm.isDelete"  @click="showDialog=false">删除</el-button>-->
        <el-button @click="showDialog=false">取消</el-button>
      </span>
      </el-dialog>
    </el-row>
  </page-main-body>
</template>

<script>

import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.SamplePost('', condition);
const getSamplePosList = (params) => axios.get('/api/dict/list/sample_store_place', {params});
const addNewSamplePos = (payload) => axios.post('/api/dict/sample_store_place', payload);
const getSamplePosById = (id) => axios.get(`/api/dict/${id}`);
// const modifySamplePos = (id) => axios.post('/api/samplePos', {data: id});
const deleteSamplePos = (id) => axios.delete('/api/dict', {data: id});
// const getInspectSamplePos = () => axios.post('/api/samplePos');

export default {
  name: 'SampleSavePos',
  data () {
    return {
      loading: false,
      selectRow: [],
      dialogRules: {},
      column_desc: [
        {
          prop: 'detail',
          label: '存放地点'
        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      // table_data: [
      //   {
      //     detail: 'yu'
      //   }
      // ],
      showDialog: false,
      dialogForm: {
        id: '',
        isDelete: false,
        title: '添加样品存放地点',
        detail: ''
      }
    };
  },
  // mounted () {
  //   getInspectSamplePos().then(data => {
  //     if (data.data.code === '000') {
  //       this.showDialog = false;
  //     }
  //   });
  // },
  methods: {
    addSave () {
      this.showDialog = true;
    },
    viewSaveDetail (id, action) {
      this.loading = true;
      getSamplePosById(id).then(data => {
        this.loading = false;
        this.showDialog = true;
        if (data.data.code === '000') {
          this.dialogForm = {
            id: data.data.datas[0].id,
            isDelete: false,
            title: '编辑样品存放地点',
            detail: data.data.datas[0].detail
          };
        } else {
          this.onAlertError('搜索失败');
        }
      });

      // if (action === 'delete') {
      //   this.dialogForm.isDelete = true;
      //   this.dialogForm.title = '删除样品存放地点';
      // }
    },
    doQuery (searchCondition, pageIndex, pageSize) {
      this.loading = true;
      return getSamplePosList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    closeDialog () {
      this.dialogForm = {
        isDelete: false,
        title: '添加样品存放地点',
        detail: ''
      };
    },
    saveSamplePos () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            const payload = {
              id: this.dialogForm.id,
              detail: this.dialogForm.detail
            };
            addNewSamplePos(payload).then(data => {
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
            };
            addNewSamplePos(payload).then(data => {
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
        deleteSamplePos({id: this.selectRow}).then(data => {
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
