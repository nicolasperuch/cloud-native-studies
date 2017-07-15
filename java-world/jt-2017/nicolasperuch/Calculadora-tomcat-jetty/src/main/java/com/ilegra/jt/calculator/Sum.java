package com.ilegra.jt.calculator;

import org.springframework.stereotype.Component;

@Component
public class Sum implements Operations {

    @Override
    public double execute(double valor1, double valor2) {
        return valor1 + valor2;
    }
}
