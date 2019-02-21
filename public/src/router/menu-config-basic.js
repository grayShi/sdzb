// 基本信息
import ProfessionTypeMaintain from '../pages/professionTypeMaintain';
import SampleHandleMaintain from '../pages/sampleHandleMaintain';
import SymbolPictureMaintain from '../pages/symbolPictureMaintain';
import InspectUnitMaintain from '../pages/inspectUnitMaintain';
import ClientUnitMaintain from '../pages/clientUnitMaintain';
import NoticeMaintain from '../pages/noticeMaintain';
import CheckResultMaintain from '../pages/checkResultMaintain';
import SpecialSign from '../pages/specialSign';
import SpecialSampleMaintain from '../pages/specialSampleMaintain';
import ChargingUnitMaintain from '../pages/chargingUnitMaintain';
import ChargingMethodMaintain from '../pages/chargingMethodMaintain';
import ChargingItemMaintain from '../pages/chargingItemMaintain';
import InspectUnitSymbol from '../pages/inspectUnitSymbol';
import Department from '../pages/BaseInfo/department.vue';
import SampleManage from '../pages/BaseInfo/sample_manage.vue';
import DuplicateSamplePos from '../pages/BaseInfo/duplicate_sample_pos.vue';
import SamplingPos from '../pages/BaseInfo/sampling_pos.vue';
import SamplingMethod from '../pages/BaseInfo/sample_method.vue';
import ValidateMethod from '../pages/BaseInfo/validate_method.vue';
import SampleSavePos from '../pages/BaseInfo/sample_save_pos.vue';
import SampleLevel from '../pages/BaseInfo/sample_level.vue';
import StandardManage from '../pages/BaseInfo/standard_manage.vue';
import SampleStatusMaintain from '../pages/sampleStatusMaintain.vue';
const router = [
  {
    module: '基础信息',
    seq: 1000,
    action: [
      {
        path: '/inspectUnitSymbol',
        desktop: InspectUnitSymbol,
        notShowInMenu: true
      },
      {
        path: '/professionTypeMaintain',
        title: '专业类型维护',
        desktop: ProfessionTypeMaintain
      },
      {
        path: '/sampleHandleMaintain',
        title: '样品处理方式',
        desktop: SampleHandleMaintain
      },
      {
        path: '/symbolPictureMaintain',
        title: '标志图片维护',
        desktop: SymbolPictureMaintain
      },
      {
        path: '/inspectUnitMaintain',
        title: '检验单位维护',
        desktop: InspectUnitMaintain
      },
      {
        path: '/clientUnitMaintain',
        title: '委托单位维护',
        desktop: ClientUnitMaintain
      },
      {
        path: '/noticeMaintain',
        title: '公告信息维护',
        desktop: NoticeMaintain
      },
      {
        path: '/checkResultMaintain',
        title: '检验结论维护',
        desktop: CheckResultMaintain
      },
      {
        path: '/specialSign',
        title: '特殊符号',
        desktop: SpecialSign
      },
      {
        path: '/specialSampleMaintain',
        title: '特殊样品维护',
        desktop: SpecialSampleMaintain
      },
      {
        path: '/chargingUnitMaintain',
        title: '收款单位维护',
        desktop: ChargingUnitMaintain
      },
      {
        path: '/chargingMethodMaintain',
        title: '收款方式维护',
        desktop: ChargingMethodMaintain
      },
      {
        path: '/chargingItemMaintain',
        title: '收费项目维护',
        desktop: ChargingItemMaintain
      },
      {
        path: '/department',
        title: '部门维护',
        desktop: Department
      },
      {
        path: '/sample_manage',
        title: '样品单号维护',
        desktop: SampleManage
      },
      {
        path: '/duplicate_sample_pos',
        title: '备样存放地点',
        desktop: DuplicateSamplePos
      },
      {
        path: '/sampling_pos',
        title: '样品抽样地点',
        desktop: SamplingPos
      },
      {
        path: '/sampling_method',
        title: '样品抽样方式',
        desktop: SamplingMethod
      },
      {
        path: '/validate_method',
        title: '检验类型维护',
        desktop: ValidateMethod
      },
      {
        path: '/sample_save_pos',
        title: '样品存放地点',
        desktop: SampleSavePos
      },
      {
        path: '/sample_level',
        title: '样品等级维护',
        desktop: SampleLevel
      },
      {
        path: '/standard_manage',
        title: '检验标准维护',
        desktop: StandardManage
      },
      {
        path: '/sampleStatusMaintain',
        title: '样品状态维护',
        desktop: SampleStatusMaintain
      }
    ]
  }
];

export const basicMenu = (() => {
  // todo
  return router;
})();
