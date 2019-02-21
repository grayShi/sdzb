<template>
  <page-main-body :title="title">
    <div style="width: 50%">
      <el-form :model="standardForm" ref="standardForm" label-width="100px">
        <el-row>
          <el-form-item label="标准号" prop="standardNo">
            <el-input v-model="standardForm.standardNo" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="标准名称" prop="standardName">
            <el-input v-model="standardForm.standardName" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="状态" prop="standardStatus">
            <el-select v-model="standardForm.standardStatus" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in standardStatusList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="年号" prop="useYear">
            <el-date-picker
              v-model="standardForm.useYear"
              type="year"
              :placeholder="$placeholder.selectYear">
            </el-date-picker>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="部门" prop="department">
            <el-select v-model="standardForm.department" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in departmentList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="专业类别" prop="standardType">
            <el-select v-model="standardForm.standardType" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in standardTypeList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary">添加</el-button>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'addStandard',
  data () {
    return {
      title: '检验标准添加',
      standardForm: {
        standardNo: '',
        standardName: '',
        standardStatus: '',
        useYear: '',
        department: '',
        standardType: ''
      },
      standardStatusList: [
        { value: 'inUse', label: '使用' },
        { value: 'notInUse', label: '废弃' }
      ],
      departmentList: [],
      standardTypeList: []
    };
  }
};
</script>

<style scoped>

</style>
