package com.ilegra.jt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.Twitter;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class TwitterConfigTest {

    @Bean
    public AmountOfTweets amountOfTweets(){
        return new AmountOfTweets();
    }

    @Bean
    public ExternalResponse externalResponse(){
        return mock(ExternalResponse.class);
    }

    @Bean
    public Twitter twitter(){
        return mock(Twitter.class);
    }


}
