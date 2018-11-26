<template>
  <div class="login-body">
    <div class="login-box">
      <div class="login-div">
        <div><h3>淄博质检所LIMS系统</h3></div>
        <el-form ref="form" :model="form" :rules="loginRules" label-width="80px">
          <el-form-item label="账号" prop="username">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="form.password"></el-input>
          </el-form-item>
        </el-form>
        <div class="login-forget">
          <span><a :href="goToLink('register')">立即注册</a></span>
          <span><a :href="goToLink('forget')">忘记密码</a></span>
        </div>
        <el-button type="primary" size="small" @click="login">登陆</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import '../css/loginCSS.css';
export default {
  name: 'login',
  data () {
    return {
      form: {
        username: '',
        password: ''
      },
      loginRules: {
        username: [
          this.requiredInput('用户名')
        ],
        password: [
          this.requiredInput('密码')
        ]
      }
    };
  },
  methods: {
    login () {
      // this.$refs.form.validate(valid => {
      //
      // });
      this.$router.push('/index');
    },
    goToLink (action) {
      return `/#/register?action=${action}`;
    }
  }
};
</script>

<style scoped>

</style>
