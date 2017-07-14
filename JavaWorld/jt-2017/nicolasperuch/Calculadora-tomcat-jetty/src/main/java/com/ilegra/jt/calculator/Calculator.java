package com.ilegra.jt.calculator;

import com.ilegra.jt.historic.HistoricMap;

public class Calculator {

    OperationsMap operations;

    HistoricMap historicMap;

    public double doTheMath(double valor1, double valor2, String operacao){
        double result = operations.executeOperation(valor1, valor2, operacao);
        historicMap.save(valor1, valor2, result, operacao);
        return result;
    }

    public void showHistoric(){
        historicMap.print();
    }

    public void setOperations(OperationsMap operations) {
        this.operations = operations;
    }
    public void setHistoricMap(HistoricMap historicMap) {
        this.historicMap = historicMap;
    }
}
