package com.yxysoft.utils.weixin.beans.message.resp.voice;

import com.yxysoft.utils.weixin.beans.message.resp.BaseMessage;

/**
 * ClassName: ImageMessage
 * @Description: 回复语音消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class VoiceMessage extends BaseMessage {
	private Voice voice ;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}
