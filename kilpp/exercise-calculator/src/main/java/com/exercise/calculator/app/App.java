package com.exercise.calculator.app;

import com.exercise.calculator.configuration.AppConfig;
import com.exercise.calculator.model.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class App {
    public static void main(String args []){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");
        System.out.println(calculator.getMapHistory().getMapHistory());

        System.out.println(calculator.doCalculation(3,"/",0));
        System.out.println(calculator.doCalculation(3,"/",9));
        System.out.println(calculator.doCalculation(3,"+",9));
        System.out.println(calculator.doCalculation(3,"-",9));
        System.out.println(calculator.doCalculation(3,"*",9));
        System.out.println(calculator.doCalculation(3,"^",9));
        System.out.println(calculator.doCalculation(3,"a",9));
        System.out.println(calculator.doCalculation(120,"+",9));
        System.out.println(calculator.getMapHistory().getMapHistory());
    }
}
