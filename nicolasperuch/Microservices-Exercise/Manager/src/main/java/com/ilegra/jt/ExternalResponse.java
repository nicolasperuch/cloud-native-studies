package com.ilegra.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalResponse {

    @Autowired
    RestTemplate twitterTemplate;
    @Autowired
    RestTemplate githubTemplate;

    ResponseEntity responseEntity;

    private String TWITTER_PATH = "http://localhost:8002/tweets/";
    private String GITHUB_PATH = "http://localhost:8001/github/";


    public String twitterResponse(String twitter) {
        try {
            responseEntity = twitterTemplate.getForEntity(TWITTER_PATH + twitter, String.class);
            return responseEntity.getBody().toString();
        } catch (Exception e) {
            return "Sorry, Twitter is down right now";
        }
    }

    public String githubResponse(String github) {
        try {
            responseEntity = githubTemplate.getForEntity(GITHUB_PATH + github, String.class);
            return responseEntity.getBody().toString();
        } catch (Exception e) {
            return "Sorry, Github is down right now";
        }

    }

}
