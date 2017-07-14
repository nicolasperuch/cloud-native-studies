package com.ilegra.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@Controller
public class GithubRepositories {

    @Autowired
    private ExternalResponse externalResponse;

    @RequestMapping("/github/{user}")
    @ResponseBody
    public String getRepo(@PathVariable(value = "user") String user){

        if(externalResponse.getRepositories(user) != "-1")
            return "@"+user+" - Public repositories: "+externalResponse.getRepositories(user);
        return "Sorry, We had some mistakes to take your repos";

    }

}
