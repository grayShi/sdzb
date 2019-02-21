<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 95%">
      <light-table ref="table"
                   :columns="columns"
                   :addable="true" @on-add="addFee"
                   :deleteable="true" @on-delete="goToDelete"
                   :remote="true" :remoteMethod="doQuery"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="operation" slot-scope="props">
          <el-button size="mini" @click="goToModify(props.prop.id)">编辑</el-button>
        </template>
      </light-table>
      <el-dialog
        :title="dialogForm.title"
        :visible.sync="showDialog"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogClose"
        center>
        <el-form :model="dialogForm" :rules="dialogRules" ref="dialogForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="单位名称" prop="department">
                <el-select v-model="dialogForm.department" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in departmentList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="金额" prop="count">
                <el-input v-model="dialogForm.count" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="收费项目" prop="feeProject">
                <el-select v-model="dialogForm.feeProject" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in feeProjectList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费方式" prop="feeWay">
                <el-select v-model="dialogForm.feeWay" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in feeWayList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="发票号" prop="ticketNo">
                <el-input v-model="dialogForm.ticketNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开票日期" prop="ticketDate">
                <el-date-picker
                  v-model="dialogForm.ticketDate"
                  align="right" style="width: 100%"
                  type="date"
                  :placeholder="$placeholder.selectDate">
                </el-date-picker>
                <!--<el-input v-model="dialogForm.ticketDate" :placeholder="$placeholder.input"></el-input>-->
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="是否到账" prop="whether">
                <el-select v-model="dialogForm.whether" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in whetherList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="编号" prop="number">
                <el-input v-model="dialogForm.number" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="收款单位" prop="feeDepartment">
                <el-select v-model="dialogForm.feeDepartment" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in feeDepartmentList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="科室" prop="section">
                <el-select v-model="dialogForm.section" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in sectionList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="备注" prop="more">
                <el-input v-model="dialogForm.more" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialog = false">取消</el-button>
          <el-button type="primary" @click="saveRegister">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';
const saveFee = (feeForm) => axios.post('/api/fee', feeForm);
const getFeeById = (id) => axios.get(`/api/fee/${id}`);
const getFeeDataList = (condition, order) => axios.get(`/api/fee?${condition}`, order);
const deleteFeeById = (id) => axios.delete('/api/fee', {data: id});

export default {
  name: 'feeRegister',
  data () {
    return {
      title: '收费登记',
      loading: false,
      columns: [
        {
          prop: 'number',
          label: '编号'
        },
        {
          prop: 'department',
          label: '企业名称'
        },
        {
          prop: 'section',
          label: '部门'
        },
        {
          prop: 'feeProject',
          label: '收费项目'
        },
        {
          prop: 'count',
          label: '金额'
        },
        {
          prop: 'ticketNo',
          label: '发票号'
        },
        {
          prop: 'ticketDate',
          label: '开票日期',
          formatter: (col) => {
            return this.formatDate(col);
          }
        },
        {
          prop: 'audit',
          label: '是否核实',
          formatter: (col) => {
            return col ? '已核实' : '未核实';
          }
        },
        {
          prop: 'feeWay',
          label: '收款方式'
        },
        {
          prop: 'whether',
          label: '是否到账',
          formatter: (col) => {
            return col ? '已到账' : '未到账';
          }
        },
        {
          prop: 'feeDepartment',
          label: '收款单位'
        },
        {
          prop: 'more',
          label: '备注'
        },
        {
          prop: 'operation',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      dialogForm: {
        title: '收费登记',
        department: '',
        count: '',
        feeProject: '',
        feeWay: '',
        ticketNo: '',
        ticketDate: '',
        whether: '',
        number: '',
        feeDepartment: '',
        section: '',
        more: ''
      },
      showDialog: false,
      dialogRules: {
        count: [this.inputNumber()],
        whether: [this.requiredInput('是否到账')]
        // count: [this.requiredInput('部门名称')],
      },
      departmentList: [
        { value: '化工一室', label: '化工一室' },
        { value: '化工二室', label: '化工二室' }
      ],
      feeProjectList: [
        { value: '培训费', label: '培训费' },
        { value: '协议费', label: '协议费' }
      ],
      feeWayList: [
        { value: '现金', label: '现金' },
        { value: '汇款', label: '汇款' }
      ],
      whetherList: [
        { value: 'true', label: '是' },
        { value: 'false', label: '否' }
      ],
      feeDepartmentList: [
        { value: '市质检所', label: '市质检所' },
        { value: '市建材站', label: '市建材站' }
      ],
      sectionList: [
        { value: '化工一室', label: '化工一室' },
        { value: '化工二室', label: '化工二室' }
      ],
      selectRow: []
    };
  },
  methods: {
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    },
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        deleteFeeById({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.loading = false;
            this.onAlertSuccess('删除成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    goToModify (id) {
      this.loading = true;
      getFeeById(id).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          const result = data.data.datas[0];
          this.dialogForm = {
            id: result.id,
            title: '收费登记',
            department: result.department,
            count: result.count,
            feeProject: result.feeProject,
            feeWay: result.feeWay,
            ticketNo: result.ticketNo,
            ticketDate: result.ticketDate,
            whether: `${result.whether}`,
            number: result.number,
            feeDepartment: result.feeDepartment,
            section: result.section,
            more: result.more
          };
        }
        this.showDialog = true;
      });
    },
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return getFeeDataList(this.formatParams({ audit: false, searchCondition, page, size })).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    addFee () {
      this.showDialog = true;
    },
    saveRegister () {
      this.$refs.dialogForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          saveFee(this.dialogForm).then(data => {
            this.loading = false;
            if (data.data.code === '000') {
              this.onAlertSuccess('保存成功');
              this.showDialog = false;
              this.$refs.table.doRemoteMethod();
            } else {
              this.onAlertError('保存失败');
            }
          }).catch(err => {
            this.loading = false;
            console.log(err);
            this.onAlertError('保存失败');
          });
        } else {
          this.onAlertError('请确认输入');
        }
      });
    },
    dialogClose () {
      this.dialogForm = {
        id: '',
        title: '收费登记',
        department: '',
        count: '',
        feeProject: '',
        feeWay: '',
        ticketNo: '',
        ticketDate: '',
        whether: '',
        number: '',
        feeDepartment: '',
        section: '',
        more: ''
      };
    }
  }
};
</script>

<style scoped>

</style>
