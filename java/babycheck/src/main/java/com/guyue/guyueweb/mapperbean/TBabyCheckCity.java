package com.guyue.guyueweb.mapperbean;

import javax.persistence.*;

@Table(name = "t_baby_check_city")
public class TBabyCheckCity {
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
     * baby筛查url
     */
    @Column(name = "c_url")
    private String cUrl;

    /**
     * 是否有效
     */
    @Column(name = "c_valid")
    private String cValid;

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
     * 获取baby筛查url
     *
     * @return c_url - baby筛查url
     */
    public String getcUrl() {
        return cUrl;
    }

    /**
     * 设置baby筛查url
     *
     * @param cUrl baby筛查url
     */
    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }

    /**
     * 获取是否有效
     *
     * @return c_valid - 是否有效
     */
    public String getcValid() {
        return cValid;
    }

    /**
     * 设置是否有效
     *
     * @param cValid 是否有效
     */
    public void setcValid(String cValid) {
        this.cValid = cValid == null ? null : cValid.trim();
    }
}