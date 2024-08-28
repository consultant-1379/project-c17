package com.project.gitRepoA;


public class Commit{

    private Long id = null;

    private String time;

    private String commit;

    private String author;

    private String file;

    private int insertions;

    private int deletions;

    public Commit(){}

    public Commit(String time, String commit, String author, String file, int insertions, int deletions) {
        //super();
        this.time = time;
        this.commit = commit;
        this.author = author;
        this.file = file;
        this.insertions = insertions;
        this.deletions = deletions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public String getCommit() {
        return commit;
    }

    public String getFile() {
        return file;
    }

    public int getInsertions() {
        return insertions;
    }

    public void setInsertions(int insertions) {
        this.insertions = insertions;
    }

    public int getDeletions() {
        return deletions;
    }

    public void setDeletions(int deletions) {
        this.deletions = deletions;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", commit='" + commit + '\'' +
                ", author='" + author + '\'' +
                ", file='" + file + '\'' +
                ", insertions=" + insertions +
                ", deletions=" + deletions +
                '}';
    }
}
