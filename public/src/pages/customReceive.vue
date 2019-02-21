<template>
    <page-main-body title="顾客领取">
      <light-table  :columns="columns"
                    style="width: 100%"
                    :need-index="true"
                    :remote="true" :remoteMethod="doQuery">
        <template slot="edit" slot-scope="props">
          <el-button size="mini" type="primary" @click="customerReceive(props.prop)">顾客领取</el-button>
          <el-button size="mini" type="danger" style='margin-left: auto' @click="viewList(props.prop)">领取记录</el-button>
        </template>
      </light-table>
      <el-dialog :visible.sync="showDialog"
                 center
                 width="50%"
                 :title="dialogForm.title">
        <el-form ref="dialogForm" :model="dialogForm" label-width="100px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="样品单号" prop="sampleNo">
                <el-input v-model="dialogForm.sampleNo" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="样品名称" prop="sampleName">
                <el-input v-model="dialogForm.sampleName" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="报告编号" prop="reportNo">
                <el-input v-model="dialogForm.reportNo" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="封条编号" prop="sealNumber">
                <el-input v-model="dialogForm.sealNumber" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="检验数量" prop="inspectionQuantity">
                <el-input v-model="dialogForm.inspectionQuantity" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="备样数量" prop="sampleQuantity">
                <el-input v-model="dialogForm.sampleQuantity" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="受检单位" prop="company">
                <el-input v-model="dialogForm.company" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="样品状态" prop="status">
                <el-input v-model="dialogForm.status" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="登记日期" prop="registerDate">
                <el-input v-model="dialogForm.registerDate" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="备注" prop="remark">
                <el-input v-model="dialogForm.remark" :disabled="!dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="企业领样时间" prop="opDate">
                <el-input v-model="dialogForm.opDate" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="企业领样人" prop="opUser">
                <el-input v-model="dialogForm.opUser" :disabled="dialogForm.isDelete"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer">
        <el-button type="primary" v-if="!dialogForm.isDelete"  @click="onSubmit">保存</el-button>
        <el-button type="danger" v-if="dialogForm.isDelete"  @click="showDialog=false">删除</el-button>
        <el-button @click="showDialog=false">取消</el-button>
      </span>
      </el-dialog>
      <el-dialog
        title="领取记录"
        :visible.sync="showRecordDialog"
        width="50%"
        center>
        <light-table ref="recordTable"
                     :columns="dialogColumns"
                     :remote="true"
                     :remoteMethod="dialogQuery">
        </light-table>
      </el-dialog>
    </page-main-body>
</template>

<script>
  import axios from 'axios';

  const searchSampleList = (condition) => axios.get('/api/sample_product', {params : condition})
  const getSampleDataList = (id,condition) => axios.post(`/api/sample_product/${id}/operate`,condition);
  const getRecordDataList=(productId,type) => axios.get(`api/sample_product/${productId}/${type}/list`);

export default {
  name: 'customReceive',
  data () {
    return {
      dialogColumns:[
        {
          prop: 'opDate',
          label: '企业领样时间'
        },
        {
          prop: 'opUser',
          label: '企业领样人'
        }
      ],
      columns: [
        {
          prop: 'sampleNo',
          label: '样品单号'
        },
        {
          prop: 'sampleName',
          label: '样品名称'
        },
        {
          prop: 'reportNo',
          label: '报告编号'
        },
        {
          prop: 'sealNumber',
          label: '封条编号'
        },
        {
          prop: 'inspectionQuantity',
          label: '检验数量'
        },
        {
          prop: 'sampleQuantity',
          label: '备样数量'
        },
        {
          prop: 'sampleStatus',
          label: '样品状态'
        },
        {
          prop: 'company',
          label: '受检单位'
        },
        {
          prop: 'registerDate',
          label: '登记日期'
        },
        {
          prop: 'remark',
          label: '备注'
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
      showRecordDialog: false,
      type:'take',
      id:'',
      productId:'',
      dialogForm: {
        isDelete: false,
        title: '样品入库',
        sampleNo:'',
        sampleName:'',
        reportNo:'',
        sealNumber:'',
        inspectionQuantity:'',
        sampleQuantity: '',
        status: '',
        company: '',
        registerDate:'',
        opUser:'',
        opDate:'',
        remark:''
      }
    };
  },
  methods: {
    doQuery (searchCondition, page, size, order) {
      this.loading = true;
      return searchSampleList({ searchCondition, page, size }).then(data => {
        this.loading = false;
        if (data.data.code === '000') {
          return this.formatGetTableData(data.data.datas);
        } else {
          this.onAlertError('查询失败');
          return [];
        }
      });
    },
    customerReceive(prop){
      this.id = prop.id;
      this.showDialog = true;
      this.dialogForm = prop;
      this.dialogForm.inStorePlace='';
      this.dialogForm.inStoreCount='';
      this.dialogForm.title = '顾客领取';
    },
    viewList(prop){
      this.loading = true;
      this.productId = prop.productId;
      this.showRecordDialog = true;
      this.$nextTick(() => {
        this.$refs.recordTable.doRemoteMethod();
      });
    },
    onSubmit(){
      this.showDialog = true;
      getSampleDataList(this.id, {opDate:this.dialogForm.opDate, opPlace:this.dialogForm.opPlace,opCount:this.dialogForm.opCount, opType:"take",opUser:this.dialogForm.opUser}).then(result =>{
        this.loading = false;
        if(result.data.code === '000') {
          this.onAlertSuccess('提交成功');
          this.$refs.table.doRemoteMethod();
          this.showDialog = false;
        }else{
          this.onAlertError('查询失败');
          return [];
        }
      })
    },
    dialogQuery(){
      this.loading = true;
      return getRecordDataList(this.productId,this.type).then(data =>{
        this.loading = false;
        if(data.data.code === '000'){
          return this.$refs.recordTable.formatGetTableData(data.data.datas);
        }else{
          this.onAlertError('TAT');
          return [];
        }
      })
    }
  }
};
</script>

<style scoped>

</style>
