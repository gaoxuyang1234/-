package com.yxysoft.utils.weixin.beans.button;
/**
 * ClassName: ClickButton
 * @Description: view类型菜单对象
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class ClickButton  extends BaseButton{
	private String type ;//菜单的响应动作类型
	private String key ;//菜单KEY值，用于消息接口推送，不超过128字节(click等点击类型必须)
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
