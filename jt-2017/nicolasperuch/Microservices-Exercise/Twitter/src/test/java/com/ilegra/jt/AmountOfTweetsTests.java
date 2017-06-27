package com.ilegra.jt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TwitterConfigTest.class)
public class AmountOfTweetsTests {

    @Autowired
    AmountOfTweets amountOfTweets;
    @Autowired
    ExternalResponse externalResponse;

    @Test
    public void getTweetsHappyPathTest(){
        when(externalResponse.numberOfTweets("devperuch")).thenReturn(3);
        Assert.assertEquals("@devperuch - Tweets: 3",amountOfTweets.getTweets("devperuch"));
    }
    @Test
    public void getTweetsWonderfulPathTest(){
        when(externalResponse.numberOfTweets("devp22211eruch")).thenReturn(-1);
        Assert.assertEquals("Sorry, We had some mistakes to find your twitter",amountOfTweets.getTweets("devp22211eruch"));
    }

}
