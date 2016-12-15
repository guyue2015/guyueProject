DROP DATABASE IF EXISTS common;
CREATE DATABASE common;
USE common;

DROP TABLE IF EXISTS t_common_project;
create table t_common_project (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        name varchar(100) comment '项目名称',
        path varchar(300) comment '项目代码所在路径',
        codetype int comment '项目代码类型1:java',
        createuserid bigint comment '创建者id',
        createtime datetime comment '创建时间',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_user;
create table t_common_user (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        username varchar(100) comment '用户名称',
        password varchar(50) comment '密码',
        alias varchar(50) comment '别名',
        headimg varchar(100) comment '头像',
        phone varchar(20) comment '手机号',
        email varchar(100) comment '电子邮箱',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_role;
create table t_common_role (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        name varchar(100) comment '角色名称',
        projectid bigint comment '项目id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_right;
create table t_common_right (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        projectid bigint comment '项目id',
        key varchar(200) comment '权限字',
        invalid int comment '是否有效',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_mode;
create table t_common_mode (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        name varchar(50) comment '模块名称',
        alias varchar(50) comment '模块别名',
        rightkey varchar(200) comment '模块权限字',
        projectid bigint comment '项目id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_userright;
create table t_common_userright (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        userid bigint comment '用户id',
        rightkey varchar(100) comment '权限字',
        roleid bigint comment '角色id',
        type int comment '赋权类型1权限字2角色id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_projectuser;
create table t_common_projectuser (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        userid bigint comment '用户id',
        projectid bigint comment '项目id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_roleright;
create table t_common_roleright (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        rightkey bigint comment '权限字',
        roleid bigint comment '角色id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_codetype;
create table t_common_codetype (
        id bingint NOT NULL AUTO_INCREMENT comment '主键',
        key varchar(200) comment 'code对应的全局key例如：1000000000',
        value varchar(200) comment 'code描述',
        order bigint comment '排序',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_common_code;
create table t_common_code (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        codetype varchar(200) comment '单值代码类型',
        code int comment '代码',
        value varchar(200) comment '代码值',
        value_en varchar(200) comment '英文代码值',
        order int comment '排序',
        pcode int comment '父代码',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;
