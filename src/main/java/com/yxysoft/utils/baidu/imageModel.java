package com.yxysoft.utils.baidu;

public class imageModel {
	/**
	 * 图片信息(总数据大小应小于10M)，图片上传方式根据image_type来判断。 两张图片通过json格式上传
	 */
	private String image;
	/**
	 * 图片类型
		BASE64:图片的base64值，base64编码后的图片数据，需urlencode，编码后的图片大小不超过2M；
		URL:图片的 URL地址( 可能由于网络等原因导致下载图片时间过长)**；
		FACE_TOKEN: 人脸图片的唯一标识，调用人脸检测接口时，会为每个人脸图片赋予一个唯一的FACE_TOKEN，
		同一张图片多次检测得到的FACE_TOKEN是同一个。
	 */
	private String image_type;
	/**
	 * 人脸的类型
		LIVE表示生活照：通常为手机、相机拍摄的人像图片、或从网络获取的人像图片等，
		IDCARD表示身份证芯片照：二代身份证内置芯片中的人像照片，
		WATERMARK表示带水印证件照：一般为带水印的小图，如公安网小图
		CERT表示证件照片：如拍摄的身份证、工卡、护照、学生证等证件图片
		默认LIVE
	 */
	private String face_type;
	/**
	 * 图片质量控制 NONE: 不进行控制 LOW:较低的质量要求 NORMAL: 
	 * 一般的质量要求 HIGH: 较高的质量要求 默认 NONE
	 */
	private String quality_control;
	/**
	 * 活体检测控制
		NONE: 不进行控制
		LOW:较低的活体要求(高通过率 低攻击拒绝率)
		NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
		HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
		默认NONE
	 */
	private String liveness_control;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage_type() {
		return image_type;
	}
	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	public String getFace_type() {
		return face_type;
	}
	public void setFace_type(String face_type) {
		this.face_type = face_type;
	}
	public String getQuality_control() {
		return quality_control;
	}
	public void setQuality_control(String quality_control) {
		this.quality_control = quality_control;
	}
	public String getLiveness_control() {
		return liveness_control;
	}
	public void setLiveness_control(String liveness_control) {
		this.liveness_control = liveness_control;
	}
	
}
