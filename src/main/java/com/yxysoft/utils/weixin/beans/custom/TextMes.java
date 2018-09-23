/**  
 * @Title: TextMes.java
 * @package com.yxysoft.utils.weixin.beans.custom
 * @Description: TODO
 * @author yangsy
 * @date 2016-4-17
 */
package com.yxysoft.utils.weixin.beans.custom;

/**
 * ClassName: TextMes 
 * @Description: TODO
 * @author yangsy
 * @date 2016-4-17
 */
public class TextMes extends CustomBase {
	private TextContent text;

	public TextContent getText() {
		return text;
	}

	public void setText(TextContent text) {
		this.text = text;
	}
}
