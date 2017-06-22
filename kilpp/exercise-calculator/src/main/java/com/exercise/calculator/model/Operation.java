package com.exercise.calculator.model;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface Operation{
     double calculate(double x, double y);
}
