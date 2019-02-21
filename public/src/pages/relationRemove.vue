<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table
        ref="table"
        :remote="true" :remoteMethod="doQuery"
        :rowSelect="true" @select-row="getSelectRow"
        :columns="columns" >
        <template slot="operateTable">
          <el-button @click="cancelConnect()">取消关联</el-button>
          <el-button @click="">关联记录</el-button>
          <el-button @click="">批准打印</el-button>
        </template>
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
import axios from 'axios';
import _ from 'lodash';
const getConnectFeeList = (condition, order) => axios.get(`api/fee/relate?${condition}`, order);
const cancelConnectFee = (sampleIds, feeId) => axios.put(`/api/fee/${feeId}/cancel_relate`, {sampleIds});

export default {
  name: 'relationRemove',
  data () {
    return {
      title: '关联取消',
      loading: false,
      columns: [
        {
          prop: 'number',
          label: '序号'
        },
        {
          prop: 'reportNo',
          label: '报告号'
        },
        {
          prop: 'missionNo',
          label: '任务号'
        },
        {
          prop: 'companyName',
          label: '企业名称'
        },
        {
          prop: 'feeCompany',
          label: '收费企业'
        },
        {
          prop: 'testType',
          label: '检验类型'
        },
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'presentState',
          label: '当前状态'
        },
        {
          prop: 'feeState',
          label: '收费状态'
        }
      ],
      selectRow: []
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getConnectFeeList(this.formatParams({ searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          let { totalData, totalLength } = this.formatGetTableData(data.data.datas);
          totalData = totalData.map(item => ({
            number: item.ziboFee.number,
            missionNo: item.product.missionNo,
            reportNo: item.product.reportNo,
            companyName: item.inspectedEnterprise.enterpriseName,
            feeCompany: item.inspectedEnterprise.enterpriseName,
            testType: item.product.checkType,
            department: item.ziboFee.department,
            presentState: '',
            feeState: '',
            feeId: item.ziboFee.id,
            sampleId: item.product.id
          }));
          return { totalData, totalLength };
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push({ feeId: item.feeId, sampleIds: [ item.sampleId ] });
      });
      this.selectRow = id;
    },
    cancelConnect () {
      if (this.selectRow.length !== 1) {
        this.onAlertError('选中数量只能为1条');
      } else {
        this.loading = true;
        cancelConnectFee(this.selectRow[0].sampleIds, this.selectRow[0].feeId).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.loading = false;
            this.onAlertSuccess('取消成功');
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
