package com.guyue.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuyueLoggerFactory {
	public static Logger getLogger(Class className){
		 return LoggerFactory.getLogger(className);
	}
}
