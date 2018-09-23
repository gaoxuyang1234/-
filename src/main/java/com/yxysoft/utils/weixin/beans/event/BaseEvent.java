/**  
 * @Title: BaseEvent.java
 * @package com.yxysoft.utils.weixin.beans.event
 * @Description: TODO
 * @author yangsy
 * @date 2016-3-30
 */
package com.yxysoft.utils.weixin.beans.event;

/**
 * ClassName: BaseEvent 
 * @Description: TODO
 * @author yangsy
 * @date 2016-3-30
 */
public class BaseEvent {
	public String ToUserName;//接收方帐号（收到的OpenID）
	public String FromUserName;//开发者微信号
	public long CreateTime;//消息创建时间 （整型）
	public String MsgType;//文本类型 event
	
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
}
