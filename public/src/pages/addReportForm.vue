<template>
  <page-main-body>
    <div style="width: 90%">
      <el-button @click="addColumns">增加单元格</el-button>
      <el-button @click="saveReport">保存</el-button>
      <report-form :formColumns="formColumns"
                   @delete-columns="deleteColumns"
                   @modify-columns="modifyColumns"
      >

      </report-form>
      <el-dialog
        :title="dialogForm.title"
        :visible.sync="showDialog"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogClose"
        center>
        <el-form :model="dialogForm" :rules="dialogRules" ref="dialogForm" label-width="100px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="文字" prop="message" v-if="!dialogForm.bindData">
                <el-input v-model="dialogForm.message" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="宽度" prop="width">
                <el-input v-model="dialogForm.width" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="高度" prop="height">
                <el-input v-model="dialogForm.height" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="文字位置" prop="position">
                <el-radio v-model="dialogForm.position" label="left">左上</el-radio>
                <el-radio v-model="dialogForm.position" label="center">居中</el-radio>
                <el-radio v-model="dialogForm.position" label="right">右下</el-radio>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="边框" prop="border">
                <el-checkbox-group v-model="dialogForm.border">
                  <el-checkbox label="borderTop">顶部</el-checkbox>
                  <el-checkbox label="borderLeft">左部</el-checkbox>
                  <el-checkbox label="borderBottom">底部</el-checkbox>
                  <el-checkbox label="borderRight">右部</el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="绑定字段" prop="bindData" v-if="!dialogForm.message">
                <el-select v-model="dialogForm.bindData" filterable clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in bindDataList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="字体大小" prop="fontSize">
                <el-input v-model="dialogForm.fontSize" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="showDialog = false">取消</el-button>
            <el-button v-if="!dialogForm.i" type="primary" @click="saveColumns">添加</el-button>
            <el-button v-if="dialogForm.i" type="danger" @click="modifySaveColumns(dialogForm.i)">保存</el-button>
          </span>
      </el-dialog>
      <el-dialog
        :title="saveDialogForm.title"
        :visible.sync="showSaveDialog"
        width="50%"
        :close-on-click-modal="false"
        @close="saveDialogClose"
        center>
        <el-form :model="saveDialogForm" :rules="saveDialogRules" ref="saveDialogForm" label-width="100px">
          <el-row>
            <el-col :span="24">
              <el-form-item label="表格名称" prop="name">
                <el-input v-model="saveDialogForm.name" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="showSaveDialog = false">取消</el-button>
            <el-button type="primary" @click="saveReportForm">保存</el-button>
          </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
import reportForm from '../components/reportForm';
import _ from 'lodash';
import axios from 'axios';
const saveZBtable = (table) => axios.post('/api/zibo_table', table);
const getZBtableById = (id) => axios.get(`/api/zibo_table/${id}`);

export default {
  name: 'testReportForm',
  components: {
    reportForm
  },
  data () {
    return {
      showDialog: false,
      dialogForm: {
        title: '添加单元格',
        height: 2,
        width: 6,
        message: '',
        bindData: '',
        i: '',
        position: 'center',
        border: ['borderTop', 'borderLeft', 'borderBottom', 'borderRight'],
        fontSize: 15
      },
      dialogRules: {},
      saveDialogForm: {
        title: '添加单元格',
        name: ''
      },
      saveDialogRules: {},
      showSaveDialog: false,
      formColumns: [],
      bindDataList: [
        {
          label: '承检部门',
          value: 'department'
        },
        {
          label: '样品单号',
          value: 'sampleNo'
        },
        {
          label: 'WT',
          value: 'wt'
        },
        {
          label: '样品名称',
          value: 'sampleName'
        },
        {
          label: '检验类型',
          value: 'checkType'
        },
        {
          label: '单元名称',
          value: 'unitName'
        },
        {
          label: '省级发证报告号',
          value: 'reportNo'
        },
        {
          label: '商标',
          value: 'mark'
        },
        {
          label: '生产批号',
          value: 'produceNo'
        },
        {
          label: '样品等级',
          value: 'sampleLevel'
        },
        {
          label: '型号规格',
          value: 'size'
        },
        {
          label: '生产日期',
          value: 'proDate'
        },
        {
          label: '产品标准',
          value: 'proStandard'
        },
        {
          label: '检验项目',
          value: 'checkPro'
        },
        {
          label: '样品数量',
          value: 'sampleCount'
        },
        {
          label: '样品存放地点',
          value: 'savePlace'
        },
        {
          label: '备样存放地点',
          value: 'samplePlace'
        },
        {
          label: '封条数量和号码',
          value: 'countNo'
        },
        {
          label: '样品处理方式',
          value: 'handleType'
        },
        {
          label: '样品状态',
          value: 'sampleStatus'
        },
        {
          label: '完成日期',
          value: 'completeDate'
        },
        {
          label: '备样数量',
          value: 'number'
        },
        {
          label: '方式',
          value: 'mode'
        },
        {
          label: '抽样地点',
          value: 'samplingPlace'
        },
        {
          label: '抽样方式',
          value: 'samplingWay'
        },
        {
          label: '抽/送样日期',
          value: 'samDate'
        },
        {
          label: '抽样人',
          value: 'samPeople'
        },
        {
          label: '样品基数/批量',
          value: 'samBase'
        },
        {
          label: '企业陪同人',
          value: 'comPeople'
        },
        {
          label: '送样人',
          value: 'sendPeople'
        },
        {
          label: '样品到达时间',
          value: 'reachTime'
        },
        {
          label: '检查封样人员',
          value: 'sealPeople'
        },
        {
          label: '封样状态',
          value: 'sealState'
        },
        {
          label: '受检单位',
          value: 'inspectCompany'
        },
        {
          label: '受检企业代码',
          value: 'inspectComCode'
        },
        {
          label: '受检企业地址',
          value: 'inspectComAddress'
        },
        {
          label: '受检企业邮编',
          value: 'inspectComPostNo'
        },
        {
          label: '受检企业电话',
          value: 'inspectComPhone'
        },
        {
          label: '受检企业联系人',
          value: 'inspectComContact'
        },
        {
          label: '生产单位',
          value: 'produceCompany'
        },
        {
          label: '生产企业代码',
          value: 'produceComCode'
        },
        {
          label: '生产企业地址',
          value: 'produceComAddress'
        },
        {
          label: '生产企业邮编',
          value: 'produceComPostNo'
        },
        {
          label: '生产企业电话',
          value: 'produceComPhone'
        },
        {
          label: '生产企业联系人',
          value: 'produceComContact'
        },
        {
          label: '委托单位',
          value: 'deputeCompany'
        },
        {
          label: '委托企业代码',
          value: 'deputeComCode'
        },
        {
          label: '委托企业邮编',
          value: 'deputeComPostNo'
        },
        {
          label: '委托企业电话',
          value: 'deputeComPhone'
        },
        {
          label: '委托企业联系人',
          value: 'deputeComContact'
        },
        {
          label: '任务来源',
          value: 'taskSource'
        },
        {
          label: '抽样单位',
          value: 'sampleUnit'
        },
        {
          label: '获取报告方式',
          value: 'getReport'
        }

      ]
    };
  },
  mounted () {
    if (this.$route.query.id) {
      this.loading = true;
      getZBtableById(this.$route.query.id).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          this.saveDialogForm.name = data.data.datas[0].tableName;
          this.formColumns = data.data.datas[0].tableList;
        }
      });
    }
  },
  methods: {
    addColumns () {
      this.showDialog = true;
    },
    saveColumns () {
      const newColumns = {'x': 0, 'y': 0};
      newColumns.w = Number(this.dialogForm.width);
      newColumns.h = Number(this.dialogForm.height);
      newColumns.i = _.maxBy(this.formColumns, 'i') ? _.maxBy(this.formColumns, 'i').i + 1 : 1;
      newColumns.message = this.dialogForm.bindData ? '' : this.dialogForm.message;
      newColumns.bindData = this.dialogForm.message ? '' : this.dialogForm.bindData;
      newColumns.position = this.dialogForm.position ? this.dialogForm.position : '';
      newColumns.fontSize = this.dialogForm.fontSize ? this.dialogForm.fontSize : 0;
      newColumns.border = this.dialogForm.border;
      this.formColumns.push(newColumns);
      this.showDialog = false;
    },
    dialogClose () {
      this.dialogForm = {
        title: '增加单元格',
        height: 2,
        width: 6,
        message: '',
        bindData: '',
        i: '',
        position: 'center',
        border: ['borderTop', 'borderLeft', 'borderBottom', 'borderRight'],
        fontSize: 15
      };
    },
    saveDialogClose () {
      if (!this.$route.query.id) {
        this.saveDialogForm = {
          title: '添加单元格',
          name: ''
        };
      }
    },
    deleteColumns (column) {
      const findIndex = _.findIndex(this.formColumns, item => item.i === column.i);
      this.formColumns.splice(findIndex, 1);
    },
    modifyColumns (column) {
      this.showDialog = true;
      this.dialogForm = {
        title: '修改单元格',
        height: column.h,
        width: column.w,
        message: column.message,
        bindData: column.bindData,
        i: column.i,
        position: column.position,
        border: column.border,
        fontSize: column.fontSize
      };
    },
    modifySaveColumns (columnI) {
      const find = _.find(this.formColumns, item => item.i === columnI);
      if (find) {
        find.message = this.dialogForm.message;
        find.h = this.dialogForm.height;
        find.w = this.dialogForm.width;
        find.bindData = this.dialogForm.bindData;
        find.position = this.dialogForm.position;
        find.border = this.dialogForm.border;
        find.fontSize = this.dialogForm.fontSize;
        this.showDialog = false;
      }
    },
    saveReport () {
      this.showSaveDialog = true;
    },
    saveReportForm () {
      this.loading = true;
      saveZBtable({id: this.$route.query.id, tableName: this.saveDialogForm.name, tableList: this.formColumns}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          this.showSaveDialog = false;
          this.saveDialogClose();
          this.onAlertSuccess('保存成功');
          this.$router.push(`/addReportForm?id=${data.data.datas[0].id}`);
        } else {
          this.onAlertError('保存失败');
        }
      });
    }
  }
};
</script>

<style scoped>

</style>
