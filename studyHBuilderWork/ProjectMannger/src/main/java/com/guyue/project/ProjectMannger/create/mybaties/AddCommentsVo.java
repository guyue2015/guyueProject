package com.guyue.project.ProjectMannger.create.mybaties;

import java.util.List;
import java.util.Map;

import com.guyue.common.util.DB.DatabaseUtil;
import com.guyue.common.vo.DBColumn;
import com.guyue.common.vo.DBConnecttion;

public class AddCommentsVo {
	public static void addComments(DBConnecttion connect,String dbName,Map<String,String> javaFileTableRelations){
		DatabaseUtil.createAndReturenConnect(connect);
		for(String tableName:javaFileTableRelations.keySet()){
			List<DBColumn> tableColumns = DatabaseUtil.getDBColumns(dbName,tableName);
		}
	}
	
}
