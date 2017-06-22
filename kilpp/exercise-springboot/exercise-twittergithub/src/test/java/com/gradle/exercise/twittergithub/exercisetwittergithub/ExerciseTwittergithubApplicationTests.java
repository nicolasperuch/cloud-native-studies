package com.gradle.exercise.twittergithub.exercisetwittergithub;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExerciseTwitterGitHubConfigTest.class)
public class ExerciseTwittergithubApplicationTests {

	@Autowired
	Federate federate;

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void federateTwitterGitHubOfflineCountTest() throws IOException {
		when(federate.githubtweet("guilhermekilpp", "kilpp")).thenReturn("[Twitter Service Offline,GitHub Service Offline]");
		Assert.assertEquals("[Twitter Service Offline,GitHub Service Offline]", federate.githubtweet("guilhermekilpp", "kilpp"));
	}

	@Test
	public void federateTwitterGitHubOnlineCountTest() throws IOException {
		when(federate.githubtweet("guilhermekilpp", "kilpp")).thenReturn("[@guilhermekilpp NUMBER OF TWEETS: 11,Public Repositories of kilpp: [Complexidade, TF_JT_ILEGRA, jts.cloud-native.2017, sandbox-jts17, teste_gitspringrest]");
		Assert.assertEquals("[@guilhermekilpp NUMBER OF TWEETS: 11,Public Repositories of kilpp: [Complexidade, TF_JT_ILEGRA, jts.cloud-native.2017, sandbox-jts17, teste_gitspringrest]", federate.githubtweet("guilhermekilpp", "kilpp"));
	}

}
