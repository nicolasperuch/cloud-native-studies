package com.gradle.exercise.springgithub.exercisegithub;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GitHubConfigurationTest.class)
public class ExerciseGithubApplicationTests {

	@Autowired
	private GitHubRepCount gitHubRepCount;

	@Autowired
    private GitRepService gitRepService;

	@Test
    public void gitHubRepTest() throws IOException {
	    when(gitHubRepCount.userNumberOfRepositories("kilpp")).thenReturn("Public Repositories of kilpp: " +  "[Complexidade, TF_JT_ILEGRA, jts.cloud-native.2017, sandbox-jts17, teste_gitspringrest]");
        Assert.assertEquals("Public Repositories of " + "kilpp" + ": " +  "[Complexidade, TF_JT_ILEGRA, jts.cloud-native.2017, sandbox-jts17, teste_gitspringrest]", gitHubRepCount.userNumberOfRepositories("kilpp") );
    }

    @Test
    public void gitHubRepNotFoundTest() throws IOException {
        when(gitHubRepCount.userNumberOfRepositories("kilpp")).thenReturn("User Not Found");
        Assert.assertEquals("User Not Found" , gitHubRepCount.userNumberOfRepositories("kilpp") );
    }



}
