package com.guyue.common.vo;

import java.util.List;

public class DBTable {
	private String tableDbName;
	private String tableName;
	private List<DBColumn> tableColumnList;
	public String getTableDbName() {
		return tableDbName;
	}
	public void setTableDbName(String tableDbName) {
		this.tableDbName = tableDbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<DBColumn> getTableColumnList() {
		return tableColumnList;
	}
	public void setTableColumnList(List<DBColumn> tableColumnList) {
		this.tableColumnList = tableColumnList;
	}
}
