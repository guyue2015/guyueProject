package com.guyue.project.ProjectMannger;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.guyue.project.ProjectMannger.checkcode.CheckFileRules;
import com.guyue.project.ProjectMannger.checkcode.rule.CheckExceptionOutRule;
import com.guyue.project.ProjectMannger.checkcode.rule.CheckMethodSizeRule;
import com.guyue.project.ProjectMannger.checkcode.rule.Rule;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestCheckFileRules 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestCheckFileRules( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestCheckFileRules.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFileCheckRules()
    {
    	CheckExceptionOutRule rule1 = new CheckExceptionOutRule();
    	CheckMethodSizeRule methodSizeRule = new CheckMethodSizeRule();
    	List<Rule> testRulesList =new ArrayList<Rule>();
    	testRulesList.add(rule1);
    	testRulesList.add(methodSizeRule);
//    	String projectPathFileName = "E:\\guyue\\git\\Source\\easycommerce-management-api\\";
    	String projectPathFileName = "E:\\guyue\\ty_order_system\\source\\";
    	Path projectPath = FileSystems.getDefault().getPath(projectPathFileName);
    	CheckFileRules.checkRules(projectPath, testRulesList);
    }
}
