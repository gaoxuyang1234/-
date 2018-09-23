package com.yxysoft.basic.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysOvertime {
    private Integer overtimeId;

    private Integer overtimeName;

    private Date overtimeStartTime;

    private Date overtimeEndTime;

    private BigDecimal overtimeHours;

    private String overtimeReason;

    private Integer reviewer;

    private Integer reviewerState;

    private String reviewerReason;

    private Date createTime;

    private Integer state;
    
    private SysUser sysUser;

    public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysOvertime(Integer overtimeId, Integer overtimeName, Date overtimeStartTime, Date overtimeEndTime, BigDecimal overtimeHours, String overtimeReason, Integer reviewer, Integer reviewerState, String reviewerReason, Date createTime, Integer state) {
        this.overtimeId = overtimeId;
        this.overtimeName = overtimeName;
        this.overtimeStartTime = overtimeStartTime;
        this.overtimeEndTime = overtimeEndTime;
        this.overtimeHours = overtimeHours;
        this.overtimeReason = overtimeReason;
        this.reviewer = reviewer;
        this.reviewerState = reviewerState;
        this.reviewerReason = reviewerReason;
        this.createTime = createTime;
        this.state = state;
    }

    public SysOvertime() {
        super();
    }

    public Integer getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Integer overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Integer getOvertimeName() {
        return overtimeName;
    }

    public void setOvertimeName(Integer overtimeName) {
        this.overtimeName = overtimeName;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm ", timezone = "GMT+8")
    public Date getOvertimeStartTime() {
        return overtimeStartTime;
    }
    //@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    public void setOvertimeStartTime(Date overtimeStartTime) {
        this.overtimeStartTime = overtimeStartTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm ", timezone = "GMT+8")
    public Date getOvertimeEndTime() {
        return overtimeEndTime;
    }
   // @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    public void setOvertimeEndTime(Date overtimeEndTime) {
        this.overtimeEndTime = overtimeEndTime;
    }

    public BigDecimal getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(BigDecimal overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public String getOvertimeReason() {
        return overtimeReason;
    }

    public void setOvertimeReason(String overtimeReason) {
        this.overtimeReason = overtimeReason == null ? null : overtimeReason.trim();
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getReviewerState() {
        return reviewerState;
    }

    public void setReviewerState(Integer reviewerState) {
        this.reviewerState = reviewerState;
    }

    public String getReviewerReason() {
        return reviewerReason;
    }

    public void setReviewerReason(String reviewerReason) {
        this.reviewerReason = reviewerReason == null ? null : reviewerReason.trim();
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