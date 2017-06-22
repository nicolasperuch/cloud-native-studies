package com.ilegra.jt.config;

import com.ilegra.jt.calculator.*;
import com.ilegra.jt.historic.HistoricMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
@ComponentScan(basePackages = "com.ilegra.jt")

public class AppConfig {

    @Bean
    public Calculator calculator() {
        Calculator calculator = new Calculator();
        calculator.setHistoricMap(historicMap());
        calculator.setOperations(operationsMap());
        return calculator;
    }

    @Bean
    public OperationsMap operationsMap() {
        OperationsMap operationsMap = new OperationsMap();

        operationsMap.getOperation().put("sum", new Sum());
        operationsMap.getOperation().put("sub", new Sub());
        operationsMap.getOperation().put("mult", new Mult());
        operationsMap.getOperation().put("div", new Div());
        operationsMap.getOperation().put("pow", new Pow());

        return operationsMap;
    }

    @Bean
    public HistoricMap historicMap(){
        HistoricMap historicMap = new HistoricMap();

        historicMap.getHistoricMap().put("sum", new ArrayList<>());
        historicMap.getHistoricMap().put("sub", new ArrayList<>());
        historicMap.getHistoricMap().put("mult", new ArrayList<>());
        historicMap.getHistoricMap().put("div", new ArrayList<>());
        historicMap.getHistoricMap().put("pow", new ArrayList<>());

        return historicMap;
    }
}
