<template>
  <page-main-body :title="title">
  <div style="height: 100%;width:1000px">
    <el-row class="head-message">
      <el-col :span="8" :offset="3">
        <el-card>
          <el-row>
            <el-col :span="10">
              <div class="message-body">
                <img src="../assets/logo.png" title="用户头像" class="image">
              </div>
            </el-col>
            <el-col :span="14">
              <div class="message-body">
                <div>
                  <span>姓名，工号</span>
                  <div style="margin-top: 5px">
                    <span>消息中心</span>
                    <span>新闻公告</span>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
      <el-col :span="8" :offset="2">
        <el-card>
          <el-row>
            <el-col :span="12">
              <div class="message-body">
                <span>
                  时间
                </span>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="message-body">
                <span>日历</span>
              </div>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row style="margin-bottom: 0">
      <el-form :model="detailForm" ref="ruleForm" label-width="100px">
    <div >
    <p >
      抽样进度：
    </p>
      <el-steps :active="1" simple finish-status="wait">
        <el-step title="业务申请" icon=" "></el-step>
        <el-step title="抽样" icon=" "></el-step>
        <el-step title="抽检" icon=" "></el-step>
        <el-step title="审核" icon=" "></el-step>
        <el-step title="完成" icon=" "></el-step>
      </el-steps>
    <el-row v-if="Local" style="margin-top: 30px;margin-bottom: 0">
      <el-form :model="detailForm" ref="ruleForm" label-width="100px">
      <el-col :span="6">
        <el-form-item label="业务员" >
          <el-input v-model="detailForm.Salesman" disabled="disabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="业务员编号" >
          <el-input v-model="detailForm.SalesmanNum" disabled="disabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="联系方式" >
          <el-input v-model="detailForm.Contact" disabled="disabled"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="6">
        <el-form-item label="现场信息" >
          <el-input v-model="detailForm.Information" disabled="disabled"></el-input>
        </el-form-item>
      </el-col>
      </el-form>
    </el-row>
      <el-row v-if="!Local" style="margin-top: 30px;margin-bottom: 0" >
        <el-form :model="detailForm" ref="ruleForm" label-width="100px" >
          <el-col :span="6" >
            <el-form-item label="送检抽样" >
              <el-input v-model="detailForm.Inspection" disabled="disabled"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" offset="3">
            <el-form-item label="寄送样品数量" >
              <el-input v-model="detailForm.Count" disabled="disabled"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" offset="3">
            <el-form-item label="预计寄送时间" >
              <el-input v-model="detailForm.Time" disabled="disabled"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    <el-row style="margin-bottom: 0">
      <el-col v-if="Local">
        <span >现场抽样：</span>
      </el-col>
      <el-col v-if="!Local">
        <span >送检抽样：</span>
      </el-col>
      <el-row>
      <el-col :span="8" style="margin-left: 100px" v-if="Appointed&Local">
                <span class="text" >
                  业务员已指派，正在派往现场
                </span>
    </el-col>
      <el-col span="8" v-if="Appointed&Local" style="margin-left: 165px">
          <span style="color: gray" class="content">预计到场时间：2018-10-1</span>
      </el-col>

      <el-col :span="8" style="margin-left: 100px" v-if="Appointed&!Local">
                <span class="text" >
                  等待送检方寄出样品
                </span>
      </el-col>
      <el-col span="12" v-if="Appointed&!Local">
          <span style="color: gray" ></span>
      </el-col>
      </el-row>
      <el-row>
      <el-col :span="8" style="margin-left: 100px" v-if="OnLocal&Local">
          <span class="text" >
                  业务员正在现场确认
                </span>
    </el-col>
      <el-col span="8" v-if="OnLocal&Local" style="margin-left: 150px">
          <span style="color: gray" class="content" >预计完成抽样时间：2018-10-2</span>
      </el-col>
      <el-col :span="8" style="margin-left: 100px" v-if="OnLocal&!Local">
          <span class="text" >
                  样品已寄出
                </span>
      </el-col>
      <el-col span="8" v-if="OnLocal&!Local" style="margin-left: 150px">
          <span style="color: gray" class="content">预计收到样品时间：2018-10-2</span>
      </el-col>
      </el-row>
      <el-row>
      <el-col :span="8" style="margin-left: 100px" v-if="Submitted&Local">
          <span class="text" >
                  抽样信息已提交，等待任务分配
                </span>
      </el-col>
      <el-col :span="8" style="margin-left: 100px" v-if="Submitted&!Local">
          <span class="text" >
                  样品已接收，等待任务分配
                </span>
      </el-col>
      <el-col span="8" style="margin-left: 230px">
          <el-button type="primary" style="width:150px;margin-left: 50px">
            <span style="color: white">分配任务</span>
          </el-button>
      </el-col>
      </el-row>
    </el-row>
    </div>
      </el-form>
    </el-row>
    <el-row  style="margin-left: 100px;">
      <el-button type="primary" style="width:160px;margin-right: 100px" @click="Local = !Local">
        <span style="color: white">确认</span>
      </el-button>
      <el-button type="primary"   style="width:160px">
        <span style="color: white">取消</span>
      </el-button>
    </el-row>
  </div>
  </page-main-body>
</template>

<script>
import '../css/business.css';
export default {
  name: 'business',
  data () {
    return {
      Local: true,
      Appointed: true,
      OnLocal: true,
      Submitted: true,
      detailForm: {
        Salesman: '张三',
        SalesmanNum: '112358',
        Contact: '10010202',
        Information: 'null',
        Inspection: 'qwe',
        Count: '44',
        Time: '2019'
      }
    };
  },
  computed: {
    title () {
      return this.Local ? '查看抽样进度-现场抽样' : '查看抽样进度-送检抽样';
    }
  }
};
</script>

<style scoped>
  .el-row {
    margin-bottom: 30px;
  }
  /*.el-row:last-child {
    margin-bottom: 0px;
  }*/
  .el-col {
    border-radius: 4px;
  }

  .text {
    border-radius: 4px;
    line-height: 40px;
    height: 40px;
    width: 130%;
    border:1px solid lightgray;
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: center;
  }
.content{
  height: 40px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
