package com.ilegra.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubRun {

	public static void main(String[] args) {
		SpringApplication.run(GithubRepositories.class, args);
	}
}
