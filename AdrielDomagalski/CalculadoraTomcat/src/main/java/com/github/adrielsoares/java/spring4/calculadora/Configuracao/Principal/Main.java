package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Principal;

    import com.github.adrielsoares.java.spring4.calculadora.Configuracao.ConfiguracaoAPP;
    import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.Calculo;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Adriel on 21/05/2017.
 */

public class Main {
    public static void main(String [] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfiguracaoAPP.class);
        Calculo calculador = (Calculo) applicationContext.getBean("calculo");

        System.out.println(calculador.calculo(5, 5, "+"));
        System.out.println(calculador.calculo(10, 5, "-"));
        System.out.println(calculador.calculo(20, 4, "/"));
        System.out.println(calculador.calculo(20, 0, "/"));
        System.out.println(calculador.calculo(10, 2, "*"));
        System.out.println(calculador.calculo(7, 2, "^"));
        System.out.println(calculador.calculo(8, 5, "+"));

        System.out.println(calculador.getHistoricoMap().getMapHistorico());

        ((AnnotationConfigApplicationContext)applicationContext).close();
    }
}


