package com.gradle.exercise.twittergithub.exercisetwittergithub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SpringBootApplication
@RestController
public class Federate {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/federate/{user}/{user2}")
    @ResponseBody
    public Object githubtweet(@PathVariable(value = "user") String user, @PathVariable(value = "user2") String user2) {
        List<Object> list = new ArrayList<>();
        list.add(federateTwitterCount(user));
        list.add(federateGitHubCount(user2));
        return list;
    }

    private Object federateTwitterCount(String user) {
        try {
            ResponseEntity responseTwitter = restTemplate.getForEntity("http://localhost:8003/tweets/" + user, String.class);
            return responseTwitter.getBody();
        }catch (Exception e){
            String error = "Twitter Service Offline";
            return error;
        }
    }

    private Object federateGitHubCount(String user2) {
        try {
            ResponseEntity responseGithub = restTemplate.getForEntity("http://localhost:8002/github/" + user2, String.class);
            return responseGithub.getBody();
        } catch (Exception e) {
            String error = "GitHub Service Offline";
            return error;
        }
    }
}
