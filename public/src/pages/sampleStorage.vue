<template>
  <page-main-body title="样品入库">
    <light-table ref="table"
                 :columns="columns" style="width: 100%"
                 :need-index="true"
                 :remote="true" :remoteMethod="doQuery">
      <template slot="edit" slot-scope="props">
        <el-button size="mini" type="primary" @click="sampleStorage(props.prop)">样品入库</el-button>
        <el-button size="mini" type="info" style='margin-left: auto' @click="viewList(props.prop)">入库记录</el-button>
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
            <el-form-item label="入库数量" prop="inStoreCount">
              <el-input v-model="dialogForm.inStoreCount" :disabled="dialogForm.isDelete"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="入库地点" prop="inStorePlace">
              <el-input v-model="dialogForm.inStorePlace" :disabled="dialogForm.isDelete"></el-input>
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
      title="入库记录"
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
  import _ from 'lodash';
  import returnLookup from '../components/lookup/returnLookup';
  import reportForm from '../components/reportForm';


  const searchSampleList = (condition) => axios.get('/api/sample_product', {params : condition})
  const getSampleDataList = (id,condition) => axios.post(`/api/sample_product/${id}/in_store`,condition);
  const getRecordDataList=(productId,type) => axios.get(`api/sample_product/${productId}/${type}/list`)

  export default {
      name: "sampleStorage",
      components: {
         returnLookup,
         reportForm
      },
      data () {
        return {
          dialogColumns:[
            {
              prop: 'opCount',
              label: '入库数量',
            },
            {
              prop: 'opPlace',
              label: '入库地点'
            }
          ],
          columns: [
            // {
            //   prop: 'id',
            //   label: '序号',
            //   sort: {
            //     show: true,
            //     default: 'asc'
            //   }
            // },
            // {
            //   prop: 'productId',
            //   label: '产品序号',
            //   sort: {
            //     show: true,
            //     default: 'asc'
            //   }
            // },
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
              label: '状态'
            },
            {
              prop: 'statusName',
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
              prop: 'sampleCount',
              label: '库存数量'
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
          showRecordDialog:false,
          showDialog: false,
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
            inStoreCount:'',
            inStoreCount:'',
            inStorePlace:'',
            remark:''
          },
          loading: false,
          selectRow: [],
          type:'in_store',
          id:'',
          productId:''
        };
      },
      methods: {
        sampleStorage(prop){
          this.id = prop.id;
          this.showDialog = true;
          this.dialogForm = prop;
          this.dialogForm.inStorePlace='';
          this.dialogForm.inStoreCount='';
          this.dialogForm.title = '样品入库';
        },
        closeDialog () {
          this.dialogForm = {
            isDelete: false,
            title: '添加顾客领取信息',
            sampleNo:'',
            sampleName:'',
            reportNo:'',
            sealNumber:'',
            inspectionQuantity:'',
            sampleQuantity: '',
            status: '',
            company: '',
            registerDate:'',
            storeCount:'',
            inStoreCount:'',
            inStorePlace:'',
            remark:''
          };
        },
        onSubmit(){
          this.showDialog = true;
          getSampleDataList(this.id, {inStorePlace:this.dialogForm.inStorePlace,inStoreCount:this.dialogForm.inStoreCount}).then(result =>{
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
        viewList(prop){
          this.loading = true;
          this.productId = prop.productId;
          this.showRecordDialog = true;
          this.$nextTick(() => {
            this.$refs.recordTable.doRemoteMethod();
          });
        },
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
        // chooseQuery(){
        //   if(this.clicked){
        //     return this.doQuery();
        //   }
        //   else{
        //     return this.dialogQuery();
        //   }
        // }
      }
    }
</script>

<style scoped>

</style>
