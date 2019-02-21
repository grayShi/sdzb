<template>

  <my-input :myText="text" @input-ready="a">
    <el-button slot="slot1">test</el-button>
    <div slot="slot2">
      test11231
    </div>
  </my-input>

</template>

<script>
import myInput from '../components/myInput';
export default {
  name: 'testCom',
  components: {
    myInput
  },
  data () {
    return {
      text: '123'
    };
  },
  methods: {
    a (val) {
      debugger;
    }
  }
};
</script>

<style scoped>

</style>
