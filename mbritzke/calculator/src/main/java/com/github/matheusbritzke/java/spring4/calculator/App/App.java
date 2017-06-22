package com.github.matheusbritzke.java.spring4.calculator.App;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Calculator;
import com.github.matheusbritzke.java.spring4.calculator.ConfigurationApp.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String args[]){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator useCalculator = (Calculator) applicationContext.getBean("calculator");

        System.out.println(useCalculator.calculate(2, 2, "+"));
        System.out.println(useCalculator.calculate(4, 3, "-"));
        System.out.println(useCalculator.calculate(8, 2, "*"));
        System.out.println(useCalculator.calculate(6, 2, "/"));
        System.out.println(useCalculator.calculate(6, 0, "/"));
        System.out.println(useCalculator.calculate(7, 4, "C"));
        System.out.println(useCalculator.calculate(5, 2, "^"));
        System.out.println(useCalculator.calculate(10, 2, "+"));

        useCalculator.showHistoryByOperation("Invalid Operation");
        useCalculator.showHistoryByOperation("+");

        useCalculator.showHistory();

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
