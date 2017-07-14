package com.gradle.exercise.springtwitter.exercisetwitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TweetCountConfigTest.class)
public class TweetCountApplicationTests {

	@Autowired
	private TweetCountService tTweetCountService;

	@Autowired Tweets tweets;

	@Test
	public void tweetCountServiceTest() throws IOException {
		when(tweets.tweetCount("kilpp")).thenReturn("@kilpp NUMBER OF TWEETS: " + 1);
		Assert.assertEquals("@kilpp NUMBER OF TWEETS: " + 1, tweets.tweetCount("kilpp"));
	}

    @Test
    public void tweetCountNotFoundServiceTest() throws IOException {
        when(tweets.tweetCount("kilpp")).thenReturn("User Not Found");
        Assert.assertEquals("User Not Found", tweets.tweetCount("kilpp"));
    }


}
