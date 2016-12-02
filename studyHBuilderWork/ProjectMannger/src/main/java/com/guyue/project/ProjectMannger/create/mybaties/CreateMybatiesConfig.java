package com.guyue.project.ProjectMannger.create.mybaties;

import java.util.List;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.GuyueStringBuffer;
import com.guyue.common.util.StringUtil;
import com.guyue.project.ProjectMannger.create.vo.MybatiesConfigVo;

public class CreateMybatiesConfig {
	public static void createMybatiesConfig(MybatiesConfigVo configVo){
		GuyueStringBuffer sb = appendConfig(configVo);
		String configXmlPath = configVo.getResultConfigxmlPath();
		if(StringUtil.isNotEmpty(configXmlPath)){
			FileUtil.deleteFile(configXmlPath);
			FileUtil.writeFile(configXmlPath,sb.toString());
		}
	}
	public static GuyueStringBuffer appendConfig(MybatiesConfigVo configVo){
		GuyueStringBuffer sb = new GuyueStringBuffer();
			sb.appendln("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.appendln("<!DOCTYPE generatorConfiguration");
			sb.appendln("        PUBLIC \"-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN\"");
			sb.appendln("        \"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd\">");
			sb.appendln("<generatorConfiguration>");
//			追加数据库驱动
			appendDbJdbcJar(sb,configVo);
			sb.appendln("    <context id=\"my\" targetRuntime=\"MyBatis3\">");
			sb.appendln("        <commentGenerator>");
			sb.appendln("            <property name=\"suppressDate\" value=\"false\"/>");
			sb.appendln("            <property name=\"suppressAllComments\" value=\"true\"/>");
			sb.appendln("        </commentGenerator>");
//			追加数据库链接配置
			appendDbConfig(sb,configVo);
//			entity
			sb.appendln("        <javaModelGenerator targetPackage=\""+configVo.getVoPackagePath()+"\"");
			sb.appendln("                            targetProject=\""+configVo.getTargetProjectName()+"\">");
			sb.appendln("            <property name=\"enableSubPackages\" value=\"true\"/>");
			sb.appendln("            <property name=\"trimStrings\" value=\"true\"/>");
			sb.appendln("        </javaModelGenerator>");
//			sqlMapper
			sb.appendln("        <sqlMapGenerator targetPackage=\""+configVo.getMapperPackagePath()+"\"");
			sb.appendln("                         targetProject=\""+configVo.getTargetProjectName()+"\">");
			sb.appendln("            <property name=\"enableSubPackages\" value=\"true\"/>");
			sb.appendln("        </sqlMapGenerator>");
//			dao
			sb.appendln("        <javaClientGenerator targetPackage=\""+configVo.getDaoPackagePath()+"\"");
			sb.appendln("                             targetProject=\""+configVo.getTargetProjectName()+"\" type=\"XMLMAPPER\">");
			sb.appendln("            <property name=\"enableSubPackages\" value=\"true\"/>");
			sb.appendln("        </javaClientGenerator>");
//			table
			appendTables(sb,configVo);
//			sb.append("        <!--<table tableName=\"T_FEE_AGTBILL\" domainObjectName=\"FeeAgentBill\"");
//			sb.append("               enableCountByExample=\"false\" enableUpdateByExample=\"false\"");
//			sb.append("               enableDeleteByExample=\"false\" enableSelectByExample=\"false\"");
//			sb.append("               selectByExampleQueryId=\"false\"/>-->");
			sb.appendln("    </context>");
			sb.appendln("</generatorConfiguration>");
			return sb;
		}
	private static void appendTables(GuyueStringBuffer sb, MybatiesConfigVo configVo) {
		List<String> tablesNamesList = configVo.getTableNamesList();
		if(tablesNamesList==null||tablesNamesList.size()==0){
			return;
		}
		String voName="";
		for(String tablesName:tablesNamesList){
			if(tablesName.startsWith("t_")){				
				voName = tablesName.replaceFirst("t_", "");
			}
			if(tablesName.startsWith("T_")){				
				voName = tablesName.replaceFirst("T_", "");
			}
			if(voName==null||voName==""){
				continue;
			}
			String[] voNameArray = voName.split("_");
			voName="";
			if(voNameArray.length>0){
				for(String name:voNameArray){
					voName+=name.substring(0, 1).toUpperCase()+name.substring(1);
				}
			}
			sb.appendln("        <table tableName=\""+tablesName+"\" domainObjectName=\""+voName+"\"");
			sb.appendln("               enableCountByExample=\"false\" enableUpdateByExample=\"false\"");
			sb.appendln("               enableDeleteByExample=\"false\" enableSelectByExample=\"false\"");
			sb.appendln("               selectByExampleQueryId=\"false\">");
			sb.appendln("            <!--<columnRenamingRule searchString=\"^D_\"");
			sb.appendln("                                replaceString=\"\"/>-->");
			sb.appendln("        </table>");
		}
	}
	private static void appendDbJdbcJar(GuyueStringBuffer sb, MybatiesConfigVo configVo){
		sb.appendln("    <classPathEntry");
		sb.appendln("            location=\""+configVo.getDbJdbcJarPath()+"\"/>");
	}
	private static void appendDbConfig(GuyueStringBuffer sb, MybatiesConfigVo configVo){
		sb.appendln("        <jdbcConnection driverClass=\""+configVo.getDbDriver()+"\"");
		sb.appendln("                        connectionURL=\""+configVo.getDbUrl()+"\" userId=\""+configVo.getDbUserName()+"\"");
		sb.appendln("                        password=\""+configVo.getDbPassword()+"\"/>");
	}
}
