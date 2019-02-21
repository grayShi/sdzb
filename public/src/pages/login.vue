<template>
  <div class="login-body login-body-img">
    <div class="login-box login-box-img">
      <div class="login-box-body">
        <div class="login-box-title">
          <img :src="`/static/img/logo.png`"/>
        </div>
        <div class="login-box-form">
          <h3>登录</h3>
          <h3>L O G I N</h3>
          <div class="login-box-form-input">
            <el-input :placeholder="$placeholder.input" v-model="form.username">
              <template slot="prepend">
                <img :src="`/static/img/login/登录用户名.png`"/>
              </template>
            </el-input>
            <el-input :placeholder="$placeholder.input" v-model="form.password">
              <template slot="prepend">
                <img :src="`/static/img/login/登录密码.png`"/>
              </template>
            </el-input>
          </div>
          <div class="login-box-form-href">
            <span><a :href="goToLink('register')">立即注册</a></span>
            <span><a :href="goToLink('forget')">忘记密码</a></span>
          </div>
          <div class="login-box-footer">
            <el-button type="primary" @click="login">登录系统</el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
// const loginForm = (form) => axios.post()

export default {
  name: 'login',
  data () {
    return {
      form: {
        username: '',
        password: ''
      }
    };
  },
  methods: {
    login () {
      if (this.form.username && this.form.password) {

      }
      this.$router.push('/index');
    },
    goToLink (action) {
      return `/#/register?action=${action}`;
    }
  }
};
</script>

<style lang="scss">
@import "../scss/login";
</style>
