package com.guyue.project.ProjectMannger.create.mybaties;

import java.nio.file.Path;
import java.util.List;

import com.guyue.common.util.FileUtil;

public class ReNameMapper {
	public void reNameMapperJavaFiles(Path mappingPath,Path daoPath){
		List<Path> mappingXmlPaths = FileUtil.getSubPath(mappingPath);
		
		List<Path> daoJavaPaths = FileUtil.getSubPath(daoPath);
		
	}
}
