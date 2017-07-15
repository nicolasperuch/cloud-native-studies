package com.gradle.exercise.springgithub.exercisegithub;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class GitHubConfigurationTest {

    @Bean
    public GitHubRepCount gitHubRepCount(){
        return mock(GitHubRepCount.class);
    }

    @Bean
    public GitRepService gitRepService(){
        return mock(GitRepService.class);
    }

    @Bean
    public GitHub gitHub()  {
        return mock(GitHub.class);
    }

}
