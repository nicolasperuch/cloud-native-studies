package com.exercise.calculator.model;
import org.springframework.stereotype.Component;

@Component
public class Pow implements Operation {
    @Override
    public double calculate(double x, double y) throws ArithmeticException {
        return Math.pow(x, y);
}
}
