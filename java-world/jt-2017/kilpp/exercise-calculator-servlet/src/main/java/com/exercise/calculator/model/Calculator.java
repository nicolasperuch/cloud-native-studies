package com.exercise.calculator.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class Calculator {
    private MapCalculations mapCalculations;
    private MapHistory mapHistory;

    @Autowired
    public Calculator(MapCalculations mapCalculations, MapHistory mapHistory) {
        this.mapCalculations=mapCalculations;
        this.mapHistory=mapHistory;
    }

    public String doCalculation(double x, String operation, double y) {
        if (validateOperation(operation) && !validateDivisionByZero(operation, y)) {
            double calculateAux = mapCalculations.getMapCalculations().get(operation).calculate(x, y);
            saveCalculation(x, operation, y, calculateAux);
            return x + " " + operation + " " + y + " = " + calculateAux;
        } else if (validateDivisionByZero(operation, y)) {
            mapHistory.getMapHistory().get("/").add(x + " " + operation + " " + y + " = " + "Cannot Divide by Zero");
            return "Error - Cannot Divide by Zero";
        } else {
            mapHistory.getMapHistory().get("Error").add(x + " " + operation + " " + y + " = " + "Error - Invalid Operation");
            return "Error - Invalid Operation";
        }
    }


    public void saveCalculation(double x, String operation, double y, double calculateAux) {
        String saveCalculation = x + " " + operation + " " + y + " = " + calculateAux;
        getMapHistory().getMapHistory().get(operation).add(saveCalculation);
    }

    public boolean validateOperation(String operation) {
        String validateOperations = "+-*/^";
        return validateOperations.contains(operation);
    }

    public boolean validateDivisionByZero(String operation, double y) {
        String division = "/";
        return operation.contains(division) && y == 0;
    }

    public MapHistory getMapHistory() {
        return mapHistory;
    }


}




