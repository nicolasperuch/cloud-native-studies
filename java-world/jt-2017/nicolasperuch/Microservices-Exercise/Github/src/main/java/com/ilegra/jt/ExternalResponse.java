package com.ilegra.jt;

import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;

public class ExternalResponse {

    @Autowired
    GitHub github;

    public String getRepositories(String user) {
        try {
            return github.getUser(user).getRepositories().keySet().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }
}
