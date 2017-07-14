package com.github.adrielsoares.java.spring4.calculadora.Configuracao.Operacoes;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by adriel on 05/06/17.
 */
public class MapOperacao {
    private Map<String, Operacao> mapOperacao = new LinkedHashMap<>();

    public Map<String, Operacao> getMapOperacao() {
        return mapOperacao;
    }
}
