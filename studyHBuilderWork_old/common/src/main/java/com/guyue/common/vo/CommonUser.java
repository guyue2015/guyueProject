package com.guyue.common.vo;

public class CommonUser {
    private Long id;

    private String cUsername;

    private String cPassword;

    private String cAlias;

    private String cHeadimg;

    private String cPhone;

    private String cEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcAlias() {
        return cAlias;
    }

    public void setcAlias(String cAlias) {
        this.cAlias = cAlias == null ? null : cAlias.trim();
    }

    public String getcHeadimg() {
        return cHeadimg;
    }

    public void setcHeadimg(String cHeadimg) {
        this.cHeadimg = cHeadimg == null ? null : cHeadimg.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }
}