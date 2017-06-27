package com.github.adrielsoares.java.rest.Veiculos;

import java.text.DecimalFormat;

/**
 * Created by adriel on 06/06/17.
 */
public class Carro {
    private double valor = 2.11;

    public String printCarro(){
        String mostra = "U$" + valor;
        return mostra;
    }

    public String validaPagamentoCarro(double dinheiro) {
        DecimalFormat df = new DecimalFormat("0.##");
        String mensagem = null;
        if(dinheiro > 2.11){
            double valida = dinheiro - valor;
            return mensagem = "Carro liberado \n Seu troco: " + df.format(valida);
        }
        else if(dinheiro == 2.11){
            return mensagem = "Carro Liberado";    
        }
        else if(dinheiro < 2.11){
            double valida = valor - dinheiro;
            return mensagem = "Faltou " + df.format(valida) + " dolares";
        }
        return mensagem;
    }
}
