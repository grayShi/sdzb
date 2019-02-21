<template>
  <page-main-body :title="title">
    <div style="width: 90%">
      <el-row>
        <el-col :span="24">
          <light-table :data="searchData" :columns="columns" :addable="true" @on-add="addType" style="width: 100%">
            <template slot="operation" slot-scope="props">
              <el-button size="mini" @click="viewTypeDetail(props.prop.id,'edit')">编辑</el-button>
              <el-button size="mini" type="danger" @click="viewTypeDetail(props.prop.id,'delete')">删除</el-button>
            </template>
          </light-table>
        </el-col>
      </el-row>
      <el-dialog
        :title="dialogTypeForm.title"
        :visible.sync="showDialogType"
        width="50%"
        :close-on-click-modal="false"
        @close="dialogTypeClose"
        center>
        <el-form :model="dialogTypeForm" :rules="dialogTypeRules" ref="dialogTypeForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="检验单位名称" prop="unitName">
                <el-input v-model="dialogTypeForm.unitName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="标志名称" prop="symbolName">
                <el-input v-model="dialogTypeForm.symbolName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="标志编号" prop="number">
                <el-input v-model="dialogTypeForm.number" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有效使用日期起" prop="dateStart">
                <el-date-picker
                  v-model="dialogTypeForm.dateStart"
                  type="datetime"
                  :disabled="dialogTypeForm.isDelete"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="有效使用日期止" prop="dateEnd">
                <el-date-picker
                  v-model="dialogTypeForm.dateEnd"
                  type="datetime"
                  :disabled="dialogTypeForm.isDelete"
                  :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd" format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="showDialogType = false">取消</el-button>
          <el-button v-if="!dialogTypeForm.isDelete" type="primary" @click="showDialogType = false">保存</el-button>
          <el-button v-if="dialogTypeForm.isDelete" type="danger" @click="showDialogType = false">删除</el-button>
        </span>
      </el-dialog>
    </div>
  </page-main-body>
</template>

<script>
  export default {
    name: "inspectUnitSymbol",
    data () {
      return {
        title: '检验单位标志维护',
        columns: [
          {
            prop: 'unitName',
            label: '检验单位名称'
          },
          {
            prop: 'symbolName',
            label: '标志名称'
          },
          {
            prop:'number',
            label:'标志编号'
          },
          {
            prop:'dateStart',
            label:'有效使用日期起'
          },
          {
            prop:'dateEnd',
            label:'有效使用日期止'
          },
          {
            prop: 'operation',
            label: '操作',
            type: {
              operate: true
            }
          }
        ],
        searchData:[
          {
            id:1,
            unitName: '淄博市产品质量监督检验所',
            symbolName:'CMAF',
            number:'F2012150025',
            dateStart: '2011-01-01',
            dateEnd:'2015-04-26'
          }
        ],
        dialogTypeForm:{
          title:"添加检验单位标志",
          isDelete: false,
          unitName:'',
          symbolName:'',
          number:'',
          dateStart: '',
          dateEnd:''
        },
        showDialogType: false,
        dialogTypeRules: {

        },
      };
    },
    methods:{
      viewTypeDetail(id, action) {
        this.dialogTypeForm = {
          title: '修改检验单位标志',
          unitName: '淄博市产品质量监督检验所',
          symbolName:'CMAF',
          number:'F2012150025',
          dateStart: '2011-01-01',
          dateEnd:'2015-04-26'
        };
        if (action === 'delete') {
          this.dialogTypeForm.isDelete = true;
          this.dialogTypeForm.title = '删除检验单位标志';
        }
        this.showDialogType = true;
      },
      addType() {
        this.showDialogType = true;
      },
      dialogTypeClose() {
        this.dialogTypeForm = {
          title: '添加检验单位标志',
          isDelete: false,
          unitName:'',
          symbolName:'',
          number:'',
          dateStart: '',
          dateEnd:''
        };
      }
    }
  }
</script>

<style scoped>

</style>
