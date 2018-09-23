package com.yxysoft.utils.weixin.beans.message.resp.music;

import com.yxysoft.utils.weixin.beans.message.resp.BaseMessage;

/**
 * ClassName: MusicMessage
 * @Description: 回复音乐消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class MusicMessage extends BaseMessage {
	private Music Music ;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		this.Music = music;
	}


}
