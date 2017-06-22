package com.gradle.exercise.springgithub.exercisegithub;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GitHubConfig {

    @Bean
    public GitHub github() throws IOException {
        GitHub gc = GitHub.connect();
        return gc;
    }
}


