package com.exercise.calculator.model;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Operation{
    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}

