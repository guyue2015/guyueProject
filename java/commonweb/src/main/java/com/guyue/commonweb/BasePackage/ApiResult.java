package com.guyue.commonweb.BasePackage;

import lombok.Data;

@Data
public class ApiResult {
	private Integer code;
	private Object data;
	private String message;
	public static ApiResult instance(){
		return new ApiResult();
	}
	public static ApiResult invalid(String message){
		ApiResult tesult = ApiResult.instance();
		tesult.message=message;
		tesult.code=400;
		tesult.data=null;
		return tesult;
	}
	
	public static ApiResult invalid(){
		ApiResult tesult = ApiResult.instance();
		tesult.message=null;
		tesult.code=400;
		tesult.data=null;
		return tesult;
	}
	public static ApiResult invalid(Integer code,String message){
		ApiResult tesult = ApiResult.instance();
		tesult.message=message;
		tesult.code=code;
		tesult.data=null;
		return tesult;
	}
	public static ApiResult success(Object data){
		ApiResult tesult = ApiResult.instance();
		tesult.message=null;
		tesult.code=200;
		tesult.data=data;
		return tesult;
	}
	public static ApiResult success(){
		ApiResult tesult = ApiResult.instance();
		tesult.message=null;
		tesult.code=200;
		tesult.data=null;
		return tesult;
	}
}
