package com.guyue.common.util;

public class GuyueStringBuffer {
	private StringBuffer sb;
	public GuyueStringBuffer(){
		this.sb = new StringBuffer();
	}
	public int length(){
		return sb.length();
	}
	public void insert(int dstOffset, String str){
		sb.insert(dstOffset, str);
	}
	public void deleteCharAt(int index){
		sb.deleteCharAt(index);
	}
	public void appendln(String str){
		sb.append(str);
		sb.append("\n");
	}
	public void append(String str){
		sb.append(str);
	}
	public boolean isNotEmpty(){
		return sb.length()>0;
	}
	public String toString(){
		return sb.toString();
	}
}
