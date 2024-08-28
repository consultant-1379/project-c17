package com.example.databasereader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/commits")
public class DatabaseReaderController {

    @Autowired
    CommitService commitService;

    @GetMapping(value = "", produces="application/json")
    public List<Commit> list() {
        return commitService.listCommits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commit> get(@PathVariable Long id) {
        try {
            Commit commit = commitService.getCommit(id);
            return new ResponseEntity<Commit>(commit, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Commit>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Commit commit) {
        commitService.addCommit(commit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Commit commit, @PathVariable Long id) {
        try {
            Commit existCommit = commitService.getCommit(id);
            commit.setId(id);
            commitService.addCommit(commit);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/amount")
    public Long getAmount(){
        Long amount = commitService.getLength();
        return amount;
    }

    @GetMapping("/health")
    public String healthCheck(){
        return "{\"Status\":\"UP\"}";
    }

//    @GetMapping("/chainsetmin")
//    public ResponseEntity<Integer> getChainsetMin(){
//
//    }
}
