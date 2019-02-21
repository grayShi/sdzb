<template>
  <page-main-body title="检验标准维护" :loading="loading">
    <div style="width: 95%">
      <light-table :columns="columnDesc" :data="tableData"
                   @on-search="searchTable" :addable="true"
                   @on-add="addType" style="width: 100%"
                   :deleteable="true" @on-delete="goToDelete"
                   :rowSelect="true" @select-row="getSelectRow">
        <template slot="edit" slot-scope="props">
          <el-button size="mini" @click="viewStandard(props.prop.id,'edit')">编辑</el-button>
        </template>
      </light-table>
      <el-dialog :visible.sync="showDialog"
                 center
                 :title="dialogForm.title"
                 :close-on-click-modal="false"
                 width="50%"
                 @close="closeDialog">
        <el-form label-width="100px" ref="dialogForm" :model="dialogForm" :rules="dialogRules">
          <el-row>
            <el-col :span="12">
              <el-form-item label="标准号" prop="number">
                <el-input v-model="dialogForm.number" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="标准名称" prop="name">
                <el-input v-model="dialogForm.name" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="状态">
                <el-select  v-model="dialogForm.status" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in statusOptions"
                    :key="item.value"
                    :value="item.value"
                    :label="item.label">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="年号">
                <el-select  v-model="dialogForm.year" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in yearOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="部门">
                <el-select  v-model="dialogForm.depart" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in departmentOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="专业类别">
                <el-select  v-model="dialogForm.category" :disabled="dialogForm.isDelete" clearable :placeholder="$placeholder.select">
                  <el-option
                    v-for="item in majorOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialog = false">取消</el-button>
          <el-button v-if="!dialogForm.isDelete" type="primary" @click="saveStandard">保存</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
import axios from 'axios';
const searchStandard = (condition) => axios.post('/api/standard', condition);
const add_Standard = (standardForm) => axios.post('/api/standard', standardForm);
const getStandardById = (id) => axios.get('/api/standard', id);
const modifyStandard = (standardForm) => axios.post('/api/standard', standardForm);
const deleteStandard = (id) => axios.delete('/api/standard', id);

export default {
  name: 'StandardManage',
  data () {
    return {
      loading: false,
      statusOptions: [
        {label: '使用', value: 'use'},
        {label: '废弃', value: 'discard'}
      ],
      yearOptions: [
        {value: '2018', label: '2018'}
      ],
      departmentOptions: [
        {value: 'chemical1', label: '化工一室'}
      ],
      majorOptions: [
        {value: 'chemical', label: '化工'}
      ],
      columnDesc: [
        {
          prop: 'number',
          label: '标准号'

        },
        {
          prop: 'name',
          label: '标准名称'

        },
        {
          prop: 'status',
          label: '标准状态'

        },
        {
          prop: 'depart',
          label: '部门'

        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      selectRow: [],
      tableData: [
        {
          id: '1',
          number: '312',
          name: 'zz'
        }
      ],
      dialogForm: {
        isDelete: false,
        title: '添加检验标准',
        number: '',
        name: '',
        status: '',
        depart: '',
        year: '',
        category: ''
      },
      showDialog: false,
      dialogRules: {
        number: [this.requiredInput('标准号')],
        name: [this.requiredInput('标准名称')]
      },
    };
  },
  methods: {
    searchTable (condition) {
      this.loading = true;
      searchStandard({condition}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          // todo
        } else {
          this.onAlertError('搜索失败');
        }
      });
    },
    addType () {
      this.showDialog = true;
    },
    viewStandard (id, action) {
      this.loading = true;
      getStandardById({id}).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          // todo
          this.dialogForm = data.data.datas;
          /*this.dialogForm = {
            id: '1',
            number: '312',
            name: 'zz',
            status: '',
            depart: '',
            year: '',
            category: ''
          };*/
          this.showDialog = true;
        } else {
          this.onAlertError('搜索失败');
        }
      });
    },
    closeDialog () {
      this.dialogForm = {
        isDelete: false,
        title: '添加检验标准',
        number: '',
        name: '',
        status: '',
        depart: '',
        year: '',
        category: ''
      };
    },
    saveStandard () {
      this.$refs.dialogForm.validate((valid) => {//表单验证，必填字段是否填好
        if (valid) {
          this.loading = true;
          if (this.dialogForm.id) {
            modifyStandard({standardForm: this.dialogForm}).then(data => {//更改
              if (data.data.code === '000') {
                this.showDialog = false;
              }
            });
          } else {
            add_Standard({standardForm: this.dialogForm}).then(data => {
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
    goToDelete () {
      if (this.selectRow.length === 0) {
        this.onAlertError('选中数量为0条');
      } else {
        this.loading = true;
        deleteStandard({id: this.selectRow}).then(data => {
          this.loading = false;
          if (data.data.code === '000') {
            this.onAlertError('删除成功');
            this.$refs.table.doRemoteMethod();
          }
        });
      }
    },
    getSelectRow (val) {
      let id = [];
      _.each(val, item => {
        id.push(item.id);
      });
      this.selectRow = id;
    }
  }
};
</script>

<style scoped>
</style>
