// 业务管理
import InfoRegister from '../pages/infoRegister';
import InspectData from '../pages/inspectData';
import ReportAudit from '../pages/reportAudit';
import ReportApproval from '../pages/reportApproval';
import ChangeReport from '../pages/changeReport';
import PrintGiveOut from '../pages/printGiveOut';
import HistoricalRecord from '../pages/historicalRecord';
import NewSample from '../pages/newSample.vue';
import InspectReport from '../pages/inspectReport';
const router = [
  {
    module: '业务管理',
    seq: 300,
    action: [
      {
        path: '/newSample',
        title: '新建样品',
        desktop: NewSample,
        notShowInMenu: true
      },
      {
        path: '/infoRegister',
        title: '信息登记',
        desktop: InfoRegister
      },
      {
        path: '/inspectReport',
        module: '检验报告',
        desktop: InspectReport,
        notShowInMenu: true
      },
      {
        path: '/inspectData',
        title: '检验数据',
        desktop: InspectData
      },
      {
        path: '/reportAudit',
        title: '报告审核',
        desktop: ReportAudit
      },
      {
        path: '/reportApproval',
        title: '报告批准',
        desktop: ReportApproval
      },
      {
        path: '/changeReport',
        title: '更改报告',
        desktop: ChangeReport
      },
      {
        path: '/printGiveOut',
        title: '打印发放',
        desktop: PrintGiveOut
      },
      {
        path: '/historicalRecord',
        title: '历史记录',
        desktop: HistoricalRecord
      }
    ]
  }
];

export const businessMenu = (() => {
  // todo
  return router;
})();
