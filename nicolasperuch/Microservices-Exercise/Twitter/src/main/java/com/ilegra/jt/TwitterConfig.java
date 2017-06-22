package com.ilegra.jt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig{

    @Bean
    public Twitter twitter() {
        Twitter twitter = new TwitterTemplate(System.getenv("TWITTER_APP_ID"),
                System.getenv("TWITTER_APP_SECRET"),
                System.getenv("TWITTER_TOKEN"),
                System.getenv("TWITTER_TOKEN_SECRET"));
        return twitter;
    }

    @Bean
    public ExternalResponse externalResponse() {
        return new ExternalResponse();
    }

}
