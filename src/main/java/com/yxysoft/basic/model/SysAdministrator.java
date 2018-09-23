package com.yxysoft.basic.model;

import java.util.Date;

public class SysAdministrator {
    private Integer administratorId;

    private String administratorName;

    private String administratorCode;

    private String department;

    private Integer createUserId;

    private Date createTime;

    private Integer state;

    private Integer depId;

    public SysAdministrator(Integer administratorId, String administratorName, String administratorCode, String department, Integer createUserId, Date createTime, Integer state, Integer depId) {
        this.administratorId = administratorId;
        this.administratorName = administratorName;
        this.administratorCode = administratorCode;
        this.department = department;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.state = state;
        this.depId = depId;
    }

    public SysAdministrator() {
        super();
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName == null ? null : administratorName.trim();
    }

    public String getAdministratorCode() {
        return administratorCode;
    }

    public void setAdministratorCode(String administratorCode) {
        this.administratorCode = administratorCode == null ? null : administratorCode.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

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

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}