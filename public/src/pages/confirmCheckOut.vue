<template>
  <page-main-body :title="title">
    <div style="width: 80%">
      <el-row style="margin-bottom: 10px">
        <el-card>
          <div slot="header">
            <span>样品信息预览</span>
          </div>
          <el-form :model="detailForm" ref="detailForm" label-width="100px">
            <el-row>
              <el-col :span="8">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="detailForm.businessName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品数量" prop="sampleCount">
                  <el-input v-model="detailForm.sampleCount"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="样品编号" prop="sampleNo">
                  <el-input v-model="detailForm.sampleNo"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品数据" prop="sampleDetail">
                  <el-input v-model="detailForm.sampleDetail" type="textarea"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品图片" prop="sampleDetail">
                  <div class="sample-photo" style="overflow: auto">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                    <img src="../assets/logo.png" title="用户头像" class="image">
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品视频" prop="sampleDetail">
                  [视频]
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-card>
      </el-row>
      <el-row style="margin-bottom: 10px">
        <el-card>
          <div slot="header">
            <span>部门信息预览</span>
          </div>
          <el-form :model="departmentForm" ref="departmentForm" label-width="100px">
            <el-row>
              <el-col :span="12">
                <el-form-item label="出库部门" prop="department">
                  <el-input v-model="detailForm.department"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="样品领取时间" prop="receiveTime">
                  <el-input v-model="detailForm.receiveTime"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="负责人" prop="actionBy">
                  <el-input v-model="detailForm.actionBy"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="抽检内容" prop="checkDetail">
                  <el-input v-model="detailForm.checkDetail"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="联系方式" prop="phone">
                  <el-input v-model="detailForm.phone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="抽检时长" prop="checkTime">
                  <el-date-picker
                    v-model="detailForm.checkTime"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="领取数量" prop="receiveCount">
                  <el-input v-model="detailForm.receiveCount"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

          </el-form>
        </el-card>
      </el-row>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'confirmCheckOut',
  data () {
    return {
      title: '出库确认',
      detailForm: {
        sampleName: '',
        sampleCount: '',
        sampleNo: '',
        sampleDetail: ''
      },
      departmentForm: {
        department: '',
        receiveTime: '',
        actionBy: '',
        checkDetail: '',
        phone: '',
        checkTime: '',
        receiveCount: ''
      }
    };
  }
};
</script>

<style scoped>
  img {
    margin-right: 20px;
  }
  img:last-child {
    margin-right: 0;
  }
  .sample-photo {
    height: 100px;
    text-align: center;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
  }
</style>
