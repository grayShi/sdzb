<template>
    <page-main-body title="样品维护" :loading="loading">
      <light-table
                   :columns="columns"
                   style="width: 100%"
                   :need-index="true"
                   :remote="true" :remoteMethod="doQuery">
      </light-table>
    </page-main-body>
</template>

<script>
  import axios from 'axios';
  import _ from 'lodash';

  const searchSampleList = (condition) => axios.get('/api/sample_product', {params : condition})



export default {
  name: 'sampleMaintain',
  data () {
    return {
      // columns: [
      //   {
      //     prop: 'reportNo',
      //     label: '报告编号'
      //   },
      //   {
      //     prop: 'missionNo',
      //     label: '任务号'
      //   },
      //   {
      //     prop: 'sampleName',
      //     label: '样品名称'
      //   },
      //   {
      //     prop: 'sampleNo',
      //     label: '样品单号'
      //   },
      //   {
      //     prop: 'checkType',
      //     label: '检验类型'
      //   },
      //   {
      //     prop: 'completeDate',
      //     label: '要求完成日期'
      //   },
      //   {
      //     prop: 'department',
      //     label: '部门'
      //   },
      //   {
      //     prop: 'people',
      //     label: '领用人'
      //   },
      //   {
      //     prop: 'count',
      //     label: '领用数量'
      //   },
      //   {
      //     prop: 'status',
      //     label: '样品状态'
      //   },
      //   {
      //     prop: 'returnPeople',
      //     label: '退样人'
      //   },
      //   {
      //     prop: 'returnNumber',
      //     label: '退样数量'
      //   },
      //   {
      //     prop: 'status',
      //     label: '报告状态'
      //   },
      //
      // ],
      columns: [
        {
          prop: 'sampleNo',
          label: '样品单号'
        },
        {
          prop: 'sampleName',
          label: '样品名称'
        },
        {
          prop: 'reportNo',
          label: '报告编号'
        },
        {
          prop: 'sealNumber',
          label: '封条编号'
        },
        {
          prop: 'inspectionQuantity',
          label: '检验数量'
        },
        {
          prop: 'sampleQuantity',
          label: '备样数量'
        },
        {
          prop: 'sampleStatus',
          label: '状态'
        },
        {
          prop: 'statusName',
          label: '样品状态'
        },
        {
          prop: 'company',
          label: '受检单位'
        },
        {
          prop: 'registerDate',
          label: '登记日期'
        },
        {
          prop: 'sampleCount',
          label: '库存数量'
        },
        {
          prop: 'remark',
          label: '备注'
        }
      ],
      showDialog: false,
      loading: false,
      selectRow: [],
      id: ''
    };
  },
  mounted() {

  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return searchSampleList({ searchCondition, page, size }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    }
    // goToDelete () {
    //   console.log('aaa');
    //   if (this.selectRow.length === 0) {
    //     this.onAlertError('选中数量为0条');
    //   } else {
    //     this.loading = true;
    //     deleteSampleById({id: this.selectRow}).then(data => {
    //       this.loading = false;
    //       if (data.data.code === '000') {
    //         this.loading = false;
    //         this.onAlertSuccess('删除成功');
    //         this.$refs.table.doRemoteMethod();
    //       }
    //     });
    //   }
    // },
    // getSelectRow (val) {
    //   let id = [];
    //   _.each(val, item => {
    //     id.push(item.id);
    //   });
    //   this.selectRow = id;
    // }

  }
};
</script>

<style scoped>

</style>
