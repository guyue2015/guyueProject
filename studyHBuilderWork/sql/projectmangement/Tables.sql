DROP DATABASE IF EXISTS projectmangement;
CREATE DATABASE projectmangement;
USE projectmangement;
DROP TABLE IF EXISTS t_project_checkrecord;
CREATE TABLE t_project_checkrecord (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_projectid  bigint  COMMENT '项目id',
        n_userid  bigint  COMMENT '用户id',
        d_checktime  datetime  COMMENT '检查时间',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_codecheck_rule;
CREATE TABLE t_codecheck_rule (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_checkdesc  varchar(200)  COMMENT '检查出错时描述',
        c_name  varchar(50)  COMMENT '检查名称',
        c_codetype  varchar(200)  COMMENT '代码类型',
        c_classname  varchar(200)  COMMENT '类名',
        c_methodname  varchar(100)  COMMENT '方法名称',
        n_invalid  int  COMMENT '是否有效单值代码1000000001,1是2否',
        n_author  bigint  COMMENT '作者',
        n_share  int  COMMENT '是否共享单值代码1000000001,1是2否',
        c_desc  varchar(500)  COMMENT '描述',
        n_type  int  COMMENT '检查类型单值代码1000020002，1服务器代码2数据库3接口',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
DROP TABLE IF EXISTS t_project_checkresult_item;
CREATE TABLE t_project_checkresult_item (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        n_ruleid  bigint  COMMENT '规则id',
        n_checkid  bigint  COMMENT '检查id',
        c_filepath  varchar(300)  COMMENT '违反规则文件路径',
        c_codeline  varchar(300)  COMMENT '违反规则行内容',
        c_checkdesc  varchar(500)  COMMENT '违反规则描述',
        n_status  int  COMMENT '状态单值代码1000020001，1创建2分配3解决',
        n_solveuserid  bigint  COMMENT '解决人',
        d_solvetime  datetime  COMMENT '解决时间',
        d_checktime  datetime  COMMENT '检查时间',
        n_checkuserid  bigint  COMMENT '检查人',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
