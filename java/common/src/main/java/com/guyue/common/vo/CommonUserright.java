package com.guyue.common.vo;

public class CommonUserright {
    private Long id;

    private Long nUserid;

    private String cRightkey;

    private Long nRoleid;

    private Integer nType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getnUserid() {
        return nUserid;
    }

    public void setnUserid(Long nUserid) {
        this.nUserid = nUserid;
    }

    public String getcRightkey() {
        return cRightkey;
    }

    public void setcRightkey(String cRightkey) {
        this.cRightkey = cRightkey == null ? null : cRightkey.trim();
    }

    public Long getnRoleid() {
        return nRoleid;
    }

    public void setnRoleid(Long nRoleid) {
        this.nRoleid = nRoleid;
    }

    public Integer getnType() {
        return nType;
    }

    public void setnType(Integer nType) {
        this.nType = nType;
    }
}