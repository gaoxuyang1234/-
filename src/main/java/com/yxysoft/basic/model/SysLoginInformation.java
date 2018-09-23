package com.yxysoft.basic.model;

import java.util.Date;

public class SysLoginInformation {
    private Integer loginId;

    private Integer administratorId;

    private Date loginTime;

    private Integer state;

    public SysLoginInformation(Integer loginId, Integer administratorId, Date loginTime, Integer state) {
        this.loginId = loginId;
        this.administratorId = administratorId;
        this.loginTime = loginTime;
        this.state = state;
    }

    public SysLoginInformation() {
        super();
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}