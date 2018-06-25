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
}
