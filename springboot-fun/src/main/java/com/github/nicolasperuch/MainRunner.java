package com.github.nicolasperuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MainRunner extends SpringBootServletInitializer{

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Central.class, args);
    }

}
