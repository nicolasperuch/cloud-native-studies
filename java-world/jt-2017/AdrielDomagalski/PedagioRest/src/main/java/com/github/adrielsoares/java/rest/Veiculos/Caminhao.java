package com.github.adrielsoares.java.rest.Veiculos;

import java.text.DecimalFormat;

/**
 * Created by adriel on 06/06/17.
 */
public class Caminhao {
    private double valor = 3.95;

    public String printCaminhao(int eixoExtra){
        String mostra = "U$" + (valor  * eixoExtra);
        return mostra;
    }

    public String validaPagamentoCaminhao(int eixoExtra, double dinheiro) {
        DecimalFormat df = new DecimalFormat("0.##");
        double valida = valor * eixoExtra;
        String mensagem = null;
        if(eixoExtra == 0){
            return  mensagem = "Você precisa adicionar um eixo pelo menos";
        }
        if(dinheiro < valida){
            double aux = valida - dinheiro;
            return mensagem = "Faltou " + df.format(aux) + " dolares";
        }
        else if(dinheiro == valida) {
            return mensagem = "Pagamento realizado com sucesso";
        }
        else if(dinheiro > valida){
            double aux = dinheiro - valida;
            return mensagem = "Pagamento realizado com sucesso \nSeu troco " + df.format(aux);
        }

        return mensagem;
    }
}
