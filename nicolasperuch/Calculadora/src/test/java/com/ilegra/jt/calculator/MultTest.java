package com.ilegra.jt.calculator;

import com.ilegra.jt.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MultTest {

    @Autowired
    Mult mult;

    @Test
    public void multHappyPath1(){
        Assert.assertEquals(15,mult.execute(3,5),0);
    }
    @Test
    public void multHappyPath2(){
        Assert.assertEquals(15,mult.execute(-5,-3),0);
    }
    @Test
    public void multHappyPath3(){
        Assert.assertEquals(15,mult.execute(-5,-3.0000),0);
    }


}
