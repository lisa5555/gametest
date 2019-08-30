package com.lisa.gametest.entity;

public class TOverPaper {
    private Integer oid;

    private Integer pid;

    private Integer uid;

    private String commitchoose;

    private String commitjudge;

    private String commitanswer;

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCommitchoose() {
        return commitchoose;
    }

    public void setCommitchoose(String commitchoose) {
        this.commitchoose = commitchoose == null ? null : commitchoose.trim();
    }

    public String getCommitjudge() {
        return commitjudge;
    }

    public void setCommitjudge(String commitjudge) {
        this.commitjudge = commitjudge == null ? null : commitjudge.trim();
    }

    public String getCommitanswer() {
        return commitanswer;
    }

    public void setCommitanswer(String commitanswer) {
        this.commitanswer = commitanswer == null ? null : commitanswer.trim();
    }
}