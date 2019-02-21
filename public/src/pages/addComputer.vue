<template>
  <page-main-body :title="title">
    <div style="width: 50%">
      <el-form :model="computerForm" ref="computerForm" label-width="100px">
        <el-row>
          <el-form-item label="计算机品牌" prop="computerBrand">
            <el-input v-model="computerForm.computerBrand" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="年号" prop="useYear">
            <el-date-picker
              v-model="computerForm.useYear"
              type="year"
              :placeholder="$placeholder.selectYear">
            </el-date-picker>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="部门" prop="department">
            <el-select v-model="computerForm.department" clearable :placeholder="$placeholder.select">
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
          <el-form-item label="保管人" prop="computerOwner">
            <el-input v-model="computerForm.computerOwner" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="IP地址" prop="IPAddress">
            <el-input v-model="computerForm.IPAddress" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="MAC地址" prop="MACAddress">
            <el-input v-model="computerForm.MACAddress" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="显示器显示" prop="showMessage">
            <el-input v-model="computerForm.showMessage" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="类别" prop="category">
            <el-input v-model="computerForm.category" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="房间号" prop="roomNo">
            <el-input v-model="computerForm.roomNo" :placeholder="$placeholder.input"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="配置" prop="config">
            <el-input type="textarea" :autosize="$textareaAutosize" v-model="computerForm.config" :placeholder="$placeholder.inputTextarea"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="用途" prop="purpose">
            <el-select v-model="computerForm.purpose" clearable :placeholder="$placeholder.select">
              <el-option
                v-for="item in purposeList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="配套仪器" prop="linkDevice">
            <el-input type="textarea" :autosize="$textareaAutosize" v-model="computerForm.linkDevice" :placeholder="$placeholder.inputTextarea"></el-input>
          </el-form-item>
        </el-row>
        <el-row>
          <el-form-item label="其他说明" prop="remark">
            <el-input type="textarea" :autosize="$textareaAutosize" v-model="computerForm.remark" :placeholder="$placeholder.inputTextarea"></el-input>
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
export default {
  name: 'addComputer',
  data () {
    return {
      title: '计算机信息维护',
      computerForm: {
        computerBrand: '',
        useYear: '',
        department: '',
        computerOwner: '',
        IPAddress: '',
        MACAddress: '',
        showMessage: '',
        category: '',
        roomNo: '',
        config: '',
        purpose: '',
        linkDevice: '',
        remark: ''
      },
      departmentList: [
        { value: '化工一室', label: '化工一室'},
        { value: '化工二室', label: '化工二室'}
      ],
      purposeList: [
        { value: 'work', label: '办公' },
        { value: 'check', label: '检验' },
        { value: 'inbound', label: '入库' }
      ]
    };
  }
};
</script>

<style scoped>

</style>
