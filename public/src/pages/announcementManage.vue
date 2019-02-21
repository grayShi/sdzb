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
                <el-form-item label="标题" prop="titleName">
                  <el-input v-model="dialogTypeForm.titleName" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :span="20">
              <el-form-item label="内容" prop="content">
                <el-input v-model="dialogTypeForm.content" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
              </el-form-item>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="发布人" prop="person">
                  <el-input v-model="dialogTypeForm.person" :disabled="dialogTypeForm.isDelete" :placeholder="$placeholder.input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="时间" prop="time">
                  <el-date-picker
                    v-model="dialogTypeForm.time"
                    type="datetime"
                    :disabled="dialogTypeForm.isDelete"
                    :placeholder="$placeholder.selectDate" value-format=" yyyy-MM-dd HH:mm" format="yyyy-MM-dd HH:mm">
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
        name: "announcementManage",
      data () {
        return {
          title: '公告管理',
          columns: [
            {
              prop: 'number',
              label: '序号'
            },
            {
              prop: 'titleName',
              label: '标题'
            },
            {
              prop: 'content',
              label: '内容'
            },
            {
              prop: 'person',
              label: '发布人'
            },
            {
              prop: 'time',
              label: '时间'
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
              number:1,
              titleName:'关于统计论文、专利等的通知',
              content:'接上级通知，需上报我所2018年论文、专利等的统计，现将统计表上传，望各科室认真填写，11月23日将此表电子版与复印件交于业务室。',
              person:'赵月宁',
              time:'2018-11-22 00:00'
            }
          ],
          dialogTypeForm:{
            title:"添加检验单位标志",
            isDelete: false,
            titleName:'',
            content:'',
            person:'',
            time:''
          },
          showDialogType: false,
          dialogTypeRules: {

          },
        };
      },
      methods:{
        viewTypeDetail(id, action) {
          this.dialogTypeForm = {
            title: '修改公告信息',
            titleName:'关于统计论文、专利等的通知',
            content:'接上级通知，需上报我所2018年论文、专利等的统计，现将统计表上传，望各科室认真填写，11月23日将此表电子版与复印件交于业务室。',
            person:'赵月宁',
            time:'2018-11-22 00:00'
          };
          if (action === 'delete') {
            this.dialogTypeForm.isDelete = true;
            this.dialogTypeForm.title = '删除公告信息';
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
            titleName:'',
            content:'',
            person:'',
            time:''
          };
        }
      }
    }
</script>

<style scoped>

</style>
