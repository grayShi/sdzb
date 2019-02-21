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
        <el-row style="margin-bottom: 10px">
          <el-col :span="4">
            <div style="...">
              <span class="head-span">对应的任务列表：</span>
            </div>
          </el-col>

        </el-row>
        <el-row style="margin-bottom: 30px">
          <el-col :span="5">
            <el-form-item label="任务状态" prop="taskstate">
              <el-input v-model="detailForm.taskstate"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="任务编号" prop="tasknum">
              <el-input v-model="detailForm.tasknum"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="任务内容" prop="taskcontent">
              <el-input v-model="detailForm.taskcontent"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="5">
            <el-form-item label="负责人" prop="charger">
              <el-input v-model="detailForm.charger"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="2":offset="1">
            <el-button size="medium" @click="viewReportDetail(props.prop.id)">查看报告</el-button>
          </el-col>
        </el-row>



      </el-form>
    </el-row>
    <div slot="footer">
      <el-button type="primary">确认</el-button>
      <el-button>取消</el-button>
    </div>
  </page-main-body>

</template>

<script>
export default {
  name:'viewInspectResult',
  data () {
    return {
      title: '抽检结果',
      detailForm: {
        modelName: '',
        sampleName: '',
        count: '',
        company: '',
        actionBy: '',
        phone: '',
        taskstate:'',
        tasknum:'',
        taskcontent:'',
        charger:'',
        missionlist:[
          {
          taskstate:'',
          tasknum:'',
          taskcontent:'',
          charger:'',
          }
        ]
      },
    };
  },
  methods: {
    viewReportDetail () {
      this.$router.push('/reportDetail');
    },
    deleteReport () {

    },
    showQRCode () {

    }
  }
};
</script>

<style scoped>

</style>
