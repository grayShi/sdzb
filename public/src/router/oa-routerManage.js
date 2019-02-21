import { oaMenu } from '../router/oa-menu-config';
import _ from 'lodash';

const totalOAMenu = [].concat(oaMenu).map(menu => {
  if (!menu.notShowInMenu) {
    menu.menuImage = `/static/img/oamenuIcon/${menu.module}.png`;
  }
  return menu;
});

export default _.sortBy(totalOAMenu, item => Number(item.seq));
