export default {
  methods: {
    requiredInput (str, trigger = 'blur', type = 'string') {
      return { required: true, message: `请输入${str}`, trigger, type }
    },
    maxInput (max, trigger = 'blur') {
      return { max: max, message: `输入不超过${max}个字符`, trigger }
    }
  }
}
