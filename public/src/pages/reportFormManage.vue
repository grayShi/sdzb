<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table ref="table"
                   :columns="columns"
                   :addable="true" @on-add="addReportForm"
                   :deleteable="true" @on-delete="goToDelete"
                   :remote="true" :remoteMethod="doQuery"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operation" slot-scope="props">
          <el-button size="mini" @click="goToModify(props.prop)">编辑</el-button>
        </template>
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
import axios from 'axios';
import _ from 'lodash';
const findSDZBtable = (condition) => axios.get(`/api/zibo_table?${condition}`);
const deleteZBtableById = (id) => axios.delete('/api/zibo_table', {data: id});

export default {
  name: 'reportFormManage',
  data () {
    return {
      title: '',
      loading: false,
      selectRow: [],
      columns: [
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
      ]
    };
  },
  methods: {
    addReportForm () {
      this.$router.push('/addReportForm');
    },
    doQuery (searchCondition, pageNumber, pageSize) {
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
    goToModify (row) {
      this.$router.push(`/addReportForm?id=${row.id}`);
    },
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        deleteZBtableById({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.loading = false;
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
