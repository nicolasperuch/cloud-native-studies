package com.ilegra.jt.calculator;

import java.util.HashMap;
import java.util.Map;

public class OperationsMap {

    Map<String, Operations> operations = new HashMap<>();

    public Map<String, Operations> getOperation() {
        return operations;
    }

    public double executeOperation(double value1, double value2, String operation) {
        Map<String, Operations> operations1 = getOperation();
        return operations1.get(operation).execute(value1, value2);
    }

}