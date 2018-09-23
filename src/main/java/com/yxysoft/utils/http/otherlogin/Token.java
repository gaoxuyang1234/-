package com.yxysoft.utils.http.otherlogin;
/**
 * ClassName: Token 
 * @Description: 凭证实体类
 * @author yangsy
 * @date 2016-3-23
 */
public class Token {
	// 接口访问凭证
    private String accessToken;
    // 凭证有效期，单位：秒
    private int expiresIn;
    
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
