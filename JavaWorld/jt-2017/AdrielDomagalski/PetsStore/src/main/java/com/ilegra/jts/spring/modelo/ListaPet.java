package com.ilegra.jts.spring.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adriel on 31/05/2017.
 */
public class ListaPet {
    Map<Integer, Pet> listaPet = new HashMap<>();

    public Map<Integer, Pet> getListaPet() {
        return listaPet;
    }

    public void setListaPet(Map<Integer, Pet> listaPet) {
        this.listaPet = listaPet;
    }
}
