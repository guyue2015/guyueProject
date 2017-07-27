package com.guyue.commonweb.intercepptor;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class}) })
@Slf4j
public class MybatisIntecepter  implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Connection conn = (Connection)invocation.getArgs()[0];
		DatabaseMetaData clientInfo = conn.getMetaData();
		log.info("获取数据库配置信息：{}",clientInfo.getURL());
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		 return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}
	
}
