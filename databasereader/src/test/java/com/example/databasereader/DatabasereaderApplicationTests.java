package com.example.databasereader;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

class DatabasereaderApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	Commit commit;
	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setup(){
		commit = new Commit("2:00", "added legacy support", "index.html", "20", "20", "20", "20", "Adam");
	}

	@Test
	public void setTimeWorks(){
		commit.setTime("3:00");
		assertThat(commit.getTime(), equalTo("3:00"));
	}

	@Test
	public void setFileWorks(){
		commit.setFile("java.html");
		assertThat(commit.getFile(), equalTo("java.html"));
	}

	@Test
	public void setCommitWorks(){
		commit.setCommit("added tea");
		assertThat(commit.getCommit(), equalTo("added tea"));
	}

	@Test
	public void setIdWorks(){
		commit.setId(1L);
		assertThat(commit.getId(), equalTo(1L));
	}

	@Test
	public void toStringWorks(){
		Commit commit = new Commit("test", "test", "test", "20", "20", "20", "20", "test");
		System.out.println(commit);
		//assertThat(commit.toString(), equalTo("Commit{time='test', commit='test', file='test'}"));
	}

//	@Test
//	public void getCommitsPortWorks(){
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/commits", Commit.class).getCommit(), equalTo("Test"));
//	}



}
