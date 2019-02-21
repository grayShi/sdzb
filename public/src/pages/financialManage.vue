<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <light-table :showSearch="false"
                   :remote="true" :remoteMethod="doQuery"
                   :columns="columns">
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'financialManage',
  data () {
    return {
      columns: [
        {
          prop: 'manage',
          label: '财务统计'
        },
        {
          prop: 'cost',
          label: '合格率统计调查费'
        },
        {
          prop: 'checkPrice',
          label: '委托检验费'
        },
        {
          prop: 'total',
          label: '总计'
        }
      ]
    };
  },
  methods: {
    doQuery () {

    }
  }
};
</script>

<style scoped>

</style>
