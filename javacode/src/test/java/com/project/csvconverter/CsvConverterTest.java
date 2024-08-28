package com.project.csvconverter;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

class CsvConverterTest {

    CsvConverter converter;

    Commit testCommit;

    @BeforeEach
    void setUp() {
        converter = new CsvConverter();
        testCommit = new Commit("10/10/2010","TestCommit","test.txt","0","0","0","0","Test");
    }

    @Test
    void convertFail() throws IOException {
        Assertions.assertThrows(IOException.class, () -> converter.convert(""));
    }

    @Test
    void initFail() throws IOException{
        converter.setName("");
        Assertions.assertThrows(IOException.class, () -> converter.init());
    }

    @Test
    void setAndGetName(){
        converter.setName("Test");
        Assert.assertEquals("Test",converter.getName());
    }

    @Test
    void getDefaultTime(){
        Assert.assertEquals(5000,converter.getTime());
    }

    @Test
    void setAndGetTime(){
        converter.setTime(10000);
        Assert.assertEquals(10000,converter.getTime());
    }

    @Test
    void testReadFile() throws IOException {
        File file = new File("test.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String test = converter.readFile(br);
        Assert.assertEquals("Time,Commit,File,Insertions,Deletions,Lines_Added,Lines_Removed,Maximum_Changeset,Average_Changeset,Authors\n" +
                "2021-10-21 1:00,NO-JIRA test,test.txt,0,0,0,0,0,0,Test",test);
    }

    @Test
    void convert() throws IOException{
        String all = "Time,Commit,File,Insertions,Deletions,Lines_Added,Lines_Removed,Maximum_Changeset,Average_Changeset,Authors\n10/10/2010,TestCommit,test.txt,0,0,0,0,0,0,Test";
        ArrayList<Commit> commits = converter.convert(all);
        Assert.assertNotNull(commits);
        Assert.assertTrue(commits.get(0).equals(testCommit));
    }

    @Test
    void returnCommits(){
        converter.persist(testCommit);
        Assert.assertEquals((testCommit.toString()+"\n"),converter.toString());
    }
}