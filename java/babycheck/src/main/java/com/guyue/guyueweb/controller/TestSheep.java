package com.guyue.guyueweb.controller;

import java.util.ArrayList;
import java.util.List;

public class TestSheep {
public static void main(String[] args) {
	testSheep(1);
	testSheep(2);
	testSheep(3);
	testSheep(4);
	testSheep(5);
	testSheep(6);
	testSheep(7);
	testSheep(8);
	testSheep(9);
	testSheep(10);
	testSheep(11);
	testSheep(12);
}
/**
 * 测试多年后的养的个数
 * @param year 设置年数
 */
private static void testSheep(Integer year) {
	Sheep.initSheep();
	List<Sheep> allAliveSheep=null;
	for(int i=0;i<year;i++){
		allAliveSheep = Sheep.getAllAliveSheep();
		for(Sheep sheep:allAliveSheep){
			sheep.addYearAndNewOrKill(sheep);
		}
	}
	System.out.println(year+"年之後活羊的個數是:"+Sheep.getAllAliveSheep().size());
}

}
class Sheep{
	//年龄
	private Integer year;
//	是否死亡
	private Boolean isDead;
//	所有的羊
	private static List<Sheep> sheepList = new ArrayList<Sheep>();
//	存活着的羊 临时变量
	private static List<Sheep> aliveSheepList = new ArrayList<Sheep>();
	/**
	 * 初始化 刚开始一个羊
	 */
	public static void initSheep(){
		sheepList.clear();
		putNewSheep();
	}
	/**
	 * 获取所有活着的羊
	 * @return
	 */
	public static List<Sheep> getAllAliveSheep(){
		aliveSheepList.clear();
		for(Sheep sheep:sheepList){
			if(!sheep.isDead){				
				aliveSheepList.add(sheep);
			}
		}
		return aliveSheepList;
	}
	/**
	 * 私有构造 禁止外部创建
	 */
	private Sheep(){
		this.year=0;
		this.isDead = Boolean.FALSE;
	}
	/**
	 * 生羊
	 */
	private static void putNewSheep(){
		sheepList.add(new Sheep());
	}
	/**
	 * 增加年龄 并杀羊或者生小羊
	 * @param sheep
	 */
	public void addYearAndNewOrKill(Sheep sheep){
		addYear();
		Integer year = sheep.getYear();
		if(year==2||year==3||year==5){
			putNewSheep();
		}
		if(sheep.getYear()==7){
			sheep.isDead();
		}
	}
	/**
	 * 仅仅增加羊年齡
	 */
	private void addYear(){
		this.year++;
	}
	/**
	 * 获取羊年龄
	 * @return
	 */
	private Integer getYear(){
		return this.year;
	}
	/**
	 * 杀羊
	 */
	private void isDead(){
		this.isDead=Boolean.TRUE;
	}
	
}