package com.ilegra.jt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;

public class ExternalResponse {

    @Autowired
    Twitter twitter;

    public int numberOfTweets(String user){
        try {
            return twitter.userOperations().getUserProfile(user).getStatusesCount();
        }catch (Exception e){
            return -1;
        }
    }
}
