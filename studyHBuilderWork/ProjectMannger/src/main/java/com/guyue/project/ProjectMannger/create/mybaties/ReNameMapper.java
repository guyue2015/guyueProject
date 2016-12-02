package com.guyue.project.ProjectMannger.create.mybaties;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.GuyueCollectionUtils;
import com.guyue.common.util.GuyueLoggerFactory;
import com.guyue.common.util.StringUtil;

public class ReNameMapper {
	public static Logger logger = GuyueLoggerFactory.getLogger(FileUtil.class);
	public static void reNameMapperJavaFiles(Path mappingPath,Path daoPath) throws IOException{
		List<Path> mappingXmlPaths = FileUtil.getSubPath(mappingPath);
		
		List<Path> daoJavaPaths = FileUtil.getSubPath(daoPath);
		if(GuyueCollectionUtils.isEmpty(mappingXmlPaths)){
			logger.error("沒有mapping文件,路徑是{}",mappingPath);
			return;
		}
		if(GuyueCollectionUtils.isEmpty(daoJavaPaths)){
			logger.error("沒有java文件,路徑是{}",daoPath);
			return;
		}
		String javaMapperName="";
		String javaContext="";
		String javaDaoName="";
		Path javaDaoPath=null;
		for(Path javaMapperPath:daoJavaPaths){
			if(javaMapperPath.toString().endsWith("Mapper.java")){				
				javaMapperName = javaMapperPath.getFileName().toString().replace(".java", "");
				javaDaoName = javaMapperName.replace("Mapper", "Dao");
				javaContext = new String(Files.readAllBytes(javaMapperPath));
				javaContext = javaContext.replace(javaMapperName, javaDaoName);
				javaDaoPath =  FileSystems.getDefault().getPath(daoPath.toString(),javaDaoName+".java");
				Files.write(javaDaoPath, javaContext.getBytes(), StandardOpenOption.CREATE);
				Files.deleteIfExists(javaMapperPath);
				
			}
		}
//		修改mapper.xml
		Pattern pattern = Pattern.compile("\".*\"");
		Matcher matcher;
		for(Path path:mappingXmlPaths){
			if(path.toString().endsWith(".xml")){
				String line="";
				String daoLine="";
				try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf-8"))) {
					while((line = reader.readLine())!=null){
		                if(line.contains("<mapper namespace=")){
		                	break;
		                }
		            }
					if(StringUtil.isEmpty(line)){
						logger.error("沒有找到“<mapper namespace”节点,文件路径是{}",path);
						continue;
					}
					matcher = pattern.matcher(line);
					if(matcher.find()){
						line = matcher.group(0);
					}
					if(StringUtil.isNotEmpty(line)){
						daoLine = line.replace("Mapper\"", "Dao\"");
						String contextXML = new String(Files.readAllBytes(path));
						contextXML = contextXML.replace(line, daoLine);
						Files.write(path, contextXML.getBytes(),StandardOpenOption.TRUNCATE_EXISTING);
					}
		        } catch (IOException e) {
		        	logger.error("读取文件发生异常,文件路径是:{}",path);
					continue;
				}
			}
		}
	}
}
