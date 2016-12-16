package com.guyue.common.vo;

public class CommonCode {
    private Long id;

    private String cCodetype;

    private String cCode;

    private String cValue;

    private String cValueEn;

    private Integer nOrder;

    private String cPcode;

    private String cDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcCodetype() {
        return cCodetype;
    }

    public void setcCodetype(String cCodetype) {
        this.cCodetype = cCodetype == null ? null : cCodetype.trim();
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue == null ? null : cValue.trim();
    }

    public String getcValueEn() {
        return cValueEn;
    }

    public void setcValueEn(String cValueEn) {
        this.cValueEn = cValueEn == null ? null : cValueEn.trim();
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public String getcPcode() {
        return cPcode;
    }

    public void setcPcode(String cPcode) {
        this.cPcode = cPcode == null ? null : cPcode.trim();
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc == null ? null : cDesc.trim();
    }
}