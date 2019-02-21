<template>
  <page-main-body :title="title">
    <div style="width: 90%">
      <el-form :model="deviceForm" ref="deviceForm" label-width="100px">
        <el-row>
          <el-col :span="6">
            <el-form-item label="所内编号" prop="deviceNo">
              <el-input v-model="deviceForm.deviceNo" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="仪器名称" prop="deviceName">
              <el-input v-model="deviceForm.deviceName" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="规格型号" prop="deviceType">
              <el-input v-model="deviceForm.deviceType" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="量程" prop="range">
              <el-input v-model="deviceForm.range" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="准确度" prop="accuracy">
              <el-input v-model="deviceForm.accuracy" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="制造单位" prop="deviceUnit">
              <el-input v-model="deviceForm.deviceUnit" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="出厂编号" prop="deviceOutNo">
              <el-input v-model="deviceForm.deviceOutNo" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="分辨力" prop="distinguish">
              <el-input v-model="deviceForm.distinguish" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="设备原值(元)" prop="equipmentNo">
              <el-input v-model="deviceForm.equipmentNo" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="购买日期" prop="purchaseDate">
              <el-date-picker
                v-model="deviceForm.purchaseDate"
                align="right" style="width: 100%"
                type="date"
                :placeholder="$placeholder.selectDate">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="校验周期(年)" prop="checkYear">
              <el-input v-model="deviceForm.checkYear" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="校验单位" prop="checkUnit">
              <el-input v-model="deviceForm.computerBrand" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="维护周期" prop="checkPeriod">
              <el-input v-model="deviceForm.computerBrand" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="校验类型" prop="checkType">
              <el-input v-model="deviceForm.checkType" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="校验方式" prop="checkMethod">
              <el-input v-model="deviceForm.checkMethod" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="校验室" prop="checkRoom">
              <el-input v-model="deviceForm.checkRoom" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="存放地" prop="stayRoom">
              <el-input v-model="deviceForm.stayRoom" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="期间检查时间(月)" prop="checkDate">
              <el-input v-model="deviceForm.computerBrand" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="问题" prop="question">
              <el-input v-model="deviceForm.question" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="检定/校准部件" prop="checkDevice">
              <el-input v-model="deviceForm.checkDevice" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="校准参数范围" prop="checkParams">
              <el-input v-model="deviceForm.checkParams" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="今年实际需核查" prop="needCheck">
              <el-input v-model="deviceForm.needCheck" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="检定费" prop="checkCost">
              <el-input v-model="deviceForm.checkCost" :placeholder="$placeholder.input"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">
            <el-form-item label="2015年" prop="year2015">
              <el-date-picker
                v-model="deviceForm.year2015"
                align="right" style="width: 100%"
                type="date"
                :placeholder="$placeholder.selectDate">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="2016年" prop="year2016">
              <el-date-picker
                v-model="deviceForm.year2016"
                align="right" style="width: 100%"
                type="date"
                :placeholder="$placeholder.selectDate">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="2017年" prop="year2017">
              <el-date-picker
                v-model="deviceForm.year2017"
                align="right" style="width: 100%"
                type="date"
                :placeholder="$placeholder.selectDate">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="6">
            <el-form-item label="2018年" prop="year2018">
              <el-date-picker
                v-model="deviceForm.year2018"
                align="right" style="width: 100%"
                type="date"
                :placeholder="$placeholder.selectDate">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary">登记</el-button>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'addDevice',
  data () {
    return {
      title: '设备登记',
      deviceForm: {
        deviceNo: '',
        deviceName: '',
        deviceType: '',
        range: '',
        accuracy: '',
        deviceUnit: '',
        deviceOutNo: '',
        distinguish: '',
        equipmentNo: '',
        purchaseDate: '',
        checkYear: '',
        checkUnit: '',
        checkPeriod: '',
        checkType: '',
        checkMethod: '',
        checkRoom: '',
        stayRoom: '',
        checkDate: '',
        question: '',
        checkDevice: '',
        checkParams: '',
        needCheck: '',
        checkCost: '',
        year2015: '',
        year2016: '',
        year2017: '',
        year2018: ''
      }
    };
  }
};
</script>

<style scoped>

</style>
