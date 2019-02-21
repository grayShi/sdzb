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
    name: "moduleMaintain",
    data () {
      return {
        title: '系统模块维护',
        columns: [
          {
            prop: 'number',
            label: '序号'
          },
          {
            prop: 'moduleName',
            label: '模块名称'
          },
          {
            prop: 'modulePath',
            label: '模块路径'
          },
          {
            prop: 'connectionParameter',
            label: '连接参数'
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
