package com.gradle.exercise.springtwitter.exercisetwitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class AppConfig{

    @Bean
    public Twitter twitterBuilder() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(System.getenv("CONSUMER_KEY"))
                .setOAuthConsumerSecret(System.getenv("CONSUMER_SECRETE"))
                .setOAuthAccessToken(System.getenv("ACESS_TOKEN"))
                .setOAuthAccessTokenSecret(System.getenv("ACESS_TOKEN_SECRET"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}