<template>
    <page-main-body :title="title">
      <div style="width:90%">
        <el-row>
          <el-card>
            <div slot="header">
              <span>基本信息</span>
            </div>
            <el-form :model="detailForm" ref="detailForm" label-width="100px">
              <el-row>
                <el-col :span="8">
                  <el-form-item label="业务名称" prop="businessName">
                    <el-input v-model="detailForm.businessName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="样品名称" prop="sampleName">
                    <el-input v-model="detailForm.sampleName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="样品数量" prop="sampleCount">
                    <el-input v-model="detailForm.sampleCount"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="客户企业名称" prop="company">
                    <el-input v-model="detailForm.company"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="负责人" prop="companyActionBy">
                    <el-input v-model="detailForm.companyActionBy"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="联系方式" prop="phone">
                    <el-input v-model="detailForm.phone"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row style="text-align: center">
                <el-button size="mini">业务声明</el-button>
              </el-row>
            </el-form>
          </el-card>
        </el-row>
        <el-row style="margin-top: 20px">
          <el-card>
            <div slot="header">
              <span>抽样检验申请</span>
            </div>
            <el-form :model="requestForm" ref="requestForm" label-width="100px">
              <el-row>
                <el-form-item label="现场地址" prop="address">
                  <el-select v-model="requestForm.sampleMethod" placeholder="请选择">
                    <el-option
                      v-for="item in methodsOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-row>
              <el-row v-if="requestForm.sampleMethod === 'currentMethod'">
                <el-col :span="6">
                  <el-form-item label="现场地址" prop="address">
                    <el-input v-model="requestForm.address"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="样品数量" prop="sampleCount">
                    <el-input v-model="requestForm.sampleCount"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="抽样时间" prop="sampleTime">
                    <el-date-picker
                      v-model="requestForm.sampleTime"
                      align="right" style="width: 100%"
                      type="date"
                      placeholder="选择日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="费用" prop="currentCost">
                    <el-input v-model="requestForm.currentCost"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row v-if="requestForm.sampleMethod === 'postMethod'">
                <el-col :span="6">
                  <el-form-item label="样品寄送方式" prop="postMethod">
                    <el-input v-model="requestForm.postMethod"></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="寄送时间" prop="postTime">
                    <el-date-picker
                      v-model="requestForm.postTime"
                      align="right" style="width: 100%"
                      type="date"
                      placeholder="选择日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item label="费用" prop="postCost">
                    <el-input v-model="requestForm.postCost"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
          </el-card>
        </el-row>
      </div>
    </page-main-body>
</template>

<script>
export default {
  name: 'registerTable',
  data () {
    return {
      title: '质检申请登记表',
      detailForm: {
        businessName: '',
        sampleName: '',
        sampleCount: '',
        company: '',
        companyActionBy: '',
        phone: ''
      },
      requestForm: {
        sampleMethod: 'currentMethod',
        address: '',
        sampleCount: '',
        sampleTime: '',
        currentCost: '',
        postMethod: '',
        postTime: '',
        postCost: ''
      },
      methodsOptions: [
        {label: '现场抽样', value: 'currentMethod'},
        {label: '送检抽样', value: 'postMethod'}
      ]
    };
  }
};
</script>

<style scoped>

</style>
