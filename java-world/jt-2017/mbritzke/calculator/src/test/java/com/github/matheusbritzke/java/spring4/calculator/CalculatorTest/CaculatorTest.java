package com.github.matheusbritzke.java.spring4.calculator.CalculatorTest;

import com.github.matheusbritzke.java.spring4.calculator.Calculator.Calculator;
import com.github.matheusbritzke.java.spring4.calculator.ConfigurationApp.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class CaculatorTest {

    @Autowired
    Calculator calculatorTest;

    @Test
    public void sum(){
        String sum = calculatorTest.calculate(2,2,"+");
        Assert.assertEquals(sum, "4.0");
    }

    @Test
    public void sub(){
        String sub = calculatorTest.calculate(2, 2, "-");
        Assert.assertEquals(sub, "0.0");
    }

    @Test
    public void mult(){
        String mult = calculatorTest.calculate(3,3, "*");
        Assert.assertEquals(mult, "9.0");
    }

    @Test
    public void div(){
        String div = calculatorTest.calculate(3, 3, "/");
        Assert.assertEquals(div, "1.0");
    }

    @Test
    public void pow(){
        String pow = calculatorTest.calculate(3, 3, "^");
        Assert.assertEquals(pow, "27.0");
    }

    @Test
    public void divisionByZero(){
        String divZero = calculatorTest.calculate(4,0,"/");
        Assert.assertEquals("Error, division by zero",divZero);
    }

    @Test
    public void invalidOperation(){
        String ans = calculatorTest.calculate(2,2,"a");
        Assert.assertEquals("Erro", ans);
    }
}
