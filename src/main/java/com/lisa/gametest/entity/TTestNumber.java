package com.lisa.gametest.entity;

import java.util.Date;

public class TTestNumber {
    private Integer kid;

    private Date createtime;

    private Date endtime;

    private String kaoshitime;

    private Integer tid;

    private Integer qid;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getKaoshitime() {
        return kaoshitime;
    }

    public void setKaoshitime(String kaoshitime) {
        this.kaoshitime = kaoshitime == null ? null : kaoshitime.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
}