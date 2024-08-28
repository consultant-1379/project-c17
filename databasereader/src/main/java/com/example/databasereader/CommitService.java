package com.example.databasereader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CommitService {
    @Autowired
    private CommitRepository commitRepository;

    public List<Commit> listCommits(){
        return commitRepository.findAll();
    }

    public void addCommit(Commit commit){
        commitRepository.save(commit);
    }

    public Commit getCommit(Long id){
        return commitRepository.findById(id).get();
    }

    public Long getLength(){return commitRepository.count();}

}
