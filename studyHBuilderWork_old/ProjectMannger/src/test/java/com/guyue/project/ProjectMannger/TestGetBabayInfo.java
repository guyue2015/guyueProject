package com.guyue.project.ProjectMannger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.guyue.common.util.DateUtil;
import com.guyue.common.util.HttpClientUtil;
import com.guyue.common.util.StringUtil;

public class TestGetBabayInfo {
	private static List<String> urlGet = new ArrayList<String>();
	private static long bhStart = 17000098705L;
	private static int limit = 500;
	private static Date startDate = DateUtil.praseDateymd("2017-6-01");
//	static{
//		for(int i=0;i<limit;i++){
//			bhStart = bhStart+1;
//			for(int j=0;j<100;j++){
//				urlGet.add("http://fyxs.isgenetic.com/cx/QueryformServlet?barcode="+bhStart+"&birthday="+DateUtil.praseDateymd(startDate));
//				startDate = DateUtil.addDays(startDate, 1);
//			}
//		}
//	}
	public static void main(String[] args) {
		String url="http://fyxs.isgenetic.com/cx/QueryformServlet?barcode=17000098705&birthday=2017-06-02";
		String result  = HttpClientUtil.httpGet(url);
		System.out.println(result);
//		for(String url:urlGet){			
//			String result  = HttpClientUtil.httpGet(url);
//			if(StringUtil.isEmpty(result)||result.contains("[]")){
//				
//			}else{
//				System.out.println(result);
//			}
//		}
	}
	
	
}


[{
	 "BIRTHDAY":"2017-06-02",
	 "EITEM":"PHE,TSH,17_a_OHP",
	 "TARGET_MSMS":null,
	 "TARGET_G6PD":null,
	 "HOS":"阜南县人民医院",
	 "PATIENTNAME":"刘红勤",
	 "CONCLUSION_G6PD":null,
	 "TARGET_17_A_OHP":"1.96",
	 "CONCLUSION_PHE":"正常",
	 "CONCLUSION_17AOHP":"正常",
	 "SEX":"女",
	 "COLLECTDATE":"2017-06-06",
	 "BARCODESTRING":"17000098705",
	 "TARGET_PHE":"0.9",
	 "TARGET_TSH":"2.75",
	 "CONCLUSION_MSMS":null,
	 "CONCLUSION_TSH":"正常"
		 }]


