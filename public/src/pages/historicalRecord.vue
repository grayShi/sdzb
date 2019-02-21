<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table ref="table"
                   :columns="columns"
                   :deadline="true"
                   :remote="true" :remoteMethod="doQuery"
                   :rowSelect="true" @select-row="getSelectRow">
      <template slot="otherCondition">
          <div  style="margin: 5px 0">
            <span>当前状态</span>
            <el-select style="width: 50%" v-model="searchStatus" multiple clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in statusList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </div>
        </template>
        <template slot="operateTable">
          <el-button @click="goToConnect" type="primary">收费关联</el-button>
        </template>
        <template slot="operation" slot-scope="props">
          <el-button size="mini" @click="goToView(props.prop)">查看</el-button>
        </template>
      </light-table>
    </div>

    <el-dialog
      title="收费关联"
      :visible.sync="showDialog"
      width="90%"
      @close="closeDialog"
      top>

      <light-table ref="sampleTable"
                   :showSearch="false"
                   :tableHeight="200"
                   :columns="sampleColumns"
                   :data="sampleData">
      </light-table>
      收费列表
      <light-table ref="connectTable"
                   :columns="connectColumns"
                   :remote="true" :remoteMethod="doFeeQuery"
                   :single-select="true" @single-row="getSingleSelectRow">
        <template slot="operation" slot-scope="props">
          <el-button size="mini" @click="goToModify(props.prop.id)">编辑</el-button>
        </template>
      </light-table>
      <span slot="footer" class="dialog-footer">
          <el-button @click="showDialog=false">取消</el-button>
          <el-button type="primary" @click="saveConnect">关联</el-button>
        </span>
    </el-dialog>
  </page-main-body>
</template>

<script>
import axios from 'axios';
import _ from 'lodash';
const getHistoryList = (condition, order) => axios.post(`/api/sample/list?${condition}`, order);
const getFeeDataList = (condition, order) => axios.get(`/api/fee?${condition}`, order);
const saveConnectFee = (sampleIds, feeId) => axios.put(`/api/fee/${feeId}/relate`, {sampleIds});

export default {
  name: 'historicalRecord',
  data () {
    return {
      title: '历史记录',
      loading: false,
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
          prop: 'completeDate',
          label: '要求完成日期',
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
        },
        {
          prop: 'operation',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      searchStatus: [],
      statusList: [
        {
          label: '已登记',
          value: 'initial'
        },
        {
          label: '未校验',
          value: 'pre_test'
        },
        {
          label: '未较核',
          value: 'pre_check'
        },
        {
          label: '未批准',
          value: 'pre_approve'
        },
        {
          label: '未打印',
          value: 'pre_print'
        }
      ],
      selectRow: [],
      showDialog: false,
      sampleColumns: [
        {
          prop: 'id',
          label: '序号',
          sort: false
        },
        {
          prop: 'missionNo',
          label: '任务号',
          sort: false
        },
        {
          prop: 'reportNo',
          label: '报告号',
          sort: false
        },
        {
          prop: 'sampleName',
          label: '样品名称',
          sort: false
        },
        {
          prop: 'inspectCompany',
          label: '企业名称',
          sort: false
        }
      ],
      sampleData: [],
      singleSelect: '',
      connectColumns: [
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
          prop: 'auditTime',
          label: '核实日期',
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
        }
      ]
    };
  },
  methods: {
    goToView (row) {
      this.$router.push(`/inspectReport?id=${row.id}`);
    },
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getHistoryList(this.formatParams({ status: this.searchStatus.join(','), searchCondition, page, size }), order).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    doFeeQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getFeeDataList(this.formatParams({ audit: false, searchCondition, page, size })).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item);
      });
      this.selectRow = id;
    },
    getSingleSelectRow (val) {
      this.singleSelect = val.id;
    },
    goToConnect () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.sampleData = this.selectRow;
        this.showDialog = true;
        this.$nextTick(() => {
          this.$refs.connectTable.doRemoteMethod();
        });
      }
    },
    saveConnect () {
      if (this.sampleData.length > 0 && this.singleSelect) {
        const sampleIds = _.map(this.sampleData, item => item.id);
        this.loading = true;
        saveConnectFee(sampleIds, this.singleSelect).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.onAlertSuccess('保存成功');
            this.showDialog = false;
            this.$refs.table.doRemoteMethod();
          } else {
            this.onAlertError('关联失败');
          }
        });
      } else {
        this.onAlertError('选中关联收费数量为0条');
      }
    },
    closeDialog () {
      this.$refs.table.doClearSelection();
      this.$refs.connectTable.doClearSelection();
      this.selectRow = [];
      this.singleSelect = '';
    }
  }
};
</script>

<style scoped>

</style>
