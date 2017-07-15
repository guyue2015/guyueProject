package com.guyue.guyueweb.mapperbean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_baby_check_http")
public class TBabyCheckHttp {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 城市编号
     */
    @Column(name = "c_city_bh")
    private String cCityBh;

    /**
     * 状态 单值代码 00002 0 录入 1 解析处理
     */
    @Column(name = "c_status")
    private String cStatus;

    /**
     * url返回内容 未解析
     */
    @Column(name = "c_ressult")
    private String cRessult;

    /**
     * 请求地址
     */
    @Column(name = "c_url")
    private String cUrl;

    /**
     * 创建时间
     */
    @Column(name = "dt_createtime")
    private Date dtCreatetime;

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
     * 获取城市编号
     *
     * @return c_city_bh - 城市编号
     */
    public String getcCityBh() {
        return cCityBh;
    }

    /**
     * 设置城市编号
     *
     * @param cCityBh 城市编号
     */
    public void setcCityBh(String cCityBh) {
        this.cCityBh = cCityBh == null ? null : cCityBh.trim();
    }

    /**
     * 获取状态 单值代码 00002 0 录入 1 解析处理
     *
     * @return c_status - 状态 单值代码 00002 0 录入 1 解析处理
     */
    public String getcStatus() {
        return cStatus;
    }

    /**
     * 设置状态 单值代码 00002 0 录入 1 解析处理
     *
     * @param cStatus 状态 单值代码 00002 0 录入 1 解析处理
     */
    public void setcStatus(String cStatus) {
        this.cStatus = cStatus == null ? null : cStatus.trim();
    }

    /**
     * 获取url返回内容 未解析
     *
     * @return c_ressult - url返回内容 未解析
     */
    public String getcRessult() {
        return cRessult;
    }

    /**
     * 设置url返回内容 未解析
     *
     * @param cRessult url返回内容 未解析
     */
    public void setcRessult(String cRessult) {
        this.cRessult = cRessult == null ? null : cRessult.trim();
    }

    /**
     * 获取请求地址
     *
     * @return c_url - 请求地址
     */
    public String getcUrl() {
        return cUrl;
    }

    /**
     * 设置请求地址
     *
     * @param cUrl 请求地址
     */
    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }

    /**
     * 获取创建时间
     *
     * @return dt_createtime - 创建时间
     */
    public Date getDtCreatetime() {
        return dtCreatetime;
    }

    /**
     * 设置创建时间
     *
     * @param dtCreatetime 创建时间
     */
    public void setDtCreatetime(Date dtCreatetime) {
        this.dtCreatetime = dtCreatetime;
    }
}