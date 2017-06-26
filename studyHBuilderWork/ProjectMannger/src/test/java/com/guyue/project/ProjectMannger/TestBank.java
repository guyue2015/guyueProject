package com.guyue.project.ProjectMannger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.guyue.common.util.FileUtil;
import com.guyue.common.util.office.ExcelUtil;

public class TestBank {
	public static void main(String[] args) {
		List<Bank> bankList = new ArrayList<Bank>(); 
		List<Bank> bankListNew = new ArrayList<Bank>(); 
		Set<String> bankname = new HashSet<String>();
		String excelPath = "F:/工作资料/柚信科技工作记录/20170515钱包相关内容/卡bin-cardbin.xls";
		Path path = FileUtil.getPraseFileStrToPath(excelPath);
		Map<Integer,List<Map<Integer,String>>> readExcel = ExcelUtil.readExcel(path);
		List<Map<Integer,String>> sheetMap0 = readExcel.get(0);
		for(Map<Integer,String> tempMap:sheetMap0){
			if(tempMap.containsKey(15)&&"借记卡".equals(tempMap.get(15))){
				Bank bank = new Bank();
				String[] split = tempMap.get(0).replace("\n", "").split("\\(");
				bankname.add(split[0]);
				bank.setBankName(split[0]);
				bank.setBankCode(split[1].replace(")", ""));
				bank.setCardLength(Integer.valueOf(tempMap.get(8)));
				bank.setPrefixLength(Integer.valueOf(tempMap.get(12)));
				bank.setPrefix(tempMap.get(13));
				bankList.add(bank);
			}
		}
		System.out.println("========");
		for(Bank bank:bankList){
			if(bank.getBankName().contains("北京银行")){
				bank.setBankId(1);
			}else if(bank.getBankName().contains("工商银行") || bank.getBankName().contains("工银")){
				bank.setBankId(2);
			}else if(bank.getBankName().contains("农业银行")){
				bank.setBankId(3);
			}else if(bank.getBankName().contains("中国银行")){
				bank.setBankId(4);
			}else if(bank.getBankName().contains("建设银行")){
				bank.setBankId(5);
			}else if(bank.getBankName().contains("光大银行")){
				bank.setBankId(6);
			}else if(bank.getBankName().contains("广发银行")){
				bank.setBankId(7);
			}else if(bank.getBankName().contains("兴业银行")){
				bank.setBankId(8);
			}else if(bank.getBankName().contains("民生银行")){
				bank.setBankId(9);
			}else if(bank.getBankName().contains("中信银行")){
				bank.setBankId(10);
			}else if(bank.getBankName().contains("交通银行")){
				bank.setBankId(11);
			}else if(bank.getBankName().contains("平安银行")){
				bank.setBankId(12);
			}else if(bank.getBankName().contains("邮政储蓄")||bank.getBankName().contains("邮储银行")){
				bank.setBankId(13);
			}
			if(bank.getBankId()!=null){
				bankListNew.add(bank);
			}
		}
		Collections.sort(bankListNew);
		for(Bank bank:bankListNew){
			System.out.println(bank.getInsertSql());
		}
	}
}
class Bank implements Comparable{
	private Integer bankId;
	private String insertSql;
	private String bankName;
	private String bankCode;
	private Integer cardLength;
	private Integer prefixLength;
	private String prefix;
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public Integer getCardLength() {
		return cardLength;
	}
	public void setCardLength(Integer cardLength) {
		this.cardLength = cardLength;
	}
	public Integer getPrefixLength() {
		return prefixLength;
	}
	public void setPrefixLength(Integer prefixLength) {
		this.prefixLength = prefixLength;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Override
	public String toString() {
		return this.getBankName()+":"+this.getBankCode()+":"+this.getPrefix();
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getInsertSql() {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO everest.bank_card_rule (bank_card_prefix, support_bank_id, create_time, prefix_length, card_length, bank_code) VALUES (");
		sb.append("'"+this.getPrefix()+"',");
		sb.append(this.getBankId()+",");
		sb.append("now(),");
		sb.append(this.getPrefixLength()+",");
		sb.append(this.getCardLength()+",");
		sb.append("'"+this.getBankCode()+"');");
		return sb.toString();
	}
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}
	@Override
	public int compareTo(Object o) {
		Bank b = (Bank)o;
		return this.getBankId()-b.getBankId();
	}
}