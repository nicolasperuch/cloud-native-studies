package com.ilegra.jt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ManagementConfigTest.class)
public class ManagementOfMicroservicesTest {

    @Autowired
    ExternalResponse externalResponse;
    @Autowired
    ManagementOfMicroservices manager;

    @Test
    public void managementOfMicroservicesHappyPathTest(){
        when(externalResponse.twitterResponse("twitter")).thenReturn("TwitterUser");
        when(externalResponse.githubResponse("github")).thenReturn("GithubUser");
        Assert.assertEquals("TwitterUser<br />GithubUser",
                            manager.managementOfMicroservices("twitter","github"));
    }
}
