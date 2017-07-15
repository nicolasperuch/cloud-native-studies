package com.ilegra.jt;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class GithubConfigTest {

    @Bean
    public GithubRepositories githubRepositories(){
        return new GithubRepositories();
    }
    @Bean
    public ExternalResponse externalResponse(){
        return mock(ExternalResponse.class);
    }
    @Bean
    public GitHub gitHub(){
        return mock(GitHub.class);
    }
}
