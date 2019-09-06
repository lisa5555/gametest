package com.lisa.gametest.entity;

public class TOverPaper {
    private Integer oid;

    private Integer qid;

    private Integer uid;

    private String commitChoose;

    private String commitJudge;

    private String commitAnswer;

    private Integer score;

    private Integer state;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCommitChoose() {
        return commitChoose;
    }

    public void setCommitChoose(String commitChoose) {
        this.commitChoose = commitChoose;
    }

    public String getCommitJudge() {
        return commitJudge;
    }

    public void setCommitJudge(String commitJudge) {
        this.commitJudge = commitJudge;
    }

    public String getCommitAnswer() {
        return commitAnswer;
    }

    public void setCommitAnswer(String commitAnswer) {
        this.commitAnswer = commitAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}