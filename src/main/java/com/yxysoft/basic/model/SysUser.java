package com.yxysoft.basic.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class SysUser {
    private Integer userId;

    private String userName;

    private String userCode;

    private String cardNo;

    private String mobile;

    private String department;

    private String openid;

    private String unionid;

    private Integer createUserId;



    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public SysAdministrator getSysAdministrator() {
        return sysAdministrator;
    }

    public void setSysAdministrator(SysAdministrator sysAdministrator) {
        this.sysAdministrator = sysAdministrator;
    }

    private Integer state;
    private Integer depId;
     private SysAdministrator sysAdministrator;

    public SysUser(Integer userId, String userName, String userCode, String cardNo, String mobile, String department, String openid, String unionid, Integer createUserId, Date createTime, Integer state, Integer depId) {
        this.userId = userId;
        this.userName = userName;
        this.userCode = userCode;
        this.cardNo = cardNo;
        this.mobile = mobile;
        this.department = department;
        this.openid = openid;
        this.unionid = unionid;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.state = state;
    }

    public SysUser() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
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
    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}