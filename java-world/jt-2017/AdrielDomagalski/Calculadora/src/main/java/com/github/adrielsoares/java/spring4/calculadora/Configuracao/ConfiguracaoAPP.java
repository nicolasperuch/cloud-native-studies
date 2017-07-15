package com.github.adrielsoares.java.spring4.calculadora.Configuracao;

import com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adriel on 21/05/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.github.adrielsoares.java.spring4.calculadora.Operacoes")
public class ConfiguracaoAPP {
    // is

    @Bean
    public Calculo calculo(){
        Calculo calculo = new Calculo();

        calculo.getOperacaoMap().put("+", new Soma());
        calculo.getOperacaoMap().put("-", new Subtracao());
        calculo.getOperacaoMap().put("*", new Multiplicacao());
        calculo.getOperacaoMap().put("/", new Divisao());
        calculo.getOperacaoMap().put("^", new Potencia());

        calculo.getOpera().put("+", new ArrayList());
        calculo.getOpera().put("-", new ArrayList());
        calculo.getOpera().put("*", new ArrayList());
        calculo.getOpera().put("/", new ArrayList());
        calculo.getOpera() .put("^", new ArrayList());
        calculo.getOpera().put("er", new ArrayList());

        return calculo;
    }
}

