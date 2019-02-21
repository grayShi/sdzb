// 财务管理
import FeeRegister from '../pages/feeRegister';
import FeeAudit from '../pages/feeAudit';
import FeeResearch from '../pages/feeResearch';
import RelationRemove from '../pages/relationRemove';
import FinancialManage from '../pages/financialManage';
import DetailManage from '../pages/detailManage';
const router = [
  {
    module: '财务管理',
    seq: 500,
    action: [
      {
        path: '/feeRegister',
        title: '收费登记',
        desktop: FeeRegister
      },
      {
        path: '/feeAudit',
        title: '收费核实',
        desktop: FeeAudit
      },
      {
        path: '/feeResearch',
        title: '收费查询',
        desktop: FeeResearch
      },
      {
        path: '/relationRemove',
        title: '关联取消',
        desktop: RelationRemove
      },
      {
        path: '/financialManage',
        title: '财务统计',
        desktop: FinancialManage
      },
      {
        path: '/detailManage',
        title: '明细统计',
        desktop: DetailManage
      }
    ]
  }
];

export const financialMenu = (() => {
  // todo
  return router;
})();
