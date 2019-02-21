<template>
  <page-main-body title="退样记录">
    <light-table :data="searchData" :columns="columns" style="width: 100%" :need-index="true" >

    </light-table>
  </page-main-body>
</template>

<script>
  export default {
    name: "withdrawRecord",
    data () {
      return {
        searchData: [
          {
            sampleNo:124,
            sampleName:'塑料薄膜',
            reportNo:888,
            sealNumber:676,
            inspectionQuantity:60,
            sampleQuantity:40,
            status:'已入库',
            company:'青岛海岛电力电气设备制造有限公司',
            registerDate:'2018-12-25'
          },
          {
            sampleNo:124,
            sampleName:'双瓦楞纸箱',
            reportNo:999,
            sealNumber:668,
            inspectionQuantity:50,
            sampleQuantity:30,
            status:'已领取',
            company:'淄博瑞月包装材料有限公司',
            registerDate:'2018-12-03'
          }
        ],
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
            prop: 'status',
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
            prop: 'storageNumber',
            label: '入库数量'
          },
          {
            prop: 'storagePlace',
            label: '入库地点'
          },
          {
            prop: 'receiveDate',
            label: '领样日期'
          },
          {
            prop: 'receivePeople',
            label: '领样人'
          },
          {
            prop: 'receivePlace',
            label: '领样地点'
          },
          {
            prop: 'receiveNumber',
            label: '领样数量'
          },
          {
            prop: 'remark',
            label: '备注'
          },
          {
            prop: 'edit',
            label: '操作',
            type: {
              operate: true
            }
          }
        ]
      };
    },
    methods: {
    }
  }
</script>

<style scoped>

</style>
