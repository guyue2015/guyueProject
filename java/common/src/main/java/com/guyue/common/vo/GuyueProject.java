package com.guyue.common.vo;

import java.util.Date;

public class GuyueProject {
    private Long id;

    private String cName;

    private String cAlias;

    private String cWebname;

    private String cGithub;

    private String cDatabase;

    private String cCodeprefix;

    private Date dCreatetime;

    private String cDesc;

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

    public String getcWebname() {
        return cWebname;
    }

    public void setcWebname(String cWebname) {
        this.cWebname = cWebname == null ? null : cWebname.trim();
    }

    public String getcGithub() {
        return cGithub;
    }

    public void setcGithub(String cGithub) {
        this.cGithub = cGithub == null ? null : cGithub.trim();
    }

    public String getcDatabase() {
        return cDatabase;
    }

    public void setcDatabase(String cDatabase) {
        this.cDatabase = cDatabase == null ? null : cDatabase.trim();
    }

    public String getcCodeprefix() {
        return cCodeprefix;
    }

    public void setcCodeprefix(String cCodeprefix) {
        this.cCodeprefix = cCodeprefix == null ? null : cCodeprefix.trim();
    }

    public Date getdCreatetime() {
        return dCreatetime;
    }

    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }
}