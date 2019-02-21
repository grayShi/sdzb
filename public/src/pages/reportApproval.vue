<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <light-table :columns="columns" ref="table"
                   :remote="true" :remoteMethod="doQuery"
                   :deadline="true"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operateTable">
          <el-button @click="goToCommit">提交</el-button>
          <el-button @click="goToReturn">返工</el-button>
          <el-button @click="viewReturnList">返工记录</el-button>
        </template>
        <template slot="operation" slot-scope="props">
          <el-button size="mini" @click="goToModify(props.prop)">查看</el-button>
        </template>
      </light-table>
    </div>
    <return-Lookup :isAddable="isAddable" :showDialog="showReturnDialog" :id="id" @on-close="onClose"></return-Lookup>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';
import returnLookup from '../components/lookup/returnLookup';
const commitSampleById = (idStatus) => axios.put('/api/sample', idStatus);
const getReportApproveDataList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);

export default {
  name: 'reportApproval',
  components: {
    returnLookup
  },
  data () {
    return {
      title: '报告批准',
      columns: [
        {
          prop: 'id',
          label: '序号',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'reportNo',
          label: '报告号',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'projectNo',
          label: '项目名称',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'companyName',
          label: '企业名称',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleName',
          label: '样品名称',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleNo',
          label: '样品单号',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'checkType',
          label: '检验类型',
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
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'status',
          label: '状态',
          sort: {
            show: true,
            default: 'asc'
          }
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
      showReturnDialog: false,
      id: '',
      isAddable: true
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getReportApproveDataList(this.formatParams({ status: 'pre_approve', searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    goToModify (row) {
      this.$router.push(`/inspectReport?id=${row.id}`);
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    },
    goToCommit () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        commitSampleById({id: this.selectRow, status: 'pre_print'}).then(data => {
          if (data.data.code === '000') {
            this.onAlertSuccess('提交成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    goToReturn () {
      if (this.selectRow.length !== 1) {
        this.onAlertError(`选中数量为必须为1条`);
      } else {
        this.isAddable = true;
        this.id = this.selectRow[0];
        this.showReturnDialog = true;
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
    onClose (val) {
      if (!val && this.isAddable) {
        this.$refs.table.doRemoteMethod();
      }
      this.showReturnDialog = val;
    }
  }
};
</script>

<style scoped>

</style>
