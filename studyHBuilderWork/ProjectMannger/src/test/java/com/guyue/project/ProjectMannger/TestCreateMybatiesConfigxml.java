package com.guyue.project.ProjectMannger;

import java.util.ArrayList;
import java.util.List;

import com.guyue.project.ProjectMannger.create.mybaties.CreateMybatiesConfig;
import com.guyue.project.ProjectMannger.create.vo.MybatiesConfigVo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    public void testApp()
    {
    	List<String> tablesNameList = new ArrayList<String>();
    	init(tablesNameList);
       MybatiesConfigVo mybatiesConfigVo = new MybatiesConfigVo();
       mybatiesConfigVo.setDbJdbcJarPath("E:\\guyue\\project\\maven3.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
       mybatiesConfigVo.setDbDriver("com.mysql.jdbc.Driver");
       mybatiesConfigVo.setDbUrl("jdbc:mysql://127.0.0.1/common?useUnicode=true&amp;characterEncoding=UTF-8");
       mybatiesConfigVo.setDbUserName("root");
       mybatiesConfigVo.setDbPassword("root");
       mybatiesConfigVo.setTargetProjectName("ApiSpeed");
       mybatiesConfigVo.setMapperPackagePath("com.guyue.apispeed.mapping");
       mybatiesConfigVo.setVoPackagePath("com.guyue.apispeed.vo");
       mybatiesConfigVo.setTableNamesList(tablesNameList);
       mybatiesConfigVo.setDaoPackagePath("com.guyue.apispeed.dao");
       mybatiesConfigVo.setResultConfigxmlPath("F:\\studyProjectWork\\studyHBuilderWork\\ApiSpeed\\mybaties-generator-config.xml");
       CreateMybatiesConfig.createMybatiesConfig(mybatiesConfigVo);
    }

	private void init(List<String> tablesNameList) {
		tablesNameList.add("t_common_config");
		tablesNameList.add("t_common_opt_log");
	}
}
