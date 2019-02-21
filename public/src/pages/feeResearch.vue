<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table
        :remote="true" :remoteMethod="doQuery"
        :columns="columns">
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';
const getFeeDataList = (condition, order) => axios.get(`/api/fee?${condition}`, order);

export default {
  name: 'feeResearch',
  data () {
    return {
      title: '收费查询',
      loading: false,
      columns: [
        {
          prop: 'number',
          label: '编号'
        },
        {
          prop: 'department',
          label: '企业名称'
        },
        {
          prop: 'section',
          label: '部门'
        },
        {
          prop: 'feeProject',
          label: '收费项目'
        },
        {
          prop: 'count',
          label: '金额'
        },
        {
          prop: 'ticketNo',
          label: '发票号'
        },
        {
          prop: 'ticketDate',
          label: '开票日期',
          formatter: (col) => {
            return this.formatDate(col);
          }
        },
        {
          prop: 'audit',
          label: '是否核实',
          formatter: (col) => {
            return col ? '已核实' : '未核实';
          }
        },
        {
          prop: 'feeWay',
          label: '收款方式'
        },
        {
          prop: 'whether',
          label: '是否到账',
          formatter: (col) => {
            return col ? '已到账' : '未到账';
          }
        },
        {
          prop: 'feeDepartment',
          label: '收款单位'
        },
        {
          prop: 'more',
          label: '备注'
        }
      ]
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getFeeDataList(this.formatParams({ searchCondition, page, size })).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    }
  }
};
</script>

<style scoped>

</style>
