package com.gradle.exercise.springtwitter.exercisetwitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@RequestMapping("/tweets/*")
public class Tweets {

    @Autowired
    private TweetCountService tweetCountService;

    @RequestMapping("/tweets/{user}")
    @ResponseBody
    public String tweetCount(@PathVariable String user) {
        try {
            if (tweetCountService.tweetCountServicesforAccount(user) != "User Not Found") {
                return "@" + user + " NUMBER OF TWEETS: " + tweetCountService.tweetCountServicesforAccount(user);
            } else {
                return "User Not Found";
            }
        }catch(Exception e){
                return "Service Offline";
        }
    }
}



