package com.ilegra.jts.spring.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adriel on 02/06/2017.
 */
public class ListaServico {
    Map<Integer, List<Object>> petServico = new HashMap<>();

    public Map<Integer, List<Object>> getPetServico() {
        return petServico;
    }

    public void setPetServico(Map<Integer, List<Object>> petServico) {
        this.petServico = petServico;
    }
}
