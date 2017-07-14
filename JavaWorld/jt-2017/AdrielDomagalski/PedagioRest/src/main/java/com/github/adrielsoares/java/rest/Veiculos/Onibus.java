package com.github.adrielsoares.java.rest.Veiculos;

import java.text.DecimalFormat;

/**
 * Created by adriel on 06/06/17.
 */
public class Onibus {
    private double valor = 1.59;

    public String printOnibus(){
        String mostra = "U$" + valor;
        return mostra;
    }

    public String validaPagamentoOnibus(double dinheiro) {
        DecimalFormat df = new DecimalFormat("0.##");
        String mensagem = null;
        if(dinheiro < 1.59){
            double valida = valor - dinheiro;
            return mensagem = "Faltou " + df.format(valida) + " dolares";
        }
        else if(dinheiro == 1.59) {
            return mensagem = "Pagamento realizado com sucesso";
        }
        else if(dinheiro > 1.59){
            double valida = dinheiro - valor;
            return mensagem = "Pagamento realizado com sucesso \n Seu troco " + df.format(valida);
        }

        return mensagem;
    }
}
