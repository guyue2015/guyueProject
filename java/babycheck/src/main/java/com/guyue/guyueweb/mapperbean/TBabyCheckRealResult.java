package com.guyue.guyueweb.mapperbean;

import javax.persistence.*;

@Table(name = "t_baby_check_real_result")
public class TBabyCheckRealResult {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 婴儿出生日期
     */
    @Column(name = "c_birthday")
    private String cBirthday;

    /**
     * 筛查项目
     */
    @Column(name = "c_eitem")
    private String cEitem;

    /**
     * 检测信息
     */
    @Column(name = "c_target_msms")
    private String cTargetMsms;

    /**
     * 检测g6pd
     */
    @Column(name = "c_target_g6pd")
    private String cTargetG6pd;

    /**
     * 医院
     */
    @Column(name = "c_host")
    private String cHost;

    /**
     * 母亲信息
     */
    @Column(name = "c_mother_name")
    private String cMotherName;

    /**
     * 得出结论g6pd
     */
    @Column(name = "c_conclusioin_g6pd")
    private String cConclusioinG6pd;

    /**
     * 检测结果17aoph
     */
    @Column(name = "c_targer_17_aohp")
    private String cTarger17Aohp;

    /**
     * 得出结论phe
     */
    @Column(name = "c_conclusion_phe")
    private String cConclusionPhe;

    /**
     * 得出结论17aohp
     */
    @Column(name = "c_conclusion_17aohp")
    private String cConclusion17aohp;

    /**
     * 婴儿性别
     */
    @Column(name = "c_sex")
    private String cSex;

    /**
     * 采集日期
     */
    @Column(name = "c_collectdate")
    private String cCollectdate;

    /**
     * 婴儿筛查编号
     */
    @Column(name = "c_babybh")
    private String cBabybh;

    /**
     * 检测结果phe
     */
    @Column(name = "c_target_phe")
    private String cTargetPhe;

    /**
     * 检测结果tsh
     */
    @Column(name = "c_targer_tsh")
    private String cTargerTsh;

    /**
     * 得出结论
     */
    @Column(name = "c_conclusion_msms")
    private String cConclusionMsms;

    /**
     * 得出结论tsh
     */
    @Column(name = "c_conclusion_tsh")
    private String cConclusionTsh;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取婴儿出生日期
     *
     * @return c_birthday - 婴儿出生日期
     */
    public String getcBirthday() {
        return cBirthday;
    }

    /**
     * 设置婴儿出生日期
     *
     * @param cBirthday 婴儿出生日期
     */
    public void setcBirthday(String cBirthday) {
        this.cBirthday = cBirthday == null ? null : cBirthday.trim();
    }

    /**
     * 获取筛查项目
     *
     * @return c_eitem - 筛查项目
     */
    public String getcEitem() {
        return cEitem;
    }

    /**
     * 设置筛查项目
     *
     * @param cEitem 筛查项目
     */
    public void setcEitem(String cEitem) {
        this.cEitem = cEitem == null ? null : cEitem.trim();
    }

    /**
     * 获取检测信息
     *
     * @return c_target_msms - 检测信息
     */
    public String getcTargetMsms() {
        return cTargetMsms;
    }

    /**
     * 设置检测信息
     *
     * @param cTargetMsms 检测信息
     */
    public void setcTargetMsms(String cTargetMsms) {
        this.cTargetMsms = cTargetMsms == null ? null : cTargetMsms.trim();
    }

    /**
     * 获取检测g6pd
     *
     * @return c_target_g6pd - 检测g6pd
     */
    public String getcTargetG6pd() {
        return cTargetG6pd;
    }

    /**
     * 设置检测g6pd
     *
     * @param cTargetG6pd 检测g6pd
     */
    public void setcTargetG6pd(String cTargetG6pd) {
        this.cTargetG6pd = cTargetG6pd == null ? null : cTargetG6pd.trim();
    }

    /**
     * 获取医院
     *
     * @return c_host - 医院
     */
    public String getcHost() {
        return cHost;
    }

    /**
     * 设置医院
     *
     * @param cHost 医院
     */
    public void setcHost(String cHost) {
        this.cHost = cHost == null ? null : cHost.trim();
    }

    /**
     * 获取母亲信息
     *
     * @return c_mother_name - 母亲信息
     */
    public String getcMotherName() {
        return cMotherName;
    }

    /**
     * 设置母亲信息
     *
     * @param cMotherName 母亲信息
     */
    public void setcMotherName(String cMotherName) {
        this.cMotherName = cMotherName == null ? null : cMotherName.trim();
    }

    /**
     * 获取得出结论g6pd
     *
     * @return c_conclusioin_g6pd - 得出结论g6pd
     */
    public String getcConclusioinG6pd() {
        return cConclusioinG6pd;
    }

    /**
     * 设置得出结论g6pd
     *
     * @param cConclusioinG6pd 得出结论g6pd
     */
    public void setcConclusioinG6pd(String cConclusioinG6pd) {
        this.cConclusioinG6pd = cConclusioinG6pd == null ? null : cConclusioinG6pd.trim();
    }

    /**
     * 获取检测结果17aoph
     *
     * @return c_targer_17_aohp - 检测结果17aoph
     */
    public String getcTarger17Aohp() {
        return cTarger17Aohp;
    }

    /**
     * 设置检测结果17aoph
     *
     * @param cTarger17Aohp 检测结果17aoph
     */
    public void setcTarger17Aohp(String cTarger17Aohp) {
        this.cTarger17Aohp = cTarger17Aohp == null ? null : cTarger17Aohp.trim();
    }

    /**
     * 获取得出结论phe
     *
     * @return c_conclusion_phe - 得出结论phe
     */
    public String getcConclusionPhe() {
        return cConclusionPhe;
    }

    /**
     * 设置得出结论phe
     *
     * @param cConclusionPhe 得出结论phe
     */
    public void setcConclusionPhe(String cConclusionPhe) {
        this.cConclusionPhe = cConclusionPhe == null ? null : cConclusionPhe.trim();
    }

    /**
     * 获取得出结论17aohp
     *
     * @return c_conclusion_17aohp - 得出结论17aohp
     */
    public String getcConclusion17aohp() {
        return cConclusion17aohp;
    }

    /**
     * 设置得出结论17aohp
     *
     * @param cConclusion17aohp 得出结论17aohp
     */
    public void setcConclusion17aohp(String cConclusion17aohp) {
        this.cConclusion17aohp = cConclusion17aohp == null ? null : cConclusion17aohp.trim();
    }

    /**
     * 获取婴儿性别
     *
     * @return c_sex - 婴儿性别
     */
    public String getcSex() {
        return cSex;
    }

    /**
     * 设置婴儿性别
     *
     * @param cSex 婴儿性别
     */
    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    /**
     * 获取采集日期
     *
     * @return c_collectdate - 采集日期
     */
    public String getcCollectdate() {
        return cCollectdate;
    }

    /**
     * 设置采集日期
     *
     * @param cCollectdate 采集日期
     */
    public void setcCollectdate(String cCollectdate) {
        this.cCollectdate = cCollectdate == null ? null : cCollectdate.trim();
    }

    /**
     * 获取婴儿筛查编号
     *
     * @return c_babybh - 婴儿筛查编号
     */
    public String getcBabybh() {
        return cBabybh;
    }

    /**
     * 设置婴儿筛查编号
     *
     * @param cBabybh 婴儿筛查编号
     */
    public void setcBabybh(String cBabybh) {
        this.cBabybh = cBabybh == null ? null : cBabybh.trim();
    }

    /**
     * 获取检测结果phe
     *
     * @return c_target_phe - 检测结果phe
     */
    public String getcTargetPhe() {
        return cTargetPhe;
    }

    /**
     * 设置检测结果phe
     *
     * @param cTargetPhe 检测结果phe
     */
    public void setcTargetPhe(String cTargetPhe) {
        this.cTargetPhe = cTargetPhe == null ? null : cTargetPhe.trim();
    }

    /**
     * 获取检测结果tsh
     *
     * @return c_targer_tsh - 检测结果tsh
     */
    public String getcTargerTsh() {
        return cTargerTsh;
    }

    /**
     * 设置检测结果tsh
     *
     * @param cTargerTsh 检测结果tsh
     */
    public void setcTargerTsh(String cTargerTsh) {
        this.cTargerTsh = cTargerTsh == null ? null : cTargerTsh.trim();
    }

    /**
     * 获取得出结论
     *
     * @return c_conclusion_msms - 得出结论
     */
    public String getcConclusionMsms() {
        return cConclusionMsms;
    }

    /**
     * 设置得出结论
     *
     * @param cConclusionMsms 得出结论
     */
    public void setcConclusionMsms(String cConclusionMsms) {
        this.cConclusionMsms = cConclusionMsms == null ? null : cConclusionMsms.trim();
    }

    /**
     * 获取得出结论tsh
     *
     * @return c_conclusion_tsh - 得出结论tsh
     */
    public String getcConclusionTsh() {
        return cConclusionTsh;
    }

    /**
     * 设置得出结论tsh
     *
     * @param cConclusionTsh 得出结论tsh
     */
    public void setcConclusionTsh(String cConclusionTsh) {
        this.cConclusionTsh = cConclusionTsh == null ? null : cConclusionTsh.trim();
    }
}