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
    	excelHeadDefine.put(CreateBeanFromExcel.propertyName_KEY, 0);
    	excelHeadDefine.put(CreateBeanFromExcel.propertyType_KEY, 2);
    	excelHeadDefine.put(CreateBeanFromExcel.propertyComment_KEY, 3);
    	excelHeadDefine.put(CreateBeanFromExcel.propertyTestValue_KEY, 4);
//    	String excelFile = "F:\\工作资料\\柚信科技工作记录\\20170118风控之同盾项目\\未捷请求参数路径.xlsx";
    	String excelFile = "F:\\工作资料\\柚信科技工作记录\\20170118风控之同盾项目\\数据认证测试数据.xlsx";
    	Integer sheetIndex=Integer.valueOf(0);
    	Path excelPath = FileSystems.getDefault().getPath(excelFile);
    	CreateBeanFromExcel.createBeanFromExcel(excelHeadDefine, false, excelPath,sheetIndex);
    }
}
