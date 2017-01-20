package com.guyue.project.ProjectMannger;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.guyue.project.ProjectMannger.create.mybaties.ReNameMapper;

public class TestReNameMapper extends TestCase{
	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestReNameMapper( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(TestReNameMapper.class );
    }
    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void ReName() throws IOException
    {
    	Path mappingPath = FileSystems.getDefault().getPath("C:\\guyue\\gitForme\\studyHBuilderWork\\ApiSpeed\\src\\main\\java\\com\\guyue\\apispeed\\mapping");
    	Path daoPath = FileSystems.getDefault().getPath("C:\\guyue\\gitForme\\studyHBuilderWork\\ApiSpeed\\src\\main\\java\\com\\guyue\\apispeed\\dao");
    	ReNameMapper.reNameMapperJavaFiles(mappingPath, daoPath);
    }
    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testReYouxinRcDaoName() throws IOException
    {
    	Path mappingPath = FileSystems.getDefault().getPath("E:\\guyue\\rc\\Source\\rc-api\\src\\main\\java\\com\\creditpomelo\\rc\\api\\mapping");
    	Path daoPath = FileSystems.getDefault().getPath("E:\\guyue\\rc\\Source\\rc-api\\src\\main\\java\\com\\creditpomelo\\rc\\api\\repository");
    	ReNameMapper.reNameMapperJavaFiles(mappingPath, daoPath);
    }
}
