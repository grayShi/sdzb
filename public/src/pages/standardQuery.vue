<template>
<page-main-body title="标准查询">
  <el-row>
    <el-row>
  <el-form :model="detailForm" ref="ruleForm" label-width="120px" style="margin-top: 20px">
    <el-col span="8">
      <el-form-item label="请选择专业类别" >
      <el-select v-model="detailForm.major" >
        <el-option
          v-for="item in majorOptions"
        :key="item.value"
        :label="item.label"
        :value="item.value">
        </el-option>
      </el-select>
      </el-form-item>
    </el-col>
    <el-col span="8">
    <el-form-item label="标准号">
      <el-input v-model="detailForm.number"></el-input>
    </el-form-item>
  </el-col>
    <el-col span="8">
      <el-form-item label="标准名称">
        <el-input v-model="detailForm.name"></el-input>
      </el-form-item>
    </el-col>
  </el-form>
    </el-row>
  <light-table :data="searchData" :columns="columns" :needIndex="true">
    <template slot="edit" slot-scope="props">
      <el-button size="mini" type="primary" @click="viewStandardDetail(props.prop.id, 'edit')">编辑</el-button>
      <el-button size="mini" type="danger" @click="viewStandardDetail(props.prop.id, 'delete')">删除</el-button>
    </template>
  </light-table>
    <el-dialog
      :title="dialogForm.title"
      :visible.sync="showDialog"
      width="50%"
      @close="dialogClose"
      center>
      <el-form :model="dialogForm" ref="dialogForm" label-width="100px">
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
            <el-form-item label="标准状态" prop="status" >
              <el-select v-model="dialogForm.status" clearable :disabled="dialogForm.isDelete">
                <el-option v-for="item in statusOptions"
                           :key="item.value"
                           :value="item.value"
                           :label="item.label"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="部门" prop="department" >
                <el-select v-model="dialogForm.department" clearable :disabled="dialogForm.isDelete">
                  <el-option v-for="item in departmentOptions"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value"></el-option>
                </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" v-if="!dialogForm.isDelete" @click="showDialog=false">保存</el-button>
          <el-button  type="danger" v-if="dialogForm.isDelete" @click="showDialog=false">删除</el-button>
          <el-button  @click="showDialog=false">取消</el-button>
        </span>
    </el-dialog>
  </el-row>
</page-main-body>
</template>

<script>
export default {
  name: 'standardQuery',
  data () {
    return {
      detailForm: {
        number: '',
        major: '',
        name: ''
      },
      majorOptions: [
        {label: '机械1', value: '机械1'},
        {label: '机械2', value: '机械2'}
      ],
      searchData: [
        {
          standard_id: 'JG/400',
          standard_name: '减速机',
          status: '启用',
          department: 'ours'
        },
        {
          standard_id: '020',
          standard_name: 'xi7x',
          status: 'fine',
          department: 'hers'
        }
      ],
      columns: [
        {
          prop: 'standard_id',
          label: '标准号'
        },
        {
          prop: 'standard_name',
          label: '标准名称'
        },
        {
          prop: 'status',
          label: '标准状态'
        },
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'edit',
          label: '编辑',
          type: {
            operate: true
          }
        }
      ],
      dialogForm: {
        title: '编辑标准',
        number: '',
        name: '',
        status: '',
        department: '',
        isDelete: false
      },
      showDialog: false,
      statusOptions: [
        {
          label: '启用',
          prop: 'used'
        },
        {
          label: '禁用',
          prop: 'unused'
        }
      ],
      departmentOptions: [
        {
          label: '机械一室',
          prop: 'machineOne'
        }
      ]
    };
  },
  methods: {
    viewStandardDetail (id, action) {
      this.dialogForm = {
        title: '编辑标准',
        number: 'JG/400',
        name: '减速机',
        status: '启用',
        department: 'ours'
      };
      if (action === 'delete') {
        this.dialogForm.title = '删除标准';
        this.dialogForm.isDelete = true;
      };
      this.showDialog = true;
    },
    dialogClose () {
      this.dialogForm = {
        title: '编辑标准',
        number: '',
        name: '',
        status: '',
        department: '',
        isDelete: false
      };
    }
  }
};
</script>

<style scoped>

</style>
