package com.lisa.gametest.vo;

import com.lisa.gametest.entity.TTestType;

public class MyAnswer {
    private Integer aid;

    private String coment;

    private Integer tid;

    private String dec;

    private Integer score;

    private TTestType tTestType;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public TTestType gettTestType() {
        return tTestType;
    }

    public void settTestType(TTestType tTestType) {
        this.tTestType = tTestType;
    }
}
