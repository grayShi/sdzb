// 报告查询
import ReportSearch from '../pages/reportSearch';
import ReportStatistics from '../pages/reportStatistics';
import ReworkStatistics from '../pages/reworkStatistics';
import CompleteRate from '../pages/completeRate';
import TardinessReport from '../pages/tardinessReport';
import ApproveManage from '../pages/approveManage';
const router = [
  {
    module: '报告查询',
    seq: 400,
    action: [
      {
        path: '/reportSearch',
        title: '报告查询',
        desktop: ReportSearch
      },
      {
        path: '/reworkStatistics',
        title: '报告返工统计',
        desktop: ReworkStatistics
      },
      {
        path: '/reportStatistics',
        title: '报告统计',
        desktop: ReportStatistics
      },
      {
        path: '/completeRate',
        title: '定检完成率',
        desktop: CompleteRate
      },
      {
        path: '/tardinessReport',
        title: '拖期报告',
        desktop: TardinessReport
      },
      {
        path: '/approveManage',
        title: '批准统计',
        desktop: ApproveManage
      }
    ]
  }
];

export const reportMenu = (() => {
  // todo
  return router;
})();
