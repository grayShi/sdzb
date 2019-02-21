公告信息维护
request: /api/standard
methods: post
params: (standardForm：object)
introduction: 新建检验标准，standardForm对象有id为修改，否则为新建

request: /api/standard/
methods: get
params: (id: number)
introduction: 通过ID获取已存在的检验标准

request: /api/standard
methods: post
params: (searchCondition: string)
introduction: 获取全部已存在的检验标准

request: /api/standard
methods: delete
params: (id: array)
introduction: 通过ID删除已存在的检验标准
