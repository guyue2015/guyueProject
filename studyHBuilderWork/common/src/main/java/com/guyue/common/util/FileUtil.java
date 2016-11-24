package com.guyue.common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class FileUtil {
	public static Properties readProperties(String propertiesName) {
		return readProperties(FileSystems.getDefault().getPath(propertiesName));
	}
	/**
	 * 读取properties文件
	  * @Title: readProperties 
	  * @Description: 
	  * @param propertiesPath
	  * @return
	 */
	public static Properties readProperties(Path propertiesPath) {
		Properties properties = new Properties();
		try {
			properties.load(Files.newBufferedReader(propertiesPath,
					Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
