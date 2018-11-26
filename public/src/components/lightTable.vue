<template>
  <div style="margin-top: 10px; margin-bottom: 10px">
    <div style="margin-bottom: 10px">
      <el-row>
        <el-col :span="6">
          <el-input v-model="searchCondition"></el-input>
        </el-col>
        <el-col :span="3">
          <el-button type="primary" style="margin-left: 20px">搜索</el-button>
        </el-col>
      </el-row>
    </div>
    <el-table
      :data="data"
      :height="tableHeight"
      :row-class-name="rowClass"
      border
      style="width: 100%">
      <el-table-column  v-for="column in columns" :key="column.prop"
                        :prop="column.prop"
                        :label="column.label"
                        :width="column.width">
        <template slot-scope="scope">
          <div style="text-align: center"  v-if="column.type && column.type.operate">
            <slot :name="column.prop" :prop="scope.row"></slot>
          </div>
          <a  v-else-if="column.type && column.type.linkable" :href="column.type.linkUrl">{{scope.row[column.prop]}}</a>
          <span v-else>{{scope.row[column.prop]}}</span>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
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
    tableHeight: {
      type: Number,
      default: () => {
        return window.innerHeight * 0.7;
      }
    }
  },
  data () {
    return {
      searchCondition: ''
    };
  },
  methods: {

  }
};
</script>

<style>
  .el-table .delete-row {
    background: #EBEEF5;
  }
  .el-button+.el-button {
    margin-left: 0;
  }
</style>
