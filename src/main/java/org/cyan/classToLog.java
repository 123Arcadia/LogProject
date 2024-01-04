package org.cyan;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Data
@NoArgsConstructor
@Slf4j(topic = "classToLog") // private static final Logger logger = LogManager.getLogger( name: "classToLog");
public class classToLog {



    private String name;
    private String age;
    private static int count = 0;

    public classToLog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        log.error("[classToLog]Hello World : " + (++count));
    }


}
