package com.guyue.common.vo;

public class CommonRoleright {
    private Long id;

    private String cRightkey;

    private Long nRoleid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}