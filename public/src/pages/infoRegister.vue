<template>
    <page-main-body :title="title" :loading="loading">
      <div style="width: 95%">
        <light-table ref="table"
                     :columns="columns"
                     :addable="true" @on-add="addInformation"
                     :deleteable="true" @on-delete="goToDelete"
                     :remote="true" :remoteMethod="doQuery"
                     :deadline="true"
                     :rowSelect="true" @select-row="getSelectRow">
          <template slot="operateTable">
            <el-button @click="goToCommit">提交</el-button>
            <el-button @click="viewReturnList">返工记录</el-button>
          </template>
          <template slot="operation" slot-scope="props">
            <el-button size="mini" @click="goToModify(props.prop)">编辑</el-button>
            <el-button size="mini" @click="goToPrint(props.prop)">打印</el-button>
          </template>
        </light-table>
      </div>
      <return-Lookup :isAddable="isAddable" :showDialog="showReturnDialog" :id="id" @on-close="onClose"></return-Lookup>
      <el-dialog
        title="打印报表"
        :visible.sync="showDialog"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogClose"
        center>
        <div class="pdf-hide">
          <report-form :formColumns="formColumns" :isPrint="true" :editable="false">
          </report-form>
        </div>
        <light-table ref="table"
                     :columns="dialogColumns"
                     :remote="true"
                     :remoteMethod="dialogQuery">
          <template slot="operation" slot-scope="props">
            <el-button size="mini" @click="getPrint(props.prop)">打印</el-button>
          </template>
        </light-table>
      </el-dialog>
    </page-main-body>
</template>

<script>
import axios from 'axios';
import _ from 'lodash';
import returnLookup from '../components/lookup/returnLookup';
import reportForm from '../components/reportForm';

const getSampleDataList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);
const deleteSampleById = (id) => axios.delete('/api/sample', {data: id});
const commitSampleById = (idStatus) => axios.put('/api/sample', idStatus);
const findSDZBtable = (condition) => axios.get(`/api/zibo_table?${condition}`);
const getZBtableById = (id) => axios.get(`/api/zibo_table/${id}`);
const getSampleById = (id) => axios.get(`/api/sample/${id}`);

export default {
  name: 'infoRegister',
  components: {
    returnLookup,
    reportForm
  },
  data () {
    return {
      title: '样品登记',
      columns: [
        {
          prop: 'id',
          label: '序号',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleNo',
          label: '样品单号',
          width: '130',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'inspectCompany',
          label: '企业名称',
          width: '130',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleName',
          label: '样品名称',
          width: '130',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'checkType',
          label: '检验类型',
          width: '130',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'completeDate',
          label: '要求完成日期',
          width: '150',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'department',
          label: '部门',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'status',
          label: '状态',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'operation',
          label: '操作',
          width: '200',
          type: {
            operate: true
          }
        }
      ],
      dialogColumns: [
        {
          prop: 'id',
          label: '序号'
        },
        {
          prop: 'tableName',
          label: '报表名称'
        },
        {
          prop: 'operation',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      formColumns: [],
      formTitle: '',
      selectRow: [],
      showReturnDialog: false,
      showDialog: false,
      id: '',
      printId: '',
      isAddable: true,
      loading: false
    };
  },
  methods: {
    addInformation () {
      this.$router.push('/newSample');
    },
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getSampleDataList(this.formatParams({ status: 'initial', searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    dialogQuery (searchCondition, pageNumber, pageSize) {
      this.loading = true;
      return findSDZBtable(this.formatParams({ searchCondition, pageNumber, pageSize })).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    goToPrint (row) {
      this.printId = row.id;
      this.showDialog = true;
    },
    getPrint (row) {
      this.loading = true;
      this.formColumns = [];
      this.formTitle = '报表';
      getZBtableById(row.id).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          let formColumns = data.data.datas[0].tableList;
          this.formTitle = data.data.datas[0].tableName;
          if (this.printId) {
            getSampleById(this.printId).then(data => {
              if (data.data.code === '000') {
                const sample = data.data.datas[0];
                _.each(formColumns, item => {
                  if (item.bindData) {
                    item.message = sample[item.bindData] instanceof Array ? sample[item.bindData].join(',') : sample[item.bindData];
                  }
                });
                this.formColumns = formColumns;
              }
            });
          }
        }
      }).then(() => {
        this.$nextTick(() => {
          setTimeout(() => {
            this.getPdf(this.formTitle, 'printReportPage', 3, 1);
          }, 500);
        });
      });
    },
    goToModify (row) {
      this.$router.push(`/newSample?id=${row.id}`);
    },
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        deleteSampleById({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.loading = false;
            this.onAlertSuccess('删除成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    goToCommit () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        commitSampleById({id: this.selectRow, status: 'pre_test'}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.onAlertSuccess('提交成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    viewReturnList () {
      if (this.selectRow.length !== 1) {
        this.onAlertError(`选中数量为必须为1条`);
      } else {
        this.isAddable = false;
        this.id = this.selectRow[0];
        this.showReturnDialog = true;
      }
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    },
    onClose (val) {
      this.showReturnDialog = val;
    },
    dialogClose () {
      this.printId = '';
    }
  }
};
</script>

<style scoped>

</style>
