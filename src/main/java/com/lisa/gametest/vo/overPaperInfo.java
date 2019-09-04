package com.lisa.gametest.vo;

public class overPaperInfo {

    private Integer oid;

    private Integer pid;

    private Integer uid;

    private Integer tid;

    private String commitchoose;

    private String commitjudge;

    private String commitanswer;

    private Integer score;

    private Integer state;

    private String typeName;

    private String username;

    private String name;

    public overPaperInfo() {
    }

    public overPaperInfo(Integer oid, Integer pid, Integer uid, Integer tid, String commitchoose, String commitjudge, String commitanswer, Integer score, Integer state, String typeName, String username, String name) {
        this.oid = oid;
        this.pid = pid;
        this.uid = uid;
        this.tid = tid;
        this.commitchoose = commitchoose;
        this.commitjudge = commitjudge;
        this.commitanswer = commitanswer;
        this.score = score;
        this.state = state;
        this.typeName = typeName;
        this.username = username;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
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
        this.commitchoose = commitchoose;
    }

    public String getCommitjudge() {
        return commitjudge;
    }

    public void setCommitjudge(String commitjudge) {
        this.commitjudge = commitjudge;
    }

    public String getCommitanswer() {
        return commitanswer;
    }

    public void setCommitanswer(String commitanswer) {
        this.commitanswer = commitanswer;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
