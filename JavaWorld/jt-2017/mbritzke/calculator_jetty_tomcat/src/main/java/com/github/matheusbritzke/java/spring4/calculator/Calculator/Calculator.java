package com.github.matheusbritzke.java.spring4.calculator.Calculator;

import com.github.matheusbritzke.java.spring4.calculator.Maps.HistoryOperations;
import com.github.matheusbritzke.java.spring4.calculator.Maps.MapOperations;
import org.springframework.beans.factory.annotation.Autowired;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class Calculator {

    private MapOperations mapOperations;
    private HistoryOperations historyOperations;

    @Autowired
    public Calculator(MapOperations mapOperations, HistoryOperations historyOperations){
        this.historyOperations = historyOperations;
        this.mapOperations = mapOperations;
    }

    public String calculate(double firstNumber, double secondNumber, String operation) {
        try {
            boolean validateOperator = validateOperation(operation);
            if(validateOperator){
                double ans = mapOperations.getMapOperations().get(operation).calculate(firstNumber, secondNumber);
                if (ans == Infinity){
                    saveOperations(firstNumber, secondNumber, operation, "Error, division by zero");
                    return "Error, division by zero";
                }
                saveOperations(firstNumber, secondNumber, operation, String.valueOf(ans));
                return String.valueOf(ans);
            }
        }catch (Exception exception){
            saveOperations(firstNumber, secondNumber, "Invalid Operation", "Erro");
        }
        return "Erro";
    }

    private boolean validateOperation(String operation) {
        String typeOfOperation = "+-*/^";
        return typeOfOperation.contains(operation);
    }

    private void saveOperations(double firstNumber, double secondNumber, String operation, String ans) {
        String completeOperation = firstNumber + " "+ operation + " " + secondNumber + " = " + ans;
        historyOperations.getHistoryOperations().get(operation).add(completeOperation);
    }

    public String showHistory(){
        StringBuilder ans = new StringBuilder();
        for(String aux: historyOperations.getHistoryOperations().keySet())
            ans.append(historyOperations.getHistoryOperations().get(aux) + "\n");
        return ans.toString();
    }

    public String showHistoryByOperation(String operation) {
        StringBuilder ans = new StringBuilder();
        for(String aux: historyOperations.getHistoryOperations().keySet())
            if (aux.contains(operation))
                ans.append(historyOperations.getHistoryOperations().get(aux) + "\n");
        return ans.toString();
    }
}
