import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class LogTest {

    Logger logger = LogManager.getLogger("selfLogger");

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
        logger2.debug("Hello Debug");
    }

    /*异步日志记录，不包含类名和方法名*/
    Logger asyncLogger = LogManager.getLogger("AsyncSelfLogger");
    @Test
    public void testAsyncLog() throws InterruptedException {
        asyncLogger.info("Hello {}","AsyncLogger");

    }
}
