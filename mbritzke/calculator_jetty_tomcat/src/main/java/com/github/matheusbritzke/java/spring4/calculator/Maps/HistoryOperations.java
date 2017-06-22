package com.github.matheusbritzke.java.spring4.calculator.Maps;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HistoryOperations {

    private Map<String, List<String>> historyOperations = new HashMap<>();

    public Map<String, List<String>> getHistoryOperations() {
        return historyOperations;
    }
}
