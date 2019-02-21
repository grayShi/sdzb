<template>
  <page-main-body :title="title">
    <light-table :data="searchData" :columns="columns" style="width: 95%">
      <template slot="operation" slot-scope="props">
        <el-button v-if="showButton(props.prop.status, '查看领取进度')" size="mini" @click="goToDetail('查看领取进度', props.prop)">查看领取进度</el-button>
        <el-button v-if="showButton(props.prop.status, '数据录入')" size="mini" @click="goToDetail('数据录入', props.prop)">数据录入</el-button>
        <el-button v-if="showButton(props.prop.status, '查看审核进度')" size="mini" @click="goToDetail('查看审核进度', props.prop)">查看审核进度</el-button>
        <el-button v-if="showButton(props.prop.status, '查看任务报告')" size="mini" @click="goToDetail('查看任务报告', props.prop)">查看任务报告</el-button>
        <el-button v-if="showButton(props.prop.status, '提醒负责人确认任务')" size="mini" @click="goToDetail('提醒负责人确认任务', props.prop)">提醒负责人确认任务</el-button>
      </template>
    </light-table>
  </page-main-body>
</template>

<script>
import _ from 'lodash';

export default {
  name: 'missionManage',
  data () {
    return {
      title: '任务列表',
      searchData: [
        {
          missionNo: 1,
          missionName: '任务1',
          missionDetail: '内容',
          sampleName: '样品1',
          sampleNo: '编号1',
          needCount: '1',
          businessName: '业务1',
          department: '部门1',
          actionBy: '负责人1',
          status: '未领取样品'
        },
        {
          missionNo: 2,
          missionName: '任务2',
          missionDetail: '内容',
          sampleName: '样品2',
          sampleNo: '编号2',
          needCount: '2',
          businessName: '业务2',
          department: '部门2',
          actionBy: '负责人2',
          status: '正在抽检'
        },
        {
          missionNo: 3,
          missionName: '任务3',
          missionDetail: '内容',
          sampleName: '样品3',
          sampleNo: '编号3',
          needCount: '3',
          businessName: '业务3',
          department: '部门3',
          actionBy: '负责人3',
          status: '等待审核'
        },
        {
          missionNo: 4,
          missionName: '任务4',
          missionDetail: '内容',
          sampleName: '样品4',
          sampleNo: '编号4',
          needCount: '4',
          businessName: '业务4',
          department: '部门4',
          actionBy: '负责人4',
          status: '任务完成'
        },
        {
          missionNo: 5,
          missionName: '任务5',
          missionDetail: '内容',
          sampleName: '样品5',
          sampleNo: '编号5',
          needCount: '5',
          businessName: '业务5',
          department: '部门5',
          actionBy: '负责人5',
          status: '任务反样'
        },
        {
          missionNo: 6,
          missionName: '任务6',
          missionDetail: '内容',
          sampleName: '样品6',
          sampleNo: '编号6',
          needCount: '6',
          businessName: '业务6',
          department: '部门6',
          actionBy: '负责人6',
          status: '待确认'
        }
      ],
      columns: [
        {
          prop: 'missionNo',
          label: '任务编号'
        },
        {
          prop: 'missionName',
          label: '任务名称'
        },
        {
          prop: 'missionDetail',
          label: '任务内容'
        },
        {
          prop: 'sampleName',
          label: '样品'
        },
        {
          prop: 'sampleNo',
          label: '样品编号'
        },
        {
          prop: 'needCount',
          label: '需要样品数量'
        },
        {
          prop: 'businessName',
          label: '对应业务'
        },
        {
          prop: 'department',
          label: '负责部门'
        },
        {
          prop: 'actionBy',
          label: '负责人'
        },
        {
          prop: 'status',
          label: '任务状态',
          width: 150
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
          status: '未领取样品',
          show: ['查看领取进度']
        },
        {
          status: '正在抽检',
          show: ['数据录入']
        },
        {
          status: '等待审核',
          show: ['查看审核进度']
        },
        {
          status: '任务完成',
          show: ['查看任务报告']
        },
        {
          status: '待确认',
          show: ['提醒负责人确认任务']
        }
      ];
      const find = _.filter(form, item => item.status === status && item.show.indexOf(action) >= 0);
      return find.length > 0;
    },
    goToDetail (type, scope) {
      if (type === '查看领取进度') {
        this.$router.push('/viewReceiving');
      } else if (type === '数据录入') {
        this.$router.push('/dataImport');
      } else if (type === '查看审核进度') {
        this.$router.push('/viewProgress');
      } else if (type === '查看任务报告') {

      } else if (type === '提醒负责人确认任务') {

      }
    }
  }
};
</script>

<style scoped>

</style>
