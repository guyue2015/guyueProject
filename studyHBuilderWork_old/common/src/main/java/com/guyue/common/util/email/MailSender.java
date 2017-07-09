package com.guyue.common.util.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class MailSender {
	/**
	 * 以文本格式发送邮件
	 */
	public boolean sendTextMail(SendMail mailInfo) {
		// 判断是否需要身份认证
		Authentication authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new Authentication(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			Message mailMessage = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
			
			
			String mailContent = mailInfo.getContent();
			
			mailMessage.setText(mailContent);
			
			
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 */
	public boolean sendHtmlMail(SendMail mailInfo) {
		// 判断是否需要身份认证
		Authentication authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			authenticator = new Authentication(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
			
			
			Multipart mainPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			
			mailMessage.setContent(mainPart);
			
			
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	/**
	 * 发送HTML格式文件，包含图片，附件
	 * @param mailInfo
	 * @return
	 */
	public boolean sendHtmlMail2(SendMail mailInfo) {
		// 判断是否需要身份认证
		Authentication authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			authenticator = new Authentication(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
		      
		    //邮件正文 
		    MimeMultipart multipart = new MimeMultipart("mixed"); 
		    mailMessage.setContent(multipart); 
		    /* 
		     * 创建邮件的内容 
		     * 包括一个邮件正文和两个附件 
		     */ 
		    MimeBodyPart content = new MimeBodyPart();   //邮件内容 
//		    MimeBodyPart attch1 = new MimeBodyPart();   //附件1 
//		    MimeBodyPart attch2 = new MimeBodyPart();   //附件2 
		    //将邮件内容添加到multipart中 
		    multipart.addBodyPart(content); 
//		    multipart.addBodyPart(attch1); 
//		    multipart.addBodyPart(attch2); 
//		      
//		    //设置附件1 
//		    DataSource ds1 = new FileDataSource("G:\\电子书\\oracle口令.txt"); 
//		    DataHandler dh1 = new DataHandler(ds1); 
//		    attch1.setDataHandler(dh1); 
//		    attch1.setFileName("oracle.txt"); 
//		    //设置附件2 
//		    DataSource ds2 = new FileDataSource("G:\\电子书\\账号.txt"); 
//		    DataHandler dh2 = new DataHandler(ds2); 
//		    attch2.setDataHandler(dh2); 
//		    attch2.setFileName(MimeUtility.encodeText("账号.txt")); 
		    /* 
		     * 设置内容（正文）---是一个复杂体 
		     * 包括HTML正文和显示一张图片 
		     */
		    MimeMultipart bodyMultipart = new MimeMultipart("related"); 
		    content.setContent(bodyMultipart); 
		    //构造正文 
		    MimeBodyPart htmlBody = new MimeBodyPart(); 
		    MimeBodyPart gifBody = new MimeBodyPart(); 
		    bodyMultipart.addBodyPart(htmlBody); 
		    bodyMultipart.addBodyPart(gifBody); 
		    String path = MailSender.class.getClassLoader().getResource("").getPath()+"email//";
		    //设置图片 
		    DataSource gifds = new FileDataSource(path+"logo.png"); 
		    DataHandler gifdh = new DataHandler(gifds); 
		    gifBody.setDataHandler(gifdh); 
		    gifBody.setHeader("Content-ID", "<logo>"); 
		    //gifBody.setHeader("Content-Location", "http://www.itcast.cn/logo.gif"); 
		    //设置HTML正文 
			path =path+"index.html";
			String stringvalue = readHTML(path);
					
			stringvalue = stringvalue.replaceAll("toemailaddress",mailInfo.getToAddress());
			stringvalue = stringvalue.replaceAll("emailverifycode",mailInfo.getContent());
		    
		    htmlBody.setContent(stringvalue, "text/html;charset=UTF-8"); 
		      
		    mailMessage.saveChanges();    //生成邮件 
		    Transport.send(mailMessage); 
		    return true ;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	  } 
	
	public static String readHTML(String spath) {

		InputStreamReader isReader = null;

		BufferedReader bufReader = null;

		StringBuffer buf = new StringBuffer();

		try {

			File file = new File(spath);

			isReader = new InputStreamReader(new FileInputStream(file), "utf-8");

			bufReader = new BufferedReader(isReader, 1);

			String data;

			while ((data = bufReader.readLine()) != null) {

				buf.append(data);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				isReader.close();
				bufReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			return buf.toString();
	}
}