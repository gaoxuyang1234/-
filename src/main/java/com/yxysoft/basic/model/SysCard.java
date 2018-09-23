package com.yxysoft.basic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class SysCard {
    private Integer cardId;

    private Integer cardUserId;


    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date cardTime;

    private String cardPlace;

    private String cardReason;

    private String shiftName;
    
 
    
    
    

    public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	private Integer approver;

    private Integer approverState;

    private String approverReason;

    private Date createTime;

    private Integer satte;
    
    private SysUser sysUser;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    private String picturePath;

    public SysCard(Integer cardId, Integer cardUserId, Date cardTime, String cardPlace, String cardReason, String shiftName, Integer approver, Integer approverState, String approverReason, Date createTime, Integer satte) {
        this.cardId = cardId;
        this.cardUserId = cardUserId;
        this.cardTime = cardTime;
        this.cardPlace = cardPlace;
        this.cardReason = cardReason;
        this.shiftName = shiftName;
        this.approver = approver;
        this.approverState = approverState;
        this.approverReason = approverReason;
        this.createTime = createTime;
        this.satte = satte;
    }

    public SysCard() {
        super();
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardUserId() {
        return cardUserId;
    }

    public void setCardUserId(Integer cardUserId) {
        this.cardUserId = cardUserId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    public Date getCardTime() {
        return cardTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    public void setCardTime(Date cardTime) {
        this.cardTime = cardTime;
    }

    public String getCardPlace() {
        return cardPlace;
    }

    public void setCardPlace(String cardPlace) {
        this.cardPlace = cardPlace == null ? null : cardPlace.trim();
    }

    public String getCardReason() {
        return cardReason;
    }

    public void setCardReason(String cardReason) {
        this.cardReason = cardReason == null ? null : cardReason.trim();
    }
  
    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public Integer getApprover() {
        return approver;
    }

    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    public Integer getApproverState() {
        return approverState;
    }

    public void setApproverState(Integer approverState) {
        this.approverState = approverState;
    }

    public String getApproverReason() {
        return approverReason;
    }

    public void setApproverReason(String approverReason) {
        this.approverReason = approverReason == null ? null : approverReason.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSatte() {
        return satte;
    }

    public void setSatte(Integer satte) {
        this.satte = satte;
    }
}