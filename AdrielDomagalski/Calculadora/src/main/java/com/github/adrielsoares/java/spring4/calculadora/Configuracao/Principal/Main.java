package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Principal;

import com.github.adrielsoares.java.spring4.calculadora.Configuracao.ConfiguracaoAPP;
import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Calculo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adriel on 21/05/2017.
 */

public class Main {
    public static void main(String [] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfiguracaoAPP.class);
        Calculo calculador = (Calculo) applicationContext.getBean("calculo");

        System.out.println(calculador.calcula(5, 5, "+"));
        System.out.println(calculador.calcula(10, 5, "-"));
        System.out.println(calculador.calcula(20, 4, "/"));
        System.out.println(calculador.calcula(20, 0, "/"));
        System.out.println(calculador.calcula(10, 2, "*"));
        System.out.println(calculador.calcula(7, 2, "^"));
        System.out.println(calculador.calcula(8, 5, "+"));

        System.out.println(calculador.getOpera());

        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}
