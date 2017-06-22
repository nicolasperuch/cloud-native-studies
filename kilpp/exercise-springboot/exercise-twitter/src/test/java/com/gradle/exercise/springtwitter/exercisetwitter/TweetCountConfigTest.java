package com.gradle.exercise.springtwitter.exercisetwitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import twitter4j.Twitter;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TweetCountConfigTest {

    @Bean
    public Twitter twitter(){
        return mock(Twitter.class);
    }

    @Bean
    public TweetCountService tweetCountService(){
        return mock(TweetCountService.class);
    }

    @Bean
    public Tweets tweets(){
        return mock(Tweets.class);
    }

}
