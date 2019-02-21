<template>
  <div id="printBodyPage">
    <el-row class="pdf-body pdf-index">
      <el-row class="pdf-header-img">
        <el-col :span="8">
          <img src="../assets/logo.png"/>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h1">检 验 报 告</span>
        </el-col>
      </el-row>
      <el-row class="line-margin">
      <el-col :span="24">
        <span class="pdf-title-h2">Test Report</span>
      </el-col>
      </el-row>
      <el-row class="line-mim-margin">
        <el-col :span="24">
          <span class="pdf-title-h3">{{sampleForm.reportNo}}</span>
        </el-col>
      </el-row>
      <el-row class="line-margin">
        <el-col :span="20" :offset="2" class="pdf-form">
          <el-col :span="10">
            <el-row>
              <span>样 品 名 称</span>
            </el-row>
            <el-row class="pdf-form-label-english">
              <span>Sample</span>
            </el-row>
          </el-col>
          <el-col :span="14" class="pdf-form-input">
            {{sampleForm.sampleName}}
          </el-col>
        </el-col>
      </el-row>
      <el-row class="line-margin">
        <el-col :span="20" :offset="2" class="pdf-form">
          <el-col :span="10">
            <el-row>
              <span>规 格 型 号</span>
            </el-row>
            <el-row class="pdf-form-label-english">
              <span>Model,Type</span>
            </el-row>
          </el-col>
          <el-col :span="14" class="pdf-form-input">
            {{sampleForm.size}}
          </el-col>
        </el-col>
      </el-row>
      <el-row class="line-margin">
        <el-col :span="20" :offset="2" class="pdf-form">
          <el-col :span="10">
            <el-row>
              <span>委 托 单 位</span>
            </el-row>
            <el-row class="pdf-form-label-english">
              <span>The Client</span>
            </el-row>
          </el-col>
          <el-col :span="14" class="pdf-form-input">
            {{sampleForm.deputeCompany}}
          </el-col>
        </el-col>
      </el-row>
      <el-row class="line-margin">
        <el-col :span="20" :offset="2" class="pdf-form">
          <el-col :span="10">
            <el-row>
              <span>受 检 单 位</span>
            </el-row>
            <el-row class="pdf-form-label-english">
              <span>Supervised Enterprise</span>
            </el-row>
          </el-col>
          <el-col :span="14" class="pdf-form-input">
            {{sampleForm.inspectCompany}}
          </el-col>
        </el-col>
      </el-row>
      <el-row class="line-margin">
        <el-col :span="20" :offset="2" class="pdf-form">
          <el-col :span="10">
            <el-row>
              <span>检 验 类 别</span>
            </el-row>
            <el-row class="pdf-form-label-english">
              <span>Test Kind</span>
            </el-row>
          </el-col>
          <el-col :span="14" class="pdf-form-input">
            {{sampleForm.checkType}}
          </el-col>
        </el-col>
      </el-row>
      <el-row class="line-max-margin">
        <el-col :span="24">
          <span class="pdf-title-h4">淄博市产品质量监督检验所</span>
        </el-col>
      </el-row>
      <el-row class="line-mim-margin">
        <el-col :span="24">
          <span class="pdf-title-h5">Zibo Institute of Product Quality Supervision & Inspection</span>
        </el-col>
      </el-row>
    </el-row>
    <el-row class="pdf-body pdf-second">
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h2">注  意  事  项</span>
        </el-col>
      </el-row>
      <el-row class="pdf-body-font">
        <el-row>
          1. 报告无"检验专用专用章"无效。
        </el-row>
        <el-row>
          2. 报告不得部分复制。
        </el-row>
        <el-row>
          3. 报告无主检、审核、批准人签字无效。
        </el-row>
        <el-row>
          4. 报告涂改无效。
        </el-row>
        <el-row>
          5. 对检验报告若有异议，应于收到报告之日起十五日内向检验单位书面提出，逾期不予受理。
          其中对监督抽查、定期监督检验等法制检验结果有异议的，可向任务委托的政府主管部门书面提出。
        </el-row>
        <el-row>
          6. 送样委托检验仅对来样负责。
        </el-row>
        <el-row>
          7. 检验项目中注"*"者为分包检验项目。
        </el-row>
        <el-row>
          8. 国家陶瓷与耐火材料产品质量监督检验中心非法人单位，所有法律责任由母体淄博市产品质量监督检验所承担。
        </el-row>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h2">Notices</span>
        </el-col>
      </el-row>
      <el-row class="pdf-body-font">
        <el-row>
          1. A report is invalid without stamping of the Special Chop of Test Report.
        </el-row>
        <el-row>
          2. A reproduced report is invalid.
        </el-row>
        <el-row>
          3. A report is invalid without signatures of the inspector,the checker and the approver.
        </el-row>
        <el-row>
          4. A report is invalid if altered.
        </el-row>
        <el-row>
          5. Any dispute to the report should be claimed in written form to the agency in 15 days from the day the report is received.
          Overdue claim would not be accepted.If you have any objection on the report of supervision and inspection,
          such as supervisory selective examination and periodic supervision and inspection,
          disputes to the report should be claimed in written form to the government department in charge allocating the task.
        </el-row>
        <el-row>
          6. The test results under the clients' instructions only carry the responsibilities to the samples submitted.
        </el-row>
        <el-row>
          7. Test items with "*" are subcontracted items.
        </el-row>
        <el-row>
          8. National Quality Supervision and Inspection Center for Ceramic and Refractories is an unincorporated unit,
          all legal liabilities shall be borne by the Zibo Institute of Product Quality Supervision & Inspection.
        </el-row>
      </el-row>
      <el-row class="pdf-footer pdf-footer-font">
        <el-row>
          <el-checkbox v-model="address1">地址一</el-checkbox>
          <span>(Address one)</span>
          <span>: 山东省淄博市张店区昌国西路88号(中国陶瓷科技城)</span>
        </el-row>
        <el-row>
          <span>88 Changguo Road, Zhangdian, Zibo, Shandong Province (China Technology Commodity Market)</span>
        </el-row>
        <el-row class="line-margin">
          <el-checkbox v-model="address2">地址二</el-checkbox>
          <span>(Address two)</span>
          <span>: 山东省淄博市高新技术产业开发区裕民路齐林工业园</span>
        </el-row>
        <el-row>
          <span>Qi Lin Industrial Park, Yumin Road, High and new technology industry development zone, Zibo</span>
        </el-row>
        <el-row class="line-margin">
          <el-col :span="12">
            <span>电话</span>
            <span>(Tel)</span>
            <span>: 0533-2858000</span>
          </el-col>
          <el-col :span="12">
            <span>传真</span>
            <span>(FAX)</span>
            <span>: 0533-2858060</span>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <span>邮政编码</span>
            <span>(Post Code)</span>
            <span>: 255063</span>
          </el-col>
          <el-col :span="12">
            <span>电子邮箱</span>
            <span>(E-mail)</span>
            <span>: zbzjyws@163.com</span>
          </el-col>
        </el-row>
      </el-row>
    </el-row>
    <el-row class="pdf-body pdf-third">
      <div class="pdf-title-h6 pdf-head-mission-no">
        {{sampleForm.reportNo}}
      </div>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h4">淄博市产品质量监督检验所</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h6">Zibo Institute of Product Quality Supervision & Inspection</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h4">检验报告</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h6">Test Report</span>
        </el-col>
      </el-row>
      <el-row style="text-align: right">
        <span>第1页 共{{tableList.length + 1}}页</span>
      </el-row>
      <el-row>
        <table>
          <tr>
            <td class="table-label">
              <div>样品名称</div>
              <div>Sample</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sampleName}}</div></td>
            <td class="table-label">
              <div>检验类别</div>
              <div>Test Kind</div>
            </td>
            <td class="table-input"><div>{{sampleForm.checkType}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>型号规格</div>
              <div>Model,Type</div>
            </td>
            <td class="table-input"><div>{{sampleForm.size}}</div></td>
            <td class="table-label">
              <div>样品等级</div>
              <div>Grade</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sampleLevel}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>委托单位</div>
              <div>The Client</div>
            </td>
            <td class="table-input"><div>{{sampleForm.deputeCompany}}</div></td>
            <td class="table-label">
              <div>商标</div>
              <div>Brand</div>
            </td>
            <td class="table-input"><div>{{sampleForm.mark}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>受检单位</div>
              <div>Supervised Enterprise</div>
            </td>
            <td class="table-input"><div>{{sampleForm.inspectCompany}}</div></td>
            <td class="table-label">
              <div>送样地点</div>
              <div>Sampling Location</div>
            </td>
            <td class="table-input"><div>{{sampleForm.samplingPlace}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>单位地址</div>
              <div>Address of EnterPrise</div>
            </td>
            <td class="table-input"><div>{{sampleForm.inspectComAddress}}</div></td>
            <td class="table-label">
              <div>送样人员</div>
              <div>Client Representative</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sendPeople}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>样本基数</div>
              <div>Batch Quantity</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sampleCount}}</div></td>
            <td class="table-label">
              <div>接样日期</div>
              <div>Receipt Date</div>
            </td>
            <td class="table-input"><div>{{sampleForm.samDate}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>样品数量</div>
              <div>Sample Quantity</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sampleCount}}</div></td>
            <td class="table-label">
              <div>生产日期</div>
              <div>Producing Date</div>
            </td>
            <td class="table-input"><div>{{sampleForm.proDate}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>样品特性和状态</div>
              <div>Sample Description</div>
            </td>
            <td class="table-input"><div>{{sampleForm.sampleStatus}}</div></td>
            <td class="table-label">
              <div>样品批号</div>
              <div>Batch No.</div>
            </td>
            <td class="table-input"><div>{{sampleForm.produceNo}}</div></td>
          </tr>
          <tr>
            <td class="table-label">
              <div>检验环境</div>
              <div>Environment for Test</div>
            </td>
            <td class="table-input">
              <div>
                <span v-if="sampleForm.temperature">温度{{sampleForm.temperature}}˚C; </span>
                <span v-if="sampleForm.humidity">湿度{{sampleForm.humidity}}%; </span>
                <span v-if="sampleForm.pressure">气压{{sampleForm.pressure}}hPa; </span>
              </div></td>
            <td class="table-label">
              <div>检验日期</div>
              <div>Test Date</div>
            </td>
            <td class="table-input"><div>{{sampleForm.fromDate}} ~ {{sampleForm.toDate}}</div></td>
          </tr>
          <tr>
            <td class="table-label" rowspan="2">
              <div>检验依据</div>
              <div>Test Standard</div>
            </td>
            <td class="table-input table-message-input" colspan="3"><div>{{sampleForm.proStandard}}</div></td>
          </tr>
          <tr>
            <td class="table-input table-message-input" colspan="3"><div>{{sampleForm.inspectStandard}}</div></td>
          </tr>
          <tr class="span-columns">
            <td class="table-label">
              <div>检验要求</div>
              <div>Test Date</div>
            </td>
            <td class="table-input table-message-input" colspan="3">
              <div>{{sampleForm.inspectRequire}}</div>
              <div class="report-mark">检验单位（盖章）{{moment().format('YYYY年M月D日')}}&nbsp;&nbsp;&nbsp;&nbsp;</div>
            </td>
          </tr>
          <tr class="span-columns">
            <td class="table-label">
              <div>检验结论</div>
              <div>Test Date</div>
            </td>
            <td class="table-input table-message-input" colspan="3"><div>{{sampleForm.inspectResult}}</div></td>
          </tr>
          <tr class="span-columns">
            <td class="table-label">
              <div>备注</div>
              <div>Test Date</div>
            </td>
            <td class="table-input table-message-input" colspan="3">
              <div>{{sampleForm.remark}}</div>
            </td>
          </tr>
        </table>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-col :span="8" class="pdf-sign-label">
            <el-row>
              批准：
            </el-row>
            <el-row>
              Inspector
            </el-row>
          </el-col>
          <el-col :span="16" class="pdf-sign">
            {{sampleForm.approver}}
          </el-col>
        </el-col>
        <el-col :span="8">
          <el-col :span="8" class="pdf-sign-label">
            <el-row>
              审核：
            </el-row>
            <el-row>
              Inspector
            </el-row>
          </el-col>
          <el-col :span="16" class="pdf-sign">
            {{sampleForm.auditor}}
          </el-col>
        </el-col>
        <el-col :span="8">
          <el-col :span="8" class="pdf-sign-label">
            <el-row>
              主检：
            </el-row>
            <el-row>
              Inspector
            </el-row>
          </el-col>
          <el-col :span="16" class="pdf-sign">
            {{sampleForm.mainInspector}}
          </el-col>
        </el-col>
      </el-row>
    </el-row>
    <el-row class="pdf-body pdf-third" v-for="(list, index) in tableList" :key="index">
      <div class="pdf-title-h6 pdf-head-mission-no">
        {{sampleForm.reportNo}}
      </div>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h4">淄博市产品质量监督检验所</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h6">Zibo Institute of Product Quality Supervision & Inspection</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h4">检验报告(续页)</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span class="pdf-title-h6">Test Report</span>
        </el-col>
      </el-row>
      <el-row style="text-align: right">
        <span>第{{index + 2}}页 共{{tableList.length + 1}}页</span>
      </el-row>
      <el-row>
        <table>
          <tr>
            <th rowspan="2">序号</th>
            <th rowspan="2">检测项目</th>
            <th rowspan="2">技术要求</th>
            <th rowspan="2">单位</th>
            <th :colspan="extraProLabel.length">检验结果</th>
            <th rowspan="2">单项判定</th>
          </tr>
          <tr>
            <th v-for="item in extraProLabel" :key="item.prop + item.label">{{item.label}}</th>
          </tr>
          <tr v-for="item in list" :key="item.number">
            <td class="table-input"><div>{{item.number}}</div></td>
            <td class="table-input"><div>{{item.project}}</div></td>
            <td class="table-input"><div>{{item.requirement}}</div></td>
            <td class="table-input"><div>{{item.unit}}</div></td>
            <td class="table-input" v-for="label in extraProLabel" :key="label.prop">
              <div>{{item[label.prop]}}</div>
            </td>
            <td class="table-input"><div>{{item.judgement}}</div></td>
          </tr>
        </table>
      </el-row>
    </el-row>

  </div>

</template>

<script>
import _ from 'lodash';
import moment from 'moment';
import axios from 'axios';
import './inspectReportPdf.css';

const getSampleById = (id) => axios.get(`/api/sample/${id}`);
export default {
  name: 'inspectReportPdf',
  props: {
    id: [Number, String],
    default: () => {
      return '';
    }
  },
  data () {
    return {
      address1: false,
      address2: false,
      sampleForm: {},
      extraProLabel: [],
      tableList: [],
      moment
    };
  },
  watch: {
    id (val) {
      this.getSample(val);
    }
  },
  methods: {
    getSample (id) {
      if (id) {
        getSampleById(id).then(data => {
          if (data.data.code === '000') {
            this.sampleForm = data.data.datas[0];
            this.extraProLabel = [];
            this.tableList = [];
            let list = [];
            _.each(this.sampleForm.extraProLabel, label => {
              this.extraProLabel.push({prop: label.pro, label: label.label});
            });
            _.each(this.sampleForm.checkProjectList, item => {
              const newRow = {
                number: item.number,
                project: item.project,
                requirement: item.requirement,
                unit: item.unit,
                judgement: item.judgement
              };
              _.each(this.sampleForm.extraProLabel, label => {
                newRow[label.pro] = item.extraPro[label.pro];
              });
              list.push(newRow);
              if (list.length > 12) {
                this.tableList.push(list);
                list = [];
              }
            });
            this.tableList.push(list);
          }
          return this.sampleForm.reportNo || '检测报告';
        }).then((title) => {
          this.$emit('on-print', true, title);
        });
      }
    }
  }
};
</script>

<style scoped>

</style>
