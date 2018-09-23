package com.yxysoft.utils.weixin.beans.button;

/**
 * ClassName: BaseButton
 * @Description: 菜单对象基类
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class BaseButton {
	private String name ;//菜单标题，不超过16个字节，子菜单不超过40个字节

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
