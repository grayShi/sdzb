<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="detailForm"  ref="ruleForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span >基本信息:</span>
            </div>
          </el-col>
          <el-col :span="22">
            <el-row>
              <el-col :span="8">
                <el-form-item label="业务名称" >
                  <el-input v-model="detailForm.Name" disabled="disabled"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品" >
                  <el-input v-model="detailForm.Sample" disabled="disabled"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="(基本信息)">
                  <el-input v-model="detailForm.Message" disabled="disabled"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

          </el-col>
        </el-row>
       <!--<task-item></task-item>-->
        <el-row>
          <p>任务1：</p>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="部门选择" >
              <el-select v-model="detailForm.department" placeholder="选择负责部门">
                <el-option
                  v-for="item in departmentOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="负责人" >
              <el-select v-model="detailForm.people" placeholder="选择负责人">
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
        <el-row>
          <el-col :span="8">
            <el-form-item label="负责内容" >
              <el-select v-model="detailForm.conclude" placeholder="选择质检内容">
                <el-option
                  v-for="item in concludeOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="（其他信息）" >
             <el-input v-model="detailForm.others" ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
          <el-form-item label="截止日期">
            <el-date-picker
              v-model="detailForm.deadline"
              align="right" style="width: 100%"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </el-form-item>
          </el-col>
        </el-row>
        <el-row style="margin-left: 30px">
          <el-button type="primary" icon="el-icon-plus" @click="Add ++ ">添加任务</el-button>
        </el-row>、
      <el-row style="margin-top: 25px;margin-left: 25px">
        <el-button type="primary" style="width:110px;margin-right: 70px" >
          <span style="color: white">提交任务</span>
        </el-button>
        <el-button type="primary"   style="width:110px">
          <span style="color: white">取消</span>
        </el-button>
      </el-row>
      </el-form>
    </el-row>
  </page-main-body>
</template>

<script>
var taskitem = {
  template: '<span>item</span>'
};
export default {
  name: 'assignment',
  components: {
    'task-item': taskitem
  },
  data () {
    return {
      Add: false,
      list: {
        Add1: true
      },
      detailForm: {
        Name: '张三',
        Sample: '025',
        Message: 'hhh',
        department: '',
        people: '',
        conclude: '',
        others: '',
        deadline: ''
      },
      departmentOptions: [
        {label: '部门1', value: '部门1'},
        {label: '部门2', value: '部门2'},
        {label: '部门3', value: '部门3'}
      ],
      peopleOptions: [
        {label: '业务员1', value: '业务员1'},
        {label: '业务员2', value: '业务员2'},
        {label: '业务员3', value: '业务员3'}
      ],
      concludeOptions: [
        {label: '业务1', value: '业务1'},
        {label: '业务2', value: '业务2'},
        {label: '业务3', value: '业务3'}
      ]
    };
  },
  methods: {
    handle: function () {
      this.detailForm.business.push({
        department: '',
        people: '',
        conclude: '',
        others: '',
        deadline: ''
      });
      this.Add = true;
    }
  },
  computed: {
    title () {
      return this.Add ? '分配任务-添加任务' : '分配任务';
    }
  }
};
</script>

<style scoped>

</style>
