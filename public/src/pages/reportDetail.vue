<template>
  <page-main-body :title="title">
    <div>
      <el-row>
        <el-card>
          <div slot="header">
            <span>业务详情</span>
          </div>
          <el-form :model="detailForm" ref="detailForm" label-width="100px">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务名称" prop="businessName">
                  <el-input v-model="detailForm.businessName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="业务编号" prop="businessNo">
                  <el-input v-model="detailForm.businessNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间" prop="businessCreatedAt">
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
          </el-form>
        </el-card>
      </el-row>
      <el-row>
        <el-card>
          <div slot="header">
            <span>样品详情</span>
          </div>
          <el-form :model="detailForm" ref="sampleForm" label-width="100px">
            <el-row>
              <el-col :span="6">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="detailForm.sampleName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="样品数量" prop="businessNo">
                  <el-input v-model="detailForm.businessNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="创建时间" prop="sampleCreatedAt">
                  <el-date-picker
                    v-model="detailForm.createdAt"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="寄送方式" prop="shipping">
                  <el-input v-model="detailForm.shipping"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品数据" prop="sampleDetail">
                  <el-input v-model="detailForm.company" type="textarea" :rows="2"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品图片" prop="samplePhoto">
                  <div class="sample-photo" style="overflow: auto">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-card>
      </el-row>
      <el-row>
        <el-card>
          <div slot="header">
            <span>任务详情</span>
          </div>
          <el-form :model="detailForm" ref="missionForm" label-width="100px">
            <el-row>
              <el-col :span="8">
                <el-form-item label="任务内容" prop="missionDetail">
                  <el-input v-model="detailForm.missionDetail"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="任务编号" prop="missionNo">
                  <el-input v-model="detailForm.missionNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责人" prop="missionActionBy">
                  <el-input v-model="detailForm.missionActionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="抽检结果" prop="checkResult">
                  <el-input v-model="detailForm.checkResult"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="改进意见" prop="suggestion">
                  <el-input v-model="detailForm.suggestion"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="审核反馈" prop="feedback">
                  <el-input v-model="detailForm.feedback"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-card>
      </el-row>
    </div>
    <div slot="footer">
      <el-button type="primary">生成报告二维码</el-button>
      <el-button type="primary">导出报告</el-button>
      <el-button type="danger">删除报告</el-button>
      <el-button>取消</el-button>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'reportDetail',
  data () {
    return {
      title: '报告详情',
      detailForm: {
        businessNo: '',
        businessName: '',
        businessCreatedAt: '',
        company: '',
        companyActionBy: '',
        phone: '',
        sampleName: '',
        sampleCreatedAt: '',
        shipping: '',
        sampleDetail: '',
        samplePhoto: [],
        missionDetail: '',
        missionNo: '',
        department: '',
        missionActionBy: '',
        checkResult: '',
        suggestion: '',
        feedback: ''
      }
    };
  }
};
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;
  }
  img {
    margin-right: 20px;
  }
  img:last-child {
    margin-right: 0;
  }
  .sample-photo {
    height: 100px;
    text-align: center;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
  }
</style>
