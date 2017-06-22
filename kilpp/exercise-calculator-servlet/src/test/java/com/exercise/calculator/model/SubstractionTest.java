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
public class SubstractionTest {

        @Autowired
        private Substraction substraction;

        @Test
        public void substractionTest(){
            Assert.assertEquals(-4,substraction.calculate(3,7), 0.001);
        }
}
