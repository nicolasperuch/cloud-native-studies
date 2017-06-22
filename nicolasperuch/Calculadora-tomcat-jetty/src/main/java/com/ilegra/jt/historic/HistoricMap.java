package com.ilegra.jt.historic;

import java.util.*;

public class HistoricMap {

    Map<String, List<String>> historicMap = new HashMap<>();

        public void save (double valor1, double valor2, double result, String operacao){
            historicMap.get(operacao).add(valor1+" "+operacao+" "+valor2+" = "+result);
        }

        public void print(){

            for(String print :historicMap.keySet()) {
                System.out.println(print);
                System.out.println(historicMap.get(print));
            }

        }

    public Map<String, List<String>> getHistoricMap() {
        return historicMap;
    }
}

