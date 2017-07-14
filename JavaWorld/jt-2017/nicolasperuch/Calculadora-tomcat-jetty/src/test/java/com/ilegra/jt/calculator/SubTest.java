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
public class SubTest {

    @Autowired
    Sub sub;

    @Test
    public void subHappyPath1(){
        Assert.assertEquals(2,sub.execute(5,3),0);
    }
    @Test
    public void subHappyPath2(){
        Assert.assertEquals(-2,sub.execute(6,8),0);
    }
    @Test
    public void subHappyPath3(){
        Assert.assertEquals(2,sub.execute(-4.5,-6.5),0);
    }
    @Test
    public void subHappyPath4(){
        Assert.assertEquals(2,sub.execute(11.00000000,9),0);
    }
}
