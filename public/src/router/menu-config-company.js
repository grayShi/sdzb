// 企业管理
import AddCompany from '../pages/addCompany';
import CompanyQuery from '../pages/companyQuery';

const router = [
  {
    module: '企业管理',
    seq: 700,
    action: [
      {
        path: '/addCompany',
        title: '企业新增',
        desktop: AddCompany
      },
      {
        path: '/companyQuery',
        title: '企业查询',
        desktop: CompanyQuery
      }
    ]
  }
];

export const companyMenu = (() => {
  // todo
  return router;
})();
