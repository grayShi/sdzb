<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table :columns="columns" ref="table"
                   :remote="true" :remoteMethod="doQuery"
                   :deadline="true"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operateTable">
          <el-button @click="printPDF">打印PDF</el-button>
          <el-button @click="distributeReport">发放</el-button>
        </template>
      </light-table>
      <div class="pdf-hide">
        <inspect-report-pdf :id="pdfId" @on-print="printReady"></inspect-report-pdf>
      </div>
    </div>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';
import inspectReportPdf from '../pdf/inspectReportPdf';
const getSampleDataList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);
const commitSampleById = (idStatus) => axios.put('/api/sample', idStatus);

export default {
  name: 'printGiveOut',
  components: {
    inspectReportPdf
  },
  data () {
    return {
      title: '打印发放',
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
          prop: 'inspectCompany',
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
          prop: 'samDate',
          label: '抽送样日期',
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
          label: '当前状态',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'payState',
          label: '收费状态',
          sort: {
            show: true,
            default: 'asc'
          }
        }
      ],
      selectRow: [],
      pdfId: '',
      loading: false
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getSampleDataList(this.formatParams({ status: ['pre_print', 'fetched'].join(','), searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      }).catch(() => {
        this.loading = false;
        this.onAlertError('查询失败');
      });
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    },
    printPDF () {
      if (this.selectRow.length !== 1) {
        this.onAlertError('选中数量必须为1条');
      } else {
        this.loading = true;
        this.pdfId = this.selectRow[0];
      }
    },
    printReady (val, title) {
      if (val) {
        this.pdfId = '';
        this.getPdf(title);
      }
    },
    distributeReport () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        commitSampleById({id: this.selectRow, status: 'fetched'}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.onAlertSuccess('发放成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    }
  }
};
</script>

<style scoped>

</style>
