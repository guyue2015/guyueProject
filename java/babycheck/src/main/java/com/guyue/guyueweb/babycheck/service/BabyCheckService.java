package com.guyue.guyueweb.babycheck.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guyue.commonweb.BasePackage.ApiResult;
import com.guyue.commonweb.util.DateUtil;
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
		Long startNo = babyCheckVo.getStartNo();
		Integer year = babyCheckVo.getYear();
		Hashtable<Long, Object> checkResult = new Hashtable<Long, Object>();
		String url = tBabyCheckCityMapper.selectByPrimaryKey(babyCheckVo.getCityId()).getcUrl();
		for(int i=0;i<babyCheckVo.getIncrement();i++){
			executorService.submit(new BabyCheckThread(startNo++,year,url,checkResult));
		}
		return null;
	}
}
@Slf4j
class BabyCheckThread implements Runnable{
	private Long startNo;
	private String checkUrl;
	private Date startDate;
	private Date endDate;
	private Hashtable<Long, Object> checkResult;
	public BabyCheckThread(Long startNo, Integer year,String checkUrl, Hashtable<Long, Object> checkResult) {
		this.startNo = startNo;
		this.checkUrl = checkUrl;
		this.checkResult = checkResult;
		Calendar cal = Calendar.getInstance();
		cal.set(2000+year, 1, 1);
		this.startDate = cal.getTime();
		cal.set(2000+year, 12, 31);
		this.endDate = cal.getTime();
	}
	@Override
	public void run() {
		RestClient restClient = new RestClient();
		Boolean hasResult=Boolean.FALSE;
		while(!hasResult&&startDate.before(endDate)){
			Map<String,Object> result = restClient.get(String.format(checkUrl, startNo,DateUtil.formatDateYYYYMMDD(startDate)), Map.class);			 
			if(result!=null){
				log.info("获取检测编号：{},结果：{}",startNo,result);
				checkResult.put(startNo, result);
				hasResult = Boolean.TRUE;
			}
			startDate = DateUtil.addDays(startDate, 1);
		}
	}
	
}
