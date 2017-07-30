package com.guyue.common.vo;
/**
 * 数据连接相关工具，建立简易连接
* @ClassName: DBConnecttion  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2016年12月2日 上午11:41:04 
*
 */
public class DBConnecttion {
	private String jdbcJarPath;
	private String jdbcDiverClass;
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	public String getJdbcJarPath() {
		return jdbcJarPath;
	}
	public void setJdbcJarPath(String jdbcJarPath) {
		this.jdbcJarPath = jdbcJarPath;
	}
	public String getJdbcDiverClass() {
		return jdbcDiverClass;
	}
	public void setJdbcDiverClass(String jdbcDiverClass) {
		this.jdbcDiverClass = jdbcDiverClass;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getJdbcUserName() {
		return jdbcUserName;
	}
	public void setJdbcUserName(String jdbcUserName) {
		this.jdbcUserName = jdbcUserName;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
}
