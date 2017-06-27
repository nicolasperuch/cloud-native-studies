package com.ilegra.jt.main;

import com.ilegra.jt.calculator.Calculator;
import com.ilegra.jt.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main (String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");

        System.out.println(calculator.doTheMath(2,10,"pow"));
        System.out.println(calculator.doTheMath(2,0,"div"));
        System.out.println(calculator.doTheMath(2,9,"pow"));
        System.out.println(calculator.doTheMath(2,5,"pow"));
        System.out.println(calculator.doTheMath(2,2,"div"));

        calculator.showHistoric();
    }
}
