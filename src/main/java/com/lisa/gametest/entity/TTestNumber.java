package com.lisa.gametest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TTestNumber {
    private Integer kid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer kaoshiTime;

    private Integer tid;

    private Integer qid;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getKaoshiTime() {
        return kaoshiTime;
    }

    public void setKaoshiTime(Integer kaoshiTime) {
        this.kaoshiTime = kaoshiTime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "TTestNumber{" +
                "kid=" + kid +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", kaoshiTime='" + kaoshiTime + '\'' +
                ", tid=" + tid +
                '}';
    }
}