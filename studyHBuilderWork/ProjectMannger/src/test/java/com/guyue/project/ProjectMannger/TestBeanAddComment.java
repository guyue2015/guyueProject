package com.guyue.project.ProjectMannger;

import com.guyue.common.vo.DBConnecttion;
import com.guyue.project.ProjectMannger.create.mybaties.AddCommentsVo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestBeanAddComment  extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestBeanAddComment(String testName )
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(TestBeanAddComment.class );
    }
    /**
     * Rigourous Test :-)
     */
    public void testBeanAddComment()
    {
    	DBConnecttion dbConnection = new DBConnecttion();
    	dbConnection.setJdbcJarPath("E:\\guyue\\project\\maven3.1\\repository\\mysql\\mysql-connector-java\\5.1.31\\mysql-connector-java-5.1.31.jar");
    	dbConnection.setJdbcDiverClass("com.mysql.jdbc.Driver");
    	dbConnection.setJdbcUrl("jdbc:mysql://127.0.0.1/common?useUnicode=true&amp;characterEncoding=UTF-8");
    	dbConnection.setJdbcUserName("root");
    	dbConnection.setJdbcPassword("root");
    	AddCommentsVo.addComments(dbConnection, "ec_ceb", null);
    }
}
