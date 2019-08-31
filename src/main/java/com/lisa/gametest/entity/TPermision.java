package com.lisa.gametest.entity;

import java.util.List;

public class TPermision {
    private Integer pid;

    private String resourceName;

    private Integer parentId;

    private String permisionName;

    private String resourceType;

    private String url;
    private List<TPermision> tPermisionlist;

    public List<TPermision> gettPermisionlist() {
        return tPermisionlist;
    }

    public void settPermisionlist(List<TPermision> tPermisionlist) {
        this.tPermisionlist = tPermisionlist;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPermisionName() {
        return permisionName;
    }

    public void setPermisionName(String permisionName) {
        this.permisionName = permisionName == null ? null : permisionName.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "TPermision{" +
                "pid=" + pid +
                ", resourceName='" + resourceName + '\'' +
                ", parentId=" + parentId +
                ", permisionName='" + permisionName + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", tPermisionlist=" + tPermisionlist +
                '}';
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}