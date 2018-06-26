package vip.ipav.log.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class LoggerConnectionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerConnectionFactory.class);

    private DataSource dataSource;

    //通过内部单例接口实例化当前工厂类并提供Connection连接
    private interface Singleton {
        LoggerConnectionFactory INSTANCE = new LoggerConnectionFactory();
    }

    //饿汉式单例
    //private static final LoggerConnectionFactory loggerConnectionFactory = new LoggerConnectionFactory();

    @PostConstruct//在servlet里面，在初始化servlet前执行，只执行一次
    void init(){
        Properties prop = new Properties() {
            {
                put("username","root");
                put("password","HXB@ipav.112");
                put("url","jdbc:mysql://ipav.vip:3306/test?useUnicode=true&characterEncoding=UTF-8");
                put("driverClassName","com.mysql.jdbc.Driver");
            }
        };

        try {
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            LOGGER.error("获取数据源出错",e);
        }
    }

    private LoggerConnectionFactory() {
        init();
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return Singleton.INSTANCE.dataSource.getConnection();
    }
}
