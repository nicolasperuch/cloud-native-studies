package com.github.matheusbritzke.java.spring4.calculator.Maps;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Operations;
import com.github.matheusbritzke.java.spring4.calculator.Functions.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapOperations {

    private Map<String, Operations> mapOperations =  new HashMap<>();

    public Map<String, Operations> getMapOperations() {
        return mapOperations;
    }
}
