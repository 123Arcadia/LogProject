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
```
