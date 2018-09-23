/**  
 * @Title: QespTicket.java
 * @package com.yxysoft.utils.weixin.beans.ticket
 * @Description: TODO
 * @author yangsy
 * @date 2016-3-29
 */
package com.yxysoft.utils.weixin.beans.ticket;

/**
 * ClassName: QespTicket 
 * @Description: 生成待参数的二维码-ticket返回参数
 * @author yangsy
 * @date 2016-3-29
 */
public class RespTicket {
	/**
	 * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码
	 */
	public String ticket;
	/**
	 * 	该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	 */
	public long expire_seconds;
	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	public String url;
	/**
	 * 错误编码
	 */
	public String errcode;
	/**
	 * 错误描述
	 */
	public String errmsg;
	
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
