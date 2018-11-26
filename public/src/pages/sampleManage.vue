<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <el-row style="margin-top: 10px">
        <el-button type="info" @click="$router.push('/sampleCheckIn')">样品入库登记</el-button>
        <el-button type="info" @click="$router.push('/sampleCheckOut')">样品出库登记</el-button>
      </el-row>
      <light-table :data="searchData" :columns="columns" :rowClass="tableRowClassName" style="width: 95%">
        <template slot="QRCode" scope="props" v-if="props.prop.status !== '已撤回'">
          <a href="javascript:void(0)" @click="showQRCode(props.prop.QRCode)">点击扫描二维码</a>
        </template>
        <template slot="operation" scope="props">
          <el-button v-if="showButton(props.prop.status, '查看样品详细信息')" size="mini" @click="goToDetail('查看样品详细信息', props.prop)">查看样品详细信息</el-button>
          <el-button v-if="showButton(props.prop.status, '查看入库进度')" size="mini" @click="goToDetail('查看入库进度', props.prop)">查看入库进度</el-button>
        </template>
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
import lightTable from '../components/lightTable';
import _ from 'lodash';
export default {
  name: 'sampleManage',
  components: {
    lightTable
  },
  data () {
    return {
      title: '',
      searchData: [
        {
          sampleNo: '1',
          sampleName: '样品1',
          businessNo: '业务1',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '现场抽样',
          status: '已入库'
        },
        {
          sampleNo: '2',
          sampleName: '样品2',
          businessNo: '业务2',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '现场抽样',
          status: '待入库'
        },
        {
          sampleNo: '3',
          sampleName: '样品3',
          businessNo: '业务3',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '现场抽样',
          status: '已出库'
        },
        {
          sampleNo: '4',
          sampleName: '样品4',
          businessNo: '业务4',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '现场抽样',
          status: '待出库'
        },
        {
          sampleNo: '5',
          sampleName: '样品5',
          businessNo: '业务5',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '送检抽样',
          status: '已入库'
        },
        {
          sampleNo: '6',
          sampleName: '样品6',
          businessNo: '业务6',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '送检抽样',
          status: '待入库'
        },
        {
          sampleNo: '7',
          sampleName: '样品7',
          businessNo: '业务7',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '送检抽样',
          status: '已出库'
        },
        {
          sampleNo: '8',
          sampleName: '样品8',
          businessNo: '业务8',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '送检抽样',
          status: '待出库'
        },
        {
          sampleNo: '9',
          sampleName: '样品9',
          businessNo: '业务9',
          sampleCount: '3',
          createdAt: '2018-11-24',
          selectType: '送检抽样',
          status: '已撤回'
        }

      ],
      columns: [
        {
          prop: 'sampleNo',
          label: '样品编号'
        },
        {
          prop: 'sampleName',
          label: '样品名称'
        },
        {
          prop: 'businessNo',
          label: '所属业务'
        },
        {
          prop: 'sampleCount',
          label: '样品数量'
        },
        {
          prop: 'createdAt',
          label: '创建时间'
        },
        {
          prop: 'selectType',
          label: '抽样类型'
        },
        {
          prop: 'status',
          label: '状态'
        },
        {
          prop: 'QRCode',
          label: '二维码',
          width: 120,
          type: {
            operate: true
          }
        },
        {
          prop: 'operation',
          label: '操作',
          width: 160,
          type: {
            operate: true
          }
        }
      ]

    };
  },
  methods: {
    showButton (status, action) {
      const form = [
        {
          status: '待入库',
          show: ['查看入库进度']
        },
        {
          status: '已入库',
          show: ['查看样品详细信息']
        },
        {
          status: '待出库',
          show: ['查看样品详细信息']
        },
        {
          status: '已出库',
          show: ['查看样品详细信息']
        }

      ];
      const find = _.filter(form, item => item.status === status && item.show.indexOf(action) >= 0);
      return find.length > 0;
    },
    goToDetail (type, scope) {
      if (type === '查看样品详细信息') {
        this.$router.push('/viewReceiving');
      } else if (type === '查看入库进度') {
        this.$router.push('/checkInProgress');
      }
    },
    showQRCode () {

    },
    tableRowClassName ({ row }) {
      if (row.status === '已撤回') {
        return 'delete-row';
      }
      return '';
    }
  }
};
</script>

<style scoped>

</style>
