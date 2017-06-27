package com.github.adrielsoares.java.rest.Operacoes;

import javax.ws.rs.core.Response;

/**
 * Created by adriel on 06/06/17.
 */
public interface Pedagio {

    Response pagamentoCarro(double valor);
    Response pagamentoCarro();
    Response pagamentoOnibus(double valor);
    Response pagamentoOnibus();
    Response pagamentoBicicleta(double valor);
    Response pagamentoBicicleta();
    Response PagamentoMoto(double valor);
    Response PagamentoMoto();
    Response PagamentoCaminhao(int eixoAdicional, double valor);
    Response PagamentoCaminhao(int eixoAdicional);
}
