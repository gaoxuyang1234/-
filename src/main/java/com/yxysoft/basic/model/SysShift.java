package com.yxysoft.basic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysShift {
    private Integer shiftId;

    private String shiftName;

    private Integer startHourTime;

    private Integer startMinuteTime;

    private Integer endHourTime;

    private Integer endMinuteTime;

    private Integer createUserId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer state;

    public SysAdministrator getSysAdministrator() {
        return sysAdministrator;
    }

    public void setSysAdministrator(SysAdministrator sysAdministrator) {
        this.sysAdministrator = sysAdministrator;
    }

    private SysAdministrator sysAdministrator;

    public SysShift(Integer shiftId, String shiftName, Integer startHourTime, Integer startMinuteTime, Integer endHourTime, Integer endMinuteTime, Integer createUserId, Date createTime, Integer state) {
        this.shiftId = shiftId;
        this.shiftName = shiftName;
        this.startHourTime = startHourTime;
        this.startMinuteTime = startMinuteTime;
        this.endHourTime = endHourTime;
        this.endMinuteTime = endMinuteTime;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.state = state;
    }

    public SysShift() {
        super();
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName == null ? null : shiftName.trim();
    }

    public Integer getStartHourTime() {
        return startHourTime;
    }

    public void setStartHourTime(Integer startHourTime) {
        this.startHourTime = startHourTime;
    }

    public Integer getStartMinuteTime() {
        return startMinuteTime;
    }

    public void setStartMinuteTime(Integer startMinuteTime) {
        this.startMinuteTime = startMinuteTime;
    }

    public Integer getEndHourTime() {
        return endHourTime;
    }

    public void setEndHourTime(Integer endHourTime) {
        this.endHourTime = endHourTime;
    }

    public Integer getEndMinuteTime() {
        return endMinuteTime;
    }

    public void setEndMinuteTime(Integer endMinuteTime) {
        this.endMinuteTime = endMinuteTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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