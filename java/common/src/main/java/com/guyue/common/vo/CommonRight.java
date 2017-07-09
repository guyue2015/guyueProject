package com.guyue.common.vo;

public class CommonRight {
    private Long id;

    private Long nProjectid;

    private String cKey;

    private Integer nInvalid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getnProjectid() {
        return nProjectid;
    }

    public void setnProjectid(Long nProjectid) {
        this.nProjectid = nProjectid;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey == null ? null : cKey.trim();
    }

    public Integer getnInvalid() {
        return nInvalid;
    }

    public void setnInvalid(Integer nInvalid) {
        this.nInvalid = nInvalid;
    }
}