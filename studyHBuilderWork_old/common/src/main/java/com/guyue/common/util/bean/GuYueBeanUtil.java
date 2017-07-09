package com.guyue.common.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import com.guyue.common.util.GuyueLoggerFactory;
import com.guyue.common.util.DB.DatabaseUtil;

/**
 * 操作beanUtil
* @ClassName: GuYueBeanUtil  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2016年12月8日 下午3:19:07 
*
 */
public class GuYueBeanUtil {
	private static Logger logger = GuyueLoggerFactory.getLogger(DatabaseUtil.class);
	public static void setProperty(Object bean, String name, Object value){
		try {
			logger.debug("封装对象{},属性{},值{}", new Object[]{bean,name,value});
			BeanUtils.setProperty(bean, name, value);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("封装对象失败",e);
		}
	}
	@SuppressWarnings("rawtypes")
	public static void setBeans(Object bean, Map properties){
		try {
			logger.debug("封装对象{},Map集合内容为:{}", new Object[]{bean,properties});
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("封装对象失败",e);
		}
	}
}
