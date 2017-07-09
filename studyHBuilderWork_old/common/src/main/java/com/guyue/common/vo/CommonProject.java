package com.guyue.common.vo;

import java.util.Date;

public class CommonProject {
    private Long id;

    private String cName;

    private String cPath;

    private Integer nCodetype;

    private Long nCreateuserid;

    private Date dCreatetime;

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

    public String getcPath() {
        return cPath;
    }

    public void setcPath(String cPath) {
        this.cPath = cPath == null ? null : cPath.trim();
    }

    public Integer getnCodetype() {
        return nCodetype;
    }

    public void setnCodetype(Integer nCodetype) {
        this.nCodetype = nCodetype;
    }

    public Long getnCreateuserid() {
        return nCreateuserid;
    }

    public void setnCreateuserid(Long nCreateuserid) {
        this.nCreateuserid = nCreateuserid;
    }

    public Date getdCreatetime() {
        return dCreatetime;
    }

    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }
}