package com.lisa.gametest.entity;

public class TChoose {
    private Integer cid;

    private String coment;

    private String axuanxiang;

    private String bxuanxiang;

    private String cxuanxiang;

    private String dxuanxiang;

    private String correct;

    private Integer score;

    private Integer tid;

    private String decs;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment == null ? null : coment.trim();
    }

    public String getAxuanxiang() {
        return axuanxiang;
    }

    public void setAxuanxiang(String axuanxiang) {
        this.axuanxiang = axuanxiang == null ? null : axuanxiang.trim();
    }

    public String getBxuanxiang() {
        return bxuanxiang;
    }

    public void setBxuanxiang(String bxuanxiang) {
        this.bxuanxiang = bxuanxiang == null ? null : bxuanxiang.trim();
    }

    public String getCxuanxiang() {
        return cxuanxiang;
    }

    public void setCxuanxiang(String cxuanxiang) {
        this.cxuanxiang = cxuanxiang == null ? null : cxuanxiang.trim();
    }

    public String getDxuanxiang() {
        return dxuanxiang;
    }

    public void setDxuanxiang(String dxuanxiang) {
        this.dxuanxiang = dxuanxiang == null ? null : dxuanxiang.trim();
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }
}