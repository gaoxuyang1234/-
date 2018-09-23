package com.yxysoft.basic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="身份证信息",description="IdCardInfo")
public class IdCardInfo {
	@ApiModelProperty(value="NAME",name="name",required=true)
	private String name;    //姓名
	@ApiModelProperty(value="SEX",name="sex",required=false)
	private String sex;	    //性别
	private String folk;  	//民族
	private String birthday;//出生年月
	private String address; //住址
	private String cardno;	//身份证号码
	private String path;	//
	private String issueauthority;//签证机关
	private String validperiod;//有效期
	private String msg;
	
	
	
	
	public IdCardInfo() {
		super();
		
	}
	public IdCardInfo(String name, String sex, String folk, String birthday, String address, String cardno,
			String path) {
		this.name = name;
		this.sex = sex;
		this.folk = folk;
		this.birthday = birthday;
		this.address = address;
		this.cardno = cardno;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFolk() {
		return folk;
	}
	public void setFolk(String folk) {
		this.folk = folk;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIssueauthority() {
		return issueauthority;
	}
	public void setIssueauthority(String issueauthority) {
		this.issueauthority = issueauthority;
	}
	public String getValidperiod() {
		return validperiod;
	}
	public void setValidperiod(String validperiod) {
		this.validperiod = validperiod;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
