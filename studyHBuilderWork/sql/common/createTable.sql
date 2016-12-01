
DROP DATABASE  IF EXISTS common;

CREATE DATABASE common;

use common;

DROP TABLE IF EXISTS t_common_log;

CREATE TABLE `t_common_opt_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `operator_id` int(11) NOT NULL COMMENT '������id',
  `operator_name` varchar(60) NOT NULL COMMENT '�������û���',
  `key_id` int(11) NOT NULL COMMENT '��������id',
  `create_time` datetime NOT NULL COMMENT '����ʱ��',
  `ip` varchar(32) NOT NULL COMMENT 'ip��ַ',
  `operate_model` int(11) DEFAULT NULL COMMENT '����ģ��',
  `action` int(11) NOT NULL COMMENT '��������',
  `message` varchar(600) NOT NULL COMMENT '��������',
  `source` tinyint(1) NOT NULL COMMENT '1.�̳Ƿ��� 2���̳ǹ����̨',
  `success_status` tinyint(1) NOT NULL COMMENT '�ɹ�״̬ 0 �����ɹ� 1 ���ɹ�',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='ϵͳ������־����������������';

DROP TABLE IF EXISTS t_common_config;

CREATE TABLE `t_common_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  systemid INT(11)  COMMENT 'ϵͳid',
  `key` varchar(64) NOT NULL COMMENT '���õ�key',
  `value` varchar(1024) DEFAULT NULL COMMENT '���õ�value',
  `remark` varchar(1024) DEFAULT NULL COMMENT '˵��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='���ʺϷ��������ļ������ã�����Ҫʵʱ���µģ����߱��ܵ�';