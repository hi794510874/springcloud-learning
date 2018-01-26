package com.owen.rabbitmqUtil;

import com.owen.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huang_b on 2018/1/25.
 */
public class RmqConfig {

    // private static Logger logger = LogManager.getLogger(RmqConfig.class);
    static Properties pps;

    public static void loadProperties() {
        InputStream in = RmqConfig.class.getClassLoader().getResourceAsStream("application.properties");
        pps = new Properties();
        try {
            pps.load(in);
        } catch (IOException e) {
            //logger.error(e.getMessage() + "   trace:" + e.getStackTrace());
        }
    }

    private String host;
    private String port;
    private String userName;
    private String passWord;

    public static String getHost() {
        return pps.getProperty("rabbitmq.host");
    }

    public static String getPort() {
        return pps.getProperty("rabbitmq.port");
    }

    public static String getUserName() {
        return pps.getProperty("rabbitmq.username");
    }

    public static String getPassWord() {
        return pps.getProperty("rabbitmq.password");
    }
}
