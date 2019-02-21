import BlankPage from '../pages/blankPage';
import AddComputer from '../pages/addComputer';
import ComputerQuery from '../pages/computerQuery';

const router = [
  {
    path: '/blank',
    module: '考勤打卡',
    seq: 100,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '流程管理',
    seq: 200,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '报表管理',
    seq: 300,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '文档中心',
    seq: 400,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '公告管理',
    seq: 500,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '会议管理',
    seq: 600,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '用车管理',
    seq: 700,
    desktop: BlankPage
  },
  {
    path: '/blank',
    module: '公章管理',
    seq: 800,
    desktop: BlankPage
  },
  {
    module: '微机管理',
    seq: 900,
    action: [
      {
        path: '/addComputer',
        title: '计算机登记',
        desktop: AddComputer
      },
      {
        path: '/computerQuery',
        title: '计算机查询',
        desktop: ComputerQuery
      }
    ]
  }, {
    module: '文件管理',
    seq: 1000,
    action: []
  }
];
export const oaMenu = (() => {
  // todo
  return router;
})();
