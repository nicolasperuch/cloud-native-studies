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
public class SumTest {

    @Autowired
    private Sum sum;

    @Test
    public void sumTest(){
        Assert.assertEquals(10,sum.calculate(3,7), 0.001);
    }

}
