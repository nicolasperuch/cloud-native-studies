package com.github.matheusbritzke.java.spring4.calculator.Functions;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Operations;
import org.springframework.stereotype.Component;

@Component
public class Division implements Operations {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        double answer;
        answer = firstNumber / secondNumber;
        return answer;
    }
}
