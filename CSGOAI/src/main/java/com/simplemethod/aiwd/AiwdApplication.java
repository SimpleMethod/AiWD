package com.simplemethod.aiwd;

import ch.qos.logback.classic.BasicConfigurator;
import com.simplemethod.aiwd.AI.CSGO_Classification;
import org.deeplearning4j.ui.api.UIServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiwdApplication {


    public static void main(String[] args) {
       SpringApplication.run(AiwdApplication.class, args);

    }

}
