import _ from 'lodash';

const validateNumber = (rule, value, callback) => {
  if (isNaN(value)) {
    callback(new Error('请输入数字值'));
  } else {
    callback();
  }
};

export default {
  methods: {
    requiredInput (str, trigger = 'blur', type = 'string') {
      return { required: true, message: `请输入${str}`, trigger, type };
    },
    maxInput (max, trigger = 'blur') {
      return { max: max, message: `输入不超过${max}个字符`, trigger };
    },
    inputNumber (trigger = 'blur') {
      return { validator: validateNumber, trigger };
    },
    onAlertSuccess (message) {
      return this.$alert(message, '消息', {
        dangerouslyUseHTMLString: true
      });
    },
    onAlertConfirm (message) {
      return this.$confirm(message, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      });
    },
    onAlertError (message) {
      this.$message({
        message,
        type: 'error'
      });
    },
    formatGetTableData (data) {
      let totalData = [];
      let totalLength = 0;
      _.each(data, item => {
        totalData = totalData.concat(item.content ? item.content : item);
        totalLength += item.totalElements || 0;
      });
      return {totalData, totalLength};
    },
    setColumnsDisabled (columns, props = []) { // set columns disabled in props
      _.each(columns, item => {
        if (props.length > 0 && props.indexOf(item.prop) >= 0) {
          item.disabled = true;
        } else {
          item.disabled = true;
        }
      });
    },
    formatParams (params) {
      const newParams = [];
      for (const obj in params) {
        newParams.push(`${obj}=${params[obj]}`);
      }
      return newParams.join('&');
    }
  }
};
