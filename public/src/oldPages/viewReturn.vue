<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <light-table :data="searchData" :columns="columns" style="width: 95%">

      </light-table>
    </div>
  </page-main-body>

</template>

<script>
export default {
  name: 'viewReturn',
  data () {
    return {
      title: '查看返工记录',
      columns: [
        {
          prop: 'No',
          label: '序号'
        },
        {
          prop: 'people1',
          label: '主检人'
        },
        {
          prop: 'people2',
          label: '校核人'
        },
        {
          prop: 'people3',
          label: '批准人'
        },
        {
          prop: 'people4',
          label: '被返工人'
        },
        {
          prop: 'people5',
          label: '返工人'
        },
        {
          prop: 'reason',
          label: '返工原因'
        },
        {
          prop: 'time',
          label: '返工时间'
        },
        {
          prop: 'detail',
          label: '返工说明'
        }
      ],
      searchData: []
    };
  }
};
</script>

<style scoped>

</style>
