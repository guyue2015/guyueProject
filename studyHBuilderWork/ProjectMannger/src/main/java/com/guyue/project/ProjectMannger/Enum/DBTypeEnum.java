package com.guyue.project.ProjectMannger.Enum;
/**
 * 数据库类型
* @ClassName: DBTypeEnum  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2016年12月1日 上午9:53:17 
*
 */
public enum DBTypeEnum {
	MYSQL(1,"mysql"),ORACLE(2,"oracle"),MSSQL(3,"mssql");
	private int code;
	private String desc;
	DBTypeEnum(int code,String desc){
		this.code=code;
		this.desc=desc;
	}
	public int getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
}
