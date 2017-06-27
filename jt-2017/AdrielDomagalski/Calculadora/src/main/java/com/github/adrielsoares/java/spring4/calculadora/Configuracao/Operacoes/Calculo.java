package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes;

import com.github.adrielsoares.java.spring4.calculadora.Configuracao.ConfiguracaoAPP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ilegra0267 on 23/05/2017.
 */

public class Calculo {
    private ConfiguracaoAPP configuracao;
    private Map<String, Operacao> operacaoMap = new HashMap<>();
    private Map<String, List> opera = new HashMap<>();

    public Map<String, List> getOpera() {
        return opera;
    }

    public Map<String, Operacao> getOperacaoMap() {
        return operacaoMap;
    }

    public Double calcula(double num1, double num2, String op) {
        if (ValidaDivisao(num2, op)) {
            String erro = "Operacao de divisao por zero invalida  ";
            System.out.print(erro);
            salvaOperacao(erro);
        } else {
            double aux = operacaoMap.get(op).calcula(num1, num2);
            salvaOperacao(num1, num2, op, aux);
            return aux;
        }
        return 0.0;
    }

    public void salvaOperacao(String erro){
        opera.get("er").add(erro);
    }

    public void salvaOperacao(double num1, double num2, String op, double aux){
        try {
            String salva = num1 + "" + op + "" + num2 + "=" + aux;
            opera.get(op).add(salva);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
    }

    public boolean ValidaDivisao(double num2, String op){
        return num2 == 0 && op == "/";
    }


}
