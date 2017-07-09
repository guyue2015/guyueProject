package com.guyue.common.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

public class GuyueCollectionUtils {
	/**
	 * 判断集合是否为空
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}
	public static<K,V> void printlnMap(Map<K,V> map){
		for(K key:map.keySet()){
			System.out.println(key+"="+map.get(key));
		}
	}
	public static<K> void printlnSet(Set<K> set){
		Iterator<K> it = set.iterator();
		while(it.hasNext()){
			K value = it.next(); 
			System.out.println(value);
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
