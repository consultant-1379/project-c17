package com.project.gitRepoA;

import org.assertj.core.util.Arrays;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.BaseMatcher.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CommitRepoTests {
    @Autowired
    CommitRepositoryImpl c;
    Commit ex = new Commit("a","b","c","d",0,0);
    Commit ex2 = new Commit("a1","b1","c1","d1",20,10);
    @Test
    public void RepoCreate() {
        c.add(ex);
        assertThat(ex, is(in(c.getAll())));
    }

    @Test
    public void RepoDelete(){
        List<Commit> exs = new ArrayList<Commit>();
        exs.add(ex);
        exs.add(ex2);
        c.addAll(exs);
        c.remove(0);
        assertAll("c", () -> assertThat(ex, is(not(in(c.getAll())))),
                () -> assertThat(ex2, is(in(c.getAll()))),
                () -> assertThat(ex2, equalTo(c.getOne(0)))
        );

    }
}
