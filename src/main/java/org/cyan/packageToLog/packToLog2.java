package org.cyan.packageToLog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class packToLog2 {



    private String name;
    private String age;
    private static int count = 0;


    public void sayHello() {
        log.error("[packToLog2]Hello World : " + (++count));
    }

}
