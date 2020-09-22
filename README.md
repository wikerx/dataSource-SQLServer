# 系统开发文档
## 开发环境
> JDK :1.8+，ActiveMQ5.15.2+
>
> Tomcat :8.5+
>
> Idea :ALL
>
> 运行环境 :Windows、Linux、Else
>
## 项目包结构
> 外部 jar lib中的 sqljdbc4.jar  官网maven收费，下不下来，所以改为外部引用（现在恢复了，使用了maven，如果下不下来的时候在使用这个jar）

> bank :银行代码
> - pay72:对应银行
>
>common :公共资源
> - base: 基础信息配置
> - dateutils：时间工具类
> - encrypt: 加密、解密类
> - exception: 异常
> - httpclient: 请求工具
> - iso：国际标准规范
> - utils: 其他封装工具类
>
>config :系统配置文件及基础默认配置
> - filter：拦截器
> - mq：ActiveMQ
> - sqlprovider：SQL拼装
> - threadpool：线程池
>
>dataSource :项目数据源切换
> - annotation: 注解
> - aop: aop
> - config: 配置
> - register: 注入
>
>model :代码服务
> - controller: 控制层
>> - api: 所有api（2方API采用内调，页面采用直连）
>>> 2方接口：http://ip:port/payment/online/pay,请求进入 BaseController，由此公共对外接口调用对应的支付服务（以后如果有N个，进行分发）：OnlinePayController
>>>
>>> 3方接口：http://ip:port/payment/page/pay,请求进入 PagePayController， 确认基础参数无误，进入 CheckPay ，由此方法进入订单支付页面，支付完成，进入 PagePayResultController， 完成支付操作(页面跳转用的是转发不是重定向，因为重定向面对多服务需要处理session丢失问题)
>>>
>>> 2.5方接口：http://ip:port/payment/domain/pay,请求进入 DomainPayController， 后面的代码暂未开发
>>>
>> - base: 所有直接服务端API的公共方法
>> - mq: 内部MQ推送
> - entity: 实体对象
> - mapper: mapper-SQL服务
> - service: 服务层
> - - impl: 服务实现
>
>
>test :测试类
> - testapi: api测试类
>
>wind :风控代码
> - self：内部集成风控
> - others：三方风控代码
>
>
>
>resource :资源文件
> - config：配置文件
> - mybatis：MyBatis配置文件
> - - config：MyBatis全局配置
> - - mappers：MyBatis xml配置
> - secret：秘钥文件
> - static：静态资源样式文件
> - templates：静态页面
>


## 关联修改
> 1.老系统管理系统修改(很多之前配读取的改为数据库存取)（争议管理 - > 争议-系统数据字典）
> > 拦截所在地区的交易：map_key:interceptIpAddress map_value:...
>数据库SQL:
> >
> > `ALTER TABLE GW_SYSTEM_PROPERTIES ALTER COLUMN map_value nvarchar(800);`
> >
> >`INSERT INTO [dbo].[GW_SYSTEM_PROPERTIES]([map_name], [map_logs], [map_type], [map_key], [map_value], [back1], [back2], [back3], [create_time]) VALUES (NULL, NULL, NULL, N'PAY_URL_72', N'https://ap-https://ap-gateway.mastercard.com/api/rest', NULL, NULL, NULL, '2020-07-13 10:14:05.000');`
> >
> >`INSERT INTO [dbo].[GW_SYSTEM_PROPERTIES]([map_name], [map_logs], [map_type], [map_key], [map_value], [back1], [back2], [back3], [create_time]) VALUES (NULL, NULL, NULL, N'interceptIpAddress', N'#US-California-Foster City#US-Texas-Austin#ES-Madrid, Comunidad de-Madrid#US-Utah-Lehi#US-Florida-Miami#JP-Tokyo-Tokyo#DE-Hessen-Frankfurt am Main#IN-Maharashtra-Mumbai#US-California-San Francisco#US-Illinois-Chicago#US-Virginia-Ashburn#US-California-Palo Alto#US-California-San Jose', NULL, NULL, NULL, NULL);`
>
> 2.IP库文件读取（txt格式分了6个）
> > application.yml中  config.data.ip 指向的文件夹为IP库文件的文件夹路径
>
>Cybs项目部署之前需要修改 jdk1.8中两个Jar
>因为系统都是64位的，但是计算的时候需要128位的算法加密
>
>
## 商户回调
> 商户回调目前仅支持3方回调（通过ActiveMQ通知商户，区分http和htpps协议）
>

## 接口支持版本
> 接口目前仅支持2方和3方
> 支付通道目前仅支持72通道（支持进件材料提交）支付


## 全局风控介绍
> 使用功能：admin管理系统 -> '风控管理' ->  '系统风控全局配置'
>
|  序号 |  标识key | 功能  | 说明  | 备注  |
| :------------: | :------------: | :------------: | :------------: | :------------: |
| 1  | BILL_ADDRESS  |  历史账单 | 1-跨张帐单：满了从新分配账单地址、2-不跨账单：满了直接挡掉   | processingModel值  |
| 2  | AMOUNT_ROUTING  |  金额路由 |  1：满了挡掉交易 2：满了随机分配通道 |   |
| 3  | FIXED_CHANNEL  |  2/3方固定通道规则 |  1：通道配置不过笔数和金额 2：只过笔数 3：只过金额 4：过笔数和金额  |   |
| 4  | STORKE_ROUTING  |  笔数路由 |  1：满了挡掉交易 2：满了随机分配通道 |   |
||||
>
>规则优先级：历史账单、卡Bin路由、网址路由、笔数-金额路由、常规通道


### 开发人员测试说明
> test - > testapi下面 是2方的支付sample
>
>3方测试页面-Sample：http://localhost:8080/payment/page
>
>2.5方测试页面-Sample：http://localhost:8080/payment/domain
>
>以上测试页面请在上线后关闭入口
>
>72通道在线API地址：https://test-gateway.mastercard.com/api/documentation/apiDocumentation/rest-json/index.html?locale=zh_CN
>
>76通道测试卡：5520330000000001
>
>2.5方支持   纯3D通道、兼容3D通道 和 常规通道的支付
>



### 修改/更新
|  序号 |  修改时间 | 功能  | 说明  | 备注  |
| :------------: | :------------: | :------------: | :------------: | :------------: |
| 1  | 2020-07-31  |  新增76通道 | 仅支持M卡，MOTO交易，支持币种：USD、EUR、GBP、HKD、AUD、CAD、CHF、SGD、SEK、JPY、NZD、TWD、KRW、ZAR、DKK、MYR、INR、THB、PHP、RUB、KZT、NOK、BRL、CNY   | 测试卡号：5520330000000001，其他信息随便填  |
| 2  | 2020-07-31  |  72通道日志入库 AND 工具包更新 | 入库的数据存在问题  | 部分工具包由Object改为指定类型  |
| 3  | 2020-08-03  |  交易送往银行的返回码封装  | 银行返回码B开头，初始化时请务必保证gw_ErrorCode中数据为空 |
| 4  | 2020-08-07  |  新增3D通道-72  | 新增部分对外返回码，72通道新增一个银行地址用于GW接收支付回调（yml中配置） |
| 5  | 2020-08-13  |  目录结构修改  | cybs.properties,bankInfo.properties两个配置文件修改，yml分化 |
| 6  | 2020-08-26  |  网址路由修改  | 网址路由支持5大卡种自由切换 |



## 注意：
> 2020-08-10 特别说明：
>
> 72通道支付地址（正式）：https://ap-gateway.mastercard.com/api/rest
>
> 76通道你支付地址（测试）：http://140.207.147.250:8006
>
> Cybs相关配置及说明
>
> 	第一步：使用件中的两个jar替换jdk中的两个jar（原因：jdk支持64位算法，但是cybs证书加密用了128位的算法）
>
>> 		替换位置：xxxx\jdk\jre\lib\security
>
> 	第二步：修改resources/config/bankInfo.properties  中的配置
>
>>		其中  resources/secret/chinapayment.p12 为Cybs的配置秘钥
>>
>>		其他数据自定义配置：支付地址线上请使用正式地址
>
>>
> 系统网关交易日志查询注意事项：
>
> 以前的  交易信息管理 - 交易日志查询   中的查询条件：几方交易  之前的通道接口变了，所以admin系统需要随之更改一下
>
> 支付地址配置位置：resource/config/bankInfo.properties
>