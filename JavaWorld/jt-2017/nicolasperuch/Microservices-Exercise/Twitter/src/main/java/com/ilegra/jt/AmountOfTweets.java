package com.ilegra.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/tweets")
@SpringBootApplication
public class AmountOfTweets {

    @Autowired
    ExternalResponse externalResponse;

    @RequestMapping("/{user}")
    @ResponseBody
    public String getTweets(@PathVariable (value = "user") String user){

        if(externalResponse.numberOfTweets(user)>=0)
            return "@"+user+" - Tweets: "+externalResponse.numberOfTweets(user);
        return "Sorry, We had some mistakes to find your twitter";
    }

}
