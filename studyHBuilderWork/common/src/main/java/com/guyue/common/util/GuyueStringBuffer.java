package com.guyue.common.util;

public class GuyueStringBuffer {
	private StringBuffer sb;
	public GuyueStringBuffer(){
		this.sb = new StringBuffer();
	}
	public void appendln(String str){
		sb.append(str);
		sb.append("\n");
	}
	public String toString(){
		return sb.toString();
	}
}
