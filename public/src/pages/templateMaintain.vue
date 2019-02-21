<template>
  <page-main-body :title="title">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table :data="searchData" :columns="columns" style="width: 100%">
            <template slot="operation" slot-scope="props">
              <el-button size="mini">编辑</el-button>
              <el-button size="mini" type="danger">删除</el-button>
            </template>
          </light-table>
        </el-col>
      </el-row>
    </div>
  </page-main-body>
</template>

<script>
  export default {
    name: "templateMaintain",
    data () {
      return {
        title: '模板信息维护',
        columns: [
          {
            prop: 'name',
            label: '类型名称'
          },
          {
            prop: 'path',
            label: '类型模板路径',
            width: '300'
          },
          {
            prop: 'operation',
            label: '操作',
            type: {
              operate: true
            }
          }
        ],
        searchData:[]
      };
    }
  }
</script>

<style scoped>

</style>
