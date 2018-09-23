package com.yxysoft.utils.weixin.beans;

public class UNIONID {
	private String access_token;//access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
	private int expires_in;//目前access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
