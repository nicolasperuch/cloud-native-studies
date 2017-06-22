package com.gradle.exercise.springgithub.exercisegithub;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitRepService {

    @Autowired
    private GitHub gitHub;

    public String getGitHubRepositories(String user){
        try {
            return ""+gitHub.getUser(user).getRepositories().keySet();
        }catch (Exception e){
            return "User Not Found";
        }
    }
}
