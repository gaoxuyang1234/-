package com.yxysoft.basic.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysAskLeave {
    private Integer leaveId;

    private Integer leaveName;

    private Date leaveStartTime;

    private Date leaveEndTime;

    private BigDecimal leaveDays;

    private String leaveReason;

    private Integer approver;

    private Integer approverState;

    private String approverReason;

    private Date createTime;

    private Integer state;
    
    private SysUser sysUser;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    private String picturePath;

    public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysAskLeave(Integer leaveId, Integer leaveName, Date leaveStartTime, Date leaveEndTime, BigDecimal leaveDays, String leaveReason, Integer approver, Integer approverState, String approverReason, Date createTime, Integer state) {
        this.leaveId = leaveId;
        this.leaveName = leaveName;
        this.leaveStartTime = leaveStartTime;
        this.leaveEndTime = leaveEndTime;
        this.leaveDays = leaveDays;
        this.leaveReason = leaveReason;
        this.approver = approver;
        this.approverState = approverState;
        this.approverReason = approverReason;
        this.createTime = createTime;
        this.state = state;
    }

    public SysAskLeave() {
        super();
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(Integer leaveName) {
        this.leaveName = leaveName;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm ", timezone = "GMT+8")
    public Date getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm ", timezone = "GMT+8")
    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public BigDecimal getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(BigDecimal leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason == null ? null : leaveReason.trim();
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}