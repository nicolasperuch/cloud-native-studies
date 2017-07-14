package com.exercise.calculator.model;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class MapCalculations {

    private Map<String, Operation> mapCalculations = new LinkedHashMap<>();

    public Map<String, Operation> getMapCalculations() {
        return mapCalculations;
    }

}
