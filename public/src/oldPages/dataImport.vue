<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="importForm" ref="importForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">抽检进度:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item>
                  <el-tag type="info">等待数据录入</el-tag>
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
          <el-col :span="22">
            <el-row>
              <el-col :span="6">
                <el-form-item label="任务内容" prop="missionDetail">
                  <el-input v-model="importForm.missionDetail"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="任务编号" prop="missionNo">
                  <el-input v-model="importForm.missionNo"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="负责部门" prop="department">
                  <el-input v-model="importForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="importForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-form>
      <el-form :model="importForm" ref="importForm" label-width="200px">
        <el-row>
          <el-card>
            <div slot="header">
              <span>数据录入</span>
            </div>
            <el-row>
              <el-col :span="8">
                <el-form-item label="选择标准库中原始记录表" prop="dataTable">
                  <el-select v-model="importForm.dataTable" placeholder="请选择">
                    <el-option
                      v-for="item in tableOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <div style="height: 200px;line-height: 200px;border: 1px solid black; text-align: center">
                业务端输入
              </div>
            </el-row>
          </el-card>
        </el-row>

      </el-form>
    </el-row>
  </page-main-body>
</template>

<script>
export default {
  name: 'dataImport',
  data () {
    return {
      title: '数据录入-正在抽检',
      importForm: {
        missionDetail: '',
        missionNo: '',
        department: '',
        actionBy: '',
        businessDetail: '',
        sampleName: '',
        sampleNo: '',
        dataTable: ''
      },
      tableOptions: [
        {
          value: '记录表1',
          label: '记录表1'
        },
        {
          value: '记录表2',
          label: '记录表2'
        }
      ]
    };
  }
};
</script>

<style scoped>

</style>
