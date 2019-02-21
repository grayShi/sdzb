<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="detailForm" :rules="detailRules" ref="ruleForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">业务基本信息:</span>
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
          <el-col :span="4">
            <div style="margin-top: 10px">
              <span class="head-span">待审核任务列表:</span>
            </div>
          </el-col>
          <el-col :span="24" v-for="item in detailForm.missionlist">
            <el-row>
              <el-checkbox-group v-model="checkList">
                <el-checkbox label=""></el-checkbox>
              </el-checkbox-group>
              <el-col :span="4">
                <el-form-item label="任务状态" prop="taskState">
                  <el-input v-model="detailForm.taskState"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="4">
                <el-form-item label="任务" prop="taskName">
                  <el-input v-model="detailForm.taskName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="4">
                <el-form-item label="内容" prop="content">
                  <el-input v-model="detailForm.content"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="4">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="4">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row v-if="showCurrent">
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">选择审核流程:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="" prop="people">
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
      <el-button>审核流程管理</el-button>
      <el-button>点击进行审核</el-button>
      <el-button>取消</el-button>
    </div>
  </page-main-body>
</template>

<script>
  export default {
    name: "auditing",
    data() {
      return {
        checkList: ['抽检完成'],
        title: '审核',
        showCurrent: true,
        detailForm: {
          modelName:'',
          sampleName:'',
          count:'',
          phone:'',
          company:'',
          missionlist:[{
            taskName:'',
            actionBy: '',
            content:'',
            department:'',
            taskState:''
          }
          ]
        },
        detailRules: {},
        peopleOptions: [
          {label: '审核流程1', value: '审核流程1'},
          {label: '审核流程2', value: '审核流程2'},
          {label: '审核流程3', value: '审核流程3'}
        ]
      };
    }
  }
</script>


<style scoped>

</style>
