package com.owen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServiceConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    //    自定义负载策略
//    http://www.60kb.com/post/77.html  这篇文说的比较麻烦   下面的写法还没有验证
//    http://blog.csdn.net/w_x_z_/article/details/71104640
//    @Bean
//    public IRule ribbonRule() {
//        return new BestAvailableRule(); //选择一个最小的并发请求的server
//        return new WeightedResponseTimeRule(); //根据相应时间分配一个weight，相应时间越长，weight越小，被选中的可能性越低。
//        return new RetryRule(); //对选定的负载均衡策略机上重试机制。
//        return new RoundRobinRule(); //roundRobin方式轮询选择server
//        return new RandomRule(); //随机选择一个server
//        return new ZoneAvoidanceRule(); //复合判断server所在区域的性能和server的可用性选择server
//        return new AvailabilityFilteringRule();//使用一个AvailabilityPredicate来包含过滤server的逻辑，其实就就是检查status里记录的各个server的运行状态
//    }
}
