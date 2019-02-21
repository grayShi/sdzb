<template>
    <page-main-body title="设备统计">
      <light-table :data="searchData" :columns="columns" style="width: 100%" :need-index="true">
        <template slot="edit" slot-scope="props">
          <el-button size="mini" type="primary" @click="viewDeviceDetail(props.prop.id,'edit')">编辑</el-button>
          <el-button size="mini" type="danger" @click="viewDeviceDetail(props.prop.id,'delete')">删除</el-button>
        </template>
      </light-table>
      <el-dialog
        :title="dialogForm.title"
        :visible.sync="showDialog"
        center
        width="50%"
        @close="closeDialog">
        <el-form ref="dialogForm" :model="dialogForm" label-width="120px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="所内编号" prop="number">
                <el-input v-model="dialogForm.number" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="仪器名称" prop="name">
                <el-input v-model="dialogForm.name" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="规格型号" prop="model">
                <el-input v-model="dialogForm.model" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="量程" prop="range">
                <el-input v-model="dialogForm.range" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="准确度" prop="accuracy">
                <el-input v-model="dialogForm.accuracy" :disabled="dialogForm.isDelete">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="分辨力" prop="resolution">
                <el-input v-model="dialogForm.resolution" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="制造单位" prop="company">
                <el-input v-model="dialogForm.company" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="出厂编号" prop="factoryNumber">
                <el-input v-model="dialogForm.factoryNumber" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="设备原值（元）" prop="money">
                <el-input v-model="dialogForm.money" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="购买日期" prop="date">
                <el-date-picker v-model="dialogForm.date" :placeholder="$placeholder.selectDate" :disabled="dialogForm.isDelete"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="校验周期（年）" prop="cycle">
                <el-input v-model="dialogForm.cycle" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="校验单位" prop="unit">
                <el-input v-model="dialogForm.unit" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="校验周期（年）" prop="cycle">
                <el-input v-model="dialogForm.cycle" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="校验单位" prop="unit">
                <el-input v-model="dialogForm.unit" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="送检日期" prop="inspectionDate">
                <el-input v-model="dialogForm.inspectionDate" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="定检费" prop="verificationFee">
                <el-input v-model="dialogForm.verificationFee" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="校验类型" prop="type">
                <el-input v-model="dialogForm.type" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="校验方式" prop="method">
                <el-input v-model="dialogForm.method" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="检验室" prop="room">
                <el-input v-model="dialogForm.room" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="存放地" prop="place">
                <el-input v-model="dialogForm.place" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="期间审查时间（月）" prop="checkTime">
                <el-input v-model="dialogForm.checkTime" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="维护周期" prop="maintainCycle">
                <el-input v-model="dialogForm.maintainCycle" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="检定/校准部件" prop="component">
                <el-input v-model="dialogForm.component" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="校准参数范围" prop="parameter">
                <el-input v-model="dialogForm.parameter" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="今年实际需核查" prop="thisYear">
                <el-input v-model="dialogForm.thisYear" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="问题" prop="question">
                <el-input v-model="dialogForm.question" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="2015" prop="year2015">
                <el-date-picker v-model="dialogForm.year2015" :disabled="dialogForm.isDelete" :placeholder="$placeholder.selectDate"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="2016" prop="year2016">
                <el-date-picker v-model="dialogForm.year2016" :disabled="dialogForm.isDelete" :placeholder="$placeholder.selectDate"></el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="2017" prop="year2017">
                <el-date-picker v-model="dialogForm.year2017" :disabled="dialogForm.isDelete" :placeholder="$placeholder.selectDate"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="2018" prop="year2018">
                <el-date-picker v-model="dialogForm.year2018" :disabled="dialogForm.isDelete" :placeholder="$placeholder.selectDate"></el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer">
          <el-button v-if="!dialogForm.isDelete" @click="showDialog=false" type="primary">保存</el-button>
          <el-button v-if="dialogForm.isDelete" @click="showDialog=false" type="danger">删除</el-button>
          <el-button @click="showDialog=false">取消</el-button>
        </span>
      </el-dialog>
    </page-main-body>
</template>

<script>
export default {
  name: 'deviceStatistics',
  data () {
    return {
      searchData: [
        {
          number: '123',
          name: 'sxx',
          model: 'qwe'
        }
      ],
      columns: [
        {
          prop: 'number',
          label: '所内编号'
        },
        {
          prop: 'name',
          label: '仪器名称'
        },
        {
          prop: 'model',
          label: '规格型号'
        },
        {
          prop: 'range',
          label: '量程'
        },
        {
          prop: 'accuracy',
          label: '准确度'
        },
        {
          prop: 'resolution',
          label: '分辨力'
        },
        {
          prop: 'company',
          label: '制造单位'
        },
        {
          prop: 'factoryNumber',
          label: '出厂编号'
        },
        {
          prop: 'money',
          label: '设备原值（元）'
        },
        {
          prop: 'date',
          label: '购买日期'
        },
        {
          prop: 'cycle',
          label: '校验周期（年）'
        },
        {
          prop: 'unit',
          label: '校验单位'
        },
        {
          prop: '2015',
          label: '2015'
        },
        {
          prop: '2016',
          label: '2016'
        },
        {
          prop: '2017',
          label: '2017'
        },
        {
          prop: '2018',
          label: '2018'
        },
        {
          prop: 'inspectionDate',
          label: '送检日期'
        },
        {
          prop: 'verificationFee',
          label: '检定费'
        },
        {
          prop: 'type',
          label: '校验类型'
        },
        {
          prop: 'method',
          label: '校验方式'
        },
        {
          prop: 'room',
          label: '检验室'
        },
        {
          prop: 'place',
          label: '存放地'
        },
        {
          prop: 'checkTime',
          label: '期间核查时间（月）'
        },
        {
          prop: 'maintainCycle',
          label: '维护周期（月）'
        },
        {
          prop: 'component',
          label: '检定/校准部件'
        },
        {
          prop: 'parameter',
          label: '校准参数范围'
        },
        {
          prop: 'thisYear',
          label: '今年实际需核查'
        },
        {
          prop: 'question',
          label: '问题'
        },
        {
          prop: 'edit',
          label: '操作',
          type: {
            operate: true
          }
        }
      ],
      showDialog: false,
      dialogForm: {
        title: '设备信息查看',
        number: '',
        name: '',
        model: '',
        range: '',
        accuracy: '',
        resolution: '',
        company: '',
        factoryNumber: '',
        money: '',
        date: '',
        cycle: '',
        unit: '',
        year2015: '',
        year2016: '',
        year2017: '',
        year2018: '',
        inspectionDate: '',
        verificationFee: '',
        type: '',
        method: '',
        room: '',
        place: '',
        checkTime: '',
        maintainCycle: '',
        component: '',
        parameter: '',
        thisYear: '',
        question: '',
        isDelete: false
      }
    };
  },
  methods: {
    viewDeviceDetail (id, action) {
      this.showDialog = true;
      this.dialogForm = {
        title: '设备信息查看',
        number: '123',
        name: 'sxx',
        model: 'qwe',
        range: '',
        accuracy: '',
        resolution: '',
        company: '',
        factoryNumber: '',
        money: '',
        date: '',
        cycle: '',
        unit: '',
        year2015: '',
        year2016: '',
        year2017: '',
        year2018: '',
        inspectionDate: '',
        verificationFee: '',
        type: '',
        method: '',
        room: '',
        place: '',
        checkTime: '',
        maintainCycle: '',
        component: '',
        parameter: '',
        thisYear: '',
        question: '',
        isDelete: false
      };
      if (action === 'delete') {
        this.dialogForm.isDelete = true;
        this.dialogForm.title = '删除设备信息';
      }
    },
    closeDialog () {
      this.dialogForm = {
        title: '设备信息查看',
        number: '',
        name: '',
        model: '',
        range: '',
        accuracy: '',
        resolution: '',
        company: '',
        factoryNumber: '',
        money: '',
        date: '',
        cycle: '',
        unit: '',
        year2015: '',
        year2016: '',
        year2017: '',
        year2018: '',
        inspectionDate: '',
        verificationFee: '',
        type: '',
        method: '',
        room: '',
        place: '',
        checkTime: '',
        maintainCycle: '',
        component: '',
        parameter: '',
        thisYear: '',
        question: '',
        isDelete: false
      };
    }
  }
};
</script>

<style scoped>

</style>
