// 设备管理
import AddDevice from '../pages/addDevice';
import DeviceStatistics from '../pages/deviceStatistics';

const router = [
  {
    module: '设备管理',
    seq: 800,
    action: [
      {
        path: '/deviceStatistics',
        title: '设备统计',
        desktop: DeviceStatistics
      },
      {
        path: '/addDevice',
        title: '设备登记',
        desktop: AddDevice
      }
    ]
  }
];

export const deviceMenu = (() => {
  // todo
  return router;
})();
