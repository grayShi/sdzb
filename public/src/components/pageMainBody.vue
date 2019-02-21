<template>
  <div style="height: 100%"  v-loading.fullscreen.lock="loading">
    <h2 v-if="!!title">
      <img :src="`/static/img/标题.png`"/>
      <span>{{title}}</span>
    </h2>
    <div class="page-body">
      <slot></slot>
    </div>
    <div :class="{'page-body-margin': !!$slots.footer }">
    </div>
    <div class="page-footer" v-if="!!$slots.footer">
      <slot name="footer"></slot>
    </div>
  </div>

</template>

<script>
export default {
  name: 'pageMainBody',
  props: {
    title: {
      type: String,
      default: () => {
        return '';
      }
    },
    loading: {
      type: Boolean,
      default: () => {
        return false;
      }
    }
  }
};
</script>

<style scoped lang="scss">
  @import "../scss/params";
  .page-body {
    display: flex;
    align-items: center;
    justify-content: center;
    &-margin {
      height: $page-footer-height - 20px;
    }
    div:first-child {
      width: 100% !important;
    }
  }
  .page-footer {
    height: $page-footer-height;
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    margin:0 auto;
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 500;
    border-top: 1px solid #c7ccd1;
    background-image: linear-gradient(to bottom, white 0%, #f7f7f7 50%, #f2f2f2 80%, #eee 100%);
    box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
    /*padding-bottom: 20px;*/
  }
  h2 {
    color: #285f85;
    span {
      margin-left: 5px;
    }
  }
</style>
