package com.yxysoft.basic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysPunchIn {
    private Integer punchId;

    private Integer userId;

    private Date punchStartTime;

    private String punchPlace;

    private String picturePath;

    private String punchReason;

    private Date punchEndTime;

    private String signBackPlace;

    private String signBackPath;

    private String signBackReason;

    private String shiftName;

    private String punchState;

    private Date createTime;

    private Integer state;

    private Integer signBackState;

    private Integer signInState;
    
    private SysUser sysUser;

    public SysPunchIn(Integer punchId, Integer userId, Date punchStartTime, String punchPlace, String picturePath, String punchReason, Date punchEndTime, String signBackPlace, String signBackPath, String signBackReason, String shiftName, String punchState, Date createTime, Integer state, Integer signBackState, Integer signInState) {
        this.punchId = punchId;
        this.userId = userId;
        this.punchStartTime = punchStartTime;
        this.punchPlace = punchPlace;
        this.picturePath = picturePath;
        this.punchReason = punchReason;
        this.punchEndTime = punchEndTime;
        this.signBackPlace = signBackPlace;
        this.signBackPath = signBackPath;
        this.signBackReason = signBackReason;
        this.shiftName = shiftName;
        this.punchState = punchState;
        this.createTime = createTime;
        this.state = state;
        this.signBackState = signBackState;
        this.signInState = signInState;
    }

    public SysPunchIn() {
        super();
    }

    public Integer getPunchId() {
        return punchId;
    }

    public void setPunchId(Integer punchId) {
        this.punchId = punchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    public Date getPunchStartTime() {
        return punchStartTime;
    }

    public void setPunchStartTime(Date punchStartTime) {
        this.punchStartTime = punchStartTime;
    }

    public String getPunchPlace() {
        return punchPlace;
    }

    public void setPunchPlace(String punchPlace) {
        this.punchPlace = punchPlace == null ? null : punchPlace.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getPunchReason() {
        return punchReason;
    }

    public void setPunchReason(String punchReason) {
        this.punchReason = punchReason == null ? null : punchReason.trim();
    }
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    public Date getPunchEndTime() {
        return punchEndTime;
    }

    public void setPunchEndTime(Date punchEndTime) {
        this.punchEndTime = punchEndTime;
    }

    public String getSignBackPlace() {
        return signBackPlace;
    }

    public void setSignBackPlace(String signBackPlace) {
        this.signBackPlace = signBackPlace == null ? null : signBackPlace.trim();
    }

    public String getSignBackPath() {
        return signBackPath;
    }

    public void setSignBackPath(String signBackPath) {
        this.signBackPath = signBackPath == null ? null : signBackPath.trim();
    }

    public String getSignBackReason() {
        return signBackReason;
    }

    public void setSignBackReason(String signBackReason) {
        this.signBackReason = signBackReason == null ? null : signBackReason.trim();
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public String getPunchState() {
        return punchState;
    }

    public void setPunchState(String punchState) {
        this.punchState = punchState == null ? null : punchState.trim();
    }
 
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSignBackState() {
        return signBackState;
    }

    public void setSignBackState(Integer signBackState) {
        this.signBackState = signBackState;
    }

    public Integer getSignInState() {
        return signInState;
    }

    public void setSignInState(Integer signInState) {
        this.signInState = signInState;
    }

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
    
    
}