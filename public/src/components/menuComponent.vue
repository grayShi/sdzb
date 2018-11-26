<template>
  <div style="height: 100%;position: fixed;width: 100%">
    <div class="menu-title">
      <span @click="goTo('index')">淄博质检所LIMS系统</span>
    </div>
    <el-row  class="page-body">
      <el-col :span="4" class="page-menu">
        <el-menu
          default-active="2" @select="selectMenu"
          class="el-menu-vertical-demo">
          <div v-for="(menu, index) in totalMenu" :key="index">
            <el-menu-item  v-if="menu.meta ? !menu.meta.isNotInMenuList : true" :index="menu.name" @click="goTo(menu.path)">
              <i class="el-icon-menu"></i>
              <span slot="title">{{menu.name}}</span>
            </el-menu-item>
          </div>
        </el-menu>
      </el-col>
      <el-col :span="20" class="show-body">
        <slot></slot>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import _ from 'lodash';

export default {
  name: 'menuComponent',
  data () {
    return {
      isCollapse: true,
      totalMenu: []
    };
  },
  created () {
    this.totalMenu = this.$router.options.routes;
  },
  mounted () {
    const pageName = this.$route.name;
    const findLi = document.getElementsByTagName('li');
    _.each(findLi, item => {
      if (item.innerText.trim() === pageName) {
        item.classList.add('is-active');
      }
    });
  },
  methods: {
    goTo (path) {
      this.$router.push(`${path}`);
    },
    selectMenu (index) {
      const findLi = document.getElementsByClassName('is-active');
      if (findLi.length > 0) {
        _.each(findLi, item => {
          if (item.innerText.trim() !== index) {
            item.classList.remove('is-active');
          }
        });
      }
    }
  }
};
</script>

<style scoped>
  .menu-title{
    font-size: 20px;
    height: 40px;
    border-bottom: #888888 solid 2px;
    font-weight: bolder;
  }
  .menu-title span {
    margin-left: 30px;
    cursor: pointer;
    line-height: 40px;
  }
  .page-body{
    height: calc(100% - 40px);
  }
  .show-body{
    height: 100%;overflow: auto
  }
  .page-menu {
    padding-right: 20px;
  }
</style>
