package com.yxysoft.base;

public class BusApplyAndUs {
    //这个实体类是用来映射业务申请表,业务对象表,用户表
	
	//业务申请主键
	private Integer aId;
	//业务事项主键
	private Integer sId;
	//用户主键
	private Integer uId;
	//真正的业务用户信息//非数据库字段
	private String agent;
	//用户姓名
	private String uName;
	//用户的身份证号码
	private String cardNo;
	//用户的手机号
	private String mobile;
	//业务名称
	private String sName;
	
	private String state;
	
	private int mail;//是否邮寄1-否；2-是
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getMail() {
		return mail;
	}
	public void setMail(int mail) {
		this.mail = mail;
	}
	
	
	
}
