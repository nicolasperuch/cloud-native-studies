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
@ContextConfiguration(classes = GithubConfigTest.class)
public class GithubRepositoriesTest {

    @Autowired
    GithubRepositories githubRepositories;
    @Autowired
    ExternalResponse externalResponse;

    @Test
    public void getRepoHappyPathTest(){
        when(externalResponse.getRepositories("nicolasperuch")).thenReturn("3");
        Assert.assertEquals("@nicolasperuch - Public repositories: 3",
                            githubRepositories.getRepo("nicolasperuch"));
    }
    @Test
    public void getRepoWonderfulPathTest(){
        when(externalResponse.getRepositories("nicolaspedsaruch")).thenReturn("-1");
        Assert.assertEquals("Sorry, We had some mistakes to take your repos",
                githubRepositories.getRepo("nicolaspedsaruch"));
    }
}
