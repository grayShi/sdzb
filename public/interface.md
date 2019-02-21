信息登记
request: /api/sample
methods: post
params: (sampleForm：object)
path: newSample
introduction: 新建样品模版，sampleForm对象有id为修改，否则为新建，修改完状态就会变更成返工

request: /api/sample/{id}
methods: get
params: (id: number)
introduction: 通过ID获取已存在的样品模版

request: /api/sample
methods: get
params: (status: string[], searchCondition: string, page: number, size: number)
introduction: 获取全部已存在的样品模版，分页

request: /api/sample
methods: delete
params: (id: array)
introduction: 通过ID删除已存在的样品模版

request: /api/sample
methods: put
params: (id: array, status: string)
introduction: 通过ID提交样品模版,更新状态

status 是一个枚举字段:
    initial("已登记"),
    rework("返工"),
    pre_test("未校验"),
    pre_check("未较核"),
    pre_approve("未批准"),
    pre_print("未打印"),
    fetched("已领取");

以上全是信息登记的部分
=============

检验数据
request: /getInspectDataList
methods: post
params: (searchCondition: string, pageIndex: number, pageSize: number)
introduction: 获取全部已存在的检验数据，分页

request: /commitSampleById
methods: post
params: (id: array)
introduction: 通过ID提交检验数据


request: api/{id}/reworks
methods: get
params: (id: long, pageIndex: number, pageSize: number)
introduction: 获取任务号对应的返工记录，分页

{
    "datas": [
        {
            "content": [
                {
                    "id": 1,
                    "approver": "批准人",
                    "auditor": "校验人",
                    "mainInspector": "主审人",
                    "reworker": "被返工人gao",
                    "operator": "返工人gao",
                    "reasons": "原因",
                    "reworkTime": "2019-01-01 20:42:24",
                    "remarks": "备注"
                }
            ],
            "pageable": {
                "sort": {
                    "sorted": false,
                    "unsorted": true
                },
                "offset": 0,
                "pageSize": 10,
                "pageNumber": 0,
                "paged": true,
                "unpaged": false
            },
            "totalPages": 1,
            "totalElements": 3,
            "last": true,
            "size": 10,
            "number": 0,
            "sort": {
                "sorted": false,
                "unsorted": true
            },
            "first": true,
            "numberOfElements": 3
        }
    ],
    "msg": null,
    "code": "000",
    "totalRecords": null
}


request: api/sample/{id}/reworks
methods: post
params: (id: long, form: { reason: ['', '', ''], remark: '', status: enum})
introduction: 保存返工记录


=======================
request: api/enterprises
methods: get
params: keyWord:string
introduction: 返回企业列表

request: api/enterprises/{id}
methods: get
params: 
introduction: 返回某个企业

request: api/enterprises
methods: post
params: {enterprise}
introduction: 新增企业

request: api/enterprises/{id}
methods: put
params:  {enterprise}
introduction: 编辑企业

request: api/enterprises/{id}
methods: delete
params:  
introduction: 删除企业





request: /api/sample
methods: post
params: (reportForm：object)
path: newSample

新加字段：

sample新加字段： 
standard: [], // 报告标准
inspectRequire: '', // 检验方法标准
inspectResult: '', // 检验结论
inspectStatus: '', // 检验状态
temperature: '', // 温度
humidity: '', // 湿度
pressure: '', // 气压
fromDate: '', // 抽检日期from
toDate: '', // 抽检日期to
inspectStandard: '', // 检验方法标准
remark: '', // 备注
approver: '', // 批准人
auditor: '', // 审核人
mainInspector: '', // 主检人

新建sample
sampleCount，countNo，number，samBase
存不进去


检验数据 save的时候返回数据





报告审核

更改报告
request: /modifyReport
methods: post
params: (id: array)
introduction: 通过ID更改报告，使报告变成初始状态


===================
自定义表格
新增
request: /api/zibo_table
methods: post
params: (
  tableName: string,
  {
    "bindData":""
    ......
  }: Array
  )
introduction: 新增自定义表格，有id表示编辑

列表
request: /api/zibo_table
methods: get
params: (
  searchCondition: string,
  pageNumber: int,
  pageSize:int
  )
introduction: 自定义表格列表

根据id获取
request: /api/zibo_table/{id}
methods: get

删除
request: /api/zibo_table
methods: delete
params: id: array







收费登记

save：有id为修改 没id为新建  api/fee post
delete：[id] api/fee/{id} delete |  api/fee id:array delete
search: 分页 排序 （两种情况：一种只搜索未核实，一种全部搜索） api/fee?searchCondition=xxx&audit=true
getById:  id: string  /api/fee/{id}

form
{
  department: '',
  count: '',
  feeProject: '',
  feeWay: '',
  ticketNo: '',
  ticketDate: '',
  whether: '',
  number: '',  // 编号 用户输入
  feeDepartment: '',
  section: '',
  more: ''，
  audit： ''， //是否核实（只有两种状态，可以true/false）
}

核实收费 [id] /api/fee/{id}/verify  put  |  api/fee/verify id:array put

取消核实 [id] /api/fee/{id}/cancel_verify put | api/fee/cancel_verify id:array put




收费关联

1. 添加核实日期。核实时候保存。
auditTime:核实日期

2. 关联样品与收费：参数sampleIds: [], feeId: ''
收费关联 [id] put /api/fee/{feeId}/relate  sampleIds:array 

取消关联 [id] put /api/fee/{feeId}/cancel_relate   sampleIds:array 

3. zmm 新增/修改企业，有两个字段：储蓄金，费率。 生成样品的时候，如果企业有储蓄金跟费率，可以自动创建收费，核实，扣款




1. 收费关联之后更新样品的 收费状态，payState

2。需要一个搜索所有未被关联的feeList。原url：`/api/fee?${condition}`


