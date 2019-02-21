<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <el-row>
        <el-form :model="reportForm" :rules="reportRules" ref="reportForm" label-width="100px">
          <el-card>
            <el-row>
              <el-col :span="24">
                <el-form-item label="报告部门" prop="department">
                  <el-select v-model="reportForm.department" :disabled="isApproval" clearable :placeholder="$placeholder.select">
                    <el-option
                      v-for="item in inspectDepartmentList"
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
                <el-form-item label="报告标准" prop="standard">
                  <el-select v-model="standard" :disabled="isApproval" multiple clearable :placeholder="$placeholder.select">
                    <el-option
                      v-for="item in standardList"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>

                <!--<el-form-item label="报告标准" prop="standard">-->
                  <!--<el-row>-->
                    <!--<el-checkbox-group v-model="standard" :disabled="isApproval">-->
                      <!--<el-col :span="8">-->
                        <!--<el-checkbox @change="getCheckInspect" label="inspect">审查验收(CMA、CAL)</el-checkbox>-->
                      <!--</el-col>-->
                      <!--<el-col :span="8">-->
                        <!--<el-checkbox @change="getCheckFood" label="food">食品验收(CMAF、CAL)</el-checkbox>-->
                      <!--</el-col>-->
                      <!--<el-col :span="8">-->
                        <!--<el-checkbox label="experiment">实验认可(ILAC、CNAS)</el-checkbox>-->
                      <!--</el-col>-->
                    <!--</el-checkbox-group>-->
                <!--</el-row>-->
                <!--</el-form-item>-->
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="任务号" prop="missionNo">
                  <el-input v-model="reportForm.missionNo" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="报告编号" prop="reportNo">
                  <el-input v-model="reportForm.reportNo" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="reportForm.sampleName" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="检验类型" prop="checkType">
                  <el-input v-model="reportForm.checkType" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="样品等级" prop="sampleLevel">
                  <el-input v-model="reportForm.sampleLevel" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="型号规格" prop="size">
                  <el-input v-model="reportForm.size" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="委托单位" prop="deputeCompany">
                  <el-input v-model="reportForm.deputeCompany" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="商标" prop="mark">
                  <el-input v-model="reportForm.mark" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="受检单位" prop="inspectCompany">
                  <el-input v-model="reportForm.inspectCompany" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="单位地址" prop="inspectComAddress">
                  <el-input v-model="reportForm.inspectComAddress" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="抽样地点" prop="samplingPlace">
                  <el-input v-model="reportForm.samplingPlace" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="抽/送样人员" prop="samPeople">
                  <el-input v-model="reportForm.samPeople" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="样品基数" prop="samBase">
                  <el-input v-model="reportForm.samBase" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="抽/接样日期" prop="samDate">
                  <el-date-picker
                    v-model="reportForm.samDate" :disabled="visibleReport"
                    type="date"
                    :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="样品数量" prop="sampleCount">
                  <el-input v-model="reportForm.sampleCount" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="生产日期" prop="proDate">
                  <el-date-picker
                    v-model="reportForm.proDate" :disabled="visibleReport"
                    type="date"
                    :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="样品特性和状态" prop="sampleStatus">
                  <el-input v-model="reportForm.sampleStatus" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="样品批号" prop="produceNo">
                  <el-input v-model="reportForm.produceNo" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="单元名称" prop="unitName">
                  <el-input v-model="reportForm.unitName" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="样品到达时间" prop="reachTime">
                  <el-input v-model="reportForm.reachTime" :disabled="visibleReport" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-card>
          <el-card>
            <div slot="header">
              <span>检验环境</span>
            </div>
            <el-row>
              <el-col :span="8">
                <el-form-item label="温度(˚C)" prop="temperature">
                  <el-input v-model="reportForm.temperature" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="湿度(%)" prop="humidity">
                  <el-input v-model="reportForm.humidity" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="气压(hPa)" prop="pressure">
                  <el-input v-model="reportForm.pressure" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-card>
          <el-card>
            <el-row>
            <el-col :span="12">
              <el-form-item label="检验日期" prop="fromDate">
                <el-date-picker
                  v-model="reportForm.fromDate"
                  type="date"
                  :placeholder="$placeholder.selectDate" :disabled="isApproval" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="到" prop="toDate">
                <el-date-picker
                  v-model="reportForm.toDate"
                  type="date"
                  :placeholder="$placeholder.selectDate" :disabled="isApproval" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          </el-card>
          <el-card>
          <div slot="header">
            <span>检验依据</span>
          </div>
            <el-row>
              <el-col>
                <el-form-item label="产品标准" prop="proStandard">
                  <el-input v-model="reportForm.proStandard" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col>
                <el-form-item label="检验方法标准" prop="inspectStandard">
                  <el-input v-model="reportForm.inspectStandard" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="检验要求" prop="inspectRequire">
                  <el-input type="textarea" :autosize="$textareaAutosize" :disabled="isApproval" v-model="reportForm.inspectRequire" :placeholder="$placeholder.inputTextarea"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="检验结论" prop="inspectResult">
                  <el-input type="textarea" :autosize="$textareaAutosize" :disabled="isApproval" v-model="reportForm.inspectResult" :placeholder="$placeholder.inputTextarea"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <el-form-item label="检验状态" prop="inspectStatus">
                  <el-radio-group v-model="reportForm.inspectStatus" :disabled="isApproval" style="width: 50%">
                    <el-row>
                      <el-col :span="8">
                        <el-radio label="合格">合格</el-radio>
                      </el-col>
                      <el-col :span="8">
                        <el-radio label="不合格">不合格</el-radio>
                      </el-col>
                      <el-col :span="8">
                        <el-radio label="不做结论">不做结论</el-radio>
                      </el-col>
                  </el-row>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col>
                <el-form-item label="备注" prop="remark">
                  <el-input v-model="reportForm.remark" :disabled="isApproval" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="批准人" prop="approver">
                  <el-input v-model="reportForm.approver" :disabled="true" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="审核人" prop="auditor">
                  <el-input v-model="reportForm.auditor" :disabled="true" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="主检人" prop="mainInspector">
                  <el-input v-model="reportForm.mainInspector" :disabled="true" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-card>
        </el-form>
      </el-row>
      <el-row>
        <el-form>
          <el-card>
            <div slot="header">
              <span>检验项目</span>
            </div>
            <light-table :data="checkProjectList" :columns="isApproval ? columns.concat(paramsData) : columns.concat(paramsData).concat(editColumns)" ref="table"
                         :showSearch="false">
              <template slot="operateTable">
                <el-button v-if="!isApproval" @click="changeParams">改变参数</el-button>
                <el-button v-if="!isApproval" @click="addProject">添加检验项目</el-button>
              </template>
              <template slot="edit" slot-scope="props">
                <el-button size="mini" type="danger" @click="deleteProject(props.prop)">删除</el-button>
              </template>
            </light-table>
          </el-card>
        </el-form>
      </el-row>
    </div>
    <div slot="footer">
      <el-button type="primary" v-if="!isApproval"  @click="saveInspectReport">保存</el-button>
    </div>
    <el-dialog
      :title="paramsFormTitle"
      :visible.sync="showDialog"
      width="60%"
      :close-on-click-modal="false"
      @close="dialogClose"
      center>
      <light-table :data="paramsData" :columns="paramsColumns" ref="paramsTable"
                   :showSearch="false">
        <template slot="operateTable">
          <el-row>
            <el-col :span="16">
              <el-input v-model="paramsLabel"></el-input>
            </el-col>
            <el-col :span="8">
              <el-button type="primary" style="margin-left: 20px" @click="addParams">添加参数</el-button>
            </el-col>
          </el-row>
        </template>
        <template slot="edit" slot-scope="props">
          <el-button size="mini" type="danger" @click="deleteParams(props.prop.prop)">删除</el-button>
        </template>
      </light-table>
    </el-dialog>
  </page-main-body>
</template>

<script>
import _ from 'lodash';
import axios from 'axios';
const saveSample = (sampleForm) => axios.post('/api/sample', sampleForm);
const getSampleById = (id) => axios.get(`/api/sample/${id}`);

export default {
  name: 'inspectReport',
  data () {
    const unitList = [
      {label: '/', value: '/'},
      {label: '符合', value: '符合'},
      {label: '不符合', value: '不符合'}
    ];
    const projectList = [
      {label: '温度', value: '温度'},
      {label: '湿度', value: '湿度'}
    ];
    return {
      title: '检验报告',
      reportForm: {
        department: '淄博市产品质量监督检验所',
        standard: [], // 报告标准
        missionNo: '',
        reportNo: '',
        inspectRequire: '', // 检验方法标准
        inspectResult: '', // 检验结论
        inspectStatus: '', // 检验状态
        deputeCompany: '',
        mark: '',
        sampleName: '',
        checkType: '',
        sampleLevel: '',
        size: '',
        inspectCompany: '',
        inspectComAddress: '',
        samPeople: '',
        samplingPlace: '',
        samBase: '',
        samDate: '',
        sampleCount: '',
        proDate: '',
        sampleStatus: '',
        unitName: '',
        reachTime: '',
        temperature: '', // 温度
        humidity: '', // 湿度
        pressure: '', // 气压
        fromDate: '', // 抽检日期from
        toDate: '', // 抽检日期to
        inspectStandard: '', // 检验方法标准
        proStandard: '',
        remark: '', // 备注
        approver: '', // 批准人
        auditor: '', // 审核人
        mainInspector: '', // 主检人
        checkProjectList: [] // 检验项目
      },
      standardList: [
        { label: '审查验收(CMA、CAL)', value: 'inspect' },
        { label: '实验认可(ILAC、CNAS)', value: 'experiment' }
      ],
      standard: [],
      checkProjectList: [],
      reportRules: {

      },
      columns: [
        {
          prop: 'number',
          label: '序号',
          type: {
            text: true
          }
        },
        {
          prop: 'project',
          label: '检测项目',
          type: {
            select: true,
            selectList: projectList
          }
        },
        {
          prop: 'requirement',
          label: '技术要求',
          type: {
            textarea: true
          }
        },
        {
          prop: 'unit',
          label: '单位',
          type: {
            textarea: true
          }
        },
        {
          prop: 'judgement',
          label: '单项判定',
          type: {
            select: true,
            selectList: unitList
          }
        }
      ],
      editColumns: [
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      paramsColumns: [
        {
          prop: 'label',
          label: '参数名称',
          type: {
            text: true
          }
        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      paramsFormTitle: '改变参数',
      showDialog: false,
      paramsData: [],
      paramsLabel: '',
      inspectDepartmentList: [
        {label: '淄博市产品质量监督检验所', value: '淄博市产品质量监督检验所'}
      ],
      isApproval: false
    };
  },
  computed: {
    visibleReport () {
      return !this.$route.params.id;
    }
  },
  mounted () {
    if (this.$route.query.id) {
      this.loading = true;
      getSampleById(this.$route.query.id).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          this.reportForm = data.data.datas[0];
          this.isApproval = this.reportForm.status === '未批准';
          if (this.isApproval) {
            this.setColumnsDisabled(this.columns);
          }
          if (this.reportForm.standard && this.reportForm.standard.length > 0) {
            this.standard = this.reportForm.standard;
          } else {
            this.standard = [];
          }
          this.paramsData = [];
          _.each(this.reportForm.extraProLabel, item => {
            this.paramsData.push({
              prop: item.pro,
              label: item.label,
              disabled: this.isApproval,
              type: JSON.parse(item.type)
            });
          });
          this.checkProjectList = [];
          _.each(this.reportForm.checkProjectList, item => {
            let list = {
              sampleCount: item.number,
              judgement: item.judgement,
              project: item.project,
              requirement: item.requirement,
              unit: item.unit
            };
            for (const key in item.extraPro) {
              list[key] = item.extraPro[key];
            }
            this.checkProjectList.push(list);
          });
        }
      });
    }
  },
  methods: {
    changeParams () {
      this.showDialog = true;
    },
    dialogClose () {
      this.paramsLabel = '';
      this.showDialog = false;
    },
    addProject () {
      const find = _.maxBy(this.checkProjectList, 'id');
      const maxId = (find ? find.id : 0) + 1;
      this.checkProjectList.push({id: maxId});
    },
    addParams () {
      if (!this.paramsLabel) {
        this.onAlertError('参数为空');
      } else {
        const find = _.filter(this.paramsData, item => item.label === this.paramsLabel);
        if (find.length > 0) {
          this.onAlertError('参数已存在');
        } else {
          this.paramsData.push({
            prop: `pro${this.paramsData.length + 1}`,
            label: this.paramsLabel,
            type: {
              textarea: true
            }
          });
          this.paramsLabel = '';
        }
      }
    },
    deleteParams (prop) {
      const findIndex = _.findIndex(this.paramsData, item => item.prop === prop);
      if (findIndex >= 0) {
        this.paramsData.splice(findIndex, 1);
      }
    },
    deleteProject (prop) {
      const findIndex = _.findIndex(this.checkProjectList, item => item.id === prop.id);
      if (findIndex >= 0) {
        this.checkProjectList.splice(findIndex, 1);
      }
    },
    saveInspectReport () {
      const newProjectList = [];
      _.each(this.checkProjectList, item => {
        let newListItem = {
          number: item.number,
          project: item.project,
          requirement: item.requirement,
          unit: item.unit,
          judgement: item.judgement,
          extraPro: {}
        };
        _.each(this.paramsData, itemData => {
          newListItem.extraPro[itemData.prop] = item[itemData.prop];
        });
        newProjectList.push(newListItem);
      });
      this.reportForm.checkProjectList = newProjectList;
      const newParamsData = [];
      _.each(this.paramsData, item => {
        newParamsData.push({
          pro: item.prop,
          label: item.label,
          type: JSON.stringify(item.type)
        });
      });
      this.reportForm.extraProLabel = newParamsData;
      this.reportForm.standard = this.standard;
      // this.reportForm.standard = [];
      this.loading = true;
      saveSample(this.reportForm).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          // this.$refs.sampleForm.resetFields();
          this.onAlertSuccess('保存成功');
          this.$router.push(`/inspectReport?id=${data.data.datas[0].id}`);
        } else {
          this.onAlertError('保存失败');
        }
      }).catch(err => {
        this.loading = false;
        console.log(err);
        this.onAlertError('保存失败');
      });
    }
  }
};
</script>

<style scoped>

</style>
