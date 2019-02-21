<template>
  <div>
    <el-input v-model="inputValue" :placeholder="$placeholder.input">
      <img slot="suffix" class="icon-click" @click="iconClick" :src="`/static/img/搜索.png`"/>
    </el-input>
    <el-dialog
      :title="title"
      :visible.sync="showDialog"
      width="60%"
      :close-on-click-modal="false"
      @close="dialogClose"
      center>
      <light-table ref="table"
                   :columns="columns"
                   :remote="true" :remoteMethod="doQuery"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operateTable">
          <el-button @click="checkSelect">确定</el-button>
        </template>
      </light-table>

    </el-dialog>
  </div>

</template>

<script>
import configFunction from './selectLookupConfig';
import _ from 'lodash';
export default {
  name: 'selectLookUp',
  props: {
    value: {
      type: String,
      default: () => {
        return '';
      }
    },
    type: {
      type: String,
      default: () => {
        return '';
      }
    }
  },
  data () {
    return {
      showDialog: false,
      selectRow: [],
      columns: [],
      title: '',
      inputValue: ''
    };
  },
  watch: {
    value (val) {
      this.inputValue = val;
    },
    inputValue (val) {
      this.$emit('input', val);
    }
  },
  mounted () {
    this.title = configFunction[this.type].title;
    this.columns = configFunction[this.type].columns;
  },
  methods: {
    iconClick () {
      this.showDialog = true;
      this.$nextTick(() => {
        this.$refs.table.doRemoteMethod();
      });
    },
    dialogClose () {
      this.$refs.table.resetTable();
      this.showDialog = false;
    },
    getSelectRow (val) {
      this.selectRow = val;
    },
    doQuery (searchCondition, page, size) {
      this.loading = true;
      if (configFunction[this.type]) {
        return configFunction[this.type].func(searchCondition, page, size).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            const returnData = this.formatGetTableData(data.data.datas);
            returnData.totalData = _.map(returnData.totalData, item => ({
              comName: item.enterpriseName,
              comCode: item.enterpriseCode,
              comAddress: item.enterpriseAddress,
              comPostNo: item.postcode,
              comPhone: item.phone,
              comContact: item.linkedUser
            }));
            returnData.totalLength = returnData.totalData.length;
            return returnData;
          } else {
            this.onAlertError('查询失败');
            return [];
          }
        });
      }
    },
    checkSelect () {
      if (this.selectRow.length !== 1) {
        this.onAlertError('选中数量不为1条');
      } else {
        this.inputValue = this.selectRow[0][configFunction[this.type].returnFields];
        this.$emit('select-row', this.selectRow[0]);
        this.dialogClose();
      }
    }
  }
};
</script>

<style scoped>
  .icon-click {
    cursor: pointer;
  }
</style>
