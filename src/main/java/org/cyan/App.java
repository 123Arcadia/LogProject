package org.cyan;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;
import org.cyan.packageToLog.packToLog;
import org.cyan.packageToLog.packToLog2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 * 从低到高依次是 trace < debug < info < warn < error
 */
public class App {

    public static final Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * 打印某一方法日志
      */
    public static final Logger methodToLog = LoggerFactory.getLogger("methodToLog");
    public static void main(String[] args) {
//        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        long start = System.currentTimeMillis();
        classToLog classToLog = new classToLog();
        packToLog packToLog = new packToLog();
        packToLog2 packToLog2 = new packToLog2();
        for (int i = 0; i < 1_000_000/10; i++) {
            logger.error("[error_App]Hello World!"+i);
            logger.info("[info_App] Hello zcw!");
            System.out.println("Hello World! " + i);
            // 只打印classToLog类下的log
            classToLog.sayHello();
            // 只打印包下的log
            packToLog.sayHello();
            packToLog2.sayHello();
            test_methodToLog();
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
        // 耗时err: 2899 ms
        logger.error("耗时err: " + (System.currentTimeMillis() - start) + " ms");
        // 耗时: 2899 ms / 3668 ms
        // 可以查看是否为异步日志
        logger.info("是否为异步日志：{}", AsyncLoggerContextSelector.isSelected());
        // 是否为异步日志：true
        System.out.println("log Async:"+AsyncLoggerContextSelector.isSelected());
        // log Async:true
    }

    /**
     * 打印某一方法日志
     */
    public static void test_methodToLog() {
        methodToLog.error("[methodToLog] ");
    }

}
