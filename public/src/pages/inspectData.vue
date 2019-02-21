<template>
  <page-main-body :title="title" :loading="loading">
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
          <el-button size="mini" @click="goToModify(props.prop)">编辑</el-button>
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

const getInspectDataList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);
const commitSampleById = (idStatus) => axios.put('/api/sample', idStatus);

export default {
  name: 'inspectData',
  components: {
    returnLookup
  },
  data () {
    return {
      title: '检验数据',
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
          prop: 'reportNo',
          label: '报告号',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'inspectCompany',
          label: '企业名称',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleName',
          label: '样品名称',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'sampleNo',
          label: '样品单号',
          width: '120',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'checkType',
          label: '检验类型',
          width: '120',
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
          width: '120',
          type: {
            operate: true
          }
        }
      ],
      selectRow: [],
      showReturnDialog: false,
      id: '',
      isAddable: true,
      loading: false
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getInspectDataList(this.formatParams({ status: 'pre_test', searchCondition, page, size }), order).then(data => {
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
        this.loading = true;
        commitSampleById({id: this.selectRow, status: 'pre_check'}).then(data => {
          this.loading = false;
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
