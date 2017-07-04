package com.guyue.project.ProjectMannger;

import com.guyue.common.util.HttpClientUtil;

public class TestGetBabayInfo {
	public static void main(String[] args) {
		String url="http://fyxs.isgenetic.com/cx/QueryformServlet?barcode=17000098705&birthday=2017-06-02";
//		String urlWx = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzUyMzAzNzc3Ng==#wechat_redirect";
		String result  = HttpClientUtil.httpGet(url);
		System.out.println(result);
	}
}
