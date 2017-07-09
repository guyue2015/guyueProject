package com.guyue.apispeed.vo;

public class ProjectInteface {
    private Long id;

    private String cName;

    private String cPath;

    private String cDesc;

    private String cClassname;

    private String cMethodname;

    private String cMethodtype;

    private String cResult;

    private Long nProjectid;

    private Long nAuthor;

    private Integer nStatus;

    private String cReturneg;

    private Long nInterfaceid;

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

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }

    public String getcClassname() {
        return cClassname;
    }

    public void setcClassname(String cClassname) {
        this.cClassname = cClassname == null ? null : cClassname.trim();
    }

    public String getcMethodname() {
        return cMethodname;
    }

    public void setcMethodname(String cMethodname) {
        this.cMethodname = cMethodname == null ? null : cMethodname.trim();
    }

    public String getcMethodtype() {
        return cMethodtype;
    }

    public void setcMethodtype(String cMethodtype) {
        this.cMethodtype = cMethodtype == null ? null : cMethodtype.trim();
    }

    public String getcResult() {
        return cResult;
    }

    public void setcResult(String cResult) {
        this.cResult = cResult == null ? null : cResult.trim();
    }

    public Long getnProjectid() {
        return nProjectid;
    }

    public void setnProjectid(Long nProjectid) {
        this.nProjectid = nProjectid;
    }

    public Long getnAuthor() {
        return nAuthor;
    }

    public void setnAuthor(Long nAuthor) {
        this.nAuthor = nAuthor;
    }

    public Integer getnStatus() {
        return nStatus;
    }

    public void setnStatus(Integer nStatus) {
        this.nStatus = nStatus;
    }

    public String getcReturneg() {
        return cReturneg;
    }

    public void setcReturneg(String cReturneg) {
        this.cReturneg = cReturneg == null ? null : cReturneg.trim();
    }

    public Long getnInterfaceid() {
        return nInterfaceid;
    }

    public void setnInterfaceid(Long nInterfaceid) {
        this.nInterfaceid = nInterfaceid;
    }
}