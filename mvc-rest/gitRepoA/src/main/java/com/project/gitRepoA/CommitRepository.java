package com.project.gitRepoA;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


public interface CommitRepository {
    List<Commit> getAll();
    Commit getOne(Integer i);
    void add(Commit commit);
    void addAll(List<Commit> m);
    void remove(int itemId);

}
