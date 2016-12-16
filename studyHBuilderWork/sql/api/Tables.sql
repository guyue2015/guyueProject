DROP DATABASE IF EXISTS api;
CREATE DATABASE api;
USE api;
DROP TABLE IF EXISTS t_project_inteface;
CREATE TABLE t_project_inteface (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_name  varchar(100)  COMMENT '接口名称',
        c_path  varchar(100)  COMMENT '接口请求路径',
        c_desc  varchar(300)  COMMENT '接口描述',
        c_classname  varchar(200)  COMMENT '接口类名',
        c_methodname  varchar(100)  COMMENT '接口方法名',
        c_methodtype  varchar(10)  COMMENT '接口类型',
        c_result  varchar(300)  COMMENT '返回结果',
        n_projectid  bigint  COMMENT '项目id',
        n_author  bigint  COMMENT '作者',
        n_status  int  COMMENT '接口状态单值代码1000010001，最新接口2历史接口',
        c_returneg  varchar(500)  COMMENT '返回示例',
        n_interfaceid  bigint  COMMENT '上次接口名称',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_project_params;
CREATE TABLE t_project_params (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_intefaceid  bigint  COMMENT '接口id',
        n_type  int  COMMENT '参数类型',
        c_desc  varchar(200)  COMMENT '参数描述',
        c_parameg  varchar(200)  COMMENT '参数示例',
        n_require  int  COMMENT '是否必须有单值代码1000000001,1是2否',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
