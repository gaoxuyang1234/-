package com.yxysoft.utils.weixin.beans.button;
/**
 * ClassName: ClickButton
 * @Description: click类型菜单对象
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class ViewButton extends BaseButton{
	private String type ;//菜单的响应动作类型
	private String url ;//网页链接，用户点击菜单可打开链接，不超过256字节(view类型必须)
	
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
}
