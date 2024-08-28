package com.project.csvconverter;

import javax.transaction.Transactional;
import java.util.Collection;

public interface CommitRepository{

    Collection<Commit> getCommits();

    void insertCommit(Commit commit);
}
