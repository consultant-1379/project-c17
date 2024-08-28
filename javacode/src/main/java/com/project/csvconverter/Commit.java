package com.project.csvconverter;


public class Commit{
    private String time;

    private String commit;

    private String file;

    private int insertions;

    private int deletions;

    private int linesAdded;

    private int linesRemoved;

    private String author;

    public Commit(){}

    public Commit(String time, String commit, String file, String insertions,String deletions, String lineAdded, String linesRemoved, String author) {
        //super();
        this.time = time;
        this.commit = commit;
        this.file = file;
        this.insertions = Integer.parseInt(insertions);
        this.deletions = Integer.parseInt(deletions);
        this.linesAdded = Integer.parseInt(lineAdded);
        this.linesRemoved = Integer.parseInt(linesRemoved);
        this.author = author;
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

    public String getTime() {
        return time;
    }

    public String getCommit() {
        return commit;
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

    public int getLinesAdded() {
        return linesAdded;
    }

    public void setLinesAdded(int linesAdded) {
        this.linesAdded = linesAdded;
    }

    public int getLinesRemoved() {
        return linesRemoved;
    }

    public void setLinesRemoved(int linesRemoved) {
        this.linesRemoved = linesRemoved;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFile() {
        return file;
    }

    public boolean equals(Commit commit){
        if(commit.getCommit().equals(getCommit())&&commit.getFile().equals(getFile())&&commit.getTime().equals(getTime())&&
                commit.getInsertions()==getInsertions()&&commit.getDeletions()==getDeletions()&&
                commit.getLinesRemoved()==getLinesRemoved()&&commit.getLinesAdded()==getLinesAdded()&&commit.getAuthor().equals(getAuthor()))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "time='" + time + '\'' +
                ", commit='" + commit + '\'' +
                ", file='" + file + '\'' +
                ", insertions=" + insertions +
                ", deletions=" + deletions +
                ", linesAdded=" + linesAdded +
                ", linesRemoved=" + linesRemoved +
                ", author='" + author + '\'' +
                '}';
    }
}
