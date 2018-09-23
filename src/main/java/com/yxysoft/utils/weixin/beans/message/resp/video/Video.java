package com.yxysoft.utils.weixin.beans.message.resp.video;

public class Video {
	private String MediaId;//通过素材管理接口上传多媒体文件，得到的id。 (是)
	private String Title;//视频消息的标题 (否)
	private String Description;//视频消息的描述 (否)

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
