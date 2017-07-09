package com.guyue.project.ProjectMannger.checkcode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.guyue.common.util.FileUtil;
import com.guyue.project.ProjectMannger.checkcode.rule.Rule;

public class CheckFileRules {
	public static void checkRules(Path projectPath,List<Rule> rules){
		List<Path> subPath = new ArrayList<Path>();
		FileUtil.getSubPath(projectPath,subPath);
		for(Path path:subPath){
			for(Rule rule:rules){
				rule.checkRule(path);
			}
		}
	}
}
