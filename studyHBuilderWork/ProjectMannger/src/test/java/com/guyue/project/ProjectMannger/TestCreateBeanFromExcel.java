package com.guyue.project.ProjectMannger;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.guyue.project.ProjectMannger.create.bean.CreateBeanFromExcel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestCreateBeanFromExcel 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCreateBeanFromExcel( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCreateBeanFromExcel.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCreateBeanFromExcel()
    {
    	Map<String,Integer>excelHeadDefine = new HashMap<String,Integer>();
    	excelHeadDefine.put("propertyName", 0);
    	excelHeadDefine.put("propertyType", 2);
    	excelHeadDefine.put("propertyComment", 3);
    	String excelFile = "F:\\工作资料\\柚信科技工作记录\\20170118风控之同盾项目\\未捷请求参数路径.xlsx";
    	Integer sheetIndex=Integer.valueOf(0);
    	Path excelPath = FileSystems.getDefault().getPath(excelFile);
    	CreateBeanFromExcel.createBeanFromExcel(excelHeadDefine, false, excelPath,sheetIndex);
    }
}
