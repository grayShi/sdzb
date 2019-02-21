<template>
  <div style="margin-top: 10px; margin-bottom: 10px">
    <div style="margin-bottom: 10px">
      <el-row>
        <el-col :span="9" v-if="showSearch">
          <el-input v-model="searchCondition" :placeholder="$placeholder.input"></el-input>
        </el-col>
        <el-col :span="9" v-if="addCondition">
          <slot name="otherCondition"></slot>
        </el-col>
        <el-col :span="tableHeadCol" class="table-title-button">
          <el-button type="primary" style="margin-left: 20px" v-if="showSearch" @click="searchClick">搜索</el-button>
          <el-button type="primary" v-if="addable" @click="onAdd">添加</el-button>
          <el-button type="danger" v-if="rowSelect && deleteable" @click="onDelete">删除</el-button>
          <slot name="operateTable"></slot>
          <slot name="showColor"></slot>
        </el-col>
      </el-row>
    </div>
    <div v-if="!!tableTitle">
      <h4>{{tableTitle}}</h4>
    </div>
    <el-row v-if="deadline">
      <el-tag color="rgb(238, 220, 130)">2天后超期</el-tag>
      <el-tag color="#EEA2AD">超期</el-tag>
    </el-row>
    <el-table
      :data="showData"
      :height="tableHeight"
      :row-class-name="setRowClass"
      border
      @sort-change="sortChange"
      :header-cell-class-name="handleAddClass"
      @selection-change="handleSelectionChange"
      style="width: 100%">
      <el-table-column v-if="rowSelect"
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column v-for="column in columns" :key="column.prop"
                        :prop="column.prop"
                        :sortable="showSort(column)"
                        :label="column.label"
                        :width="column.width">
        <template slot-scope="scope">
          <div style="text-align: center"  v-if="column.type && column.type.operate">
            <slot :name="column.prop" :prop="scope.row"></slot>
          </div>
          <el-input v-else-if="column.type && column.type.text" :disabled="column.disabled" v-model="scope.row[column.prop]" :placeholder="$placeholder.input"></el-input>
          <el-input v-else-if="column.type && column.type.textarea" :disabled="column.disabled" type="textarea" :autosize="$textareaAutosize" v-model="scope.row[column.prop]" :placeholder="$placeholder.inputTextarea"></el-input>
          <el-select v-else-if="column.type && column.type.select" :disabled="column.disabled" v-model="scope.row[column.prop]" clearable :placeholder="$placeholder.select">
            <el-option
              v-for="item in column.type.selectList"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <a  v-else-if="column.type && column.type.linkable" :href="linkGoTo(column, scope)">{{scope.row[column.prop]}}</a>
          <span v-else>{{scope.row[column.prop]}}</span>
        </template>
      </el-table-column>
    </el-table>
    <div class="page-bar-body">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalData">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import moment from 'moment';
import _ from 'lodash';
export default {
  name: 'lightTable',
  props: {
    data: {
      type: Array,
      default: () => {
        return [];
      }
    },
    columns: {
      type: Array,
      default: () => {
        return [];
      }
    },
    rowClass: {
      type: Function,
      default: () => {
        return '';
      }
    },
    tableTitle: {
      type: String,
      default: () => {
        return '';
      }
    },
    tableHeight: {
      type: Number,
      default: () => {
        return window.innerHeight * 0.7;
      }
    },
    rowSelect: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    showSearch: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    addCondition: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    addable: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    deleteable: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    deadline: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    remote: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    remoteMethod: {
      type: Function
    }
  },
  data () {
    return {
      moment,
      searchCondition: '',
      totalData: 0,
      currentPage: 1,
      pageSize: 10,
      pageIndex: 1,
      showData: [],
      orderHead: []
    };
  },
  computed: {
    tableHeadCol () {
      return 24 - (this.showSearch ? 9 : 0) - (this.addCondition ? 9 : 0);
    }
  },
  mounted () {
    _.each(this.columns, item => {
      if (!item.type && item.sort && item.sort.show) {
        this.orderHead.push({ property: item.prop, direction: item.sort.default === 'DESC' ? 'DESC' : 'ASC' });
      }
    });
    this.searchTable();
  },
  watch: {
    data () {
      this.searchTable();
    }
  },
  methods: {
    onAdd () {
      this.$emit('on-add');
    },
    onDelete () {
      this.$emit('on-delete');
    },
    linkGoTo (column, scope) {
      if (column.type.linkUrl) {
        return column.type.linkUrl(scope.row);
      }
    },
    searchClick () {
      this.searchTable();
    },
    handleSizeChange (val) {
      this.pageSize = val;
      this.searchTable();
    },
    handleCurrentChange (val) {
      this.pageIndex = val;
      this.searchTable();
    },
    showSort (column) {
      if (column.sort && column.sort.show) {
        return 'custom';
      }
      return false;
    },
    handleAddClass ({row, column, rowIndex, columnIndex}) {
      // 判断找到当前列 添加样式
      if (column.property) {
        const find = _.find(this.orderHead, item => item.property === column.property);
        if (find) {
          if (find.direction === 'ASC') {
            return 'active-asc-head';
          } else {
            return 'active-desc-head';
          }
        }
      }
    },
    sortChange ({ column, prop, order }) {
      // 拿到当前列的某个属性
      _.each(this.orderHead, item => {
        if (item.property === prop) {
          item.direction = order === 'ascending' ? 'ASC' : 'DESC';
        }
      });
      this.searchTable();
    },
    async searchTable () { // can not filter condition if not remote
      if (this.remote) {
        const findData = await this.remoteMethod(this.searchCondition, this.pageIndex - 1, this.pageSize, this.orderHead);
        this.totalData = findData.totalLength;
        this.showData = findData.totalData;
      } else {
        this.totalData = this.data.length;
        this.showData = this.data.slice((this.pageIndex - 1) * this.pageSize, this.pageIndex * this.pageSize);
      }
    },
    handleSelectionChange (val) {
      this.$emit('select-row', val);
    },
    doRemoteMethod () {
      this.searchTable();
    },
    resetTable () {
      this.searchCondition = '';
      this.totalData = 0;
      this.currentPage = 1;
      this.pageSize = 10;
      this.pageIndex = 1;
      this.showData = [];
    },
    setRowClass (row) {
      let classList = [];
      if (this.rowClass) {
        classList = classList.concat(this.rowClass(row.row));
      }
      if (row.row.rework) {
        classList.push('return-row');
      }
      if (row.row.completeDate) {
        if (moment(moment()).isAfter(row.row.completeDate)) {
          classList.push('deadline-row');
        } else if (moment(moment().add(2, 'days')).isAfter(row.row.completeDate)) {
          classList.push('ready-deadline-row');
        }
      }
      return classList.join(' ');
    }
  }
};
</script>

<style>
  .el-table .return-row {
    color: #0066FF;
  }
  .el-table .deadline-row {
    background-color: #EEA2AD;
  }
  .el-table .ready-deadline-row {
    background-color: rgb(238, 220, 130);
  }
  .el-button+.el-button {
    margin-left: 0;
  }
  .page-bar-body {
    text-align: right;
  }
  .table-title-button .el-button {
    margin-left: 20px;
    margin-bottom: 10px;
  }
  .el-tag {
    color: black;
  }
  .active-desc-head .sort-caret.descending{
    border-top-color: #409eff;
  }
  .active-asc-head .sort-caret.ascending{
    border-bottom-color: #409eff;
  }
</style>
