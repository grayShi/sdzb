<template>
  <page-main-body :title="title">
    <light-table :data="searchData" :columns="columns" style="width: 95%">
      <template slot="QRCode" scope="props">
        <a href="javascript:void(0)" @click="showQRCode(props.prop.QRCode)">查看二维码</a>
      </template>
      <template slot="operation" scope="props">
        <el-button size="mini" @click="viewReportDetail(props.prop.id)">查看报告</el-button>
        <el-button size="mini" type="danger" @click="deleteReport(props.prop.id)">删除</el-button>
      </template>
    </light-table>
  </page-main-body>
</template>

<script>
import lightTable from '../components/lightTable';
export default {
  name: 'reportManage',
  components: {
    lightTable
  },
  data () {
    return {
      title: '报告列表',
      searchData: [
        {
          reportNo: 1,
          reportName: '报告1',
          createdAt: '2018-11-24',
          reportMission: '任务1',
          missionNo: '编号1',
          business: '业务1',
          QRCode: ''
        },
        {
          reportNo: 2,
          reportName: '报告2',
          createdAt: '2018-11-24',
          reportMission: '任务2',
          missionNo: '编号2',
          business: '业务2',
          QRCode: ''
        }
      ],
      columns: [
        {
          prop: 'reportNo',
          label: '报告编号'
        },
        {
          prop: 'reportName',
          label: '报告名称'
        },
        {
          prop: 'createdAt',
          label: '生成时间'
        },
        {
          prop: 'reportMission',
          label: '对应任务'
        },
        {
          prop: 'missionNo',
          label: '任务编号'
        },
        {
          prop: 'business',
          label: '对应业务'
        },
        {
          prop: 'QRCode',
          label: '二维码',
          type: {
            operate: true
          }
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
    viewReportDetail () {
      this.$router.push('/reportDetail');
    },
    deleteReport () {

    },
    showQRCode () {

    }
  }
};
</script>

<style scoped>

</style>
