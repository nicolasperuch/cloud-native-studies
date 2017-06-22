package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ilegra0267 on 23/05/2017.
 */

public class Calculo {
    private MapOperacao operacaoMap;

    private MapHistorico historicoMap;

    public MapOperacao getOperacaoMap() {
        return operacaoMap;
    }

    public MapHistorico getHistoricoMap() {
        return historicoMap;
    }

    @Autowired
    public Calculo(MapOperacao operacaoMap, MapHistorico historicoMap ) {
        this.operacaoMap = operacaoMap;
        this.historicoMap = historicoMap;
    }

    public String calculo(double num1, double num2, String op) {
        if (validaOperacao(op) && !validaDivisao(num2, op)) {
            double aux = operacaoMap.getMapOperacao().get(op).calcula(num1, num2);
            salvaOperacao(num1, num2, op, aux);
            return num1 + " " + num2 + " " + op + " = " + aux;
        } else{
            System.out.println("Erro ao fazer o calculo");
            salvaOperacao("er");
        }

        return "Erro operacao em valida";
    }


    public void salvaOperacao(String erro){
        historicoMap.getMapHistorico().get("er").add(erro);
    }

    public void salvaOperacao(double num1, double num2, String op, double aux){
        try {
            String salva = num1 + "" + op + "" + num2 + "=" + aux;
            historicoMap.getMapHistorico().get(op).add(salva);
        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
    }

    public boolean validaDivisao(double num2, String op){
        return num2 == 0 && op == "/";
    }

    public boolean validaOperacao( String op){
        String validaOp = "+-*/^";
        return validaOp.contains(op);
    }

}
