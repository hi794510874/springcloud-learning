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

//    git仓库中文件 内容 "spring-datasource-url: jdbc:sqlserver://172.18.21.31;DatabaseName=Test"
    @Value("${spring-datasource-url}")
    private String springDataSourceUrl;

    public String getSpringDataSourceUrl() {
        return springDataSourceUrl;
    }
}
