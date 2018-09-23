package com.yxysoft.basic.model;

public class SysDepartment {
    private Integer depId;

    private String depName;

    private Integer state;

    public SysDepartment(Integer depId, String depName, Integer state) {
        this.depId = depId;
        this.depName = depName;
        this.state = state;
    }

    public SysDepartment() {
        super();
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}