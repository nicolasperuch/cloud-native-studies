package com.ilegra.jt.calculator;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class OperationsMap {

    Map<String,Operations> operations = new HashMap<>();

    public Map<String, Operations> getOperation() {
        return operations;
    }

    public double executeOperation(double valor1,double valor2, String operacao){
        Map<String, Operations> operations1 = getOperation();
        return operations1.get(operacao).execute(valor1, valor2);
    }



}
