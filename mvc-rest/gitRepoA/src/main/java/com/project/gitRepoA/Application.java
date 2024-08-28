package com.project.gitRepoA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	@Scope("application")
	public Map<Integer, Commit> commits() {
		Map<Integer, Commit> comms = new HashMap<>();
		comms.put(1,new Commit(1,"date[1]","Message[1]","File[1]"));
		comms.put(2,new Commit(2,"date[2]","Message[2]","File[2]"));
		comms.put(3,new Commit(3,"date[3]","Message[3]","File[3]"));
		return comms;
	}*/
}
