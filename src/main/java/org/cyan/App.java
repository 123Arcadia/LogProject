package org.cyan;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.async.*;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.cyan.packageToLog.packToLog;
import org.cyan.packageToLog.packToLog2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Properties;


/**
 * Hello world!
 * 从低到高依次是 trace < debug < info < warn < error
 */
public class App {

    public static final Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * 打印某一方法日志
      */
//    public static final Logger methodToLog = LoggerFactory.getLogger("methodToLog");
    public static void main(String[] args) {
//        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        long start = System.currentTimeMillis();
        classToLog classToLog = new classToLog();
        packToLog packToLog = new packToLog();
        packToLog2 packToLog2 = new packToLog2();
        for (int i = 0; i < 1_000_000/1; i++) {
            if (i%2==0) {
                logger.error("[error_App]Hello World!"+i);
            }
            logger.info("[info_App] Hello zcw!"+i);
//            System.out.println("Hello World! " + i);
//            // 只打印classToLog类下的log
//            classToLog.sayHello();
//            // 只打印包下的log
//            packToLog.sayHello();
//            packToLog2.sayHello();
//            test_methodToLog();
        }
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
        // 耗时err: 2899 ms
        logger.error("耗时err: " + (System.currentTimeMillis() - start) + " ms");
        // 耗时: 2899 ms / 3668 ms
        // 可以查看是否为异步日志
        logger.info("是否为异步日志：{}", AsyncLoggerContextSelector.isSelected());
        // 是否为异步日志：true
        System.err.println("是否为异步日志 log Async:"+AsyncLoggerContextSelector.isSelected());
        // log Async:true


//        logger.error("[log4j2]"+System.getProperty("log4j2.asyncLoggerRingBufferSize"));
//        logger.error("[log4j2]"+System.getProperty("log4jContextSelector"));

//        logger.error("[log4j2]"+System.getProperty(LOG4J_DISCARD_THRESHOLD));

    }

    /**
     * 打印某一方法日志
     */
//    public static void test_methodToLog() {
//        methodToLog.error("[methodToLog] ");
//    }

    @Test
    public void test() {

        Properties properties = PropertiesUtil.getSystemProperties();
        System.out.println("properties = " + properties);
        //properties = {}

        PropertiesUtil proUtil = PropertiesUtil.getProperties();
        String property = PropertiesUtil.getProperties().getStringProperty(
//                "AsyncLoggerConfig.RingBufferSize");
                "log4j2.asyncLoggerRingBufferSize");
        System.out.println("property = " + property);
        //property = 524288
//
//        try {
//            Field environment = proUtil.getClass().getDeclaredField("environment");
//            environment.setAccessible(true);
//            Object literal = environment.get(environment);
//            System.out.println("literal = " + literal);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
