package com.guyue.ProjectMangerSpringBoot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jna.Library;
import com.sun.jna.Native;

 

/** Simple example of native library declaration and usage. */

public class HelloWorld {
//    public interface CLibrary extends Library {
//        CLibrary INSTANCE = (CLibrary)
//            Native.loadLibrary("D:\\logs\\msvcrt", CLibrary.class);
//        void printf(String format, Object... args);
//    }
//    public static void main(String[] args) {
//        CLibrary.INSTANCE.printf("Hello, World/n");
//        for (int i=0;i < args.length;i++) {
//            CLibrary.INSTANCE.printf("Argument %d: %s/n", i, args[i]);
//        }
//    }
	 public interface CLibrary extends Library {
	        CLibrary INSTANCE = (CLibrary)
	            Native.loadLibrary("F:\\迅雷下载\\Interop.U8Login",
	                               CLibrary.class);
	        boolean Login(String sSubId, String sAccID, String sYear, String sUserID, String sPassword, String sDate, String sServer, String sSerial);
//	        var sServer = GetAppSetting("U8Server");
//            var sUserID = GetAppSetting("U8User");
//            var sPassword = GetAppSetting("U8Key");
//            var sAccID = $"{GetAppSetting("U8DB")}@{GetAppSetting("U8AccID")}";
//            var sYear = GetAppSetting("U8Year");
//            var sDate = DateTime.Now.ToString("yyyy-MM-dd");
//	        var sSubId = "SA";
//            var sSerial = "";
//	        U8Login.Login(String sSubId, ref sAccID, ref sYear, ref sUserID, ref sPassword, ref sDate, ref sServer, String sSerial)) return;
	        
	    }
	    public static void main(String[] args) {
	    	String sSubId = "SA";
	    	String sAccID = "{WIN-6EQU1C1UH6K@501}";
	    	String sYear = "2016";
	    	String sUserID = "demo";
	    	String sPassword = "DEMO";
	    	 DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");
	    	String sDate = df_ymd.format(new Date());
	    	String sServer = "localhost";
	    	String sSerial = "";
	    	System.out.println(CLibrary.INSTANCE.Login(sSubId, sAccID, sYear, sUserID, sPassword, sDate, sServer, sSerial));
	    }
}
