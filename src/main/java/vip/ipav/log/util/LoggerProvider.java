package vip.ipav.log.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.HashMap;

public class LoggerProvider {

    public enum LoggerNames {
        customLogger,
        AsyncCustomLogger,
        consoleLogger,
        simpleLogger
    }

    private static class LazyHolder {
        private static final LoggerProvider INSTANCE = new LoggerProvider();
    }

    private HashMap<String,Logger> map = new HashMap<>();

    private LoggerProvider(){}

    public static final LoggerProvider getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Logger getCustomLogger(){
        if(map.containsKey("customLogger")){
            return map.get("customLogger");
        }
        Logger logger = LogManager.getLogger("customLogger");
        map.put("customLogger",logger);
        return logger;
    }

    public Logger getAsyncSelfLogger(){
        if(map.containsKey("AsyncCustomLogger")){
            return map.get("AsyncCustomLogger");
        }
        Logger logger = LogManager.getLogger("AsyncCustomLogger");
        map.put("AsyncCustomLogger",logger);
        return logger;
    }

    public Logger getRootLogger(){
        if(map.containsKey("root")){
            return map.get("root");
        }
        Logger logger = LogManager.getLogger("root");
        map.put("root",logger);
        return logger;
    }

    public Logger getConsoleLogger(){
        if(map.containsKey("consoleLogger")){
            return map.get("consoleLogger");
        }
        Logger logger = LogManager.getLogger("consoleLogger");
        map.put("consoleLogger",logger);
        return logger;
    }

    public Logger getSimpleLogger(){
        if(map.containsKey("simpleLogger")){
            return map.get("simpleLogger");
        }
        Logger logger = LogManager.getLogger("simpleLogger");
        map.put("simpleLogger",logger);
        return logger;
    }

    /**
     * 自定义日志级别
     * @param level
     * @return
     */
    public boolean setLevel(Level level, LoggerNames loggerName){
        if(level == null || loggerName == null){
            return false;
        }
        Configurator.setLevel(loggerName.name(),level);
        return true;
    }

}
