package com.github.matheusbritzke.java.spring4.calculator.Functions;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Operations;
import org.springframework.stereotype.Component;

@Component
public class Pow implements Operations {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return Math.pow(firstNumber, secondNumber);
    }
}
