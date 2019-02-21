<template>
  <page-main-body :title="title">
    <el-row>
      <el-form :model="detailForm" :rules="detailRules" ref="ruleForm" label-width="100px">
        <el-row>
          <el-col :span="2">
            <div style="margin-top: 10px">
              <span class="head-span">抽检进度:</span>
            </div>
          </el-col>
          <el-col :span="20">
            <el-row>
              <el-col :span="4">
                <el-button disabled>业务申请</el-button>
              </el-col>
              <el-col :span="4">
                <el-button disabled>抽样</el-button>
              </el-col>
              <el-col :span="4">
                <el-button type="primary" disabled>抽检</el-button>
              </el-col>
              <el-col :span="4">
                <el-button disabled>审核</el-button>
              </el-col>
              <el-col :span="4">
                <el-button disabled>完成</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="4">
            <el-form-item label="任务" prop="task1Name">
              <el-input v-model="detailForm.task1Name"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-row>
              <el-col :span="8">
                <el-button type="danger" disabled>待确认</el-button>
              </el-col>
              <el-col :span="8">
                <el-form-item>
                  <el-button type="primary">点击提醒负责人</el-button>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="7">
                <el-form-item label="内容" prop="content">
                  <el-input v-model="detailForm.content"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="4">
            <el-form-item label="任务" prop="taskName2">
              <el-input v-model="detailForm.taskName2"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-row>
              <el-col :span="8">
                <el-button type="primary" disabled>正在抽检</el-button>
              </el-col>
              <el-col :span="8">
                <el-button type="text" disabled>预计完成抽检时间：2018-11-1</el-button>
              </el-col>
            </el-row>
            <el-row style="margin-top: 10px">
              <el-col :span="7">
                <el-form-item label="内容" prop="content">
                  <el-input v-model="detailForm.content"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="4">
            <el-form-item label="任务" prop="taskName3">
              <el-input v-model="detailForm.taskName3"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-row>
              <el-col :span="8">
                <el-button type="success" disabled>抽检完成</el-button>
              </el-col>
              <el-col :span="8">
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">点击审核任务</el-button>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-button type="text" disabled>完成抽检：2018-11-1</el-button>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="7">
                <el-form-item label="内容" prop="content">
                  <el-input v-model="detailForm.content"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row style="margin-top: 10px">
          <el-col :span="4">
            <el-form-item label="任务" prop="taskName4">
              <el-input v-model="detailForm.taskName4"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-row>
              <el-col :span="8">
                <el-button type="warning" disabled>完成审核</el-button>
              </el-col>
              <el-col :span="8">
                <el-button type="text" disabled>审核完成时间：2018-10-30</el-button>
              </el-col>
            </el-row>
            <el-row style="margin-top: 10px">
              <el-col :span="7">
                <el-form-item label="内容" prop="content">
                  <el-input v-model="detailForm.content"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="7">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        <el-row>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确认</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-row>
  </page-main-body>
</template>

<script>
  export default {
        name: "viewInspectProgress",
        data () {
          return {
            title:'查看抽检进度',
            showCurrent: true,
            detailForm: {
              taskName1: '',
              taskName2: '',
              taskName3: '',
              taskName4: '',
              content: '',
              department: '',
              actionBy: '',
              missionlist:[{

              }
              ]
            },
            detailRules: {}
          }
        }
  }
</script>

<style scoped>

</style>
