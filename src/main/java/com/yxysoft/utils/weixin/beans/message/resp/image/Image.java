package com.yxysoft.utils.weixin.beans.message.resp.image;

public class Image {
	private String MediaId;//通过素材管理接口上传多媒体文件，得到的id。

	@SuppressWarnings("unused")
	private String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
