// 系统维护
import FindPassword from '../pages/findPassword';
import ChangePassword from '../pages/changePassword';
import SetAuthority from '../pages/setAuthority';
import TemplateMaintain from '../pages/templateMaintain';
import AnnouncementManage from '../pages/announcementManage';
const router = [
  {
    module: '系统维护',
    seq: 1100,
    action: [
      {
        path: '/setAuthority',
        title: '权限维护',
        desktop: SetAuthority
      },
      {
        path: '/templateMaintain',
        title: '模板维护',
        desktop: TemplateMaintain
      },
      {
        path: '/findPassword',
        title: '找回密码',
        desktop: FindPassword
      },
      {
        path: '/changePassword',
        title: '修改密码',
        desktop: ChangePassword
      },
      {
        path: '/announcementManage',
        title: '公告管理',
        desktop: AnnouncementManage
      }
    ]
  }
];

export const systemMenu = (() => {
  // todo
  return router;
})();
