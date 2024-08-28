package com.project.csvconverter;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.String;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvConverter implements Runnable{

    private CommitRepository commitRepository = new CommitRepositoryImpl();
    private String name;
    private long time = 5000;
    private RestTemplate restTemplate = new RestTemplate();
    private int maximumChangeset;
    private int averageChangeset;

    public void setName(String name){
        this.name=name;
    }

    public void init() throws IOException {
        File file = new File(getName());
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String all = readFile(reader);
        ArrayList<Commit> commits = convert(all);
        checkAndPost(commits);
    }

    private void checkAndPost(ArrayList<Commit> commits) {
        List<Commit> repoCommits = (List<Commit>) commitRepository.getCommits();

        if(repoCommits.isEmpty()||!repoCommits.get(repoCommits.size()-1).equals(commits.get(commits.size()-1))){
            for(int i=0;i<commits.size();i++){
                if(!repoCommits.contains(commits.get(i))){
                    persist(commits.get(i));
                    try{
                        restTemplate.postForObject("http://reader:8080/commits/", commits.get(i), Commit.class);
                    }catch (Exception e){}
                }
            }
        }//else do nothing because the commit already exists in the repository
    }

    public String readFile(BufferedReader reader) throws IOException {
        String all="";
        String temp;
        while((temp = reader.readLine())!=null){
            //adds a break in front of time so that it can split later
            if(temp.length()>0&&Character.isDigit(temp.charAt(0))&&temp.contains("-")&&temp.contains(":")){
                all+="\n"+temp;
            }else
                all+=temp;
        }
        return all;
    }

    public ArrayList<Commit> convert(String all) throws IOException {
        if("".equals(all))
            throw new IOException("File Is Empty");

        String[] st = all.split("\n");
        List<String> list = new ArrayList<>();
        for(int i=0;i < st.length;i++){
            list.add(st[i]);
        }

        ArrayList<Commit> commits = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            String[]  stringList = list.get(i).split(",");
            if(stringList.length>1){
                Commit commit = new Commit(stringList[0],stringList[1],stringList[2],stringList[3],stringList[4],stringList[5],stringList[6],stringList[9]);
                commits.add(commit);
                maximumChangeset = Integer.parseInt(stringList[7]);
                averageChangeset = Integer.parseInt(stringList[8]);
            }
        }
        return commits;
    }

    public void persist(Commit commit) {
        commitRepository.insertCommit(commit);
    }

    public String getName(){
        return name;
    }

    public void setTime(long time){
        this.time = time;
    }

    public String toString(){
        String s = "";
        if(commitRepository.getCommits().isEmpty())
            return s;
        for(Commit commit:commitRepository.getCommits()){
            s+=commit.toString()+"\n";
        }
        return s;
    }

    @Override
    public void run() {
        while (true){
            try {
                //Read the csv file every n milliseconds, 1000ms = 1s
                System.out.println("NEW");
                System.out.println(toString());
                Thread.sleep(getTime());
                init();
            } catch (InterruptedException | IOException e) {
                System.out.println("Something when wrong");
            }
        }
    }

    public long getTime() {
        return time;
    }
}
