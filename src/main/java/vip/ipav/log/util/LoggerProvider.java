package vip.ipav.log.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class LoggerProvider {

    /**
     * 自定义日志种类
     */
    public enum LoggerNames {
        customLogger,
        AsyncCustomLogger,
        consoleLogger,
        simpleLogger,
        printlnLogger
    }

    private static class LazyHolder {
        private static final LoggerProvider INSTANCE = new LoggerProvider();
        static {
            if(System.getProperty("log4j2.home") == null){
                setLogParentPath(System.getProperty("user.home"));
            }
        }
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

    public Logger getPrintlnLogger(){
        if(map.containsKey("printlnLogger")){
            return map.get("printlnLogger");
        }
        Logger logger = LogManager.getLogger("printlnLogger");
        map.put("printlnLogger",logger);
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

    /**
     * 动态设置日志的根目录
     * @return
     */
    public static boolean setLogParentPath(String path){
        if(!new File(path).exists()){
            boolean tag = new File(path).mkdirs();
            if(!tag){
                return tag;
            }
        }
        if(new File(path).isDirectory()){
            System.setProperty("log4j2.home", path);
            org.apache.logging.log4j.core.LoggerContext ctx =
                    (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
            ctx.reconfigure();
            return true;
        }
        return false;
    }

    /**
     * 获取当前环境的日志根目录
     */
    public String getCurLogParentPath(){
        StringBuffer sb = new StringBuffer();
        sb.append(System.getProperties().getProperty("log4j2.home"));
        if(!"null".equals(sb.toString())){
            if(!sb.toString().endsWith(File.separator) && !sb.toString().endsWith("/") && !sb.toString().endsWith("\\")){
                sb.append(File.separator);
            }
        }else{
            sb.setLength(0);
        }
        sb.append("logs");
        return sb.toString();
    }
}
