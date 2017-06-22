package com.ilegra.jt.calculator;

import org.springframework.stereotype.Component;

@Component
public class Pow implements Operations{

    @Override
    public double execute(double valor1, double valor2) {
        return Math.pow(valor1, valor2);
    }
}
