<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="viewForm" ref="viewForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">当前任务状态:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item>
                  <el-tag type="info">未领取样品</el-tag>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">部门信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="viewForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="viewForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="联系方式" prop="phone">
                  <el-input v-model="viewForm.phone"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">预计领取时间:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建时间" prop="createdAt">
                  <el-date-picker
                    v-model="viewForm.createdAt"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="16">
                <el-form-item class="remind-message rcv-mark">
                  默认15天内完成领取，逾时取消任务
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
  name: 'viewReceiving',
  data () {
    return {
      title: '查看领取进度-未领取样品',
      viewForm: {
        department: '',
        actionBy: '',
        phone: '',
        createdAt: ''
      }
    };
  }
};
</script>

<style scoped>

</style>
