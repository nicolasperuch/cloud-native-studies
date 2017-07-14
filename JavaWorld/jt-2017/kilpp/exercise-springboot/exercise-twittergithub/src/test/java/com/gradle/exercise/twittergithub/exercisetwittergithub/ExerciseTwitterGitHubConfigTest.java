package com.gradle.exercise.twittergithub.exercisetwittergithub;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Profile("test")
@Configuration
public class ExerciseTwitterGitHubConfigTest {

    @Bean
    public RestTemplate restTemplate() {
        return mock(RestTemplate.class);
    }

    @Bean
    public ResponseEntity responseEntity(){
        return mock(ResponseEntity.class);
    }

    @Bean
    public Federate federate(){
        return mock(Federate.class);
    }
}
