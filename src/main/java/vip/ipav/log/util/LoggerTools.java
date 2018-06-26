package vip.ipav.log.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTools {
    /**
     * 获取同步自定义日志记录器
     * @return
     */
    public static Logger getCustomLogger(){
        return LogManager.getLogger("customLogger");
    }

    /**
     * 获取异步日志记录器
     * @return
     */
    public static Logger getAsyncSelfLogger(){
        return LogManager.getLogger("AsyncCustomLogger");
    }

    /**
     * 获取默认日志记录器
     * @return
     */
    public static Logger getRootLogger(){
        return LogManager.getRootLogger();
    }

    /**
     * 获取控制台输出日志器
     * @return
     */
    public static Logger getConsoleLogger() {
        return LogManager.getLogger("consoleLogger");
    }

    /**
     * 获取同步记录数据库的
     * 日志记录器
     * @return
     */
    public static Logger getDbLogger(){
        return LogManager.getLogger("SyncDBLogger");
    }

    /**
     * 获取异步数据库日志记录器
     * @return
     */
    public static Logger getAsyncDbLogger(){
        return LogManager.getLogger("AsyncDBLogger");
    }

}
