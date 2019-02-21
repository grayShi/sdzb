// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import global from '../src/mixins/globalMessage';
import printPdf from '../src/pdf/printPDF';
import axios from 'axios';

import { MessageBox } from 'element-ui';

import Components from './components/index';
import Mixins from './mixins/index';

Vue.config.productionTip = false;

Object.keys(global).forEach(key => {
  Vue.prototype[key] = global[key];
});
//
// axios.interceptors.request.use(function (config) {
//   debugger;
//   return config;
// }, function (error) {
//   // 请求错误
//   return Promise.reject(error);
// });
axios.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    if (!error.response) {
      return Promise.reject(error);
    } else {
      const msg = `${error.response.data.message || ''} 请联系管理员`;
      MessageBox.alert(msg, '出错啦', {
        showClose: false,
        type: 'error'
      });
      // this.onAlertError(error.response.data.message);
      return Promise.reject(error);
    }
  }
);

Vue.use(ElementUI);
Vue.use(Components);
Vue.use(Mixins);
Vue.use(printPdf);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});
