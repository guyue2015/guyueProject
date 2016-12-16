package com.guyue.common.vo;

public class CommonMode {
    private Long id;

    private String cName;

    private String cAlias;

    private String cRightkey;

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

    public String getcAlias() {
        return cAlias;
    }

    public void setcAlias(String cAlias) {
        this.cAlias = cAlias == null ? null : cAlias.trim();
    }

    public String getcRightkey() {
        return cRightkey;
    }

    public void setcRightkey(String cRightkey) {
        this.cRightkey = cRightkey == null ? null : cRightkey.trim();
    }

    public Long getnProjectid() {
        return nProjectid;
    }

    public void setnProjectid(Long nProjectid) {
        this.nProjectid = nProjectid;
    }
}