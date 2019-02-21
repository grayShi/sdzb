<template>
  <page-main-body :title="title" :loading="loading">
    <div style="width: 90%">
      <el-form :model="sampleForm" ref="sampleForm" :rules="sampleRules" label-width="130px">
        <el-card>
          <el-row>
            <el-col :span="12">
              <el-form-item label="特殊符号" prop="specialSymbol">
                <el-select v-model="sampleForm.specialSymbol" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in specialSymbolList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="承检部门" prop="department">
                <el-select v-model="sampleForm.department" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in departmentList"
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
              <el-form-item label="样品单号" prop="sampleNo">
                <el-select v-model="sampleForm.sampleNo" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in sampleNoList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="WT" prop="wt">
                <el-input v-model="sampleForm.wt" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-card>
        <el-card>
          <div slot="header">
            <span>产品信息</span>
          </div>
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品名称" prop="sampleName">
                <el-input v-model="sampleForm.sampleName" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="检验类型" prop="checkType">
                <el-select v-model="sampleForm.checkType" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in checkTypeList"
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
              <el-form-item label="单元名称" prop="unitName">
                <el-input v-model="sampleForm.unitName" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="省级发证报告号" prop="reportNo">
                <el-input v-model="sampleForm.reportNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="商标" prop="mark">
                <el-input v-model="sampleForm.mark" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="生产批号" prop="produceNo">
                <el-input v-model="sampleForm.produceNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品等级" prop="sampleLevel">
                <el-select v-model="sampleForm.sampleLevel" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in sampleLevelList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="型号规格" prop="size">
                <el-input v-model="sampleForm.size" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="生产日期" prop="proDate">
                <el-date-picker
                  v-model="sampleForm.proDate"
                  type="date"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="产品标准" prop="proStandard">
                <el-select v-model="sampleForm.proStandard" multiple clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in proStandardList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
                <!--<el-input v-model="sampleForm.proStandard" :placeholder="$placeholder.input"></el-input>-->
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="检验项目" prop="checkPro">
                <el-input v-model="sampleForm.checkPro" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品数量" prop="sampleCount">
                <el-input v-model="sampleForm.sampleCount" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="样品存放地点" prop="savePlace">
                <el-select v-model="sampleForm.savePlace" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in placeList"
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
              <el-form-item label="备样存放地点" prop="samplePlace">
                <el-select v-model="sampleForm.samplePlace" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in samplePlaceList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="封条数量和号码" prop="countNo">
                <el-input v-model="sampleForm.countNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品处理方式" prop="handleType">
                <el-select v-model="sampleForm.handleType" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in handleTypeList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="样品状态" prop="sampleStatus">
                <el-select v-model="sampleForm.sampleStatus" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in statusList"
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
              <el-form-item label="完成日期" prop="completeDate">
                <el-date-picker
                  v-model="sampleForm.completeDate"
                  type="date"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="备样数量" prop="number">
                <el-input v-model="sampleForm.number" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="方式" prop="mode">
                <el-select v-model="sampleForm.mode" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in modeList"
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
              <el-form-item label="抽样地点" prop="samplingPlace">
                <el-select v-model="sampleForm.samplingPlace" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in samplingPlaceList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抽样方式" prop="samplingWay">
                <el-select v-model="sampleForm.samplingWay" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in samplingWayList"
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
              <el-form-item label="抽/送样日期" prop="samDate">
                <el-date-picker
                  v-model="sampleForm.samDate"
                  type="date"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抽样人" prop="samPeople">
                <el-input v-model="sampleForm.samPeople" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品基数/批量" prop="samBase">
                <el-input v-model="sampleForm.samBase" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="企业陪同人" prop="comPeople">
                <el-input v-model="sampleForm.comPeople" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="送样人" prop="sendPeople">
                <el-input v-model="sampleForm.sendPeople" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="样品到达时间" prop="reachTime">
                <el-date-picker
                  v-model="sampleForm.reachTime"
                  type="date"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="检查封样人员" prop="sealPeople">
                <el-input v-model="sampleForm.sealPeople" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="封样状态" prop="sealState">
                <el-input v-model="sampleForm.sealState" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-card>
        <el-card>
          <el-row slot="header">
            <span>单位信息</span>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="受检单位" prop="inspectCompany">
                <select-look-up v-model="sampleForm.inspectCompany" type="company" @select-row="selectRow($event, 'inspect')"></select-look-up>
                <!--<el-input v-model="sampleForm.inspectCompany" :placeholder="$placeholder.input"></el-input>-->
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="企业代码" prop="inspectComCode">
                <el-input v-model="sampleForm.inspectComCode" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="地址" prop="inspectComAddress">
                <el-input v-model="sampleForm.inspectComAddress" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="邮编" prop="inspectComPostNo">
                <el-input v-model="sampleForm.inspectComPostNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="电话" prop="inspectComPhone">
                <el-input v-model="sampleForm.inspectComPhone" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="联系人" prop="inspectComContact">
                <el-input v-model="sampleForm.inspectComContact" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="生产单位" prop="produceCompany">
                <select-look-up v-model="sampleForm.produceCompany" type="company" @select-row="selectRow($event, 'produce')"></select-look-up>
                <!--<el-input v-model="sampleForm.produceCompany" :placeholder="$placeholder.input"></el-input>-->
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="企业代码" prop="produceComCode">
                <el-input v-model="sampleForm.produceComCode" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="地址" prop="produceComAddress">
                <el-input v-model="sampleForm.produceComAddress" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="邮编" prop="produceComPostNo">
                <el-input v-model="sampleForm.produceComPostNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="电话" prop="produceComPhone">
                <el-input v-model="sampleForm.produceComPhone" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="联系人" prop="produceComContact">
                <el-input v-model="sampleForm.produceComContact" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="委托单位" prop="deputeCompany">
                <select-look-up v-model="sampleForm.deputeCompany" type="company" @select-row="selectRow($event, 'depute')"></select-look-up>
                <!--<el-input v-model="sampleForm.deputeCompany" :placeholder="$placeholder.input"></el-input>-->
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="企业代码" prop="deputeComCode">
                <el-input v-model="sampleForm.deputeComCode" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="地址" prop="deputeComAddress">
                <el-input v-model="sampleForm.deputeComAddress" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="邮编" prop="deputeComPostNo">
                <el-input v-model="sampleForm.deputeComPostNo" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="电话" prop="deputeComPhone">
                <el-input v-model="sampleForm.deputeComPhone" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="联系人" prop="deputeComContact">
                <el-input v-model="sampleForm.deputeComContact" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="任务来源" prop="taskSource">
                <el-input v-model="sampleForm.taskSource" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="抽样单位" prop="sampleUnit">
                <el-input v-model="sampleForm.sampleUnit" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="获取报告方式" prop="getReport">
                <el-select v-model="sampleForm.getReport" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in getReportList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-card>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary" @click="saveTemplate">保存</el-button>
    </div>
  </page-main-body>
</template>

<script>
import axios from 'axios';
const saveSample = (sampleForm) => axios.post('/api/sample', sampleForm);
const getSampleById = (id) => axios.get(`/api/sample/${id}`);

export default {
  name: 'newSample',
  data () {
    return {
      title: '新建样品',
      loading: false,
      sampleForm: {
        specialSymbol: '', // 特殊符号
        department: '', // 承检部门
        sampleNo: '', // 样品单号
        wt: '', // WT
        sampleName: '', // 样品名称
        checkType: '', // 检验类型
        unitName: '', // 单元名称
        reportNo: '', // 省级发证报告号
        mark: '', // 商标
        produceNo: '', // 生产批号
        sampleLevel: '', // 样品等级
        size: '', // 型号规格
        proDate: '', // 生产日期
        proStandard: [], // 产品标准
        checkPro: '', // 检验项目
        sampleCount: '', // 样品数量
        savePlace: '', // 样品存放地点
        samplePlace: '', // 备样存放地点
        countNo: '', // 封条数量和号码
        handleType: '', // 样品处理方式
        sampleStatus: '', // 样品状态
        completeDate: '', // 完成日期
        number: '', // 备样数量
        mode: '', // 方式
        samplingPlace: '', // 抽样地点
        samplingWay: '', // 抽样方式
        samDate: '', // 抽/送样日期
        samPeople: '', // 抽样人
        samBase: '', // 样品基数/批量
        comPeople: '', // 企业陪同人
        sendPeople: '', // 送样人
        reachTime: '', // 样品到达时间
        sealPeople: '', // 检查封样人员
        sealState: '', // 封样状态
        inspectCompany: '', // 受检单位
        inspectComCode: '', // 受检企业代码
        inspectComAddress: '', // 受检企业地址
        inspectComPostNo: '', // 受检企业邮编
        inspectComPhone: '', // 受检企业电话
        inspectComContact: '', // 受检企业联系人
        produceCompany: '', // 生产单位
        produceComCode: '',
        produceComAddress: '',
        produceComPostNo: '',
        produceComPhone: '',
        produceComContact: '',
        deputeCompany: '', // 委托单位
        deputeComCode: '',
        deputeComAddress: '',
        deputeComPostNo: '',
        deputeComPhone: '',
        deputeComContact: '',
        taskSource: '', // 任务来源
        sampleUnit: '', // 抽样单位
        getReport: '' // 获取报告方式
      },
      proStandardList: [
        { value: '标准1', label: '标准1' },
        { value: '标准2', label: '标准2' }
      ],
      specialSymbolList: [
        { value: '<', label: '<' },
        { value: '>', label: '>' }
      ],
      departmentList: [
        { value: '化工一室', label: '化工一室' },
        { value: '化工二室', label: '化工二室' }
      ],
      sampleNoList: [
        { value: '委托单号（委托）', label: '委托单号（委托）' },
        { value: '抽样单号（定检）', label: '抽样单号（定检）' }
      ],
      checkTypeList: [
        { value: '定期监督检验', label: '定期监督检验' },
        { value: '日常监督检验', label: '日常监督检验' }
      ],
      sampleLevelList: [
        { value: '合格品', label: '合格品' },
        { value: '次品', label: '次品' }
      ],
      placeList: [
        { value: '本所实验室', label: '本所实验室' },
        { value: '该单位', label: '该单位' }
      ],
      samplePlaceList: [
        { value: '本所实验室', label: '本所实验室' },
        { value: '该单位', label: '该单位' }
      ],
      handleTypeList: [
        { value: '退样', label: '退样' },
        { value: '用完', label: '用完' }
      ],
      statusList: [
        { value: '正常', label: '正常' },
        { value: '破损', label: '破损' }
      ],
      modeList: [
        { value: '抽样', label: '抽样' },
        { value: '送样', label: '送样' }
      ],
      samplingPlaceList: [
        { value: '该单位成品库', label: '该单位成品库' },
        { value: '该单位样品库', label: '该单位样品库' }
      ],
      samplingWayList: [
        { value: '随机', label: '随机' },
        { value: '/', label: '/' }
      ],
      getReportList: [
        { value: '自取', label: '自取' },
        { value: '邮寄', label: '邮寄' }
      ],
      sampleRules: {
        samBase: [this.inputNumber()],
        sampleCount: [this.inputNumber()],
        countNo: [this.inputNumber()],
        number: [this.inputNumber()]
      }
    };
  },
  mounted () {
    if (this.$route.query.id) {
      this.loadSample(this.$route.query.id);
    }
  },
  methods: {
    loadSample (id) {
      getSampleById(id).then(data => {
        if (data.data.code === '000') {
          this.sampleForm = data.data.datas[0];
        }
      });
    },
    selectRow (row, type) {
      this.sampleForm[`${type}ComCode`] = row.comCode;
      this.sampleForm[`${type}ComAddress`] = row.comAddress;
      this.sampleForm[`${type}ComPostNo`] = row.comPostNo;
      this.sampleForm[`${type}ComPhone`] = row.comPhone;
      this.sampleForm[`${type}ComContact`] = row.comContact;
    },
    saveTemplate () {
      this.$refs.sampleForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          saveSample(this.sampleForm).then(data => {
            this.loading = false;
            if (data.data.code === '000') {
              // this.$refs.sampleForm.resetFields();
              this.onAlertSuccess('保存成功');
              // if (this.$route.query.id) {
              //   this.loadSample(data.data.datas[0].id);
              // } else {
              // }
              this.$router.push(`/newSample?id=${data.data.datas[0].id}`);
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
    }
  }
};
</script>

<style scoped>

</style>
