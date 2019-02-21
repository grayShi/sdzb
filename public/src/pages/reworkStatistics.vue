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
      name: "reworkStatistics",
      data () {
        return {
          title: '报告返工信息统计',
          columns: [
            {
              prop: 'reportNo',
              label: '报告编号'
            },
            {
              prop: 'employer',
              label: '返工人'
            },
            {
              prop: 'employee',
              label: '被返工人'
            },
            {
              prop: 'department',
              label: '部门'
            }
          ],
          searchData: []
        };
      }
    }
</script>

<style scoped>

</style>
