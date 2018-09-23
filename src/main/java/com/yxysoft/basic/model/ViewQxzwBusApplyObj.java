package com.yxysoft.basic.model;

public class ViewQxzwBusApplyObj {
    private Integer aId;

	private String uname;

	private String cardno;

	private String sex;

	private String mobile;

	private String address;

	public ViewQxzwBusApplyObj(Integer aId, String uname, String cardno, String sex, String mobile, String address) {
		this.aId = aId;
		this.uname = uname;
		this.cardno = cardno;
		this.sex = sex;
		this.mobile = mobile;
		this.address = address;
	}

	public ViewQxzwBusApplyObj() {
		super();
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname == null ? null : uname.trim();
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno == null ? null : cardno.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

}