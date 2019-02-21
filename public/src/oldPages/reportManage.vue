<template>
  <page-main-body :title="title">
    <light-table :data="searchData" :columns="columns" :rowClass="tableRowClassName" style="width: 95%">
      <template slot="showColor">
        <el-tag class="table-warning-row" style="color: #606266;">两天后超期</el-tag>
        <el-tag class="table-danger-row" style="color: #606266;">超期</el-tag>
      </template>
      <template slot="QRCode" slot-scope="props">
        <a href="javascript:void(0)" @click="showQRCode(props.prop.QRCode)">查看二维码</a>
      </template>
      <template slot="operation" slot-scope="props">
        <el-button size="mini" @click="viewReportDetail(props.prop.id)">查看报告</el-button>
        <el-button size="mini" type="danger" @click="deleteReport(props.prop.id)">删除</el-button>
      </template>
    </light-table>
    <el-dialog
      title="二维码"
      :modal-append-to-body="false"
      :visible.sync="dialogVisible"
      width="30%"
      center>
      <div class="QR-setter">
        <img src="../assets/QRCode.jpg"/>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </page-main-body>
</template>

<script>
export default {
  name: 'reportManage',
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
          deadline: '2018-11-24',
          business: '业务1',
          QRCode: ''
        },
        {
          reportNo: 2,
          reportName: '报告2',
          createdAt: '2018-11-24',
          reportMission: '任务2',
          missionNo: '编号2',
          deadline: '2018-11-24',
          business: '业务2',
          QRCode: ''
        },
        {
          reportNo: 3,
          reportName: '报告3',
          createdAt: '2018-11-24',
          reportMission: '任务3',
          missionNo: '编号3',
          deadline: '2018-11-24',
          business: '业务3',
          QRCode: ''
        },
        {
          reportNo: 4,
          reportName: '报告4',
          createdAt: '2018-11-24',
          reportMission: '任务4',
          missionNo: '编号4',
          deadline: '2018-11-24',
          business: '业务4',
          QRCode: ''
        },
        {
          reportNo: 5,
          reportName: '报告5',
          createdAt: '2018-11-24',
          reportMission: '任务5',
          missionNo: '编号5',
          deadline: '2018-11-24',
          business: '业务5',
          QRCode: ''
        },
        {
          reportNo: 6,
          reportName: '报告6',
          createdAt: '2018-11-24',
          reportMission: '任务6',
          missionNo: '编号6',
          deadline: '2018-11-24',
          business: '业务6',
          QRCode: ''
        },
        {
          reportNo: 7,
          reportName: '报告7',
          createdAt: '2018-11-24',
          reportMission: '任务7',
          missionNo: '编号7',
          deadline: '2018-11-24',
          business: '业务7',
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
          prop: 'deadline',
          label: '要求完成时间'
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
      ],
      dialogVisible: false
    };
  },
  methods: {
    viewReportDetail () {
      this.$router.push('/reportDetail');
    },
    deleteReport () {

    },
    showQRCode () {
      this.dialogVisible = true;
    },
    tableRowClassName ({ row }) {
      if ([2, 4, 5].indexOf(row.reportNo) >= 0) {
        return 'warning-row';
      } else if ([7].indexOf(row.reportNo) >= 0) {
        return 'danger-row';
      }
      return '';
    }
  }
};
</script>

<style scoped>
  .QR-setter {
    text-align: center;
    width: 100%;
  }
  .QR-setter img {
    width: 200px;
    height: 200px;
  }
</style>
