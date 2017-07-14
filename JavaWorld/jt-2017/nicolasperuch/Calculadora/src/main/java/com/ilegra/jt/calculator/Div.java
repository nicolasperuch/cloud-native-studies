package com.ilegra.jt.calculator;

import org.springframework.stereotype.Component;

@Component
public class Div implements Operations{

    @Override
    public double execute(double valor1, double valor2) {
        try {
            return valor1 / valor2;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
