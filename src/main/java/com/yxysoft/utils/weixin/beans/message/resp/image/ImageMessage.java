package com.yxysoft.utils.weixin.beans.message.resp.image;

import com.yxysoft.utils.weixin.beans.message.resp.BaseMessage;

/**
 * ClassName: ImageMessage
 * @Description: 回复图片消息
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class ImageMessage extends BaseMessage {
	private Image Image ;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

}
