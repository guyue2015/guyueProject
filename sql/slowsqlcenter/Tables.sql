DROP DATABASE IF EXISTS slowsqlcenter;
CREATE DATABASE slowsqlcenter;
USE slowsqlcenter;
DROP TABLE IF EXISTS t_server_config;
CREATE TABLE t_server_config (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_ip  varchar(40)  COMMENT '服务器IP',
        c_port  varchar(10)  COMMENT '服务器端口',
        c_username  varchar(20)  COMMENT '用户名',
        c_password  varchar(20)  COMMENT '密码',
        c_slowlogstatus  varchar(10)  COMMENT 'mansql日志状态',
        d_updatetime  datetime  COMMENT '更新时间',
        d_createtime  datetime  COMMENT '开始时间',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '慢sql记录服务器配置';
DROP TABLE IF EXISTS t_slow_set_log;
CREATE TABLE t_slow_set_log (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        long_querytime  decimal(10,4)  COMMENT '设置慢日志记录时间单位s，支持小数',
        startid  bigint  COMMENT '开始id',
        endid  bigint  COMMENT '结束id',
        d_starttime  datetime  COMMENT '开始时间',
        d_endtime  datetime  COMMENT '结束时间',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '慢sql记录设置记录';
