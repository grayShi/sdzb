<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <el-row>
        <el-col :span="8">
          <light-table :data="approveData" :columns="approveColumns" :showSearch="false" tableTitle="批准数量">
          </light-table>
        </el-col>
        <el-col :span="7" :offset="1">
          <light-table :data="notPayData" :columns="notPayColumns" :showSearch="false" tableTitle="未收费数量">
          </light-table>
        </el-col>
        <el-col :span="7" :offset="1">
          <light-table :data="payData" :columns="payColumns" :showSearch="false" tableTitle="收费数量">
          </light-table>
        </el-col>
      </el-row>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'approveManage',
  data () {
    return {
      title: '批准统计',
      approveData: [],
      approveColumns: [
        {
          prop: 'name',
          label: '姓名'
        }, {
          prop: 'department',
          label: '部门'
        }, {
          prop: 'approveCount',
          label: '批准数量'
        }
      ],
      payData: [],
      payColumns: [
        {
          prop: 'department',
          label: '部门'
        }, {
          prop: 'payCount',
          label: '收费数量'
        }
      ],
      notPayData: [],
      notPayColumns: [
        {
          prop: 'department',
          label: '部门'
        }, {
          prop: 'notPayCount',
          label: '未收费数量'
        }
      ]

    };
  }
};
</script>

<style scoped>

</style>
