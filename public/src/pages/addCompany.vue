<template>
  <page-main-body :title="title">
    <div style="width: 50%">
      <el-form :model="companyForm" ref="companyForm" label-width="100px">
        <el-row>
          <el-form-item label="企业名称" prop="enterpriseName">
            <el-input v-model="companyForm.enterpriseName" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="企业代码" prop="enterpriseCode">
            <el-input v-model="companyForm.enterpriseCode" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="产品代码" prop="productNo">
            <el-input v-model="companyForm.productNo" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="产品名称" prop="productName">
            <el-input v-model="companyForm.productName" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="执行标准" prop="runRules">
            <el-input v-model="companyForm.runRules" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="企业地址" prop="enterpriseAddress">
            <el-input v-model="companyForm.enterpriseAddress" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="频次" prop="rate">
            <el-input v-model="companyForm.rate" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="科室" prop="room">
            <el-select v-model="companyForm.room" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in roomList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="区县" prop="county">
            <el-input v-model="companyForm.county" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="是否定检" prop="onTimeCheck">
            <el-select v-model="companyForm.onTimeCheck" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in onTimeCheckList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="联系人" prop="linkedUser">
            <el-input v-model="companyForm.linkedUser" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="companyForm.phone" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="邮编" prop="postcode">
            <el-input v-model="companyForm.postcode" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="年号" prop="useYear">
            <el-date-picker
              v-model="companyForm.useYear"
              type="year"
              :placeholder="$placeholder.selectYear">
            </el-date-picker>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="储蓄金" prop="savings">
            <el-input v-model="companyForm.savings" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="折扣" prop="discount">
           <el-input v-model="companyForm.discount" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
      </el-form>
    </div>
    <div slot="footer">
      <el-button type="primary" @click="saveTemplate">添加</el-button>
    </div>
  </page-main-body>
</template>

<script>

import axios from 'axios';
const addNewCompany = (companyForm) => axios.post('/api/enterprises', companyForm);
const getCompanyById = (id) => axios.get(`/api/enterprises/${id}`);

export default {
  name: 'addCompany',
  data () {
    return {
      title: '企业信息添加',
      companyForm: {
        enterpriseName: '',
        enterpriseCode: '',
        productNo: '',
        productName: '',
        runRules: '',
        enterpriseAddress: '',
        rate: '',
        room: '',
        county: '',
        onTimeCheck: '',
        linkedUser: '',
        phone: '',
        postcode: '',
        useYear: '',
        savings: '',
        discount: ''
      },
      roomList: [
        {value: '化工一室', label: '化工一室'},
        {value: '化工二室', label: '化工二室'}
      ],
      onTimeCheckList: [
        {value: 'true', label: '是'},
        {value: 'false', label: '否'}
      ]
    };
  },
  mounted () {
    if (this.$route.query.id) {
      this.loadSample(this.$route.query.id);
    }
  },
  methods: {
    loadSample (id) {
      getCompanyById(id).then(data => {
        if (data.data.code === '000') {
          this.companyForm = data.data.datas[0];
        }
      });
    },
    saveTemplate () {
      this.$refs.companyForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          addNewCompany(this.companyForm).then(data => {
            this.loading = false;
            if (data.data.code === '000') {
              // this.$refs.sampleForm.resetFields();
              this.onAlertSuccess('保存成功');
              // if (this.$route.query.id) {
              //   this.loadSample(data.data.datas[0].id);
              // } else {
              // }
              this.$router.push(`/addCompany?id=${data.data.datas[0].id}`);
            } else {
              this.onAlertError('保存失败');
            }
          }).catch(err => {
            this.loading = false;
            console.log(err);
            this.onAlertError('保存失败');
          });
        } else {
          this.onAlertError('请确认输入');
        }
      });
    }
  }
};
</script>

<style scoped>

</style>
