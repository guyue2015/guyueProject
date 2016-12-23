package com.guyue.project.ProjectMannger.checkcode.rule;

import java.nio.file.Path;

public interface Rule {
	String getFileSuffix();
	String getErrorInfo(Object... errorInfo);
	void checkRule(Path filePath);
}
