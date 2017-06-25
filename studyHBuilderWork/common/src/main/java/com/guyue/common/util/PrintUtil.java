package com.guyue.common.util;

import java.util.List;
import java.util.Map;

public class PrintUtil {
	public static<K,V> void printlnMap(Map<K,V> map){
		for(K key:map.keySet()){
			System.out.println(key+"="+map.get(key));
		}
	}
	
	public static<K,V> void printMap(Map<K,V> map){
		for(K key:map.keySet()){
			System.out.print(key+"="+map.get(key));
		}
		System.out.println();
	}
	public static<K> void printlnList(List<K> list){
		for(K key:list){
			System.out.println(key);
		}
	}
}
