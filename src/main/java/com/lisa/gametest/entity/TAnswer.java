package com.lisa.gametest.entity;

public class TAnswer {
    private Integer aid;

    private String coment;

    private Integer tid;

    private String dec;

    private Integer score;

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
        this.coment = coment == null ? null : coment.trim();
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}