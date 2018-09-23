package com.yxysoft.utils.weixin.beans.message.resp.music;

public class Music {
	private String Title;//音乐标题 (否)
	private String Description;//音乐描述 (否)
	private String MusicURL;//音乐链接 (否)
	private String HQMusicUrl;//高质量音乐链接，WIFI环境优先使用该链接播放音乐 (否)
	private String ThumbMediaId;//缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id (否)

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

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String musicUrl) {
		HQMusicUrl = musicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
}
