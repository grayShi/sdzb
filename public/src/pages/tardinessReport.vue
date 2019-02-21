<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <light-table :data="searchData" :columns="columns" style="width: 95%">
        <template slot="operation" slot-scope="props">
          <el-button size="mini">查看</el-button>
          <el-button size="mini">编辑</el-button>
          <el-button size="mini" type="danger">删除</el-button>
        </template>
      </light-table>
    </div>
  </page-main-body>
</template>

<script>
    export default {
      name: "tardinessReport",
      data () {
        return {
          title: '拖期报告',
          columns: [
            {
              prop: 'department',
              label: '部门'
            },
            {
              prop: 'reportNo',
              label: '报告数'
            },
            {
              prop: 'tardinessRe',
              label: '拖期报告'
            },
            {
              prop: 'tardinessRate',
              label: '拖期率'
            }
          ]
        }
      }
    }
</script>

<style scoped>

</style>
