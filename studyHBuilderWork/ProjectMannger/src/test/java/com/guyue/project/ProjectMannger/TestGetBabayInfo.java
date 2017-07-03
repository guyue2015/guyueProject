package com.guyue.project.ProjectMannger;

import com.guyue.common.util.HttpClientUtil;

public class TestGetBabayInfo {
	public static void main(String[] args) {
		String url="http://fyxs.isgenetic.com/cx/QueryformServlet?barcode=17000098704&birthday=2017-06-01";
		String result  = HttpClientUtil.httpGet(url);
		System.out.println(result);
	}
}
