package com.yxysoft.utils.weixin.beans.message.resp.text;

/**
 * ClassName: ImageMessage
 * @Description: 回复文本消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class TextMessage{
	public String Content;//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

	public String ToUserName;//接收方帐号（收到的OpenID）
	public String FromUserName;//开发者微信号
	public long CreateTime;//消息创建时间 （整型）
	public String MsgType;//文本类型 image voice video  music  news
	
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
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
