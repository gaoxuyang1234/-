package com.yxysoft.utils.weixin.beans.button;

public class MiniprogramButton extends BaseButton {

	private String type ;//菜单的响应动作类型
	private String url ;//网页链接，用户点击菜单可打开链接，不超过256字节(view类型必须)
	private String appid;//
	private String pagepath;//
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagepath() {
		return pagepath==null?"pages/index/index":pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
}
