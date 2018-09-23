package com.yxysoft.basic.model;

import java.util.Date;

public class XcxSk {
    private Integer id;

    private String uuid;

    private String openid;

    private String sessionKey;

    private String unionid;

    private Long timestamp;

    private Date createTime;

    private Integer uid;

    public XcxSk(Integer id, String uuid, String openid, String sessionKey, String unionid, Long timestamp, Date createTime, Integer uid) {
        this.id = id;
        this.uuid = uuid;
        this.openid = openid;
        this.sessionKey = sessionKey;
        this.unionid = unionid;
        this.timestamp = timestamp;
        this.createTime = createTime;
        this.uid = uid;
    }

    public XcxSk() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}