# springcloud-learning


* [config-server](#config-server)
    *  基于git、rmq,实现了提交配置文件的修改， client能及时获取到最新配置
    
    
* [service-provider](#service-provider)
    * swagger-ui 、mybatis、druid datasource 热部署、druid monitor监控sql语句,并重写DruidDataSourceStatLoggerAdapter实现监控到的sql另存
    
    
* [service-consumer](#service-consumer)
    * consumer有两个实现,ribbon、feign、现阶段感觉feign比较容易上手,特别是在处理嵌套的json时，很方便
    
    
* [spring-boot-admin](#spring-boot-admin)
    * 向eureka-server中注册,并且监控service-provider、service-consumer和config-server。tip: spring-boot-admin会从eureka中获取各个应用的信息
    
* [zipk-server](#zipk-server)
    * 记录各服务之间的链路数据，添加自定义数据 tracer.addTag(key,val) ，数据保存到es，zipkin-ui中自定义查询语法还不清楚。。。。，
    * es中的查询示例：
	    <pre>		
			GET  zipkin-2018-01-24/_search
			{
			  "query": {
			    "bool": {
			      "should": [
				{
				  "nested": {
				    "path": "binaryAnnotations",
				    "query": {
				      "bool": {
					"must": {
					  "term": {
					    "binaryAnnotations.value": "514B4E58-BAEB-42EA-84CE-61491CA28309"
					  }
					}
				      }
				    }
				  }
				}
			      ]
			    }
			  }
			}

	    </pre>
    
* [mybatis](#mybatis)
    * 使用starter，好像不支持动态sql，持续关注.....  
    
* [spring-retry](#spring-retry)
    * 在service-consumer-ribbon里面有加入,测试调用service-provider失败后的场景
    
* [redis](#redis)
    * 待续.......
        
* [rabbitmp](#rabbitmp)
    * 待续.......
    
    
    

 

