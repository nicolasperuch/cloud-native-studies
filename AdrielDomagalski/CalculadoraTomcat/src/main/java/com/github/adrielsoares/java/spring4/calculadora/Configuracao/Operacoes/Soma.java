package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes;

/**
 * Created by Adriel on 21/05/2017.
 */
public class Soma implements Operacao {
    @Override
    public double calcula(double num1, double num2) {
       return num1 + num2;
    }

}
