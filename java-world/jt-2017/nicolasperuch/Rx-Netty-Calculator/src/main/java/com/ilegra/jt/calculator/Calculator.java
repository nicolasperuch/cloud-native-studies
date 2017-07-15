package com.ilegra.jt.calculator;

import com.ilegra.jt.historic.HistoricMap;

public class Calculator {

    OperationsMap operations;

    HistoricMap historicMap;

    public double doTheMath(String operation, double value1, double value2){
        double result = operations.executeOperation(value1, value2, operation);
        historicMap.save(value1, value2, result, operation);
        return result;
    }

    public HistoricMap getHistoricMap() {
        return historicMap;
    }
    public void setOperations(OperationsMap operations) {
        this.operations = operations;
    }
    public void setHistoricMap(HistoricMap historicMap) {
        this.historicMap = historicMap;
    }


}
