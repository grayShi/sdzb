<template>
  <page-main-body :title="title">
    <div style="width:90%">
      <el-card>
        <div>
          <el-badge :value="messageList.length" :max="99" class="item">
            <el-button size="small" @click="showList('normal')">消息列表</el-button>
          </el-badge>
          <el-badge :value="messageDeleteList.length" :max="99" class="item">
            <el-button size="small" @click="showList('delete')">已删除</el-button>
          </el-badge>
        </div>
        <div v-if="showMessageType" v-for="message in messageList" :key="message.id" style="margin: 10px">
          <alert-message
            :id=message.id
            :title=message.title
            :type=message.type
            :description=message.description
            :descriptionLinkable="message.descriptionLinkable"
            :linkUrl="message.linkUrl"
            @close="closeMessage"
            @read-message="readMessage"
            show-icon>
          </alert-message>
        </div>
        <div v-if="!showMessageType" v-for="message in messageDeleteList" :key="message.id" style="margin: 10px">
          <alert-message
            :id=message.id
            :title=message.title
            :type=message.type
            :description=message.description
            :descriptionLinkable="message.descriptionLinkable"
            :linkUrl="message.linkUrl"
            @close="closeMessage"
            @read-message="readMessage"
            show-icon>
          </alert-message>
        </div>
      </el-card>
    </div>
  </page-main-body>
</template>

<script>
import alertMessage from '../components/alertMessage';
import _ from 'lodash';

export default {
  name: 'messageManage',
  components: {
    alertMessage
  },
  data () {
    return {
      title: '消息中心',
      showMessageType: true,
      messageList: [
        {
          id: 1,
          type: 'info',
          title: '业务员完成现场抽样,特此通知',
          description: '2018-11-28 17:07'
        },
        {
          id: 2,
          type: 'success',
          title: '新的业务[****]已创建,特此通知',
          description: '2018-11-28 17:07'
        },
        {
          id: 3,
          type: 'info',
          title: '**部门已确认接收[任务1]的分配',
          description: '2018-11-28 17:07'
        },
        {
          id: 4,
          type: 'info',
          title: '审核已经完成,点击查看审核结果',
          descriptionLinkable: true,
          linkUrl: '/#/index',
          description: '2018-11-28 17:07'
        }
      ],
      messageDeleteList: [
        {
          id: 1,
          type: 'error',
          title: '业务员完成现场抽样,特此通知',
          description: '2018-11-28 17:07'
        },
        {
          id: 2,
          type: 'error',
          title: '新的业务[****]已创建,特此通知',
          description: '2018-11-28 17:07'
        },
        {
          id: 3,
          type: 'error',
          title: '**部门已确认接收[任务1]的分配',
          description: '2018-11-28 17:07'
        },
        {
          id: 4,
          type: 'error',
          title: '审核已经完成,点击查看审核结果',
          descriptionLinkable: true,
          linkUrl: '/#/index',
          description: '2018-11-28 17:07'
        }
      ]
    };
  },
  methods: {
    closeMessage (id) {

    },
    readMessage (id) {
      const find = _.find(this.messageList, item => item.id === id);
      if (find) {
        find.type = 'success';
      }
    },
    showList (action) {
      this.showMessageType = action === 'normal';
    }
  }
};
</script>

<style scoped>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
