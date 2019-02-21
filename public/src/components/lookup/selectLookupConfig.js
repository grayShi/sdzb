import axios from 'axios';
import commonFunc from '../../mixins/common';
const getSampleDataList = (condition) => axios.get(`/api/enterprises?${condition}`);

const commonMethods = commonFunc.methods;

export default {
  company: {
    title: '查找企业',
    func: (searchCondition, page, size) => {
      return getSampleDataList(commonMethods.formatParams({ keyWord: searchCondition, page, size }));
    },
    columns: [
      {
        prop: 'comName',
        label: '企业名称'
      },
      {
        prop: 'comCode',
        label: '企业代码'
      },
      {
        prop: 'comAddress',
        label: '地址'
      },
      {
        prop: 'comPostNo',
        label: '邮编'
      },
      {
        prop: 'comPhone',
        label: '电话'
      },
      {
        prop: 'comContact',
        label: '联系人'
      }
    ],
    returnFields: 'comName'
  }
};
