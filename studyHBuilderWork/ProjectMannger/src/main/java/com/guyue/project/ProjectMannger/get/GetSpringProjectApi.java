package com.guyue.project.ProjectMannger.get;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.guyue.common.util.FileUtil;
import com.guyue.project.ProjectMannger.vo.ProjectApiVo;
public class GetSpringProjectApi {
	public List<ProjectApiVo> getProjectApi(Path controllerClassPath){
		List<ProjectApiVo> apiList = new ArrayList<ProjectApiVo>();
		List<Path> daoJavaPaths = new ArrayList<Path>();
		FileUtil.getSubPath(controllerClassPath,daoJavaPaths);
		for(Path javaControllerPath:daoJavaPaths){
			if(javaControllerPath.toString().endsWith(".java")){				
				List<String> javaController = FileUtil.readFileForList(javaControllerPath);
			}
		}
		return apiList;
	}
}
