package com.owen.spring.cloud.config.git;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by huang_b on 2017/11/3.
 */
@Component
@RefreshScope
public class JdbcConfig {
    @Value("${spring-datasource-url}")
    private String springDataSourceUrl;

    public String getSpringDataSourceUrl() {
        return springDataSourceUrl;
    }
}
