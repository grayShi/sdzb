<template>
  <page-main-body :title="title">
    <div>
      <el-row>
        <el-card>
          <div slot="header">
            <span>基本信息</span>
          </div>
          <el-form :model="detailForm" ref="detailForm" label-width="100px">
            <el-row>
              <el-col :span="6">
                <el-form-item label="样品名称" prop="sampleName">
                  <el-input v-model="detailForm.sampleName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="样品数量" prop="sampleCount">
                  <el-input v-model="detailForm.sampleCount"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="创建时间" prop="sampleCreatedAt">
                  <el-date-picker
                    v-model="detailForm.sampleCreatedAt"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="样品状态" prop="sampleStatus">
                  <el-select v-model="detailForm.sampleStatus" placeholder="请选择">
                    <el-option
                      v-for="item in sampleStatusOptions"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6">
                <el-form-item label="所属业务" prop="businessName">
                  <el-input v-model="detailForm.businessName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="创建时间" prop="businessCreatedAt">
                  <el-date-picker
                    v-model="detailForm.businessCreatedAt"
                    align="right" style="width: 100%"
                    type="date"
                    placeholder="选择日期">
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="抽样方式" prop="samplingMethod">
                  <el-input v-model="detailForm.samplingMethod"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="6">
                <el-form-item label="业务状态" prop="businessStatus">
                  <el-input v-model="detailForm.businessStatus"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row v-show="status !== 'in'">
              <el-row style="line-height: 30px; margin-left: 30px">
                <span>任务已分配给如下部门:</span>
              </el-row>
              <el-row>
                <div class="distribute-detail">
                  <table>
                    <tr>
                      <td>部门1</td>
                      <td>负责人1</td>
                      <td style="width: 65%" v-if="status === 'wait'">
                        <span>负责人已到场,可以出库</span>
                      </td>
                      <td  v-if="status === 'out'">
                        任务状态:<el-tag>正在抽检</el-tag>
                      </td>
                      <td>
                        <el-button>查看任务</el-button>
                      </td>
                    </tr>
                    <tr>
                      <td>部门2</td>
                      <td>负责人2</td>
                      <td style="width: 65%" v-if="status === 'wait'">
                        <div>等待负责人领取样品,领取后办理出席</div>
                        <div>预计出库时间; 2018-11-26</div>
                      </td>
                      <td v-if="status === 'out'">
                        任务状态:<el-tag>正在抽检</el-tag>
                      </td>
                      <td>
                        <el-button>查看任务</el-button>
                      </td>
                    </tr>
                    <tr>
                      <td>部门3</td>
                      <td>负责人3</td>
                      <td v-if="status === 'wait'">
                        <div>等待负责人领取样品,领取后办理出席</div>
                        <div>预计出库时间; 2018-11-26</div>
                      </td>
                      <td v-if="status === 'out'">
                        任务状态:<el-tag>正在抽检</el-tag>
                      </td>
                      <td>
                        <el-button>查看任务</el-button>
                      </td>
                    </tr>
                  </table>
                </div>
              </el-row>
            </el-row>
            <el-row style="margin-top: 20px">
              <el-button type="primary" size="small" @click="viewProgress">查看业务进度</el-button>
              <span v-show="status === 'in'">抽样已完成，等待任务分配</span>
            </el-row>
          </el-form>
        </el-card>
        <el-card style="margin-top: 20px">
          <div slot="header">
            <span>专业信息</span>
          </div>
          <el-form :model="detailForm" ref="detailForm" label-width="100px">
            <el-row>
              <el-col :span="24">
                <el-form-item label="样品数据" prop="sampleDetail">
                  <el-input :autosize="$textareaAutosize" v-model="detailForm.sampleDetail" type="textarea"></el-input>
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
    </div>
    <div slot="footer">
      <el-button type="primary">确认</el-button>
      <el-button>取消</el-button>
    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'sampleDetail',
  data () {
    return {
      detailForm: {
        sampleName: '',
        sampleCount: '',
        sampleCreatedAt: '',
        sampleStatus: this.$route.query.status,
        businessName: '',
        businessCreatedAt: '',
        samplingMethod: '',
        businessStatus: ''
      },
      sampleStatusOptions: [
        {label: '已入库', value: 'in'},
        {label: '待出库', value: 'wait'},
        {label: '已出库', value: 'out'}
      ]
    };
  },
  computed: {
    title () {
      return `查看样品信息-${this.$route.query.status === 'in' ? '已入库' : this.$route.query.status === 'wait' ? '待出库' : this.$route.query.status === 'out' ? '已出库' : ''}`;
    },
    status () {
      return this.$route.query.status;
    }
  },
  methods: {
    viewProgress () {
    }
  }
};
</script>

<style scoped>

</style>
