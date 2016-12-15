DROP DATABASE IF EXISTS api;
CREATE DATABASE api;
USE api;

DROP TABLE IF EXISTS t_project_inteface;
create table t_project_inteface (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        name varchar(100) comment '接口名称',
        path varchar(100) comment '接口请求路径',
        bak varchar(300) comment '接口描述',
        classname varchar(200) comment '接口类名',
        methodname varchar(100) comment '接口方法名',
        methodtype varchar(10) comment '接口类型',
        result varchar(300) comment '返回结果',
        projectid bigint comment '项目id',
        author bigint comment '作者',
        status int comment '接口状态1最新接口2历史接口',
        returneg varchar(500) comment '返回示例',
        interfaceid bigint comment '上次接口名称',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_project_params;
create table t_project_params (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        intefaceid bigint comment '接口id',
        type int comment '参数类型',
        bak varchar(200) comment '参数描述',
        parameg varchar(200) comment '参数示例',
        require int comment '是否必须有',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;
