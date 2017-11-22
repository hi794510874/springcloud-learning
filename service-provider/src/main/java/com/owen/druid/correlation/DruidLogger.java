package com.owen.druid.correlation;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import com.alibaba.druid.stat.JdbcSqlStatValue;

/**
 * Created by huang_b on 2017/11/20.
 */
public class DruidLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

//
    @Override
    public void log(DruidDataSourceStatValue statValue) {
        for (JdbcSqlStatValue jdbcSqlStatValue: statValue.getSqlList()){

        }
        System.out.println(statValue);

    }
}
