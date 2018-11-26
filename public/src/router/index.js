import Vue from 'vue';
import Router from 'vue-router';
import Login from '../pages/login';
import Register from '../pages/register';
import Index from '../pages/index';
import BusinessManage from '../pages/businessManage';
import BusinessDetail from '../pages/businessDetail';
import ConfirmMessage from '../pages/confirmMessage';
import ReportManage from '../pages/reportManage';
import ReportDetail from '../pages/reportDetail';
import MissionManage from '../pages/missionManage';
import ViewReceiving from '../pages/viewReceiving';
import DataImport from '../pages/dataImport';
import ViewProgress from '../pages/viewProgress';
import SampleManage from '../pages/sampleManage';
import SampleCheckIn from '../pages/sampleCheckIn';
import SampleCheckOut from '../pages/sampleCheckOut';
import ConfirmCheckOut from '../pages/confirmCheckOut';
import CheckInProgress from '../pages/checkInProgress';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      meta: {
        isNotShowMenu: true,
        isNotInMenuList: true
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register,
      meta: {
        isNotShowMenu: true,
        isNotInMenuList: true
      }
    },
    {
      path: '/index',
      name: '首页',
      component: Index
    },
    {
      path: '/businessManage',
      name: '业务订单管理',
      component: BusinessManage
    },
    {
      path: '/businessDetail',
      name: '业务详情',
      component: BusinessDetail,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/confirmMessage',
      name: '确认业务信息',
      component: ConfirmMessage,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/reportManage',
      name: '报告管理',
      component: ReportManage
    },
    {
      path: '/reportDetail',
      name: '报告详情',
      component: ReportDetail,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/missionManage',
      name: '任务管理',
      component: MissionManage
    },
    {
      path: '/viewReceiving',
      name: '查看领取进度',
      component: ViewReceiving,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/dataImport',
      name: '数据录入',
      component: DataImport,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/viewProgress',
      name: '数据录入',
      component: ViewProgress,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/sampleManage',
      name: '样品管理',
      component: SampleManage
    },
    {
      path: '/sampleCheckIn',
      name: '样品入库登记',
      component: SampleCheckIn,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/sampleCheckOut',
      name: '样品出库登记',
      component: SampleCheckOut,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/confirmCheckOut',
      name: '出库确认',
      component: ConfirmCheckOut,
      meta: {
        isNotInMenuList: true
      }
    },
    {
      path: '/checkInProgress',
      name: '出库确认',
      component: CheckInProgress,
      meta: {
        isNotInMenuList: true
      }
    },
  ]
});
