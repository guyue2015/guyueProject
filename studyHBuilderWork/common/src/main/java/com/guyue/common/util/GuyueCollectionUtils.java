package com.guyue.common.util;

import java.util.Collection;

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
}
