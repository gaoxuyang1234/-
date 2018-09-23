package com.yxysoft.constant;

import java.util.Map;

public enum MailConst {

	

	SF("SF","顺丰速运"),
	JD("JD","京东物流"),
	STO("STO","申通快递"),
	YTO("YTO","圆通速递"),
	YD("YD","韵达速递"),
	YZPY("YZPY","邮政快递包裹"),
	EMS("EMS","EMS"),
	HHTT("HHTT","天天快递"),
	UC("UC","优速快递"),
	BTWL("BTWL","百世快运"),
	ZTO("ZTO","中通快递");
	private String mailNmae;
	private String mailCode;
	private Map<String,MailConst> map;
	private MailConst(String mailCode,String mailNmae) {
		this.mailCode = mailCode;
		this.mailNmae = mailNmae;
	}
	public String getMailNmae() {
		return mailNmae;
	}
	public void setMailNmae(String mailNmae) {
		this.mailNmae = mailNmae;
	}
	public String getMailCode() {
		return mailCode;
	}
	public void setMailCode(String mailCode) {
		this.mailCode = mailCode;
	}
	
	
}
