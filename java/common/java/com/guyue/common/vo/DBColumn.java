package com.guyue.common.vo;


public class DBColumn {
	private String columnDbName;
	private String columnTableName;
	private String columnName;
	private String columnComment;
	private String columnType;
	private int columnMaxLength;
	private String columnPRI;
	private String columnAutoInCrement;
	public String getColumnDbName() {
		return columnDbName;
	}
	public void setColumnDbName(String columnDbName) {
		this.columnDbName = columnDbName;
	}
	public String getColumnTableName() {
		return columnTableName;
	}
	public void setColumnTableName(String columnTableName) {
		this.columnTableName = columnTableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public int getColumnMaxLength() {
		return columnMaxLength;
	}
	public void setColumnMaxLength(int columnMaxLength) {
		this.columnMaxLength = columnMaxLength;
	}
	public String getColumnPRI() {
		return columnPRI;
	}
	public void setColumnPRI(String columnPRI) {
		this.columnPRI = columnPRI;
	}
	public String getColumnAutoInCrement() {
		return columnAutoInCrement;
	}
	public void setColumnAutoInCrement(String columnAutoInCrement) {
		this.columnAutoInCrement = columnAutoInCrement;
	}
	public boolean isPRI(){
		return "PRI".equals(columnPRI);
	}
	public boolean isAutoIncrement(){
		return "auto_increment".equals(columnAutoInCrement);
	}
}
