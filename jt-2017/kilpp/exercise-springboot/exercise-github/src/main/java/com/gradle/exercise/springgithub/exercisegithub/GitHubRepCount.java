package com.gradle.exercise.springgithub.exercisegithub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@RequestMapping("/github")
public class GitHubRepCount {

    @Autowired
    GitRepService gitRepService;

    @RequestMapping("/{user}")
    @ResponseBody
    public String userNumberOfRepositories(@PathVariable(value="user") String user) {
        try {
            if (gitRepService.getGitHubRepositories(user) != "User Not Found") {
                return "Public Repositories of " + user + ": " + gitRepService.getGitHubRepositories(user);
            } else {
                return "User not Found";
            }
        }catch (Exception e){
            return "Service Offline";
        }
    }
}
