# springcloud-learning


config-client和config-server: 基于git、rmq,实现了提交配置文件的修改， client能及时获取到最新配置


service-provider:swagger-ui 、mybatis、druid datasource 热部署、druid monitor监控sql语句,并重写DruidDataSourceStatLoggerAdapter实现监控到的sql另存

mybatis:基于starter 注解的形式 ,好像不支持动态sql 待续....

resttemplate:get和post简单封装

spring retry :有加进来 简单测试了下 service-consumer调用service-provider失败后重试的场景

spring-boot-admin：向eureka-server中注册,并且监控service-provider、service-consumer和config-server。tip：要向spring-boot-admin注册成功,必须好先向eureka-server中注册？我测试的结果是这样的

zipkin:记录各服务之间的调用链路 默认数据放在内存 ,可以配置在es  ,可以在链路数据中添加自定义的数据 tracer.addTag