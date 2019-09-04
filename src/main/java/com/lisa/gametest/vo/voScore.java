package com.lisa.gametest.vo;

public class voScore {

    private Integer sid;

    private Integer uid;

    private Integer oid;

    private Integer total;

    private String name;

    private String typeName;

    public voScore() {
    }

    public voScore(Integer sid, Integer uid, Integer oid, Integer total, String name, String typeName) {
        this.sid = sid;
        this.uid = uid;
        this.oid = oid;
        this.total = total;
        this.name = name;
        this.typeName = typeName;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
