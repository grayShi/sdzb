<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <el-row style="margin-top: 10px">
        <el-button type="info">新建原始记录表</el-button>
      </el-row>
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
  name: 'templateManage',
  data () {
    return {
      title: '标准库',
      columns: [
        {
          prop: 'tableNo',
          label: '记录表编号'
        },
        {
          prop: 'tableName',
          label: '记录表名称'
        },
        {
          prop: 'tableCreatedAt',
          label: '创建时间'
        },
        {
          prop: 'operation',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      searchData: [
        {
          tableNo: 1,
          tableName: '记录表1',
          tableCreatedAt: '2018-11-28'
        },
        {
          tableNo: 2,
          tableName: '记录表2',
          tableCreatedAt: '2018-11-28'
        },
        {
          tableNo: 3,
          tableName: '记录表1',
          tableCreatedAt: '2018-11-28'
        }

      ]
    };
  }
};
</script>

<style scoped>

</style>
