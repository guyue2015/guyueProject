
DROP DATABASE  IF EXISTS common;

CREATE DATABASE common;

use common;

DROP TABLE IF EXISTS t_common_log;

CREATE TABLE `t_common_opt_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `operator_id` int(11) NOT NULL COMMENT '操作人id',
  `operator_name` varchar(60) NOT NULL COMMENT '操作人用户名',
  `key_id` int(11) NOT NULL COMMENT '操作数据id',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  `ip` varchar(32) NOT NULL COMMENT 'ip地址',
  `operate_model` int(11) DEFAULT NULL COMMENT '操作模块',
  `action` int(11) NOT NULL COMMENT '操作类型',
  `message` varchar(600) NOT NULL COMMENT '操作内容',
  `source` tinyint(1) NOT NULL COMMENT '1.商城服务 2：商城管理后台',
  `success_status` tinyint(1) NOT NULL COMMENT '成功状态 0 ：不成功 1 ：成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='系统操作日志（包括订单操作）';

DROP TABLE IF EXISTS t_common_config;

CREATE TABLE `t_common_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  systemid INT(11)  COMMENT '系统id',
  `key` varchar(64) NOT NULL COMMENT '配置的key',
  `value` varchar(1024) DEFAULT NULL COMMENT '配置的value',
  `remark` varchar(1024) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='不适合放在配置文件的配置，如需要实时更新的，或者保密的';