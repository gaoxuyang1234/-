package com.yxysoft.utils.weixin.beans.button;
/**
 * ClassName: MenuButton
 * @Description: 最终的菜单对象
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class MenuButton  extends BaseButton{
	private BaseButton[] button ;//

	public BaseButton[] getButton() {
		return button;
	}

	public void setButton(BaseButton[] button) {
		this.button = button;
	}

}
