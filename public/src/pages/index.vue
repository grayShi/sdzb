<template>
  <page-main-body>
    <el-row style="width:100%;height:100%">
      <el-col :span="12">
        <el-row>
          <el-card>
            <div slot="header" class="card-title">
              <span>组公告</span>
              <div class="card-title-operate">
                <img :src="`/static/img/更多.png`"/>
                <span>更多</span>
              </div>
            </div>
            <el-scrollbar style="height: 100%">
              <div v-for="item in noticeList" :key="item.title" class="card-body-item">
                <img :src="`/static/img/标题.png`"/>
                <span class="card-body-item-title">{{item.title}}</span>
                <span class="card-body-item-time">{{item.time}}</span>
              </div>
            </el-scrollbar>
          </el-card>
        </el-row>
        <el-row>
          <el-card>
            <div slot="header" class="card-title">
              <span>待办事项</span>
              <div class="card-title-operate">
                <img :src="`/static/img/更多.png`"/>
                <span>更多</span>
              </div>
            </div>
            <el-scrollbar style="height: 100%">
              <div v-for="item in noticeList" :key="item.title" class="card-body-item">
                <img :src="`/static/img/标题.png`"/>
                <span class="card-body-item-title">{{item.title}}</span>
                <span class="card-body-item-time">{{item.time}}</span>
              </div>
            </el-scrollbar>
          </el-card>
        </el-row>
      </el-col>
      <el-col :span="12">
        <el-card>
          <div slot="header" class="card-title">
            <span>实时消息</span>
            <div class="card-title-operate">
              <img :src="`/static/img/更多.png`"/>
              <span>更多</span>
            </div>
          </div>
          <el-scrollbar style="height: 100%">
            <div v-for="item in noticeList" :key="item.title" class="card-body-item">
              <img :src="`/static/img/标题.png`"/>
              <span class="card-body-item-title">{{item.title}}</span>
              <span class="card-body-item-time">{{item.time}}</span>
            </div>
          </el-scrollbar>
        </el-card>
      </el-col>
    </el-row>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
export default {
  name: 'index',
  data () {
    return {
      noticeList: [
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
        { title: '标题标题标题', time: '2019-01-22' },
      ],
    };
  },
  mounted () {
    const bodyHeight = document.getElementsByClassName('page-main-body')[0].offsetHeight;
    const cardMargin = 10;
    const pageMainMargin = 20;
    const cardBodyPadding = 20;
    document.getElementsByClassName('el-main')[0].style.padding = `${pageMainMargin}px`;
    _.each(document.getElementsByClassName('el-card'), item => {
      item.style.margin = `${cardMargin}px`;
    });
    _.each(document.getElementsByClassName('el-card__body'), item => {
      item.style.padding = `${cardBodyPadding}px`;
    });
    const cardHead = document.getElementsByClassName('el-card__header')[0].offsetHeight;
    _.each(document.getElementsByClassName('el-card__body'), item => {
      if (item.parentElement.getElementsByTagName('span')[0].innerHTML === '实时消息') {
        item.style.height = `${bodyHeight - cardMargin * 2 - cardHead - pageMainMargin * 2 - 3 - cardBodyPadding * 2}px`; // border
      } else {
        item.style.height = `${(bodyHeight - cardMargin * 4 - cardHead * 2 - pageMainMargin * 2 - 6 - cardBodyPadding * 4) / 2}px`;
      }
    });
  }

};
</script>

<style scoped lang="scss">
@import "../scss/index.scss";
</style>
