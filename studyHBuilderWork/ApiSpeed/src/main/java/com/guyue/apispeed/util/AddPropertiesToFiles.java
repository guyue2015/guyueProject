package com.guyue.apispeed.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class AddPropertiesToFiles {
	/**
	 * 将context追加至file内容最后
	  * @Title: AddStringBufferToFile 
	  * @Description: 
	  * @param path
	  * @param context
	 */
	public static void AddStringBufferToFile(Path path,StringBuffer context){
		try {
			Files.write(path, context.toString().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void getPath(List<Path> pathList,Path path) throws IOException{
		if(Files.isDirectory(path)){
		DirectoryStream<Path> stream = Files.newDirectoryStream(path);
	       for (Path entry: stream) {
	    	   getPath(pathList,entry);
	        }
		}else{
			pathList.add(path);
		}
	}
	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("E:\\guyue\\git\\Source\\easycommerce-management-api\\profiles");
		List<Path> subPathList = new ArrayList<Path>();
		getPath(subPathList,path);
//		StringBuffer sb = setStringBuffer(FileSystems.getDefault().getPath("D:/local.properties"));
		for(Path tempPath:subPathList){
			StringBuffer sb = setStringBuffer(tempPath);
			AddStringBufferToFile(tempPath,sb);
		}
	}
	private static StringBuffer setStringBuffer(Path tempPath) {
		StringBuffer sb = new StringBuffer();
		sb.setLength(0);
		String quartzDomain = "";
		String localhostDomain = "http\\://localhost:8888/api";
		String secrate = "7a34a0ff78577a69ba27936a9ab1e864";
		String devDomain = "http://dev.m.cebshop.tyiti.com/api";
		String testDomain = "http://test.m.cebshop.tyiti.com/api";
		String domain="";
		String key="";
		if(tempPath.endsWith("dev.properties")||tempPath.endsWith("dev1.properties")||tempPath.endsWith("dev2.properties")||tempPath.endsWith("dev3.properties")){
			quartzDomain = "http\\://localhost:9999/quartzapi";
			domain = devDomain;
			key = secrate;
		}else if(tempPath.getFileName().startsWith("test.properties")){
			quartzDomain = "http\\://localhost:9999/quartzapi";
			domain = testDomain;
			key = secrate;
		}else if(tempPath.getFileName().startsWith("local.properties")){
			quartzDomain = "http\\://localhost:9999/quartzapi";
			domain = localhostDomain;
			key = secrate;
		}
		sb.append("\n");
		sb.append("#############定时调度相关配置开始#################");
		sb.append("\n");
		sb.append("#任务调度系统 链接地址");
		sb.append("\n");
		sb.append("qrtzSysUrl= %s");
		sb.append("\n");
		sb.append("#任务调度系统 连接秘钥");
		sb.append("\n");
		sb.append("qrtzSystemSecretKey= %s");
		sb.append("\n");
		sb.append("#任务调度，开始活动回调路径");
		sb.append("\n");
		sb.append("activityStartQrtzCalbackUrl= %s");
		sb.append("\n");
		sb.append("#任务调度，结束活动回调路径");
		sb.append("\n");
		sb.append("activityEndQrtzCalbackUrl= %s");
		sb.append("\n");
		sb.append("#############定时调度相关配置结束#################");
		sb.append("\n");
		sb = new StringBuffer(String.format(sb.toString(), quartzDomain,key,getCatString(domain,"/activity/startActivity",""),getCatString(domain,"/activity/endActivity","")));
		return sb;
	}
	private static String getCatString(String startString,String lastString,String defaultString){
		if(!StringUtils.isEmpty(startString)){
			return startString+lastString;
		}else{
			return defaultString;
		}
	}
}
