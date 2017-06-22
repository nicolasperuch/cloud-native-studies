package com.ilegra.jt;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GithubConfig {

    @Bean
    public GitHub gitHub() throws IOException {
        GitHub gitHub = GitHub.connect();
        return gitHub;
    }
    @Bean
    public ExternalResponse externalResponse(){
        return new ExternalResponse();
    }

}
