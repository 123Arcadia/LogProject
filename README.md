# LogProject
Async-Log 使用slf4j+log4j2实现异步log打印

依赖:
```xml
      <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.11.1</version>
      </dependency>
      <!--使用slf4j作为日志的门面,使用log4j2来记录日志 -->
      <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
      </dependency>
      <!--为slf4j绑定日志实现 log4j2的适配器 -->
      <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-slf4j-impl</artifactId>
        <version>2.10.0</version>
      </dependency>
      <!-- 日志异步 -->
      <dependency>
          <groupId>com.lmax</groupId>
          <artifactId>disruptor</artifactId>
          <version>3.3.7</version>
      </dependency>

      <!--注意:要排除slg4j-log4j12这个依赖-->
```
### 踩坑记录:

1. 为什么使用eclipse导出的jar运行没有采用resources下的`log4j2.xml`配置输出?

**解决**: eclipse似乎对jar运行后resources下文件不起作用，把`log4j2.xml`和`log4j2.component.properties`必须和jar保持同目录下
    在运行命令:

```shell
> java -jar -Xms1024m -Xmx1536m -XX:PermSize=128MXX:MaxPermSize=256M ***.jar
```

