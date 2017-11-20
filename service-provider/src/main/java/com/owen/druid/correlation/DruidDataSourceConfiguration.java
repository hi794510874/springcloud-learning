package com.owen.druid.correlation;

import com.alibaba.druid.pool.DruidDataSource;
import com.owen.spring.cloud.config.git.JdbcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Created by huang_b on 2017/11/3.
 */
@Configuration
public class DruidDataSourceConfiguration {
    @Autowired
    private JdbcConfig jdbcConfig;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @RefreshScope
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        String jdbcURL = jdbcConfig.getSpringDataSourceUrl();
        druidDataSource.setUrl(jdbcURL);
        druidDataSource.setFilters("stat");//druid 要监控mybatis 的sql 必须加这行代码
       /* druidDataSource.setPassword();
        druidDataSource.setUsername();
        druidDataSource.setDriverClassName();*/
        return druidDataSource;
    }
}
