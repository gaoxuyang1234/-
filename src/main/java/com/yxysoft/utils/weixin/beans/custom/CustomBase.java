/**  
 * @Title: CustomBase.java
 * @package com.yxysoft.utils.weixin.beans.custom
 * @Description: TODO
 * @author yangsy
 * @date 2016-4-17
 */
package com.yxysoft.utils.weixin.beans.custom;

/**
 * ClassName: CustomBase 
 * @Description: 客服消息体
 * @author yangsy
 * @date 2016-4-17
 */
public class CustomBase {
	/**
	 * 普通用户openid
	 */
	private String touser;
	/**
	 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	 */
	private String msgtype;
	
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
