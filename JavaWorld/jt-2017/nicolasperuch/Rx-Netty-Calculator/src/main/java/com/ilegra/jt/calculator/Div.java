package com.ilegra.jt.calculator;


public class Div implements Operations{

    @Override
    public double execute(double value1, double value2) {
        try {
            return value1 / value2;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
