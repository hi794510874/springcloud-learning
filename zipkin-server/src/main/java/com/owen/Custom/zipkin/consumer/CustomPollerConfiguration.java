package com.owen.Custom.zipkin.consumer;

import org.springframework.cloud.sleuth.stream.StreamSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.scheduling.support.PeriodicTrigger;

/**
 * Created by huang_b on 2017/11/27.
 */

/*@Configuration
public class CustomPollerConfiguration {
    @Bean(name = StreamSpanReporter.POLLER)
    PollerMetadata customPoller() {
        PollerMetadata poller = new PollerMetadata();
        poller.setMaxMessagesPerPoll(500);
        poller.setTrigger(new PeriodicTrigger(5000L));
        return poller;
    }
}
        */