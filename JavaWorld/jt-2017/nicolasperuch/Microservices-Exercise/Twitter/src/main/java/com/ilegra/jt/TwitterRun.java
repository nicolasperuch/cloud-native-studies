package com.ilegra.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class TwitterRun extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AmountOfTweets.class, args);
    }

}
