/*
package vip.ipav.log.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * 日志配置所使用的数据库连接工厂类
 * <p>Created by followtry on 2017/4/20.
 *//*

@Component
public class LoggerConnectionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerConnectionFactory.class);

    private static final LoggerConnectionFactory loggerConnectionFactory = new LoggerConnectionFactory();

    @Autowired
    private DataSource dataSource;

    //通过内部单例接口实例化当前工厂类并提供Connection连接
    private interface Singleton {
        LoggerConnectionFactory INSTANCE = new LoggerConnectionFactory();
    }

    @PostConstruct
    void init(){
        Properties prop = new Properties() {
            {
                put("username","abc");
                put("password","abc");
                put("url","jdbc:mysql://172.20.19.200:3306/xx_test?useUnicode=true&characterEncoding=UTF-8");
                put("driverClassName","com.mysql.jdbc.Driver");
            }
        };

        try {
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            LOGGER.error("获取数据源出错",e);
        }
    }

    private LoggerConnectionFactory() {}

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
*/
