package com.guyue.project.ProjectMannger;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.guyue.project.ProjectMannger.create.mybaties.CreateMybatiesConfig;
import com.guyue.project.ProjectMannger.vo.MybatiesConfigVo;

public class TestCreateMybatiesConfigxml extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCreateMybatiesConfigxml( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(TestCreateMybatiesConfigxml.class );
    }
    /**
     * Rigourous Test :-)
     */
    public void CreateConfigApi()
    {
//    	List<String> tablesNameList = new ArrayList<String>();
//    	initApi(tablesNameList);
//       MybatiesConfigVo mybatiesConfigVo = new MybatiesConfigVo();
//       mybatiesConfigVo.setDbJdbcJarPath("C:\\guyue\\project\\maven3.1.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
//       mybatiesConfigVo.setDbDriver("com.mysql.jdbc.Driver");
//       mybatiesConfigVo.setDbUrl("jdbc:mysql://127.0.0.1/common?useUnicode=true&amp;characterEncoding=UTF-8");
//       mybatiesConfigVo.setDbUserName("root");
//       mybatiesConfigVo.setDbPassword("root");
//       mybatiesConfigVo.setTargetProjectName("ApiSpeed");
//       mybatiesConfigVo.setMapperPackagePath("com.guyue.apispeed.mapping");
//       mybatiesConfigVo.setVoPackagePath("com.guyue.apispeed.vo");
//       mybatiesConfigVo.setTableNamesList(tablesNameList);
//       mybatiesConfigVo.setDaoPackagePath("com.guyue.apispeed.dao");
//       mybatiesConfigVo.setResultConfigxmlPath("C:\\guyue\\gitForme\\studyHBuilderWork\\ApiSpeed\\mybaties-generator-config.xml");
//       CreateMybatiesConfig.createMybatiesConfig(mybatiesConfigVo);
    	List<String> tablesNameList = new ArrayList<String>();
    	initApi(tablesNameList);
       MybatiesConfigVo mybatiesConfigVo = new MybatiesConfigVo();
       mybatiesConfigVo.setDbJdbcJarPath("E:\\guyue\\project\\maven3.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
       mybatiesConfigVo.setDbDriver("com.mysql.jdbc.Driver");
       mybatiesConfigVo.setDbUrl("jdbc:mysql://127.0.0.1/api?useUnicode=true&amp;characterEncoding=UTF-8");
       mybatiesConfigVo.setDbUserName("root");
       mybatiesConfigVo.setDbPassword("root");
       mybatiesConfigVo.setTargetProjectName("ApiSpeed");
       mybatiesConfigVo.setMapperPackagePath("com.guyue.apispeed.mapper");
       mybatiesConfigVo.setVoPackagePath("com.guyue.apispeed.vo");
       mybatiesConfigVo.setTableNamesList(tablesNameList);
       mybatiesConfigVo.setDaoPackagePath("com.guyue.apispeed.dao");
       mybatiesConfigVo.setResultConfigxmlPath("F:\\studyProjectWork\\studyHBuilderWork\\ApiSpeed\\mybaties-generator-config.xml");
       CreateMybatiesConfig.createMybatiesConfig(mybatiesConfigVo);
    }
    /**
     * Rigourous Test :-)
     */
    public void CreateConfigCommon()
    {
    	List<String> tablesNameList = new ArrayList<String>();
    	initCommon(tablesNameList);
       MybatiesConfigVo mybatiesConfigVo = new MybatiesConfigVo();
       mybatiesConfigVo.setDbJdbcJarPath("E:\\guyue\\project\\maven3.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
       mybatiesConfigVo.setDbDriver("com.mysql.jdbc.Driver");
       mybatiesConfigVo.setDbUrl("jdbc:mysql://127.0.0.1/common?useUnicode=true&amp;characterEncoding=UTF-8");
       mybatiesConfigVo.setDbUserName("root");
       mybatiesConfigVo.setDbPassword("root");
       mybatiesConfigVo.setTargetProjectName("common");
       mybatiesConfigVo.setMapperPackagePath("com.guyue.common.mapper");
       mybatiesConfigVo.setVoPackagePath("com.guyue.common.vo");
       mybatiesConfigVo.setTableNamesList(tablesNameList);
       mybatiesConfigVo.setDaoPackagePath("com.guyue.common.dao");
       mybatiesConfigVo.setResultConfigxmlPath("F:\\studyProjectWork\\studyHBuilderWork\\common\\mybaties-generator-config.xml");
       CreateMybatiesConfig.createMybatiesConfig(mybatiesConfigVo);
    }

	private void initCommon(List<String> tablesNameList) {
		tablesNameList.add("t_common_code");
		tablesNameList.add("t_common_codetype");
		tablesNameList.add("t_common_mode");
		tablesNameList.add("t_common_project");
		tablesNameList.add("t_common_projectuser");
		tablesNameList.add("t_common_right");
		tablesNameList.add("t_common_role");
		tablesNameList.add("t_common_roleright");
		tablesNameList.add("t_common_user");
		tablesNameList.add("t_common_userright");
		tablesNameList.add("t_guyue_project");
	}
	private void initApi(List<String> tablesNameList) {
		tablesNameList.add("t_project_inteface");
		tablesNameList.add("t_project_params");
	}
	 /**
     * Rigourous Test :-)
     */
    public void testCreateConfigYouxinRc()
    {
    	List<String> tablesNameList = new ArrayList<String>();
    	initYouxinRc(tablesNameList);
       MybatiesConfigVo mybatiesConfigVo = new MybatiesConfigVo();
       mybatiesConfigVo.setDbJdbcJarPath("E:\\guyue\\project\\maven3.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
       mybatiesConfigVo.setDbDriver("com.mysql.jdbc.Driver");
       mybatiesConfigVo.setDbUrl("jdbc:mysql://192.168.17.128/youxin_rc?useUnicode=true&amp;characterEncoding=UTF-8");
       mybatiesConfigVo.setDbUserName("ec");
       mybatiesConfigVo.setDbPassword("ec");
       mybatiesConfigVo.setTargetProjectName("rc-api");
       mybatiesConfigVo.setMapperPackagePath("com.creditpomelo.rc.api.mapping");
       mybatiesConfigVo.setVoPackagePath("com.creditpomelo.rc.api.entity");
       mybatiesConfigVo.setTableNamesList(tablesNameList);
       mybatiesConfigVo.setDaoPackagePath("com.creditpomelo.rc.api.repository");
       mybatiesConfigVo.setResultConfigxmlPath("E:\\guyue\\rc\\Source\\rc-api\\src\\main\\java\\com\\creditpomelo\\rc\\api\\mybaties-generator-config.xml");
       CreateMybatiesConfig.createMybatiesConfig(mybatiesConfigVo);
    }

	private void initYouxinRc(List<String> tablesNameList) {
		tablesNameList.add("rc_blacklist_user");
		tablesNameList.add("rc_dic");
		tablesNameList.add("rc_dic_detail");
		tablesNameList.add("rc_geo_ip");
		tablesNameList.add("rc_hit_rules");
		tablesNameList.add("rc_partner_busi");
		tablesNameList.add("rc_partner_info");
		tablesNameList.add("rc_permission");
		tablesNameList.add("rc_policy_set");
		tablesNameList.add("rc_rec_busi");
		tablesNameList.add("rc_rec_srv");
		tablesNameList.add("rc_req_attach");
		tablesNameList.add("rc_req_base");
		tablesNameList.add("rc_req_contacts");
		tablesNameList.add("rc_res_base");
		tablesNameList.add("rc_role");
		tablesNameList.add("rc_role_perm");
		tablesNameList.add("rc_sys_user");
		tablesNameList.add("rc_user_role");
		tablesNameList.add("rc_td_attribution");
	}
}
