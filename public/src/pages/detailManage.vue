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
  name: 'detailManage',
  data () {
    return {
      columns: [
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'cost',
          label: '3C检验费'
        },
        {
          prop: 'checkPrice',
          label: '定期监督检验费'
        },
        {
          prop: 'total',
          label: '发证检验费'
        },
        {
          prop: 'total',
          label: '公告费'
        },
        {
          prop: 'total',
          label: '国抽经费'
        },
        {
          prop: 'total',
          label: '国有资产处置收入'
        },
        {
          prop: 'total',
          label: '合格率统计调查费'
        },
        {
          prop: 'total',
          label: '监督检验复查费'
        },
        {
          prop: 'total',
          label: '其他国有资产有偿使用收入'
        },
        {
          prop: 'total',
          label: '省抽经费'
        },
        {
          prop: 'total',
          label: '委托检验费'
        },
        {
          prop: 'total',
          label: '协议费'
        },
        {
          prop: 'total',
          label: '协议费(机打)'
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
