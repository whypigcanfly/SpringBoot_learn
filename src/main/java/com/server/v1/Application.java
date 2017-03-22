package com.server.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wanghaoyang on 17-3-21.
 */

@SpringBootApplication
@ComponentScan
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
