<template>
  <div id="printReportPage" :style="{width: formWidth}">
    <grid-layout :layout="formColumns"
                 :style="{ 'background-color': backgroundColor }"
                 :col-num="48"
                 :row-height="20"
                 :is-draggable="draggable && editable"
                 :is-resizable="resizable && editable"
                 :vertical-compact="true"
                 :margin="[1, 1]"
                 :use-css-transforms="!isPrint">
      <grid-item v-for="item in formColumns" :key="item.i"
                 :x="item.x"
                 :y="item.y"
                 :w="item.w"
                 :h="item.h"
                 :i="item.i"
                 :style="setBorder(item)"
                 @dblclick.native="modifyColumns(item)">
        <span class="vue-delete-handle" v-if="editable" @click="deleteColumns(item)"></span>
        <div :class="fontClass(item)" :style="{fontSize: setFontSize(item)}">
          <div>{{item.message}}</div>
        </div>
      </grid-item>
    </grid-layout>
  </div>

</template>

<script>
import VueGridLayout from 'vue-grid-layout';
import '../css/reportForm.css';
export default {
  name: 'reportForm',
  components: {
    GridLayout: VueGridLayout.GridLayout,
    GridItem: VueGridLayout.GridItem
  },
  data () {
    return {
      backgroundColor: !this.editable ? 'white' : '#eee',
      formWidth: this.isPrint ? '210mm' : '100%'
    };
  },
  props: {
    formColumns: {
      type: Array,
      default: () => {
        return [];
      }
    },
    draggable: {
      type: Boolean,
      required: false,
      default: () => {
        return true;
      }
    },
    resizable: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    editable: {
      type: Boolean,
      default: () => {
        return true;
      }
    },
    isPrint: {
      type: Boolean,
      default: () => {
        return false;
      }
    }
  },
  methods: {
    deleteColumns (column) {
      this.$emit('delete-columns', column);
    },
    modifyColumns (column) {
      this.$emit('modify-columns', column);
    },
    fontClass (item) {
      const classList = ['text-show'];
      if (item.position === 'left') {
        classList.push('text-left');
      } else if (item.position === 'right') {
        classList.push('text-right');
      } else {
        classList.push('text-center');
      }
      return classList.join(' ');
    },
    setBorder (item) {
      const borderStyle = ['border: 1px solid black'];
      if (item.border.indexOf('borderTop') < 0) {
        borderStyle.push('border-top: 0');
      }
      if (item.border.indexOf('borderRight') < 0) {
        borderStyle.push('border-right: 0');
      }
      if (item.border.indexOf('borderBottom') < 0) {
        borderStyle.push('border-bottom: 0');
      }
      if (item.border.indexOf('borderLeft') < 0) {
        borderStyle.push('border-left: 0');
      }
      return borderStyle.join(';');
    },
    setFontSize (item) {
      return `${item.fontSize ? item.fontSize : 15}px`;
    }
  }
};
</script>

<style scoped>

</style>
