package com.guyue.project.ProjectMannger.vo;

import java.util.Map;

public class ProjectApiVo {
	private String url;
	private Map<String,String> params;
	private String desc;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
