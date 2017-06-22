package com.exercise.calculator.model;

import com.exercise.calculator.configuration.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void calculatorSumTest(){
        Assert.assertEquals("3.0 + 7.0 = 10.0",calculator.doCalculation(3,"+",7));
    }
    @Test
    public void calculatorSubstractiocTest(){
        Assert.assertEquals("3.0 - 7.0 = -4.0",calculator.doCalculation(3,"-",7));
    }
    @Test
    public void calculatorMultiplyTest(){
        Assert.assertEquals("3.0 * 7.0 = 21.0",calculator.doCalculation(3,"*",7));
    }
    @Test
    public void calculatorDivisionTest(){
        Assert.assertEquals("Error - Cannot Divide by Zero",calculator.doCalculation(3,"/",0));
        Assert.assertEquals("15.0 / 3.0 = 5.0",calculator.doCalculation(15,"/",3));
    }
    @Test
    public void calculatorPowTest(){
        Assert.assertEquals("2.0 ^ 4.0 = 16.0",calculator.doCalculation(2,"^",4));
    }
    @Test
    public void calculatorNoOperationTest(){
        Assert.assertEquals("Error - Invalid Operation",calculator.doCalculation(1,"a",4));
    }
}
