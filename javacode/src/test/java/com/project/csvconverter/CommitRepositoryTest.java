package com.project.csvconverter;


import org.junit.Assert;
import org.junit.Test;

public class CommitRepositoryTest {
    CommitRepositoryImpl commitRepository = new CommitRepositoryImpl();

    @Test
    public void testPersistAncGetCommit(){
        Commit testCommit = new Commit("Test","Test","Test","0","0","0","0","Test");
        commitRepository.insertCommit(testCommit);
        Assert.assertTrue(commitRepository.getCommits().contains(testCommit));
    }

}
