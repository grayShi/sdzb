<template>
  <el-container style="height:100%; border: 1px solid #eee">
    <el-aside width="auto">
      <el-scrollbar class="menu-body">
        <el-menu :collapse="isCollapseLeft" :default-active="defaultActive"
                 @select="selectMenu($event, 'left')"
                 unique-opened >
          <li class="el-menu-item menu-icon menu-icon-left">
            <img :src="`/static/img/菜单.png`" @click="isCollapseLeft = !isCollapseLeft"/>
          </li>
        <!--<div v-for="(menu, index) in totalLeftMenu" :key="setIndex(index)">-->
        <el-menu-item :class="{'collapse-width': !isCollapseLeft}" v-for="(menu, index) in totalLeftMenu" :key="setIndex('left', index)" :index="setIndex('left',index, undefined, menu.module)" @click="goTo(menu.path)" v-if="!menu.action && !menu.notShowInMenu">
          <img :src="menu.menuImage"/>
          <span slot="title">{{menu.module}}</span>
        </el-menu-item>

        <el-submenu :class="{'collapse-width': !isCollapseLeft}" v-for="(menu, index) in totalLeftMenu" :key="setIndex('left',index)" :index="setIndex('left',index)" v-if="menu.action">
          <template slot="title">
            <img :src="menu.menuImage"/>
            <span slot="title">{{menu.module}}</span>
          </template>
          <el-menu-item-group>
            <div v-for="(subMenu, subIndex) in menu.action" :key="setIndex('left',index,subIndex)">
              <el-menu-item :class="{'collapse-width': !isCollapseLeft}" :index="setIndex('left',index, subIndex, subMenu.title)" @click="goTo(subMenu.path)"
                            v-if="!subMenu.notShowInMenu">
                {{subMenu.title}}
              </el-menu-item>
            </div>
          </el-menu-item-group>
        </el-submenu>
        <!--</div>-->
      </el-menu>
      </el-scrollbar>
    </el-aside>
    <el-container>
      <el-header>
        <img :src="`/static/img/logo.png`"/>
        <div class="head-message">
          <span class="head-time">{{now}}</span>
          <el-dropdown>
            <span class="head-user">
              王练<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>修改密码</el-dropdown-item>
              <el-dropdown-item>注销</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-header>
      <el-scrollbar class="page-main-body">
        <el-main>
          <slot></slot>
        </el-main>
      </el-scrollbar>
    </el-container>
    <el-aside width="auto" style="background-color: white">
      <el-scrollbar class="menu-body menu-body-right">
        <el-menu :collapse="isCollapseRight" :default-active="defaultActive"
                 @select="selectMenu($event, 'right')"
               unique-opened>
          <li class="el-menu-item menu-icon menu-icon-right">
            <img :src="`/static/img/菜单.png`" @click="isCollapseRight = !isCollapseRight"/>
          </li>
        <!--<div v-for="(menu, index) in totalRightMenu" :key="setIndex('right',index)">-->
        <el-menu-item :class="{'collapse-width': !isCollapseRight}" v-for="(menu, index) in totalRightMenu" :key="setIndex('right',index)" :index="setIndex('right',index, undefined, menu.module)" @click="goTo(menu.path)" v-if="!menu.action && !menu.notShowInMenu">
          <img :src="menu.menuImage"/>
          <span slot="title">{{menu.module}}</span>
        </el-menu-item>

        <el-submenu :class="{'collapse-width': !isCollapseRight}" v-for="(menu, index) in totalRightMenu" :key="setIndex('right',index)" :index="setIndex('right',index)" v-if="menu.action">
          <template slot="title">
            <img :src="menu.menuImage"/>
            <span slot="title">{{menu.module}}</span>
          </template>
          <el-menu-item-group>
            <div v-for="(subMenu, subIndex) in menu.action" :key="setIndex('right',index,subIndex)">
              <el-menu-item :class="{'collapse-width': !isCollapseRight}" :index="setIndex('right',index, subIndex, subMenu.title)" @click="goTo(subMenu.path)"
                            v-if="!subMenu.notShowInMenu">
                {{subMenu.title}}
              </el-menu-item>
            </div>
          </el-menu-item-group>
        </el-submenu>
        <!--</div>-->
      </el-menu>
      </el-scrollbar>
    </el-aside>
  </el-container>
</template>

<script>
import _ from 'lodash';
import totalMenu from '../router/routerManage';
import totalOAMenu from '../router/oa-routerManage';
import moment from 'moment';

export default {
  name: 'menuComponent',
  data () {
    return {
      isCollapseLeft: false,
      isCollapseRight: false,
      totalLeftMenu: totalMenu,
      totalRightMenu: totalOAMenu,
      menuIndex: {},
      asideWidth: '200px',
      defaultActive: '',
      now: '',
      timer: ''
    };
  },
  beforeMount () {
    // 设置定时器，每1秒刷新一次
    let self = this;
    this.timer = setInterval(() => {
      self.now = moment().format('YYYY-MM-DD HH:mm:ss');
    }, 1000);
    self.now = moment().format('YYYY-MM-DD HH:mm:ss');
  },
  mounted () {
    const pageName = this.$route.name;
    const findLi = document.getElementsByTagName('li');
    _.each(findLi, item => {
      if (item.innerText.trim() === pageName) {
        item.classList.add('is-active');
        // item.parentElement.parentElement.parentElement.parentElement.style.display = '';
        // item.parentElement.parentElement.parentElement.parentElement.parentElement.classList.add('is-opened');
      }
    });
    this.defaultActive = this.menuIndex[this.$route.name];
  },
  beforeDestroy () {
    if (this.timer) {
      clearInterval(this.timer);
    }
  },
  methods: {
    goTo (path) {
      this.$router.push(`${path}`);
    },
    selectMenu (index, str) {
      const self = this;
      let removeClass = [];
      const menu = document.getElementsByClassName('menu-body');
      _.each(menu, subMenu => {
        if (subMenu.classList.contains('menu-body-right')) {
          if (str === 'left') {
            _.each(subMenu.getElementsByClassName('is-active'), el => {
              removeClass.push(el);
            });
          } else {
            _.each(subMenu.getElementsByClassName('is-active'), item => {
              if (item && self.menuIndex[item.innerText.trim()] !== index && item.tagName === 'LI' && item.children.length === 0) {
                removeClass.push(item);
              }
            });
          }
        } else {
          if (str === 'right') {
            _.each(subMenu.getElementsByClassName('is-active'), el => {
              removeClass.push(el);
            });
          } else {
            _.each(subMenu.getElementsByClassName('is-active'), item => {
              if (item && self.menuIndex[item.innerText.trim()] !== index && item.tagName === 'LI' && item.children.length === 0) {
                removeClass.push(item);
              }
            });
          }
        }
      });
      if (removeClass.length > 0) {
        _.each(removeClass, item => {
          item.classList.remove('is-active');
        });
      }
    },
    setIndex (str, index, subIndex = undefined, title) {
      if (subIndex !== undefined && subIndex + 1) {
        this.menuIndex[title] = `${str}-${index + 1}-${subIndex + 1}`;
        return `${str}-${index + 1}-${subIndex + 1}`;
      }
      this.menuIndex[title] = `${str}-${index + 1}`;
      return `${str}-${index + 1}`;
    }
  }
};
</script>

<style lang="scss">
  @import "../scss/menuComponent.scss";
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
    overflow: visible;
  }

  .menu-body-right {
    height: 100% !important;
    border-left: solid 1px #e6e6e6;
  }
  .page-main-body {
    height: 100%;
  }
</style>
