package com.guyue.project.ProjectMannger.vo;

import java.util.List;

public class MybatiesConfigVo {
	/**
	 * jdbc驱动包路径
	 */
	private String dbJdbcJarPath;
	/**
	 * 项目名称
	 */
	private String targetProjectName;
	/**
	 * 数据库驱动
	 */
	private String dbDriver;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	/**
	 * 生成vo包路径
	 */
	private String voPackagePath;
	/**
	 * 生成mapper包路径
	 */
	private String mapperPackagePath;
	/**
	 * 生成dao包路径
	 */
	private String daoPackagePath;
	/**
	 * 表名称集合，空则生成指定库中的所有表配置
	 */
	private List<String> tableNamesList;
	/**
	 * 生成结果xml路径，为空则生成文件在项目名称下面
	 */
	private String resultConfigxmlPath;
	
	public String getDbJdbcJarPath() {
		return dbJdbcJarPath;
	}
	public void setDbJdbcJarPath(String dbJdbcJarPath) {
		this.dbJdbcJarPath = dbJdbcJarPath;
	}
	public String getTargetProjectName() {
		return targetProjectName;
	}
	public void setTargetProjectName(String targetProjectName) {
		this.targetProjectName = targetProjectName;
	}
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getVoPackagePath() {
		return voPackagePath;
	}
	public void setVoPackagePath(String voPackagePath) {
		this.voPackagePath = voPackagePath;
	}
	public String getMapperPackagePath() {
		return mapperPackagePath;
	}
	public void setMapperPackagePath(String mapperPackagePath) {
		this.mapperPackagePath = mapperPackagePath;
	}
	public String getDaoPackagePath() {
		return daoPackagePath;
	}
	public void setDaoPackagePath(String daoPackagePath) {
		this.daoPackagePath = daoPackagePath;
	}
	public List<String> getTableNamesList() {
		return tableNamesList;
	}
	public void setTableNamesList(List<String> tableNamesList) {
		this.tableNamesList = tableNamesList;
	}
	public String getResultConfigxmlPath() {
		return resultConfigxmlPath;
	}
	public void setResultConfigxmlPath(String resultConfigxmlPath) {
		this.resultConfigxmlPath = resultConfigxmlPath;
	}
}
