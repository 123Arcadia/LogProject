package org.cyan;

import org.apache.logging.log4j.core.async.AsyncLoggerContextSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 * 从低到高依次是 trace < debug < info < warn < error
 */
public class App {

    public static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
//        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000/2; i++) {
            logger.error("[error]Hello World!"+i);
            logger.info("[info] Hello zcw!");
            System.out.println("Hello World! " + i);
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

}
