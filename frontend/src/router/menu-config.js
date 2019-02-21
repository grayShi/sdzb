import Hello from '../pages/hello';

const router = [
  {
    path: '/',
    module: '登录',
    desktop: Hello,
    seq: 100
  }
];

export const menu = (() => {
  // todo
  return router;
})();
