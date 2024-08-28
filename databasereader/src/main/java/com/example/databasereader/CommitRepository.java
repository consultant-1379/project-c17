package com.example.databasereader;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;

public interface CommitRepository extends JpaRepository<Commit,Long> {

}

