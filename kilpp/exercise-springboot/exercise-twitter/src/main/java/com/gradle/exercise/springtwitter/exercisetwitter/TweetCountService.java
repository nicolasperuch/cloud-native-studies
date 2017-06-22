package com.gradle.exercise.springtwitter.exercisetwitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.Twitter;

/**
 * Created by ilegra0318 on 16/06/17.
 */
@SpringBootApplication
public class TweetCountService {

    @Autowired
    Twitter twitter;

    public String tweetCountServicesforAccount(String user){
        try{
        return "" + twitter.users().showUser(user).getStatusesCount();
        }catch (Exception e){
            return "User Not Found";
        }
    }
}
