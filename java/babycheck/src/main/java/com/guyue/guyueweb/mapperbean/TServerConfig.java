package com.guyue.guyueweb.mapperbean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_server_config")
public class TServerConfig {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 服务器IP
     */
    @Column(name = "c_ip")
    private String cIp;

    /**
     * 服务器端口
     */
    @Column(name = "c_port")
    private String cPort;

    /**
     * 用户名
     */
    @Column(name = "c_username")
    private String cUsername;

    /**
     * 密码
     */
    @Column(name = "c_password")
    private String cPassword;

    /**
     * mansql日志状态
     */
    @Column(name = "c_slowlogstatus")
    private String cSlowlogstatus;

    /**
     * 更新时间
     */
    @Column(name = "d_updatetime")
    private Date dUpdatetime;

    /**
     * 开始时间
     */
    @Column(name = "d_createtime")
    private Date dCreatetime;

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
     * 获取服务器IP
     *
     * @return c_ip - 服务器IP
     */
    public String getcIp() {
        return cIp;
    }

    /**
     * 设置服务器IP
     *
     * @param cIp 服务器IP
     */
    public void setcIp(String cIp) {
        this.cIp = cIp == null ? null : cIp.trim();
    }

    /**
     * 获取服务器端口
     *
     * @return c_port - 服务器端口
     */
    public String getcPort() {
        return cPort;
    }

    /**
     * 设置服务器端口
     *
     * @param cPort 服务器端口
     */
    public void setcPort(String cPort) {
        this.cPort = cPort == null ? null : cPort.trim();
    }

    /**
     * 获取用户名
     *
     * @return c_username - 用户名
     */
    public String getcUsername() {
        return cUsername;
    }

    /**
     * 设置用户名
     *
     * @param cUsername 用户名
     */
    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    /**
     * 获取密码
     *
     * @return c_password - 密码
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * 设置密码
     *
     * @param cPassword 密码
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    /**
     * 获取mansql日志状态
     *
     * @return c_slowlogstatus - mansql日志状态
     */
    public String getcSlowlogstatus() {
        return cSlowlogstatus;
    }

    /**
     * 设置mansql日志状态
     *
     * @param cSlowlogstatus mansql日志状态
     */
    public void setcSlowlogstatus(String cSlowlogstatus) {
        this.cSlowlogstatus = cSlowlogstatus == null ? null : cSlowlogstatus.trim();
    }

    /**
     * 获取更新时间
     *
     * @return d_updatetime - 更新时间
     */
    public Date getdUpdatetime() {
        return dUpdatetime;
    }

    /**
     * 设置更新时间
     *
     * @param dUpdatetime 更新时间
     */
    public void setdUpdatetime(Date dUpdatetime) {
        this.dUpdatetime = dUpdatetime;
    }

    /**
     * 获取开始时间
     *
     * @return d_createtime - 开始时间
     */
    public Date getdCreatetime() {
        return dCreatetime;
    }

    /**
     * 设置开始时间
     *
     * @param dCreatetime 开始时间
     */
    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }
}