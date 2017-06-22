package com.ilegra.jt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

@Profile("test")
@Configuration
public class ManagementConfigTest {

    @Bean
    public ManagementOfMicroservices managementOfMicroservices(){
        return new ManagementOfMicroservices();
    }
    @Bean
    public ExternalResponse externalResponse(){
        return mock(ExternalResponse.class);
    }
    @Bean
    public RestTemplate restTemplate(){
        return mock(RestTemplate.class);
    }

}
