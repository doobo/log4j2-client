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
    Logger sqlLogger = LogManager.getLogger("AsyncDBLogger");
    @Test
    public void testSqlLog(){
        sqlLogger.info("Hello, This is Sql Error Log 2!");
        sqlLogger.error("Error Log 2!");
    }

    Logger asyncLogger = LogManager.getLogger("AsyncSelfLogger");
    @Test
    public void testAsyncLog() throws InterruptedException {
        asyncLogger.info("Hello {}","AsyncLogger");
        LoggerTools.getConsoleLogger().error("Hello World Error!");
    }
}
