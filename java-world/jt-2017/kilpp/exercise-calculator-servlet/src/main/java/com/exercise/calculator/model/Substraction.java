package com.exercise.calculator.model;
import org.springframework.stereotype.Component;

@Component
public class Substraction implements Operation{
    @Override
    public double calculate(double x, double y) {
        return x - y;
    }
}
