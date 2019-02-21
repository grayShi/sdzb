<template>
    <page-main-body title="计算机查询">
      <el-row style="width: 90%">
        <el-button type="primary" @click="dialogTableVisible = true">查询修改历史</el-button>
      <light-table :data="searchData" :columns="columns" style="width: 100%" :need-index="true">
        <template slot="edit" slot-scope="props">
          <el-button size="mini" type="primary" @click="viewComputerDetail(props.prop.id,'edit')">编辑</el-button>
          <el-button size="mini" type="danger" style="margin-top: 10px" @click="viewComputerDetail(props.prop.id,'delete')">删除</el-button>
        </template>
      </light-table>
        <el-dialog title="计算机查询历史" :visible.sync="dialogTableVisible">
          <light-table :data="searchData1" :columns="columns1" style="width: 100%" :need-index="true">
          </light-table>
        </el-dialog>
        <el-dialog
          :title="dialogForm.title"
          center
          @close="closeDialog"
          width="50%"
          :visible.sync="showDialog">
        <el-form :model="dialogForm" ref="dialogForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="计算机品牌" prop="brand">
                <el-input v-model="dialogForm.brand" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="年号" prop="year">
                <el-select v-model="dialogForm.year" :disabled="dialogForm.isDelete">
                  <el-option v-for="item in yearOptions"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="部门" prop="department">
                <el-select v-model="dialogForm.department" :disabled="dialogForm.isDelete">
                  <el-option v-for="item in departmentOptions"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="保管人" prop="people">
                <el-input v-model="dialogForm.people" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="IP地址" prop="id">
                <el-input v-model="dialogForm.ip" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="MAC地址" prop="mac">
                <el-input v-model="dialogForm.mac" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="显示器显示" prop="show">
                <el-input v-model="dialogForm.show" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="类别" prop="category">
                <el-input v-model="dialogForm.category" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="房间号" prop="room">
                <el-input v-model="dialogForm.room" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="配置" prop="category">
                <el-input v-model="dialogForm.category" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="用途" prop="usage">
                <el-select v-model="dialogForm.usage" :disabled="dialogForm.isDelete">
                  <el-option v-for="item in usageOptions"
                             :key="item.value"
                             :label="item.label"
                             :value="item.value"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="配套仪器" prop="tools">
                <el-input v-model="dialogForm.tools" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="其他说明" prop="others">
                <el-input v-model="dialogForm.others" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
          <span slot="footer">
            <el-button type="primary" v-if="!dialogForm.isDelete" @click="showDialog=false">保存</el-button>
            <el-button type="danger" v-if="dialogForm.isDelete" @click="showDialog=false">删除</el-button>
            <el-button @click="showDialog=false">取消</el-button>
          </span>
        </el-dialog>
      </el-row>
    </page-main-body>
</template>

<script>
export default {
  name: 'computerQuery',
  data () {
    return {
      viewHistory: false,
      dialogTableVisible: false,
      searchData: [
        {
          department: '计算机'
        },
        {
          department: 'mac'
        }
      ],
      searchData1: [
        {
          department: 'abc'
        }
      ],
      columns: [
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'people',
          label: '保管人'
        },
        {
          prop: 'ip',
          label: 'IP地址'
        },
        {
          prop: 'mac',
          label: 'MAC地址'
        },
        {
          prop: 'name',
          label: '计算机名称'
        },
        {
          prop: 'show',
          label: '显示器显示'
        },
        {
          prop: 'category',
          label: '类别'
        },
        {
          prop: 'room',
          label: '房间号'
        },
        {
          prop: 'configure',
          label: '配置'
        },
        {
          prop: 'use',
          label: '用途'
        },
        {
          prop: 'instrument',
          label: '配套仪器'
        },
        {
          prop: 'others',
          label: '其他说明'
        },
        {
          label: '操作',
          prop: 'edit',
          type: {
            operate: true
          }
        }
      ],
      columns1: [
        {
          prop: 'department',
          label: '部门'
        },
        {
          prop: 'people',
          label: '保管人'
        },
        {
          label: 'IP地址',
          prop: 'ip'
        },
        {
          label: 'MAC地址',
          prop: 'mac'
        },
        {
          label: '计算机品牌',
          prop: 'brand'
        },
        {
          label: '计算机型号',
          prop: 'model'
        },
        {
          label: '配置',
          prop: 'configure'
        },
        {
          label: '用途',
          prop: 'usage'
        },
        {
          label: '配套仪器',
          prop: 'instrument'
        },
        {
          label: '其他说明',
          prop: 'others'
        },
        {
          label: '修改日期',
          prop: 'date'
        },
        {
          label: '修改人',
          prop: 'people'
        }
      ],
      yearOptions: [
        {
          label: '2018',
          prop: '2018'
        },
        {
          label: '2019',
          prop: '2019'
        }
      ],
      departmentOptions: [
        {
          label: '所长',
          prop: 'manager'
        },
        {
          label: '化工一室',
          prop: 'chemicalOne'
        }
      ],
      usageOptions: [
        {
          label: '办公',
          prop: 'work'
        }
      ],
      showDialog: false,
      dialogForm: {
        title: '修改计算机信息',
        brand: '',
        department: '',
        people: '',
        ip: '',
        mac: '',
        name: '',
        show: '',
        category: '',
        room: '',
        configure: '',
        usage: '',
        tools: '',
        others: '',
        isDelete: false
      }
    };
  },
  methods: {
    viewComputerDetail (id, action) {
      this.showDialog = true;
      this.dialogForm = {
        title: '修改计算机信息',
        brand: '',
        department: '计算机',
        people: '',
        ip: '',
        mac: '',
        name: '',
        show: '',
        category: '',
        room: '',
        configure: '',
        usage: '',
        tools: '',
        others: ''
      };
      if (action === 'delete') {
        this.dialogForm.title = '删除计算机信息';
        this.dialogForm.isDelete = true;
      }
    },
    closeDialog () {
      this.dialogForm = {
        title: '修改计算机信息',
        brand: '',
        department: '',
        people: '',
        ip: '',
        mac: '',
        name: '',
        show: '',
        category: '',
        room: '',
        configure: '',
        usage: '',
        tools: '',
        others: '',
        isDelete: false
      };
    }
  }

};
</script>

<style scoped>

</style>
