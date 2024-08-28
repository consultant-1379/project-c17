package com.project.gitRepoA;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CommitTests{

	@Test
	public void CommitCreate() {
        Commit com= new Commit("null","null","null","null",0,0);
        com.setTime("a");
        com.setCommit("b");
        com.setFile("c");
        com.setAuthor("d");
        com.setInsertions(1);
        com.setDeletions(1);
        com.setId(1L);
        assertAll("com", () -> assertEquals("a", com.getTime()),
                () -> assertEquals("b", com.getCommit()),
                () -> assertEquals("c", com.getFile()),
                () -> assertEquals("d", com.getAuthor()),
                () -> assertEquals(1, com.getInsertions()),
                () -> assertEquals(1, com.getDeletions()),
                () -> assertEquals(1, com.getId()),
                () -> assertEquals("Commit{id=1, time='a', commit='b', author='d', file='c', insertions=1, deletions=1}", com.toString())
        );
    }
    @Test
    public void CommitEmpty() {
        Commit ec = new Commit();
        assertThat(ec,isA(Commit.class));
    }
}
