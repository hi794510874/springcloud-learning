package com.owen.Listener;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaAutoServiceRegistration;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 用于监听 eureka 服务的注册 注销 等操作
 * Created by huang_b on 2017/9/21.
 */
@Configuration
@EnableScheduling
public class EurekaInstanListener implements ApplicationListener {
    Logger logger = LogManager.getLogger(EurekaInstanListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        logger.info("监听到的事件:" + applicationEvent.toString());
        // 服务挂掉事件
        if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
            EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
            // 获取当前Eureka实例中的节点信息
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            // 遍历获取已注册节点中与当前失效节点ID一致的节点信息
            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {
                    if (instance.getInstanceId().equals(event.getServerId())) {
                        logger.info("服务：" + instance.getAppName() + " 挂啦。。。");
                        // // TODO: 2017/9/3 扩展消息提醒 邮件、手机短信、微信等
                    }
                });
            });
        }
        if (applicationEvent instanceof InstanceRegisteredEvent) {
            InstanceRegisteredEvent event = (InstanceRegisteredEvent) applicationEvent;
            EurekaInstanceConfigBean eurekaInstanceConfigBean = (EurekaInstanceConfigBean) event.getConfig();
            EurekaAutoServiceRegistration eurekaAutoServiceRegistration = (EurekaAutoServiceRegistration) event.getSource();
            logger.info("服务：" + eurekaInstanceConfigBean.getAppname() + " 注册成功啦。。。");
        }

        if (applicationEvent instanceof HeartbeatEvent) {
            HeartbeatEvent event = (HeartbeatEvent) applicationEvent;
            logger.info("心跳检测服务：" + event.getValue());
        }

        if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
            logger.info("服务 Aualiable。。");
        }
    }
}
