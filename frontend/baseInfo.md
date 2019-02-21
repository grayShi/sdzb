公告信息维护
request: /api/notice
methods: post
params: (noticeForm：object)
introduction: 新建公告信息，noticeForm对象有id为修改，否则为新建

request: /api/notice
methods: get
params: (id: number)
introduction: 通过ID获取已存在的公告信息

request: /api/notice
methods: post
params: (searchCondition: string)
introduction: 获取全部已存在的公告信息

request: /api/notice
methods: delete
params: (id: array)
introduction: 通过ID删除已存在的公告信息

========================================================================================================
检验结论维护
request: /api/checkResult
methods: post
params: (checkResultForm：object)
path: newCheckResult
introduction: 新建检验结论，checkResultForm对象有id为修改，否则为新建

request: /api/checkResult
methods: get
params: (id: number)
introduction: 通过ID获取已存在的检验结论

request: /api/checkResult
methods: post
params: (searchCondition: string)
introduction: 获取全部已存在的检验结论

request: /api/checkResult
methods: delete
params: (id: array)
introduction: 通过ID删除已存在的检验结论

========================================================================================================
其他的页面都是一样就是request：/api/XXXX不一样还有表格名字不一样
