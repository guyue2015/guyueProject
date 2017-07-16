package com.guyue.guyueweb.mapperbean;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_slow_set_log")
public class TSlowSetLog {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 设置慢日志记录时间单位s，支持小数
     */
    @Column(name = "long_querytime")
    private BigDecimal longQuerytime;

    /**
     * 开始id
     */
    private Long startid;

    /**
     * 结束id
     */
    private Long endid;

    /**
     * 开始时间
     */
    @Column(name = "d_starttime")
    private Date dStarttime;

    /**
     * 结束时间
     */
    @Column(name = "d_endtime")
    private Date dEndtime;

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
     * 获取设置慢日志记录时间单位s，支持小数
     *
     * @return long_querytime - 设置慢日志记录时间单位s，支持小数
     */
    public BigDecimal getLongQuerytime() {
        return longQuerytime;
    }

    /**
     * 设置设置慢日志记录时间单位s，支持小数
     *
     * @param longQuerytime 设置慢日志记录时间单位s，支持小数
     */
    public void setLongQuerytime(BigDecimal longQuerytime) {
        this.longQuerytime = longQuerytime;
    }

    /**
     * 获取开始id
     *
     * @return startid - 开始id
     */
    public Long getStartid() {
        return startid;
    }

    /**
     * 设置开始id
     *
     * @param startid 开始id
     */
    public void setStartid(Long startid) {
        this.startid = startid;
    }

    /**
     * 获取结束id
     *
     * @return endid - 结束id
     */
    public Long getEndid() {
        return endid;
    }

    /**
     * 设置结束id
     *
     * @param endid 结束id
     */
    public void setEndid(Long endid) {
        this.endid = endid;
    }

    /**
     * 获取开始时间
     *
     * @return d_starttime - 开始时间
     */
    public Date getdStarttime() {
        return dStarttime;
    }

    /**
     * 设置开始时间
     *
     * @param dStarttime 开始时间
     */
    public void setdStarttime(Date dStarttime) {
        this.dStarttime = dStarttime;
    }

    /**
     * 获取结束时间
     *
     * @return d_endtime - 结束时间
     */
    public Date getdEndtime() {
        return dEndtime;
    }

    /**
     * 设置结束时间
     *
     * @param dEndtime 结束时间
     */
    public void setdEndtime(Date dEndtime) {
        this.dEndtime = dEndtime;
    }
}