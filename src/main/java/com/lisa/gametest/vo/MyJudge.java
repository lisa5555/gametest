package com.lisa.gametest.vo;

import com.lisa.gametest.entity.TTestType;

public class MyJudge {
    private Integer jid;

    private String coment;

    private String right;

    private String score;

    private Integer tid;

    private String dec;

    private TTestType tTestType;

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
        this.coment = coment;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
        this.dec = dec;
    }

    public TTestType gettTestType() {
        return tTestType;
    }

    public void settTestType(TTestType tTestType) {
        this.tTestType = tTestType;
    }
}
