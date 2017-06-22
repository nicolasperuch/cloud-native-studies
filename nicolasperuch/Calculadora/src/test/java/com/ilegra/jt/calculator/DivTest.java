package com.ilegra.jt.calculator;

import com.ilegra.jt.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DivTest {

    @Autowired
    Div div;

    @Test
    public void divHappyPath1(){
        Assert.assertEquals(4, div.execute(20,5),0);
    }
    @Test
    public void divHappyPath2(){
        Assert.assertEquals(4, div.execute(-20,-5),0);
    }
    @Test
    public void divHappyPath3(){
        Assert.assertEquals(-4, div.execute(-20,5.000000),0);
    }
}
