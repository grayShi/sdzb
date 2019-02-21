<template>
  <page-main-body title="部门维护" :loading="loading">

    <div style="width: 90%">
      <light-table :data="tableData" @on-search="searchTable" :columns="columnDesc" :addable="true" @on-add="addNewDepartment" style="width: 100%"  need-index="true">
        <template slot="edit" slot-scope="props">
          <el-button size="mini" @click="viewDepartmentDetail(props.prop.id, 'edit')">编辑</el-button>
          <el-button size="mini" type="danger" @click="viewDepartmentDetail(props.prop.id, 'delete')">删除</el-button>
        </template>
      </light-table>
      <el-dialog
        :title="dialogForm.title"
        :visible.sync="showDialog"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogClose"
        center>
        <el-form :model="dialogForm" :rules="dialogRules" ref="dialogForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="部门名称" prop="departName">
                <el-input v-model="dialogForm.departName" :disabled="dialogForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="部门简称" prop="departShort">
                <el-input v-model="dialogForm.departShort" :disabled="dialogForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="检验单位" prop="validator">
                <el-select v-model="dialogForm.validator" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in validatorList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="日期" prop="year">
                <el-date-picker
                  v-model="dialogForm.year"
                  type="year"
                  :disabled="dialogForm.isDelete"
                  :placeholder="$placeholder.selectYear">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="状态" prop="status">
                <el-select v-model="dialogForm.status" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in statusList"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialog = false">取消</el-button>
          <el-button v-if="!dialogForm.isDelete" type="primary" @click="saveDepartment">保存</el-button>
          <el-button v-if="dialogForm.isDelete" type="danger" @click="delDepartment">删除</el-button>
        </span>
      </el-dialog>
    </div>

  </page-main-body>
</template>

<script>
import axios from 'axios';
const searchDepartment = (condition) => axios.post('', condition);
const addDepartment = (name) => axios.post('/api/hello', name);
const getDepartmentById = (id) => axios.post('', id);
const modifyDepartment = (departmentForm) => axios.post('', departmentForm);
const deleteDepartment = (id) => axios.post('', id);
const getInspectDepartment = () => axios.post('');//检验单位维护

export default {
  name: 'Department',
  data () {
    return {
      loading: false,
      columnDesc: [
        // {
        //   prop: 'seq',
        //   label: '序号'
        // },
        {
          prop: 'departName',
          label: '部门名称'
        },
        {
          prop: 'departShort',
          label: '部门简称'
        },
        {
          prop: 'validator',
          label: '检验单位'
        },
        {
          prop: 'year',
          label: '日期'
        },
        {
          prop: 'status',
          label: '状态'
        },
        {
          prop: 'edit',
          label: '编辑',
          type: {
            operate: true
          }

        }
      ],
      tableData: [
        {
          id: 1,
          // seq: 1,
          departName: '化工一室',
          departShort: 'HG',
          validator: '淄博市产品质量监督检验所',
          year: '2013',
          status: '启用'
        }
      ],
      dialogForm: {
        id: '',
        title: '添加部门',
        isDelete: false,
        departName: '',
        departShort: '',
        validator: '',
        year: '',
        status: ''
      },
      showDialog: false,
      dialogRules: {//必填，是否合法
         //departName: [this.requiredInput('部门名称')],
      },
      validatorList: [
        {
          label: '淄博市产品质量监督检验所',
          value: '淄博市产品质量监督检验所'
        },
        {
          label: '山东省陶瓷产品质量检验中心',
          value: '山东省陶瓷产品质量检验中心'
        }
      ],
      statusList: [
        {
          label: '启用',
          value: '启用'
        },
        {
          label: '禁用',
          value: '禁用'
        }
      ]
    };
  },
  mounted () {
    getInspectDepartment().then(data => {
      if (data.data.code === '000') {
        this.showDialog = false;
      }
    });
  },
  methods: {
    onSubmit: function () {
      alert('submit!');
    },
    onQuery: function () {
      alert('query!');
    },
    searchTable (condition) {
      this.loading = true;
      searchDepartment({condition}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          // todo
        } else {
          this.onAlertError('搜索失败');
        }
      });
    },
    viewDepartmentDetail (id, action) {
      this.loading = true;
      getDepartmentById({id}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          // todo
          this.dialogForm = {
            id: 1, //如果是后台写的就是id:data.data.id,这里是假数据
            title: '修改部门',
            departName: '化工一室',
            departShort: 'HG',
            validator: '淄博市产品质量监督检验所',
            year: '2013',
            status: '启用'
          };
          if (action === 'delete') {
            this.dialogForm.isDelete = true;
            this.dialogForm.title = '删除部门';
          }
          this.showDialog = true;
        } else {
          this.onAlertError('搜索失败');
        }
      });
    },
    addNewDepartment () {
      this.showDialog = true;
    },
    dialogClose () {
      this.dialogForm = {
        id: '',
        title: '添加部门',
        isDelete: false,
        departName: '',
        departShort: '',
        validator: '',
        year: '',
        status: ''
      };
    },
    saveDepartment () {
      this.$refs.dialogForm.validate((valid) => {//表单验证，必填字段是否填好
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            modifyDepartment({departmentForm: this.dialogForm}).then(data => {//更改
              if (data.data.code === '000') {
                this.showDialog = false;
              }
            });
          } else {
            addDepartment({name: this.dialogForm}).then(data => {
              this.loading = false;
              if (data.data.code === '000') {
                this.showDialog = false;
                this.onAlertSuccess('保存成功');
              } else {
                this.onAlertError('保存失败');
              }
            });
          }
        } else {
          this.onAlertError('请确认输入');
        }
      });
    },
    delDepartment () {
      this.loading = true;
      deleteDepartment({id: this.dialogForm.id}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          this.showDialog = false;
        }
      });
    }
  }
};
</script>

<style scoped>
</style>
