package com.guyue.common.vo;

public class CommonCodetype {
    private Long id;

    private String cCodetype;

    private String cValue;

    private String cValueEn;

    private Long nOrder;

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

    public Long getnOrder() {
        return nOrder;
    }

    public void setnOrder(Long nOrder) {
        this.nOrder = nOrder;
    }
}