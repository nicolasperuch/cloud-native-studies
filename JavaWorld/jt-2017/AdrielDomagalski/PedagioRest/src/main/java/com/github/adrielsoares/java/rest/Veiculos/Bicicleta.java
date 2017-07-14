package com.github.adrielsoares.java.rest.Veiculos;

import java.text.DecimalFormat;

/**
 * Created by adriel on 06/06/17.
 */
public class Bicicleta {
    private double valor = 0.45;

    public String printBike(){
        String mostra = "U$" + valor;
        return mostra;
    }

    public String validaPagamentoBike(double dinheiro){
        DecimalFormat df = new DecimalFormat("0.##");
        String mensagem = null;
        if(dinheiro < 0.45){
            double valida = valor - dinheiro;
           return mensagem = "Faltou " + df.format(valida) + " dolares";
        }
        else if(dinheiro == 0.45) {
            return mensagem = "Pagamento realizado com sucesso";
        }
        else if(dinheiro > 0.45){
            double valida = dinheiro - valor;
            return mensagem = "Pagamento realizado com sucesso \n Seu troco " + df.format(valida);
        }

        return mensagem;
    }

}
