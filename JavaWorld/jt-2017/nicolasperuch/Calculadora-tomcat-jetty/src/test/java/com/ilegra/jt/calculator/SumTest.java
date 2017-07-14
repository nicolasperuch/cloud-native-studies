package com.ilegra.jt.calculator;

import com.ilegra.jt.calculator.Sum;
import com.ilegra.jt.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)

public class SumTest {

    @Autowired
    Sum sum;

    @Autowired
    Calculator calculator;

    @Test
    public void sumHappyPath1(){
        Assert.assertEquals(5,sum.execute(3,2),0);
    }
    @Test
    public void sumHappyPath2(){
        Assert.assertEquals(5,sum.execute(2.25,2.75),0);
    }
    @Test
    public void sumHappyPath3(){
        Assert.assertEquals(5,sum.execute(-3,8),0);
    }
    @Test
    public void sumHappyPath4(){
        Assert.assertEquals(5,sum.execute(-2.50,7.50),0);
    }


    @Test
    public void testCalculator(){
        Assert.assertEquals(8, calculator.doTheMath(5,3,"sum"),0);
    }




}
