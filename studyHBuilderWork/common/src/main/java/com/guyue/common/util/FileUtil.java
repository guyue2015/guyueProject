package com.guyue.common.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 古月操作文件相关接口
 *
 * @author huhedong
 *
 * 2016年11月29日
 */
public class FileUtil {
	public static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	/**
	 * 创建文件或者文件夹
	 * @param path
	 * @param attrs
	 * @return
	 */
	public static Path createFile(Path path,FileAttribute<?>... attrs){
		Path filePath = null;
		try {
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
			List<Path> subPathList = getSubPath(filePath);
			if(subPathList.size()==0){//空文件夹
				try {
					Files.delete(filePath);
				} catch (IOException e) {
					logger.error("刪除文件失败，文件路径是:"+filePath,e);
				}
			}
			for(Path tempFilePath:subPathList){
				deleteFile(tempFilePath,deleteSubFile);
			}
		}else{
			try {
				Files.delete(filePath);
			} catch (IOException e) {
				logger.error("刪除文件失败，文件路径是:"+filePath,e);
			}
		}
	}
	public static List<Path> getSubPath(Path filePath){
		List<Path> subPathList = new ArrayList<Path>(); 
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(filePath)) {
			  for (Path entry: stream) {
				  subPathList.add(entry);
			      }
		} catch (Exception e) {
			logger.error("获取子文件失败，文件路径是:"+filePath,e);
		}
		return subPathList;
	}
}