DROP DATABASE IF EXISTS common;
CREATE DATABASE common;
USE common;
DROP TABLE IF EXISTS t_common_xzqh;
CREATE TABLE t_common_xzqh (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_bh  varchar(20)  COMMENT '行政区划编号',
        c_name  varchar(50)  COMMENT '行政区划名称',
        c_pinyin  varchar(50)  COMMENT '拼音',
        c_parent_bh  varchar(20)  COMMENT '父编号',
        i_order  int  COMMENT '排序',
        c_level  varchar(10)  COMMENT '层级',
        c_valid  varchar(10)  COMMENT '是否有效',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '行政区划';
DROP TABLE IF EXISTS t_common_config;
CREATE TABLE t_common_config (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_system_code  varchar(50)  COMMENT '系统编码',
        c_key  varchar(100)  COMMENT '系统配置key',
        c_value  varchar(100)  COMMENT '系统配置value',
        c_valid  varchar(10)  COMMENT '是否有效',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '通用配置';
DROP TABLE IF EXISTS t_common_system;
CREATE TABLE t_common_system (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(100)  COMMENT '系统名称',
        c_code  varchar(20)  COMMENT '系统编码',
        c_desc  varchar(300)  COMMENT '系统描述',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '系统';
