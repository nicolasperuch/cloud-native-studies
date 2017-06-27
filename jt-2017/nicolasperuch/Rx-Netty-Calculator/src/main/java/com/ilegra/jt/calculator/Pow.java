package com.ilegra.jt.calculator;


public class Pow implements Operations{

    @Override
    public double execute(double value1, double value2) {
        return Math.pow(value1, value2);
    }
}
