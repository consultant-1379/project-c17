package com.project.csvconverter;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommitTest {
    private Commit testCommit;
    @BeforeEach
    public void init(){
        testCommit = new Commit("20/10/2021","Test","Test.txt","0","0","0","0","test");
    }

    @Test
    void setInsertionsAndGetInsertions(){
        testCommit.setInsertions(10);
        Assert.assertEquals(10,testCommit.getInsertions());
    }

    @Test
    void setDeletionsAndGetDeletions(){
        testCommit.setDeletions(10);
        Assert.assertEquals(10,testCommit.getDeletions());
    }

    @Test
    void setTimeAndGetTime() {
        testCommit.setTime("Test Time");
        Assert.assertEquals("Test Time",testCommit.getTime());
    }

    @Test
    void testSetAndGetAuthor(){
        testCommit.setAuthor("Test");
        Assert.assertEquals("Test",testCommit.getAuthor());
    }

    @Test
    void testSetAndGetLinesAdded(){
        testCommit.setLinesAdded(100);
        Assert.assertEquals(100,testCommit.getLinesAdded());
    }

    @Test
    void testSetAndGetLinesRemoved(){
        testCommit.setLinesRemoved(100);
        Assert.assertEquals(100,testCommit.getLinesRemoved());
    }

    @Test
    void setCommitAndGetCommit() {
        testCommit.setCommit("Test Commit");
        Assert.assertEquals("Test Commit",testCommit.getCommit());
    }

    @Test
    void setFileAndGetFile() {
        testCommit.setFile("Test File");
        Assert.assertEquals("Test File",testCommit.getFile());
    }

    @Test
    void testToString() {
        Assert.assertEquals(String.format("Commit{time='%s', commit='%s', file='%s', insertions=%d, deletions=%d, linesAdded=%d, linesRemoved=%d, author='%s'}"
                ,"20/10/2021","Test","Test.txt",0,0,0,0,"test"),testCommit.toString());
    }

    @Test
    void notEquals(){
        Commit failCommit = new Commit("","","","0","0","0","0","");
        Assert.assertFalse(testCommit.equals(failCommit));
    }
}