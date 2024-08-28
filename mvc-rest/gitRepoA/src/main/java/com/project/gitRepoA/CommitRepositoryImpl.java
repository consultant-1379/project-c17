package com.project.gitRepoA;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommitRepositoryImpl implements CommitRepository{
    //private Map<Integer,Commit> commits = new HashMap<>();
    private List<Commit> commits = new ArrayList<>();

    @Override
    public List<Commit> getAll() {
        return commits;
    }

    @Override
    public Commit getOne(Integer i) {
        return commits.get(i);
    }

    @Override
    public void add(Commit commit) {
        commits.add(commit);
    }

    @Override
    public void addAll(List<Commit> list) {
        commits=list;
    }

    @Override
    public void remove(int itemId) {
        commits.remove(itemId);
    }
}
