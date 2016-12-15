package com.guyue.project.ProjectMannger;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.guyue.project.ProjectMannger.create.sql.CreateMySQLFromExcel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestCreateMySqlFromExcel 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCreateMySqlFromExcel( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCreateMySqlFromExcel.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCreateMysql()
    {
    	String excelFilePath= "C:\\guyue\\gitForme\\studyHBuilderWork\\项目数据库设计\\项目管理.xlsx";
    	String sqlFilePath = "C:\\guyue\\gitForme\\studyHBuilderWork\\sql";
    	Path excelPath = FileSystems.getDefault().getPath(excelFilePath);
    	Path sqlPath = FileSystems.getDefault().getPath(sqlFilePath);
    	CreateMySQLFromExcel.createMysqlFromExcel(excelPath, sqlPath);
    }
}
