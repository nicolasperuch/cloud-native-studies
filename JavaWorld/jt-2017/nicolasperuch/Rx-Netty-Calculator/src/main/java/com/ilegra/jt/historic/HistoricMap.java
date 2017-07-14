package com.ilegra.jt.historic;

import java.util.*;

public class HistoricMap {

    Map<String, List<String>> historicMap = new HashMap<>();

    public void save (double value1, double value2, double result, String operation){
        historicMap.get(operation).add(value1+" "+operation+" "+value2+" = "+result);
    }

    public Map<String, List<String>> getHistoricMap() {
        return historicMap;
    }
}

