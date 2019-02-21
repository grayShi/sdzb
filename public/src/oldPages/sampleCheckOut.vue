<template>
  <page-main-body :title="title">
    <div style="width: 80%">
      <h3>所有的【待出库】样品</h3>
      <el-row style="margin-bottom: 10px">
        <el-card>
          <el-row>
            <el-tag type="success">样品1</el-tag>
            <el-tag type="success">业务1</el-tag>
          </el-row>
          <el-row style="line-height: 30px; margin-left: 30px">
            <span>任务已分配给如下部门:</span>
          </el-row>
          <el-row>
            <div class="distribute-detail">
                <table>
                  <tr>
                    <td>部门1</td>
                    <td>负责人1</td>
                    <td style="width: 65%">
                      <el-button size="small"  @click="goToCheckOut">办理出库</el-button>
                      <span>负责人已到场,可以出库</span>
                    </td>
                  </tr>
                  <tr>
                    <td>部门2</td>
                    <td>负责人2</td>
                    <td style="width: 65%">
                      <div>等待负责人领取样品,领取后办理出席</div>
                      <div>预计出库时间; 2018-11-26</div>
                    </td>
                  </tr>
                  <tr>
                    <td>部门3</td>
                    <td>负责人3</td>
                    <td style="width: 65%">
                      <div>等待负责人领取样品,领取后办理出席</div>
                      <div>预计出库时间; 2018-11-26</div>
                    </td>
                  </tr>
                </table>
            </div>
          </el-row>

        </el-card>
      </el-row>
      <el-row style="margin-bottom: 10px">
        <el-card>
          <el-row>
            <el-tag type="success">样品1</el-tag>
            <el-tag type="success">业务1</el-tag>
          </el-row>
          <el-row style="line-height: 30px; margin-left: 30px">
            <span>任务已分配给如下部门:</span>
          </el-row>
          <el-row>
            <div class="distribute-detail">
              <table>
                <tr>
                  <td>部门1</td>
                  <td>负责人1</td>
                  <td style="width: 65%">
                    <el-button size="small"  @click="goToCheckOut">办理出库</el-button>
                    <span>负责人已到场,可以出库</span>
                  </td>
                </tr>
                <tr>
                  <td>部门2</td>
                  <td>负责人2</td>
                  <td style="width: 65%">
                    <div>等待负责人领取样品,领取后办理出席</div>
                    <div>预计出库时间; 2018-11-26</div>
                  </td>
                </tr>
                <tr>
                  <td>部门3</td>
                  <td>负责人3</td>
                  <td style="width: 65%">
                    <div>等待负责人领取样品,领取后办理出席</div>
                    <div>预计出库时间; 2018-11-26</div>
                  </td>
                </tr>
              </table>
            </div>
          </el-row>

        </el-card>
      </el-row>
      <el-row style="margin-bottom: 10px">
        <el-card>
          <el-row>
            <el-tag type="success">样品1</el-tag>
            <el-tag type="success">业务1</el-tag>
          </el-row>
          <el-row style="line-height: 30px; margin-left: 30px">
            <span>任务已分配给如下部门:</span>
          </el-row>
          <el-row>
            <div class="distribute-detail">
              <table>
                <tr>
                  <td>部门1</td>
                  <td>负责人1</td>
                  <td style="width: 65%">
                    <el-button size="small"  @click="goToCheckOut">办理出库</el-button>
                    <span>负责人已到场,可以出库</span>
                  </td>
                </tr>
                <tr>
                  <td>部门2</td>
                  <td>负责人2</td>
                  <td style="width: 65%">
                    <div>等待负责人领取样品,领取后办理出席</div>
                    <div>预计出库时间; 2018-11-26</div>
                  </td>
                </tr>
                <tr>
                  <td>部门3</td>
                  <td>负责人3</td>
                  <td style="width: 65%">
                    <div>等待负责人领取样品,领取后办理出席</div>
                    <div>预计出库时间; 2018-11-26</div>
                  </td>
                </tr>
              </table>
            </div>
          </el-row>

        </el-card>
      </el-row>

    </div>
  </page-main-body>
</template>

<script>
export default {
  name: 'sampleCheckOut',
  data () {
    return {
      title: '样品出库登记',
      sampleList: []
    };
  },
  methods: {
    goToCheckOut () {
      this.$router.push('/confirmCheckOut');
    }
  }
};
</script>

<style scoped>

</style>
