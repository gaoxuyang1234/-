package com.yxysoft.basic.model;

import java.util.Date;

public class WxAccessToken {
    private Integer id;

    private String accessToken;

    private Integer expiresIn;

    private Long createTime;

    private Date createDate;

    private Integer accessStatus;

    private Integer tokenType;

    public WxAccessToken(Integer id, String accessToken, Integer expiresIn, Long createTime, Date createDate, Integer accessStatus, Integer tokenType) {
        this.id = id;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.createTime = createTime;
        this.createDate = createDate;
        this.accessStatus = accessStatus;
        this.tokenType = tokenType;
    }

    public WxAccessToken() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(Integer accessStatus) {
        this.accessStatus = accessStatus;
    }

    public Integer getTokenType() {
        return tokenType;
    }

    public void setTokenType(Integer tokenType) {
        this.tokenType = tokenType;
    }
}