package com.ilegra.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@SpringBootApplication
@RequestMapping("/management")
public class ManagementOfMicroservices {

    @Autowired
    ExternalResponse externalResponse;

    @RequestMapping("/tweets/{twitter}/github/{github}")
    @ResponseBody
    public String managementOfMicroservices(@PathVariable(value = "twitter") String twitter,
                                                  @PathVariable(value = "github") String github){

        String responseTwitter = externalResponse.twitterResponse(twitter);
        String responseGithub = externalResponse.githubResponse(github);
        String responseTwitterGithub = responseTwitter+"<br />"+responseGithub;
        return responseTwitterGithub;
    }



}
