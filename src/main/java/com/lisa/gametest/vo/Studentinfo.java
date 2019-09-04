package com.lisa.gametest.vo;

import java.util.Date;

public class Studentinfo {
    private Integer kinfoid;
    private String name;
    private String sex;
    private Integer kid;
    private Date createTime;
    private Date endTime;
    private String kaoshiTime;
    private String typeName;

    public Integer getKinfoid() {
        return kinfoid;
    }

    public void setKinfoid(Integer kinfoid) {
        this.kinfoid = kinfoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getKaoshiTime() {
        return kaoshiTime;
    }

    public void setKaoshiTime(String kaoshiTime) {
        this.kaoshiTime = kaoshiTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
