DROP DATABASE IF EXISTS projectmangement;
CREATE DATABASE projectmangement;
USE projectmangement;

DROP TABLE IF EXISTS t_codecheck_rule;
create table t_codecheck_rule (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        checkdesc varchar(200) comment '检查出错时描述',
        name varchar(50) comment '检查名称',
        codetype int comment '代码类型',
        classname varchar(200) comment '类名',
        methodname varchar(100) comment '方法名称',
        invalid int comment '是否有效',
        author bigint comment '作者',
        share int comment '是否共享',
        bak varchar(500) comment '描述',
        type int comment '检查类型',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_project_checkrecord;
create table t_project_checkrecord (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        projectid bigint comment '项目id',
        userid bigint comment '用户id',
        checktime null comment '用户id',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS t_project_checkresult_item;
create table t_project_checkresult_item (
        id bigint NOT NULL AUTO_INCREMENT comment '主键',
        ruleid bigint comment '规则id',
        checkid bigint comment '检查id',
        filepath varchar(300) comment '违反规则文件路径',
        codeline varchar(300) comment '违反规则行内容',
        checkdesc varchar(500) comment '违反规则描述',
        status int comment '状态',
        solveuserid bigint comment '解决人',
        solvetime datetime comment '解决时间',
        checktime datetime comment '检查时间',
        checkuserid bigint comment '检查人',
        PRIMARY KEY (id)
)CHARACTER SET utf8 COLLATE utf8_general_ci;
