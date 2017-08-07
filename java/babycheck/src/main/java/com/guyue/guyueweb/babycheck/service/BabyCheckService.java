package com.guyue.guyueweb.babycheck.service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.commonweb.util.DateUtil;
import com.guyue.commonweb.util.HttpClientUtil;
import com.guyue.commonweb.util.RestClient;
import com.guyue.guyueweb.babycheck.vo.BabyCheckVo;
import com.guyue.guyueweb.mapper.TBabyCheckCityMapper;
import com.guyue.guyueweb.mapper.TBabyCheckHttpMapper;

@Service
public class BabyCheckService extends BabyCommonService{

	@Autowired
	private TBabyCheckCityMapper tBabyCheckCityMapper;
	@Autowired
	private TBabyCheckHttpMapper tBabyCheckHttpMapper;
	
	
	private ExecutorService executorService = Executors.newFixedThreadPool(100);
	
	public ApiResult checkDoding(BabyCheckVo babyCheckVo) {
		String startNo = babyCheckVo.getStartNo();
		Integer year = babyCheckVo.getYear();
		Hashtable<String, Object> checkResult = new Hashtable<String, Object>();
		String url = tBabyCheckCityMapper.selectByPrimaryKey(babyCheckVo.getCityId()).getcUrl();
		char[] noArray = startNo.toCharArray();
		int indexNotZero=0;
		for(int i=0;i<noArray.length;i++){
			char temp = noArray[i];
			if(temp!='0'){
				indexNotZero=i;
				break;
			}
		}
		String substartNo = startNo.substring(0, indexNotZero);
		Long valus = Long.valueOf(startNo.substring(indexNotZero, startNo.length()));
		String runNo = startNo;
		for(int i=0;i<babyCheckVo.getIncrement();i++){
			runNo = substartNo+""+valus;
			executorService.submit(new BabyCheckThread(runNo,year,url,checkResult));
			valus++;
		}
		return null;
	}
}
@Slf4j
class BabyCheckThread implements Runnable{
	private String startNo;
	private String checkUrl;
	private Date startDate;
	private Date endDate;
	private Hashtable<String, Object> checkResult;
	public BabyCheckThread(String startNo, Integer year,String checkUrl, Hashtable<String, Object> checkResult) {
		this.startNo = startNo;
		this.checkUrl = checkUrl;
		this.checkResult = checkResult;
		Calendar cal = Calendar.getInstance();
		cal.set(2000+year, 0, 1);
		this.startDate = cal.getTime();
		cal.set(2000+year, 11, 31);
		this.endDate = cal.getTime();
	}
	@Override
	public void run() {
		Boolean hasResult=Boolean.FALSE;
		while(!hasResult&&startDate.before(endDate)){
			Map<String,String> params = new HashMap<String, String>();
			params.put("barcode", startNo);
			params.put("birthday", DateUtil.formatDateYYYYMMDD(startDate));
			String result = HttpClientUtil.httpPost(checkUrl, null, params, "utf-8");
			if(StringUtils.isEmpty(result)||result.contains("[]")){
				startDate = DateUtil.addDays(startDate, 1);
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				String logString = "编号："+startNo+",结果:"+result;
				log.info("获取检测编号：{},结果：{}",startNo,result);
				checkResult.put(startNo, result);
				Path logFilepath = FileSystems.getDefault().getPath("F:\\logFile.txt");
				try {
					Files.write(logFilepath, logString.getBytes(), StandardOpenOption.APPEND);
				} catch (IOException e) {
					log.error("记录结果失败",e);
				}
				hasResult = Boolean.TRUE;
			}
		}
	}
	
}
