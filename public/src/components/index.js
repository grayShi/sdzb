import menuComponent from './menuComponent';
import pageMainBody from './pageMainBody';

const components = {
  menuComponent,
  pageMainBody
};

export default function (Vue) {
  Object.keys(components).forEach((key) => {
    Vue.component(key, components[key]);
  });
};
