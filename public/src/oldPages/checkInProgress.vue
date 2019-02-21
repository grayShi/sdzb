<template>
  <page-main-body :title="title">
    <div style="width: 90%">
      <h3>基本信息</h3>
      <el-form :model="detailForm" ref="detailForm" label-width="100px">
        <el-row>
          <el-col :span="6">
            <el-form-item label="样品名称" prop="sampleName">
              <el-input v-model="detailForm.sampleName"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="样品数量" prop="sampleCount">
              <el-input v-model="detailForm.sampleCount"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="创建时间" prop="sampleCreatedAt">
              <el-date-picker
                v-model="detailForm.sampleCreatedAt"
                align="right" style="width: 100%"
                type="date"
                placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="样品状态" prop="sampleStatus">
             <el-tag type="success">{{detailForm.sampleStatus}}</el-tag>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="所属业务" prop="businessName">
              <el-input v-model="detailForm.businessName"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="创建时间" prop="businessCreatedAt">
              <el-input v-model="detailForm.businessCreatedAt"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="业务状态" prop="businessStatus">
              <el-tag type="success">{{detailForm.businessStatus}}</el-tag>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <el-row style="margin-bottom: 20px">
        <el-button type="primary" size="small">查看业务进度</el-button>
        <span>业务已经确认,正在抽样流程</span>
      </el-row>
      <el-form :model="progressForm" ref="progressForm" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="抽样方式" prop="selectMethod">
              <el-input v-model="progressForm.selectMethod"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="入库进度" prop="progress">
              <el-input v-model="progressForm.progress"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item class="remind-message">
              <div>预计完成抽样时间: {{progressForm.deadline}}</div>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </page-main-body>
</template>

<script>
    export default {
        name: "checkInProgress",
      data() {
          return {
            title: '(待入库)查看入库进度',
            detailForm: {
              sampleName: '',
              sampleCount: '',
              sampleCreatedAt: '',
              sampleStatus: '待入库',
              businessName: '',
              businessCreatedAt: '',
              businessStatus: '抽样中'
            },
            progressForm: {
              selectMethod: '现场抽样',
              progress: '业务员已指派正在派往现场',
              deadline: '2018-11-26',
            }
          }
      }
    }
</script>

<style scoped>

</style>
