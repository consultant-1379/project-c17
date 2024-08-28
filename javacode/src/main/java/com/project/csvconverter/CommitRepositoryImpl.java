package com.project.csvconverter;

import java.util.ArrayList;

public class CommitRepositoryImpl implements CommitRepository {
    ArrayList<Commit> commits;

    public CommitRepositoryImpl(){
        commits = new ArrayList<>();
    }

    @Override
    public ArrayList<Commit> getCommits() {
        return commits;
    }

    @Override
    public void insertCommit(Commit commit) {
        commits.add(commit);
    }
}
