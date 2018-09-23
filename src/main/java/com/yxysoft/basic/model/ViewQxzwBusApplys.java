package com.yxysoft.basic.model;

import java.util.Date;

public class ViewQxzwBusApplys {
    private Integer aId;

    private Date aTime;
   
    private String aTimes;
    private Integer state;

    private Integer sId;

    private String sName;

    private Integer dId;

    private String dName;

    private Integer uId;

    private String uName;

    private String cardNo;

    private String mobile;
    
    

    public String getaTimes() {
		return aTimes;
	}

	public void setaTimes(String aTimes) {
		this.aTimes = aTimes;
	}

	public ViewQxzwBusApplys(Integer aId, Date aTime, Integer state, Integer sId, String sName, Integer dId, String dName, Integer uId, String uName, String cardNo, String mobile) {
        this.aId = aId;
        this.aTime = aTime;
        this.state = state;
        this.sId = sId;
        this.sName = sName;
        this.dId = dId;
        this.dName = dName;
        this.uId = uId;
        this.uName = uName;
        this.cardNo = cardNo;
        this.mobile = mobile;
    }

    public ViewQxzwBusApplys() {
        super();
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Date getaTime() {
        return aTime;
    }

    public void setaTime(Date aTime) {
        this.aTime = aTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}