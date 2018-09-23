package com.yxysoft.utils.weixin.beans.button;
/**
 * ClassName: NewsButton
 * @Description: 图文类型菜单对象
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class NewsButton extends BaseButton{
	private String type ;//菜单的响应动作类型
	private String media_id ;//调用新增永久素材接口返回的合法media_id
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}
