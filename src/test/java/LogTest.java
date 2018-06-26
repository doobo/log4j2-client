import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import vip.ipav.log.util.LoggerTools;

public class LogTest {

    Logger logger = LogManager.getLogger("customLogger");

    /*普通文件日志记录*/
    @Test
    public void testLog(){
        logger.info("Hello {}","Info Log");
        logger.error("Hello {}","Error Log");
        logger.debug("Hello {}","Debug Log");
    }

    //数据库日志记录
    /*Logger sqlLogger = LogManager.getLogger("AsyncDBLogger");
    @Test
    public void testSqlLog(){
        sqlLogger.info("Hello, This is Sql Error Log 4!");
        sqlLogger.error("Error Log 4!");
    }*/

    Logger logger2 = LogManager.getLogger(LogTest.class);
    @Test
    public void defaultLog(){
        LoggerTools.getConsoleLogger().debug("Hello Debug");
    }

    /*异步日志记录，不包含类名和方法名*/
    Logger asyncLogger = LogManager.getLogger("AsyncCustomLogger");
    @Test
    public void testAsyncLog() throws InterruptedException {
        asyncLogger.info("Hello {}","AsyncLogger");

    }

    @Test
    public void testTools(){
        LoggerTools.getAsyncSelfLogger().error("Hello Tools Error!");
        LoggerTools.getCustomLogger().info("Hello Tools Info!");
    }
}
