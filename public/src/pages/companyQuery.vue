<template>
  <page-main-body title="企业查询" :loading="loading" >
    <el-row style="width: 100%">
      <!--<el-row>-->
      <!--<el-form :model="detailForm" ref="ruleForm" label-width="100px" style="margin-top: 20px">-->
        <!--<el-col span="8">-->
          <!--<el-form-item label="日期" >-->
            <!--<el-select v-model="detailForm.date">-->
              <!--<el-option-->
                <!--v-for="item in dataOptions"-->
                <!--:key="item.value"-->
                <!--:label="item.label"-->
                <!--:value="item.value">-->
              <!--</el-option>-->
            <!--</el-select>-->
          <!--</el-form-item>-->
        <!--</el-col>-->
        <!--<el-col span="8">-->
          <!--<el-form-item label="部门">-->
            <!--<el-select v-model="detailForm.department" placeholder="请选择">-->
              <!--<el-option-->
                <!--v-for="item in departmentOptions"-->
                <!--:key="item.value"-->
                <!--:label="item.label"-->
                <!--:value="item.value">-->
              <!--</el-option>-->
            <!--</el-select>-->
          <!--</el-form-item>-->
        <!--</el-col>-->
        <!--<el-col span="8">-->
          <!--<el-form-item label="企业名称">-->
            <!--<el-input v-model="detailForm.name"></el-input>-->
          <!--</el-form-item>-->
        <!--</el-col>-->
      <!--</el-form>-->
    <!--</el-row>-->
    <light-table  :columns="columns" ref="table"
                  style="width: 100%" :need-index="true"

                  :deleteable="true" @on-delete="goToDelete"
                  :remote="true" :remoteMethod="doQuery"
                  :rowSelect="true" @select-row="getSelectRow">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary"  @click="viewCompanyDetail(props.prop)">编辑</el-button>
        <!--<el-button size="mini" type="danger" @click="viewCompanyDetail(props.prop.id,'delete')">删除</el-button>-->
      </template>
    </light-table>
      <!--<el-dialog-->
        <!--:title="dialogForm.title"-->
        <!--:visible.sync="showDialog"-->
        <!--width="50%"-->
        <!--@close="closeDialog"-->
      <!--center>-->
        <!--<el-form :model="dialogForm" ref="dialogForm" label-width="100px">-->
          <!--<el-row>-->
          <!--<el-col :span="12">-->
          <!--<el-form-item label="企业名称" prop="name">-->
            <!--<el-input v-model="dialogForm.name" :disabled="dialogForm.isDelete"></el-input>-->
          <!--</el-form-item>-->
          <!--</el-col>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="企业地址" prop="address">-->
                <!--<el-input v-model="dialogForm.address" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
          <!--</el-row>-->
          <!--<el-row>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="企业代码" prop="code">-->
                <!--<el-input v-model="dialogForm.code" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="企业电话" prop="tel" >-->
                <!--<el-input v-model="dialogForm.tel" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
          <!--</el-row>-->
          <!--<el-row>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="联系人" prop="people">-->
                <!--<el-input :disabled="dialogForm.isDelete" v-model="dialogForm.people"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="区县" prop="place">-->
                <!--<el-input :disabled="dialogForm.isDelete" v-model="dialogForm.place"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
          <!--</el-row>-->
          <!--<el-row>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="部门" prop="department">-->
                <!--<el-select v-model="dialogForm.department" :disabled="dialogForm.isDelete" clearable>-->
                  <!--<el-option v-for="item in departmentOptions"-->
                             <!--:key="item.value"-->
                             <!--:label="item.label"-->
                             <!--:value="item.value">-->
                  <!--</el-option>-->
                <!--</el-select>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="年号" prop="year">-->
                <!--<el-input v-model="dialogForm.year" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
          <!--</el-row>-->
          <!--<el-row>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="储蓄金" prop="savings">-->
                <!--<el-input v-model="dialogForm.savings" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
            <!--<el-col :span="12">-->
              <!--<el-form-item label="折扣" prop="discount">-->
                <!--<el-input v-model="dialogForm.discount" :disabled="dialogForm.isDelete"></el-input>-->
              <!--</el-form-item>-->
            <!--</el-col>-->
          <!--</el-row>-->
        <!--</el-form>-->
        <!--<span slot="footer">-->
          <!--<el-button type="primary" v-if="!dialogForm.isDelete" @click="showDialog=false">保存</el-button>-->
          <!--<el-button type="danger" v-if="dialogForm.isDelete" @click="showDialog=false">删除</el-button>-->
          <!--<el-button  @click="showDialog=false">取消</el-button>-->
        <!--</span>-->
      <!--</el-dialog>-->
    </el-row>
  </page-main-body>
</template>

<script>

import axios from 'axios';
import _ from 'lodash';
// const searchDupli = (condition) => axios.post('', condition);
const getCompanyList = (params) => axios.get('/api/enterprises', {params});
// const addNewLevel = (payload) => axios.post('/api/dict/sample_level', payload);
// const getLevelById = (id) => axios.get(`/api/dict/${id}`);
// const modifyLevel = (id) => axios.post('/api/level', {data: id});
const deleteCompany = (id) => axios.delete('/api/enterprises', {data: id});

export default {
  name: 'companyQuery',
  data () {
    return {
      // detailForm: {
      //   date: '2018',
      //   department: '',
      //   name: ''
      // },
      // dataOptions: [
      //   {label: '2018', value: '2018'}
      // ],
      // departmentOptions: [
      //   {label: '化工一室', value: '化工一室'}
      // ],
      // searchData: [
      //   {
      //     company_name: '华师大',
      //     address: 'heaven'
      //   },
      //   {
      //     company_name: 'university',
      //     address: 'shanghai'
      //   }
      // ],
      selectRow: [],
      loading: false,
      columns: [
        {
          prop: 'enterpriseName',
          label: '企业名称'
        },
        {
          prop: 'enterpriseAddress',
          label: '企业地址'
        },
        {
          prop: 'enterpriseCode',
          label: '企业代码'
        },
        {
          prop: 'phone',
          label: '企业电话'
        },
        {
          prop: 'linkedUser',
          label: '联系人'
        },
        {
          prop: 'place',
          label: '区县'
        },
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'year',
          label: '年号'
        },
        {
          prop: 'edit',
          label: '编辑',
          width: 200,
          type: {
            operate: true
          }
        }
      ]
      // dialogForm: {
      //   title: '编辑企业信息',
      //   name: '',
      //   address: '',
      //   code: '',
      //   tel: '',
      //   people: '',
      //   place: '',
      //   department: '',
      //   year: '',
      //   savings: '',
      //   discount: '',
      //   isDelete: false
      // },
      // showDialog: false
    };
  },
  methods: {
    viewCompanyDetail (row) {
      // this.showDialog = true;
      // this.dialogForm = {
      //   title: '编辑企业信息',
      //   name: '华师大',
      //   address: '金沙江路',
      //   code: '450000',
      //   tel: '1312',
      //   people: 'zmm',
      //   place: '金水区',
      //   department: '机械二室',
      //   year: '2018'
      // };
      // if (action === 'delete') {
      //   this.dialogForm.title = '删除企业信息';
      //   this.dialogForm.isDelete = true;
      // }
      this.$router.push(`/addCompany?id=${row.id}`);
    },
    doQuery (searchCondition, pageIndex, pageSize) {
      this.loading = true;
      return getCompanyList({ searchCondition, pageIndex, pageSize }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        deleteCompany({id: this.selectRow}).then(data => {
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
    // closeDialog () {
    //   this.dialogForm = {
    //     title: '编辑企业信息',
    //     name: '',
    //     address: '',
    //     code: '',
    //     tel: '',
    //     people: '',
    //     place: '',
    //     department: '',
    //     year: '',
    //     isDelete: false
    //   };
    // }
  }
};
</script>

<style scoped>

</style>
