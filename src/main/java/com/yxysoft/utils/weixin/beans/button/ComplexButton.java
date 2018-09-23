package com.yxysoft.utils.weixin.beans.button;
/**
 * ClassName: ClickButton
 * @Description: 符合类型（包含二级菜单的一级菜单）类型菜单对象
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class ComplexButton extends BaseButton {
	private BaseButton[] sub_button ;//二级菜单数组，个数应为1~5个

	public BaseButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
