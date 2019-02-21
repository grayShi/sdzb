<template>
  <page-main-body :title="title">
    <div style="width: 90%">
      <el-form :model="authorityForm" ref="authorityForm" label-width="200px">
        <el-row>
          <el-form-item label="年份" prop="userYear">
            <el-date-picker
              v-model="authorityForm.useYear"
              type="year"
              :placeholder="$placeholder.selectYear">
            </el-date-picker>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="请选择设置人员所在部门" prop="department">
            <el-select v-model="authorityForm.department" clearable :placeholder="$placeholder.select">
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
          <el-form-item label="请选择设置人员姓名" prop="userName">
            <el-select v-model="authorityForm.userName" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in userNameList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="设置部门权限" prop="departmentAuth">
            <el-row>
              <el-checkbox-group v-model="authorityForm.departmentAuth">
                <el-col :span="6" v-for="item in departmentAuthList" :key="item.label">
                  <el-checkbox :label="item.label" :disabled="item.disable"></el-checkbox>
                </el-col>
                <!--<el-checkbox style="margin-left: 30px" v-for="item in departmentAuthList" border :key="item.label" :label="item.label" :disabled="item.disable"></el-checkbox>-->
              </el-checkbox-group>
            </el-row>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="设置模块权限" prop="moduleAuth">
            <el-row v-for="module in moduleAuthList" :key="module.moduleName">
              <el-checkbox :indeterminate="module.isIndeterminate" v-model="module.checkAll" @change="handleCheckAllChange($event, module.moduleName)">{{module.moduleName}}</el-checkbox>
              <el-checkbox-group v-model="authorityForm.moduleAuth" @change="handleCheckedCitiesChange($event, module.moduleName)">
                <el-col :span="6" v-for="item in module.authority" :key="item.label">
                  <el-checkbox :label="item.label" :disabled="item.disable"></el-checkbox>
                </el-col>
              </el-checkbox-group>
            </el-row>
          </el-form-item>
        </el-row>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary">保存</el-button>
    </div>
  </page-main-body>
</template>

<script>
import _ from 'lodash';

export default {
  name: 'setAuthority',
  data () {
    return {
      title: '设置权限',
      departmentList: [
        { value: '化工一室', label: '化工一室' },
        { value: '化工二室', label: '化工二室' }
      ],
      userNameList: [
        { value: 'wanglian', label: '王练' },
        { value: 'admin', label: '管理员' }
      ],
      authorityForm: {
        useYear: '',
        department: '',
        userName: '',
        departmentAuth: ['化工一室', '综合业务管理室', '能源检验中心'],
        moduleAuth: ['样品登记', '退样登记', '定检完成率']
      },
      departmentAuthList: [
        { label: '化工一室', disable: false },
        { label: '化工二室', disable: false },
        { label: '机械一室', disable: false },
        { label: '机械二室', disable: false },
        { label: '轻工检验室', disable: false },
        { label: '所长', disable: false },
        { label: '综合业务管理室', disable: false },
        { label: '电器检验室', disable: false },
        { label: '能源检验中心', disable: false },
        { label: '水泵电机中心', disable: false }
      ],
      moduleAuthList: [
        {
          moduleName: '业务管理',
          isIndeterminate: true,
          checkAll: false,
          authority: [
            { label: '信息登记', disable: false },
            { label: '样品登记', disable: false },
            { label: '检验数据', disable: false },
            { label: '报告审核', disable: false },
            { label: '报告批准', disable: false },
            { label: '退样登记', disable: false },
            { label: '更改报告', disable: false }
          ]
        },
        {
          moduleName: '报告查询',
          isIndeterminate: true,
          checkAll: false,
          authority: [
            { label: '报告查询', disable: false },
            { label: '报告返工统计', disable: false },
            { label: '报告统计', disable: false },
            { label: '定检完成率', disable: false },
            { label: '拖期报告', disable: false },
            { label: '批准统计', disable: false },
            { label: '企业数统计', disable: false }
          ]
        }
      ]
    };
  },
  methods: {
    handleCheckAllChange (val, moduleName) {
      const findModule = _.find(this.moduleAuthList, item => item.moduleName === moduleName);
      const newAuth = _.cloneDeep(this.authorityForm.moduleAuth);
      if (findModule) {
        _.each(findModule.authority, item => {
          if (val) {
            if (!item.disable && this.authorityForm.moduleAuth.indexOf(item.label) < 0) {
              newAuth.push(item.label);
            }
          } else {
            if (!item.disable && this.authorityForm.moduleAuth.indexOf(item.label) >= 0) {
              _.remove(newAuth, au => au === item.label);
            }
          }
        });
        this.$set(this.authorityForm, 'moduleAuth', newAuth);
        findModule.isIndeterminate = false;
      }
    },
    handleCheckedCitiesChange (value, moduleName) {
      const findModule = _.find(this.moduleAuthList, item => item.moduleName === moduleName);
      const find = [];
      _.each(findModule.authority, auth => {
        if (value.indexOf(auth.label) >= 0) {
          find.push(auth.label);
        }
      });
      const checkedCount = find.length;
      findModule.checkAll = checkedCount === findModule.authority.length;
      findModule.isIndeterminate = checkedCount > 0 && checkedCount < findModule.authority.length;
    }
  }
};
</script>

<style scoped>

</style>
