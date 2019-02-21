备样存放地点
request:/api/dict/list/store_place
methods:post
params:(detail:string)
introduction:添加备样存放地点,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/store_place
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

样品单号维护
request:/api/dict/list/sample_number
methods:post
params:(
dict: string  样品名称
detail:string 样品编号
)
introduction:添加备样等级,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/sample_number
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

样品等级维护
request:/api/dict/list/sample_level
methods:post
params:(detail:string)
introduction:添加备样等级,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/sample_level
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

样品抽样方式维护
request:/api/dict/list/sample_method
methods:post
params:(detail:string)
introduction:添加样品抽样方式,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/sample_method
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

样品抽样地点维护
request:/api/dict/list/sample_place
methods:post
params:(detail:string)
introduction:添加样品抽样地点,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/sample_place
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

检验类型维护
request:/api/dict/list/check_type
methods:post
params:(
dict: string  类型名称
detail:string 模板路径
)
introduction:添加样品抽样方式,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/check_type
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除

==========

样品存放地点维护
request:/api/dict/list/sample_store_place
methods:post
params:(detail:string)
introduction:添加样品抽样方式,有id为修改，否则为新建

request:/api/dict/{id}
methods:get
params:(id:number)
introduction:通过ID获取已存在的

request:/api/dict/sample_store_place
methods:get
params:(searchCondition:string ,pageIndex:number,pageSize:number)
introduction:获取全部已存在的地点，分页

request:/api/dict
methods:delete
params:(id:array)
introduction:通过ID删除
