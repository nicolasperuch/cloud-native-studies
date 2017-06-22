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
public class PowTest {

    @Autowired
    Pow pow;

    @Test
    public void powHappyPath1(){
        Assert.assertEquals(8, pow.execute(2,3),0);
    }
    @Test
    public void powHappyPath2(){
        Assert.assertEquals(1, pow.execute(2,0),0);
    }
    @Test
    public void powHappyPath3(){
        Assert.assertEquals(0.5, pow.execute(2,-1),0);
    }
    @Test
    public void powHappyPatj4(){
        Assert.assertEquals(-8, pow.execute(-2,3),0);
    }

}
