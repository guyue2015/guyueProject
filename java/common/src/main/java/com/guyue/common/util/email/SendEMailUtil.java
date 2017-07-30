package com.guyue.common.util.email;


public class SendEMailUtil {
	
	private String mailServerHost ;
	private String mailServerPort ;
	private String fromAddress ;
	private String userName ;
	private String password ;
	private String mailTitle ;
	
	public String getMailServerHost() {
		return mailServerHost;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public String getMailServerPort() {
		return mailServerPort;
	}

	public void setMailServerPort(String mailServerPort) {
		this.mailServerPort = mailServerPort;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public SendEMailUtil() {
//		设置邮件发送人参数
//		  this.mailServerHost = SpringPropertiesUtil.getProperty("mailServerHost");
//		  this.mailServerPort = SpringPropertiesUtil.getProperty("mailServerPort");
//		  this.fromAddress = SpringPropertiesUtil.getProperty("fromAddress");
//		  this.userName = SpringPropertiesUtil.getProperty("userName");
//		  this.password = SpringPropertiesUtil.getProperty("password");
//		  this.mailTitle = SpringPropertiesUtil.getProperty("mailTitle");
	}
	
	public Integer sendMail(String mail, String verify_code) {
		SendMail mailInfo = new SendMail();
		mailInfo.setMailServerHost(mailServerHost);
		mailInfo.setMailServerPort(mailServerPort);
		mailInfo.setValidate(true);
		mailInfo.setUserName(userName);
		mailInfo.setPassword(password);// 您的邮箱密码
		mailInfo.setFromAddress(fromAddress);
		mailInfo.setToAddress(mail);
		mailInfo.setSubject(mailTitle);// 邮件标题
		mailInfo.setContent(verify_code);
		// 这个类主要来发送邮件
		MailSender sms = new MailSender();
		//boolean a = sms.sendTextMail(mailInfo);// 发送文体格式
		// boolean a = sms.sendHtmlMail(mailInfo);
		boolean a = sms.sendHtmlMail2(mailInfo);
		if (a) {
			return 1;
		} else {
			return 0;
		}
	}
}