package com.exercise.calculator.model;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class MapHistory {

    private Map<String, List<String>> mapHistory = new LinkedHashMap<>();

    public Map<String, List<String>> getMapHistory() {
        return mapHistory;
    }

}


