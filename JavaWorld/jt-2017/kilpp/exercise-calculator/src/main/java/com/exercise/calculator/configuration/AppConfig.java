package com.exercise.calculator.configuration;
import com.exercise.calculator.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;


@Configuration
@ComponentScan(basePackages = "com.exercise.calculator.model")
public class AppConfig {

    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator(mapCalculations(), mapHistory());
        return calculator;
    }

    @Bean
    public MapCalculations mapCalculations() {
        MapCalculations mapCalculations = new MapCalculations();
        mapCalculations.getMapCalculations().put("+", new Sum());
        mapCalculations.getMapCalculations().put("-", new Substraction());
        mapCalculations.getMapCalculations().put("*", new Multiply());
        mapCalculations.getMapCalculations().put("/", new Division());
        mapCalculations.getMapCalculations().put("^", new Pow());
        return mapCalculations;
    }

    @Bean
    public MapHistory mapHistory() {
        MapHistory mapHistory = new MapHistory();
        mapHistory.getMapHistory().put("+", new ArrayList<>());
        mapHistory.getMapHistory().put("-", new ArrayList<>());
        mapHistory.getMapHistory().put("*", new ArrayList<>());
        mapHistory.getMapHistory().put("/", new ArrayList<>());
        mapHistory.getMapHistory().put("^", new ArrayList<>());
        mapHistory.getMapHistory().put("Error", new ArrayList<>());
        return mapHistory;
    }


}

