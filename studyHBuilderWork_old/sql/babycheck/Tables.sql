DROP DATABASE IF EXISTS babycheck;
CREATE DATABASE babycheck;
USE babycheck;
DROP TABLE IF EXISTS t_baby_check_http;
CREATE TABLE t_baby_check_http (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_city_bh  varchar(20)  COMMENT '城市编号',
        c_status  varchar(10)  COMMENT '状态 单值代码 00002 0 录入 1 解析处理',
        c_ressult  varchar(300)  COMMENT 'url返回内容 未解析',
        c_url  varchar(300)  COMMENT '请求地址',
        dt_createtime  datetime  COMMENT '创建时间',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '婴儿检测请求';
DROP TABLE IF EXISTS t_baby_check_real_result;
CREATE TABLE t_baby_check_real_result (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_birthday  varchar(15)  COMMENT '婴儿出生日期',
        c_eitem  varchar(30)  COMMENT '筛查项目',
        c_target_msms  varchar(50)  COMMENT '检测信息',
        c_target_g6pd  varchar(50)  COMMENT '检测g6pd',
        c_host  varchar(50)  COMMENT '医院',
        c_mother_name  varchar(20)  COMMENT '母亲信息',
        c_conclusioin_g6pd  varchar(20)  COMMENT '得出结论g6pd',
        c_targer_17_aohp  varchar(10)  COMMENT '检测结果17aoph',
        c_conclusion_phe  varchar(30)  COMMENT '得出结论phe',
        c_conclusion_17aohp  varchar(50)  COMMENT '得出结论17aohp',
        c_sex  varchar(5)  COMMENT '婴儿性别',
        c_collectdate  varchar(15)  COMMENT '采集日期',
        c_babybh  varchar(30)  COMMENT '婴儿筛查编号',
        c_target_phe  varchar(20)  COMMENT '检测结果phe',
        c_targer_tsh  varchar(20)  COMMENT '检测结果tsh',
        c_conclusion_msms  varchar(50)  COMMENT '得出结论',
        c_conclusion_tsh  varchar(50)  COMMENT '得出结论tsh',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '婴儿检测数据分析';
DROP TABLE IF EXISTS t_baby_check_city;
CREATE TABLE t_baby_check_city (
        id  bigint  NOT NULL AUTO_INCREMENT    COMMENT '主键',
        c_city_bh  varchar(20)  COMMENT '城市编号',
        c_url  varchar(100)  COMMENT 'baby筛查url',
        c_valid  varchar(10)  COMMENT '是否有效',
        PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '婴儿检测城市';
