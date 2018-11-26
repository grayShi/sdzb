<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="detailForm" :rules="detailRules" ref="ruleForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">基本信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务名称" prop="modelName">
                  <el-input v-model="detailForm.modelName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="detailForm.sampleName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品数量" prop="count">
                  <el-input v-model="detailForm.count"></el-input>
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
              <span class="head-span">抽样申请:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item>
                  <el-tag type="success" v-if="showCurrent">现场抽样</el-tag>
                  <el-tag type="success" v-else>送检抽样</el-tag>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row v-if="showCurrent">
              <el-col :span="8">
                <el-form-item label="现场地址" prop="address">
                  <el-input v-model="detailForm.address"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品数量" prop="count">
                  <el-input v-model="detailForm.count"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row v-if="showCurrent">
              <el-col :span="8">
                <el-form-item label="抽样时间" prop="sampleTime">
                  <el-date-picker
                    v-model="detailForm.sampleTime"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="费用" prop="currentCost">
                  <el-input v-model="detailForm.currentCost"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row v-if="!showCurrent">
              <el-col :span="8">
                <el-form-item label="样品寄送方式" prop="sendMethod">
                  <el-input v-model="detailForm.sendMethod"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="寄送时间" prop="sendTime">
                  <el-date-picker
                    v-model="detailForm.sendTime"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row v-if="!showCurrent">
              <el-col :span="8">
                <el-form-item label="费用" prop="sendCost">
                  <el-input v-model="detailForm.sendCost"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row v-if="showCurrent">
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">选派业务员:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务员" prop="people">
                  <el-select v-model="detailForm.people" placeholder="请选择">
                    <el-option
                      v-for="item in peopleOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>

      </el-form>
    </el-row>
    <div slot="footer">
      <el-button type="primary" @click="showCurrent = !showCurrent">确认提交</el-button>
    </div>

  </page-main-body>

</template>

<script>
export default {
  name: 'confirmMessage',
  data () {
    return {
      showCurrent: true,
      detailForm: {
        modelName: '',
        sampleName: '',
        count: '',
        company: '',
        actionBy: '',
        phone: '',
        address: '',
        currentCost: '',
        sampleTime: '',
        people: '',
        sendMethod: '',
        sendTime: '',
        sendCost: ''
      },
      detailRules: {},
      peopleOptions: [
        {label: '业务员1', value: '业务员1'},
        {label: '业务员2', value: '业务员2'},
        {label: '业务员3', value: '业务员3'}
      ]
    };
  },
  computed: {
    title () {
      return this.showCurrent ? '确认业务信息-现场抽样' : '确认业务信息-送检抽样';
    }
  }
};
</script>

<style scoped>

</style>
