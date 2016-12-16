DROP DATABASE IF EXISTS common;
CREATE DATABASE common;
USE common;
DROP TABLE IF EXISTS t_guyue_project;
CREATE TABLE t_guyue_project (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(200)  COMMENT '项目名称',
        c_alias  varchar(200)  COMMENT '别名',
        c_webname  varchar(100)  COMMENT '前端web名称',
        c_github  varchar(100)  COMMENT 'githublujing名称',
        c_database  varchar(100)  COMMENT '数据库名称',
        c_codeprefix  varchar(20)  COMMENT '项目代码前缀',
        d_createtime  datetime  COMMENT '创建时间',
        c_desc  varchar(500)  COMMENT '项目描述',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_code;
CREATE TABLE t_common_code (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_codetype  varchar(200)  COMMENT '单值代码类型',
        c_code  varchar(20)  COMMENT '代码',
        c_value  varchar(200)  COMMENT '代码值',
        c_value_en  varchar(200)  COMMENT '英文代码值',
        n_order  int  COMMENT '排序',
        c_pcode  varchar(20)  COMMENT '父代码',
        c_desc  varchar(100)  COMMENT '描述',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_codetype;
CREATE TABLE t_common_codetype (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_codetype  varchar(200)  COMMENT 'code对应的全局key例如：1000000000',
        c_value  varchar(200)  COMMENT 'codetype中文描述',
        c_value_en  varchar(200)  COMMENT 'codetype英文描述',
        n_order  bigint  COMMENT '排序',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_mode;
CREATE TABLE t_common_mode (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(50)  COMMENT '模块名称',
        c_alias  varchar(50)  COMMENT '模块别名',
        c_rightkey  varchar(200)  COMMENT '模块权限字',
        n_projectid  bigint  COMMENT '项目id',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_userright;
CREATE TABLE t_common_userright (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_userid  bigint  COMMENT '用户id',
        c_rightkey  varchar(100)  COMMENT '权限字',
        n_roleid  bigint  COMMENT '角色id',
        n_type  int  COMMENT '赋权类型单值代码1000000002，1权限字2角色id',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_projectuser;
CREATE TABLE t_common_projectuser (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_userid  bigint  COMMENT '用户id',
        n_projectid  bigint  COMMENT '项目id',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_roleright;
CREATE TABLE t_common_roleright (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_rightkey  varchar(200)  COMMENT '权限字',
        n_roleid  bigint  COMMENT '角色id',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_project;
CREATE TABLE t_common_project (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(100)  COMMENT '项目名称',
        c_path  varchar(300)  COMMENT '项目代码所在路径',
        n_codetype  int  COMMENT '项目代码类型1:java',
        n_createuserid  bigint  COMMENT '创建者id',
        d_createtime  datetime  COMMENT '创建时间',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_user;
CREATE TABLE t_common_user (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_username  varchar(100)  COMMENT '用户名称',
        c_password  varchar(50)  COMMENT '密码',
        c_alias  varchar(50)  COMMENT '别名',
        c_headimg  varchar(100)  COMMENT '头像',
        c_phone  varchar(20)  COMMENT '手机号',
        c_email  varchar(100)  COMMENT '电子邮箱',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_role;
CREATE TABLE t_common_role (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(100)  COMMENT '角色名称',
        n_projectid  bigint  COMMENT '项目id',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_common_right;
CREATE TABLE t_common_right (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_projectid  bigint  COMMENT '项目id',
        c_key  varchar(200)  COMMENT '权限字',
        n_invalid  int  COMMENT '是否有效',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
