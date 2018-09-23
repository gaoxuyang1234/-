package com.yxysoft.utils.weixin.beans;

public class Token {
	/**
	 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
	 */
	private String access_token;
	/**
	 * 目前access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值
	 */
	private int expires_in;
	/**
	 * token类型：11-探羊网公众号的access_token 21-是摩帆网公众号的access_token
	 */
	private Integer token_type;
	
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
	public Integer getToken_type() {
		return token_type;
	}
	public void setToken_type(Integer token_type) {
		this.token_type = token_type;
	}
}
