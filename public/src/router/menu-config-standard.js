// 标准管理
import StandardQuery from '../pages/standardQuery';
import AddStandard from '../pages/addStandard';
const router = [
  {
    module: '标准管理',
    seq: 600,
    action: [
      {
        path: '/addStandard',
        title: '标准添加',
        desktop: AddStandard
      },
      {
        path: '/standardQuery',
        title: '标准查询',
        desktop: StandardQuery
      }
    ]
  }
];

export const standardMenu = (() => {
  // todo
  return router;
})();
