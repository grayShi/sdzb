// 样品管理
import CustomReceive from '../pages/customReceive';
import SampleMaintain from '../pages/sampleMaintain';
import SampleStorage from '../pages/sampleStorage';
import SampleReceive from '../pages/sampleReceive'
import SampleWithdraw from '../pages/sampleWithdraw';


const router = [
  {
    module: '样品管理',
    seq: 900,
    action: [
      {
        path: '/sampleMaintain',
        title: '样品维护',
        desktop: SampleMaintain
      },
      {
        path: '/customReceive',
        title: '顾客领取',
        desktop: CustomReceive
      },
      {
        path: '/sampleStorage',
        title: '样品入库',
        desktop: SampleStorage
      },
      {
        path: '/sampleReceive',
        title: '样品领取',
        desktop: SampleReceive
      },
      {
        path: '/sampleWithdraw',
        title: '样品退样',
        desktop:SampleWithdraw
      }
    ]
  }
];


export const sampleMenu = (() => {
  // todo
  return router;
})();
