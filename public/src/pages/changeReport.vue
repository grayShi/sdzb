<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table :columns="columns" ref="table"
                   :remote="true" :remoteMethod="doQuery"
                   :deadline="true"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operateTable">
          <el-button @click="goToModifyReport">更改报告</el-button>
        </template>
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';

const getSampleDataList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);
const commitSampleById = (idStatus) => axios.put('/api/sample', idStatus);

export default {
  name: 'changeReport',
  data () {
    return {
      title: '更改报告',
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
          prop: 'companyName',
          label: '企业名称',
          sort: {
            show: true,
            default: 'asc'
          }
        },
        {
          prop: 'inspectCompany',
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
        }
      ],
      selectRow: [],
      loading: false
    };
  },
  methods: {
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    },
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getSampleDataList(this.formatParams({ status: 'pre_print', searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    goToModifyReport () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.onAlertConfirm('确定要更改报告吗？').then(() => {
          this.loading = true;
          commitSampleById({id: this.selectRow, status: 'pre_test'}).then(data => {
            this.loading = false;
            if (data.data.code === '000') {
              this.onAlertSuccess('提交成功');
              this.$refs.table.doRemoteMethod();
            }
          });
        });
      }
    }
  }
};
</script>

<style scoped>

</style>
