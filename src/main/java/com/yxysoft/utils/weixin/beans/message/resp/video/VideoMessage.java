package com.yxysoft.utils.weixin.beans.message.resp.video;

import com.yxysoft.utils.weixin.beans.message.resp.BaseMessage;

/**
 * ClassName: ImageMessage
 * @Description: 回复视频消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class VideoMessage extends BaseMessage {
	private Video video ;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}


}
