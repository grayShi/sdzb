import {menu} from './menu-config';
import {basicMenu} from './menu-config-basic';
import {businessMenu} from './menu-config-business';
import {companyMenu} from './menu-config-company';
import {deviceMenu} from './menu-config-device';
import {financialMenu} from './menu-config-financial';
import {reportMenu} from './menu-config-report';
import {sampleMenu} from './menu-config-sample';
import {standardMenu} from './menu-config-standard';
import {systemMenu} from './menu-config-system';
import _ from 'lodash';

const totalMenu = [].concat(menu)
  .concat(basicMenu)
  .concat(businessMenu)
  .concat(companyMenu)
  .concat(deviceMenu)
  .concat(financialMenu)
  .concat(reportMenu)
  .concat(sampleMenu)
  .concat(systemMenu)
  .concat(standardMenu).map(menu => {
    if (!menu.notShowInMenu) {
      menu.menuImage = `/static/img/menuIcon/${menu.module}.png`;
    }
    return menu;
  });

export default _.sortBy(totalMenu, item => Number(item.seq));
