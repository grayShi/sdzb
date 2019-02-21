<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="viewForm" ref="viewForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">抽检进度:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="6">
                <el-form-item>
                  <el-tag type="success">抽检已完成，等待审核</el-tag>
                </el-form-item>
              </el-col>
              <el-col :span="10">
                <el-form-item class="remind-message">
                  <div>预计完成时间：{{deadline}}</div>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">任务信息:</span>
            </div>
          </el-col>
          <el-col :span="22" v-for="item in viewForm.missionList">
            <el-row>
              <el-col :span="8">
                <el-form-item label="任务内容" prop="missionDetail">
                  <el-input v-model="item.missionDetail"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="任务编号" prop="missionNo">
                  <el-input v-model="item.missionNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责部门" prop="department">
                  <el-input v-model="item.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="item.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">业务信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务名称" prop="businessName">
                  <el-input v-model="viewForm.businessName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="业务编号" prop="businessNo">
                  <el-input v-model="viewForm.businessNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品名称" prop="simpleName">
                  <el-input v-model="viewForm.simpleName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品编号" prop="simpleNo">
                  <el-input v-model="viewForm.simpleNo"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
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
  name: 'viewProgress',
  data () {
    return {
      title: '查看审核进度',
      deadline: '2018-11-24',
      viewForm: {

        businessName: '',
        businessNo: '',
        simpleName: '',
        simpleNo: '',
        missionList: [
          {
            missionDetail: '',
            missionNo: '',
            department: '',
            actionBy: ''
          },
          {
            missionDetail: '',
            missionNo: '',
            department: '',
            actionBy: ''
          }
        ]
      }
    };
  }
};
</script>

<style scoped>

</style>
