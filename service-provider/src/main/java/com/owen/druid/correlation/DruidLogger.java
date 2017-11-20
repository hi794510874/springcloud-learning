package com.owen.druid.correlation;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;

/**
 * Created by huang_b on 2017/11/20.
 */
public class DruidLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

//    http://blog.csdn.net/songhfu/article/details/70861016   要把 druid 监控的数据  存放到别的地方  还要研究
    @Override
    public void log(DruidDataSourceStatValue statValue) {
        System.out.println(statValue);

    }
}
