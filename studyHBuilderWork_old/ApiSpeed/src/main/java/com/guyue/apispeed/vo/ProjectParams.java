package com.guyue.apispeed.vo;

public class ProjectParams {
    private Long id;

    private Long nIntefaceid;

    private Integer nType;

    private String cDesc;

    private String cParameg;

    private Integer nRequire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getnIntefaceid() {
        return nIntefaceid;
    }

    public void setnIntefaceid(Long nIntefaceid) {
        this.nIntefaceid = nIntefaceid;
    }

    public Integer getnType() {
        return nType;
    }

    public void setnType(Integer nType) {
        this.nType = nType;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }

    public String getcParameg() {
        return cParameg;
    }

    public void setcParameg(String cParameg) {
        this.cParameg = cParameg == null ? null : cParameg.trim();
    }

    public Integer getnRequire() {
        return nRequire;
    }

    public void setnRequire(Integer nRequire) {
        this.nRequire = nRequire;
    }
}