<template>
  <page-main-body :title="title">
    <div style="width: 95%">
      <el-form :model="checkInForm" ref="checkInForm" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="样品编号" prop="sampleNo">
              <el-input v-model="checkInForm.sampleNo" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="创建时间" prop="createdAt">
              <el-date-picker disabled="true"
                v-model="checkInForm.createdAt"
                align="right" style="width: 100%"
                type="date"
                placeholder="选择日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="8" class="remind-message">
            <el-form-item>
              系统自动生成样品编号和创建时间
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="样品名称" prop="sampleName">
              <el-input v-model="checkInForm.sampleName"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="样品数量" prop="sampleCount">
              <el-input v-model="checkInForm.sampleCount"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="所属业务编号" prop="businessNo">
              <el-input v-model="checkInForm.businessNo"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="所属业务名称" prop="businessName">
              <el-input v-model="checkInForm.businessName"></el-input>
            </el-form-item>
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
              <el-col :span="16">
                <div v-for="message in checkInForm.sampleMessage" :key="message">
                  <el-input v-model="message.message" type="textarea" style="margin-bottom: 10px"></el-input>
                </div>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary">确认</el-button>
      <el-button>取消</el-button>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'sampleCheckIn',
  data () {
    return {
      title: '样品入库登记',
      checkInForm: {
        sampleNo: '编号1',
        createdAt: new Date(),
        sampleName: '',
        sampleCount: '',
        businessNo: '',
        businessName: '',
        sampleMessage: [
          {message: '信息1'},
          {message: '信息2'},
          {message: '信息3'}
        ]
      }
    };
  }
};
</script>

<style scoped>

</style>
