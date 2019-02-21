import menuComponent from './menuComponent';
import pageMainBody from './pageMainBody';
import lightTable from './lightTable';
import selectLookUp from './lookup/selectLookUp';

const components = {
  menuComponent,
  pageMainBody,
  lightTable,
  selectLookUp
};

export default function (Vue) {
  Object.keys(components).forEach((key) => {
    Vue.component(key, components[key]);
  });
};
