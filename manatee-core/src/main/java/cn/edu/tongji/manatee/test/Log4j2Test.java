package cn.edu.tongji.manatee.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xubing on 15:43 for manatee.
 * <p>
 * I love coding forever
 */

public class Log4j2Test {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("test");
        while(true) {
            logger.info("info");
            logger.debug("debug");
            logger.error("error");
        }
    }
}
