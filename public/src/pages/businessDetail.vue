<template>
<page-main-body :title="title">
  <el-row>
      <el-form :model="detailForm" :rules="detailRules" ref="ruleForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">业务信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务编号" prop="businessNo">
                  <el-input v-model="detailForm.businessNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="业务名称" prop="businessName">
                  <el-input v-model="detailForm.businessName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间" prop="createdAt">
                  <el-date-picker
                    v-model="detailForm.createdAt"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="企业名称" prop="company">
                  <el-input v-model="detailForm.company"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="联系方式" prop="phone">
                  <el-input v-model="detailForm.phone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">样品信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="样品编号" prop="sampleNo">
                  <el-input v-model="detailForm.sampleNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="detailForm.sampleName"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="抽样方式" prop="samplingMethod">
                  <el-input v-model="detailForm.samplingMethod"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item label="抽样信息" prop="samplingMessage">
                  <el-input v-model="detailForm.samplingMessage"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">业务状态:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务状态" prop="status">
                  <el-input v-model="detailForm.status"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-form>
  </el-row>
  <div slot="footer">
    <el-button type="danger">删除业务</el-button>
    <el-button type="primary">确认</el-button>
    <el-button>取消</el-button>
  </div>

</page-main-body>

</template>

<script>
export default {
  name: 'businessDetail',
  data () {
    return {
      title: '业务详情',
      detailForm: {
        businessNo: '',
        businessName: '',
        createdAt: '',
        company: '',
        actionBy: '',
        phone: '',
        sampleNo: '',
        sampleName: '',
        samplingMethod: '',
        samplingMessage: '',
        status: ''
      },
      detailRules: {}
    };
  }
};
</script>

<style scoped>

</style>
