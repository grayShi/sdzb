<template>
  <div style="height: 100%">
    <el-row class="head-message">
      <el-col :span="8" :offset="3">
        <el-card>
          <el-row>
            <el-col :span="10">
              <div class="message-body">
                <img src="../assets/logo.png" title="用户头像" class="image">
              </div>
            </el-col>
            <el-col :span="14">
              <div class="message-body">
                <div>
                  <span>姓名，工号</span>
                  <div style="margin-top: 5px">
                    <span>消息中心</span>
                    <span>新闻公告</span>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
      <el-col :span="8" :offset="2">
        <el-card>
          <el-row>
            <el-col :span="12">
              <div class="message-body">
                <span>
                  时间
                </span>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="message-body">
                <span>日历</span>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="22" :offset="1">
        <div class="business-table">
          <light-table :data="searchData" :columns="columns" :rowClass="tableRowClassName">
            <template slot="operation" slot-scope="props">
              <el-button v-if="showButton(props.prop.status, '确认任务信息')" size="mini" @click="goToDetail('确认任务信息', props.prop)">确认任务信息</el-button>
              <el-button v-if="showButton(props.prop.status, '查看抽样进度')" size="mini" @click="goToDetail('查看抽样进度', props.prop)">查看抽样进度</el-button>
              <el-button v-if="showButton(props.prop.status, '分配任务')" size="mini" @click="goToDetail('分配任务', props.prop)">分配任务</el-button>
              <el-button v-if="showButton(props.prop.status, '查看抽检进度')" size="mini" @click="goToDetail('查看抽检进度', props.prop)">查看抽检进度</el-button>
              <el-button v-if="showButton(props.prop.status, '审核')" size="mini" @click="goToDetail('审核', props.prop)">审核</el-button>
              <el-button v-if="showButton(props.prop.status, '查看抽检结果')" size="mini" @click="goToDetail('查看抽检结果', props.prop)">查看抽检结果</el-button>
              <el-button v-if="showButton(props.prop.status, '查看审核进度')" size="mini" @click="goToDetail('查看审核进度', props.prop)">查看审核进度</el-button>
              <el-button v-if="showButton(props.prop.status, '查看报告')" size="mini" @click="goToDetail('查看报告', props.prop)">查看报告</el-button>
              <el-button v-if="showButton(props.prop.status, '业务详情')" size="mini" @click="goToDetail('业务详情', props.prop)">业务详情</el-button>
            </template>
          </light-table>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import '../css/business.css';
import _ from 'lodash';
export default {
  name: 'business',
  data () {
    return {
      searchData: [
        {
          businessNo: 1,
          businessName: '质检1',
          createdAt: '2018-11-24',
          sampleName: '样品1',
          sampleNo: '编号1',
          samplingMethod: '',
          status: '待处理'
        },
        {
          businessNo: 2,
          businessName: '质检2',
          createdAt: '2018-11-24',
          sampleName: '样品2',
          sampleNo: '编号2',
          samplingMethod: '送检抽样',
          status: '抽样中'
        },
        {
          businessNo: 3,
          businessName: '质检3',
          createdAt: '2018-11-24',
          sampleName: '样品3',
          sampleNo: '编号3',
          samplingMethod: '现场抽样',
          status: '正在抽检'
        },
        {
          businessNo: 4,
          businessName: '质检4',
          createdAt: '2018-11-24',
          sampleName: '样品5',
          sampleNo: '编号4',
          samplingMethod: '',
          status: '正在审核'
        },
        {
          businessNo: 5,
          businessName: '质检5',
          createdAt: '2018-11-24',
          sampleName: '样品5',
          sampleNo: '编号5',
          samplingMethod: '',
          status: '已完成'
        },
        {
          businessNo: 6,
          businessName: '质检6',
          createdAt: '2018-11-24',
          sampleName: '样品6',
          sampleNo: '编号6',
          samplingMethod: '',
          status: '已删除'
        }
      ],
      columns: [
        {
          prop: 'businessNo',
          label: '业务编号'
        }, {
          prop: 'businessName',
          label: '业务名称',
          type: {
            linkable: true,
            linkUrl: '/#/businessDetail'
          }
        }, {
          prop: 'createdAt',
          label: '创建时间'
        }, {
          prop: 'sampleName',
          label: '样品'
        }, {
          prop: 'sampleNo',
          label: '样品编号'
        }, {
          prop: 'samplingMethod',
          label: '抽样方式'
        }, {
          prop: 'status',
          label: '业务状态'
        },
        {
          prop: 'operation',
          label: '操作',
          width: 150,
          type: {
            operate: true
          }
        }]
    };
  },
  methods: {
    goToDetail (type, scope) {
      if (type === '确认任务信息') {
        this.$router.push('/confirmMessage');
      } else if (type === '查看抽样进度') {

      } else if (type === '分配任务') {

      } else if (type === '查看抽检进度') {
        this.$router.push('/viewInspectProgress');
      } else if (type === '审核') {
        this.$router.push('/auditing');
      } else if (type === '查看抽检结果') {
        this.$router.push('/viewInspectResult');
      } else if (type === '查看审核进度') {
        this.$router.push('/viewProgress');
      } else if (type === '查看报告') {

      } else if (type === '业务详情') {

      }
    },
    tableRowClassName ({ row }) {
      if (row.status === '已删除') {
        return 'delete-row';
      }
      return '';
    },
    showButton (status, action) {
      const form = [
        {
          status: '待处理',
          show: ['确认任务信息']
        },
        {
          status: '抽样中',
          show: ['查看抽样进度', '分配任务']
        },
        {
          status: '正在抽检',
          show: ['查看抽检进度', '审核']
        },
        {
          status: '正在审核',
          show: ['查看抽检结果', '查看审核进度']
        },
        {
          status: '已完成',
          show: ['查看报告']
        },
        {
          status: '已删除',
          show: ['业务详情']
        }
      ];
      const find = _.filter(form, item => item.status === status && item.show.indexOf(action) >= 0);
      return find.length > 0;
    }
  }
};
</script>

<style scoped>

</style>
