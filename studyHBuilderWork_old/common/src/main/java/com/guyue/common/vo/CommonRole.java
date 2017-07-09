package com.guyue.common.vo;

public class CommonRole {
    private Long id;

    private String cName;

    private Long nProjectid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Long getnProjectid() {
        return nProjectid;
    }

    public void setnProjectid(Long nProjectid) {
        this.nProjectid = nProjectid;
    }
}