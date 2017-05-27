package com.guyue.common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
/**
 * 古月操作文件相关接口
 *
 * @author huhedong
 *
 * 2016年11月29日
 */
public class FileUtil {
	public static Logger logger = GuyueLoggerFactory.getLogger(FileUtil.class);
	/**
	 * 创建文件或者文件夹
	 * @param path
	 * @param attrs
	 * @return
	 */
	public static Path createFile(Path path,FileAttribute<?>... attrs){
		Path filePath = null;
		try {
			if(!exists(path.getParent())){
				createFile(path.getParent());
			}
			if(!path.toString().contains(".")){
				filePath = Files.createDirectory(path, attrs);
			}else{
				filePath = Files.createFile(path, attrs);
			}
		} catch (IOException e) {
			logger.error("创建文件失败",e);
		}
		return filePath;
	}
	/**
	 * 根据文件名称创建文件或文件夹
	 * @param fileName 文件路径
	 * @return
	 */
	public static Path createFile(String fileName){
		Path filePath = FileSystems.getDefault().getPath(fileName);
		filePath = createFile(filePath);
		return filePath;
	}
	/**
	 * 将字符串转为Path
	  * @Title: getPraseFileStrToPath 
	  * @Description: 
	  * @param fileDir
	  * @return
	 */
	public static Path getPraseFileStrToPath(String fileDir){
		Path filePath = FileSystems.getDefault().getPath(fileDir);
		return filePath;
	}
	/**
	 * 删除空文件夹或者文件
	 * 文件夹为空文件夹才能删除成功
	 * @param filePath
	 */
	public static void deleteFile(Path filePath){
		deleteFile(filePath,false);
	}
	/**
	 * 删除空文件夹或者文件
	 * 文件夹为空文件夹才能删除成功
	 * @param fileName
	 */
	public static void deleteFile(String fileName){
		Path filePath = FileSystems.getDefault().getPath(fileName);
		deleteFile(filePath,false);
	}
	/**
	 * 删除文件夹或者文件 文件夹可以不为空
	 * @param fileName
	 * @param deleteSubFile 当filePath为文件夹时，根据此参数是否循环删除子文件
	 */
	public static void deleteFile(String fileName,boolean deleteSubFile){
		Path filePath = FileSystems.getDefault().getPath(fileName);
		deleteFile(filePath,deleteSubFile);
	}
	/**
	 * 删除文件夹或者文件 文件夹可以不为空
	 * @param filePath 
	 * @param deleteSubFile 当filePath为文件夹时，根据此参数是否循环删除子文件
	 */
	public static void deleteFile(Path filePath,boolean deleteSubFile){
		if(deleteSubFile && Files.isDirectory(filePath)){
			List<Path> subPathList = new ArrayList<Path>();
			getSubPath(filePath,subPathList);
			if(subPathList.size()==0){//空文件夹
				try {
					Files.deleteIfExists(filePath);
				} catch (IOException e) {
					logger.error("刪除文件失败，文件路径是:"+filePath,e);
				}
			}
			for(Path tempFilePath:subPathList){
				deleteFile(tempFilePath,deleteSubFile);
			}
		}else{
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e) {
				logger.error("刪除文件失败，文件路径是:"+filePath,e);
			}
		}
	}
	public static String readFileForString(String fileName,Charset... cs){
		Path filePath = FileSystems.getDefault().getPath(fileName);		
		return readFileForString(filePath,cs);
	}
	public static List<String> readFileForList(Path path,Charset... cs){
		try {
			if(cs!=null&&cs.length>0){				
				return Files.readAllLines(path, cs[0]);
			}else{
				return Files.readAllLines(path,Charset.defaultCharset());
			}
		} catch (Exception e) {
			logger.error("读物文件失败，文件路径是:"+path,e);
			return new ArrayList<String>();
		}
	}
	public static String readFileForString(Path path,Charset... cs){
		try {
			if(cs!=null&&cs.length>0){				
				return new String(Files.readAllBytes(path),cs[0]);
			}else{
				return new String(Files.readAllBytes(path));
			}
		} catch (Exception e) {
			logger.error("读物文件失败，文件路径是:"+path,e);
			return "";
		}
	}
	public static void getSubPath(Path filePath,List<Path> subPathList){
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
			  for (Path entry: stream) {
					  if(Files.isDirectory(entry)){
						  getSubPath(entry,subPathList);
					  }else{
						  subPathList.add(entry);
					  }
			      }
		} catch (Exception e) {
			logger.error("获取子文件失败，文件路径是:"+filePath,e);
		}
	}
	/**
	 * 判断指定filePath是否存在
	  * @Title: exists 
	  * @Description: 
	  * @param filePath
	  * @return
	 */
	public static boolean exists(Path filePath){
		return Files.exists(filePath);
	}
	public static void writeFile(String fileName, String sb) {
		Path path = createFile(fileName);
		try {
			Files.write(path, sb.toString().getBytes());
		} catch (IOException e) {
			logger.error("写入文件失败，文件路径是:"+fileName,e);
		}
	}
	public static void writeFile(Path filePath, String sb) {
		try {
			Files.write(filePath, sb.toString().getBytes());
		} catch (IOException e) {
			logger.error("写入文件失败，文件路径是:"+filePath,e);
		}
	}
}
