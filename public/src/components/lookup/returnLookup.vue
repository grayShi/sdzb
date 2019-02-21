<template>
  <el-dialog
    :title="title"
    :visible.sync="show"
    width="80%"
    :close-on-click-modal="false"
    @close="dialogClose"
    center>
    <el-form :model="dialogForm" :rules="dialogRules" ref="dialogForm" label-width="100px" v-if="isAddable">
      <el-row>
        <el-col :span="24">
          <el-form-item label="审批意见" prop="reason">
            <el-checkbox-group v-model="dialogForm.reason">
              <el-col :span="6" v-for="item in reasonList" :key="item.label">
                <el-checkbox :label="item.label" :disabled="item.disable"></el-checkbox>
              </el-col>
            </el-checkbox-group>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注" prop="remark">
            <el-input type="textarea" :autosize="$textareaAutosize" v-model="dialogForm.remark" :placeholder="$placeholder.inputTextarea"></el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <span slot="footer" class="dialog-footer" v-if="isAddable">
      <el-button type="primary" @click="saveReturn('initial')">返工到信息单</el-button>
      <el-button type="primary" @click="saveReturn('pre_test')">返工到检验数据</el-button>
    </span>
    <light-table :columns="columns" ref="table" v-if="!isAddable"
                 :remote="true" :remoteMethod="doQuery">
    </light-table>
  </el-dialog>
</template>

<script>
import axios from 'axios';
const findReturnDataList = (id, condition) => axios.get(`/api/sample/${id}/reworks`, {params: condition});
const saveReturnById = (id, form) => axios.post(`/api/sample/${id}/reworks`, form);

export default {
  name: 'returnLookup',
  props: {
    showDialog: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    isAddable: {
      type: Boolean,
      default: () => {
        return false;
      }
    },
    id: {
      type: [String, Number],
      default: () => {
        return '';
      }
    }
  },
  data () {
    return {
      title: '添加返工记录',
      show: false,
      columns: [
        {
          prop: 'id',
          label: '序号',
          width: 80
        },
        {
          prop: 'mainInspector',
          label: '主检人'
        },
        {
          prop: 'auditor',
          label: '校核人'
        },
        {
          prop: 'approver',
          label: '批准人'
        },
        {
          prop: 'reworker',
          label: '被返工人'
        },
        {
          prop: 'operator',
          label: '返工人'
        },
        {
          prop: 'reasons',
          label: '返工原因'
        },
        {
          prop: 'reworkTime',
          label: '返工时间'
        },
        {
          prop: 'remarks',
          label: '返工说明'
        }
      ],
      dialogForm: {
        reason: [],
        remark: ''
      },
      dialogRules: {

      },
      reasonList: [
        { label: '结论不准确', disable: false },
        { label: '标准不准确', disable: false },
        { label: '非法定计量单位', disable: false },
        { label: '修改不规范', disable: false },
        { label: '不能反映检验过程', disable: false },
        { label: '报告不完整', disable: false },
        { label: '修约有问题', disable: false },
        { label: '信息量不足', disable: false },
        { label: '信息输入错误', disable: false }
      ]
    };
  },
  watch: {
    showDialog (newVal) {
      this.show = newVal;
      if (newVal && !this.isAddable) {
        this.$nextTick(() => {
          this.$refs.table.doRemoteMethod();
        });
      }
    }
  },
  methods: {
    doQuery (searchCondition, page, size) {
      return findReturnDataList(this.id, { searchCondition, page, size }).then(data => {
        this.title = '返工记录';
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    dialogClose () {
      this.title = '添加返工记录';
      this.$emit('on-close', false);
    },
    saveReturn (status) {
      if (this.dialogForm.reason.length > 0) {
        saveReturnById(this.id, {reason: this.dialogForm.reason, remarks: this.dialogForm.remark, status}).then(data => {
          if (data.data.code === '000') {
            this.dialogClose();
            this.onAlertSuccess('保存成功');
          } else {
            this.onAlertError('保存失败');
          }
        });
      } else {
        this.onAlertError(`审批意见选中数量为必须为1条`);
      }
    }
  }
};
</script>

<style scoped>

</style>
