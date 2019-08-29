package com.lisa.gametest.entity;

public class TJudge {
    private Integer jid;

    private String coment;

    private String right;

    private String score;

    private Integer tid;

    private String dec;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment == null ? null : coment.trim();
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right == null ? null : right.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec == null ? null : dec.trim();
    }
}