package vip.ipav.log.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerTools {
    /**
     * 获取同步自定义日志记录器
     * @return
     */
    public static Logger getCustomLogger(){
        return LogManager.getLogger("customLogger");
    }

    /**
     * 自定义日志级别
     * @param level
     * @return
     */
    public static Logger getCustomLogger(Level level){
        if(level != null){
            Configurator.setLevel("customLogger", level);
        }
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
     * 自定义日志级别
     * @param level
     * @return
     */
    public static Logger getAsyncSelfLogger(Level level){
        if(level != null){
            Configurator.setLevel("AsyncCustomLogger", level);
        }
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
     * 添加自定义日志级别
     * @param level
     * @return
     */
    public static Logger getConsoleLogger(Level level) {
        if(level != null){
            Configurator.setLevel("consoleLogger", level);
        }
        return LogManager.getLogger("consoleLogger");
    }

    /**
     * 获取自定义简单日志
     * @return
     */
    public static Logger getSimpleLogger(){
        return LogManager.getLogger("simpleLogger");
    }

    public static Logger getSimpleLogger(Level level){
        if(level != null){
            Configurator.setLevel("simpleLogger", level);
        }
        return LogManager.getLogger("simpleLogger");
    }

}
