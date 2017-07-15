package com.github.matheusbritzke.java.spring4.calculator.ConfigurationApp;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Calculator;
import com.github.matheusbritzke.java.spring4.calculator.Functions.*;
import com.github.matheusbritzke.java.spring4.calculator.Maps.HistoryOperations;
import com.github.matheusbritzke.java.spring4.calculator.Maps.MapOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@ComponentScan(basePackages = "com.github.matheusbritzke.java.spring4.calculator")

public class AppConfig {

    @Bean
    public Calculator calculator(){
        Calculator calculator = new Calculator(new MapOperations(),new HistoryOperations());
        return calculator;
    }

    @Bean
    public MapOperations mapOperations(){
        MapOperations operations = new MapOperations();
        operations.getMapOperations().put("+", new Sum());
        operations.getMapOperations().put("-", new Subtraction());
        operations.getMapOperations().put("*", new Multiply());
        operations.getMapOperations().put("/", new Division());
        operations.getMapOperations().put("^", new Pow());
        return operations;
    }

    @Bean
    public HistoryOperations historyOperations(){
        HistoryOperations history = new HistoryOperations();
        history.getHistoryOperations().put("+", new ArrayList<>());
        history.getHistoryOperations().put("-", new ArrayList<>());
        history.getHistoryOperations().put("*", new ArrayList<>());
        history.getHistoryOperations().put("/", new ArrayList<>());
        history.getHistoryOperations().put("^", new ArrayList<>());
        history.getHistoryOperations().put("Invalid Operation", new ArrayList<>());
        return history;
    }

}
