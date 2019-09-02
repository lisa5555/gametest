package com.lisa.gametest.vo;

import java.util.Date;

public class KsnInfo {
    private Integer kid;

    private Date createtime;

    private Date endtime;

    private String kaoshitime;

    private String typeName;


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
        this.kaoshitime = kaoshitime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
