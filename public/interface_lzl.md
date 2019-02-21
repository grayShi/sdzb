样品维护:

样品列表
request:/api/sample_product
methods:get
params: (searchCondition:string ,pageIndex:number,pageSize:number)
introduction:样品列表


入库
request: api/sample_product/{id}/in_store
methods: post
params:{
        "inStorePlace":"中环大厦",
        "inStoreCount":10000
       }

操作:领取/退样
request:api/sample_product/{id}/operate
method: post
params:{
        "opDate":"时间",//字符串
        "opPlace":"地点",//字符串
        "opCount":1000,//数字
        "opType":"get",//类型，get表示领取，withdraw表示退样
        "opUser":"zsx"//领取人或者退样人
       }
       
领取记录或者退样记录
api/sample_product/{productId}/{type}/list
method:get
params: {prodcutId: 样品列表返回的productId, type: get/withdraw}
