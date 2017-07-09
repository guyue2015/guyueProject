package com.guyue.common.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.BeanUtils;

public class TestBeanUtil {
	private static String[] typeArr = new String[]{"String","Date","Integer","Boolean"};
	public static void main(String[] args) {
//		createJavaFile(800);
		TestBean testBean = new TestBean();
		copyBean copyBean = new copyBean();
		Field[] declaredFields = testBean.getClass().getDeclaredFields();
		String propertyName;
		for(int i=0;i<declaredFields.length;i++){
			propertyName = declaredFields[i].getName();
			Class<?> type = declaredFields[i].getType();
			try {
				Method method = testBean.getClass().getMethod("set"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1, propertyName.length()),type);
				Object defaultValue=getDefaultValue(type.getName());
				method.invoke(testBean,defaultValue);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		long startTime = System.currentTimeMillis();
		BeanUtils.copyProperties(testBean, copyBean);
		System.out.println(String.format("属性复制完毕，耗时：%s", ""+(System.currentTimeMillis()-startTime)));
		copyBean = new copyBean();
		BeanUtils.copyProperties(testBean, copyBean);
		System.out.println(String.format("属性复制完毕，耗时：%s", ""+(System.currentTimeMillis()-startTime)));
		copyBean = new copyBean();
		BeanUtils.copyProperties(testBean, copyBean);
		System.out.println(String.format("属性复制完毕，耗时：%s", ""+(System.currentTimeMillis()-startTime)));
	}
	private static Object getDefaultValue(String type) {
		if("java.lang.String".equalsIgnoreCase(type)){
			return "测试字符串";
		}else if("java.util.Date".equalsIgnoreCase(type)){
			return new Date();
		}else if("java.lang.Integer".equalsIgnoreCase(type)){
			return Integer.valueOf(2);
		}else if("java.lang.Boolean".equalsIgnoreCase(type)){
			return true;
		}
		return null;
	}
	/**
	 * 创建java File
	  * @Title: createJavaFile 
	  * @Description: 
	  * @param propertyNumber
	 */
	private static void createJavaFile(int propertyNumber) {
		Random rc = new Random();
		for(int i=0;i<propertyNumber;i++){
			int typeIndex = rc.nextInt(4);
//			System.out.println(String.format("random index ={},value={}",typeIndex, typeArr[typeIndex]));
			System.out.println(String.format("private %s %s;", typeArr[typeIndex],"testProperty"+i));
		}
	}
}
