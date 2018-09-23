/**  
 * @Title: TicketScan.java
 * @package com.yxysoft.utils.weixin.beans.ticket
 * @Description: TODO
 * @author yangsy
 * @date 2016-3-30
 */
package com.yxysoft.utils.weixin.beans.ticket;

import com.yxysoft.utils.weixin.beans.event.BaseEvent;

/**
 * ClassName: RespTicketScan 
 * @Description: TODO
 * @author yangsy
 * @date 2016-3-30
 */
public class RespTicketScan extends BaseEvent {
	/**
	 * 事件类型，SCAN subscribe 
	 */
	private String Event;
	/**
	 * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id 
	 */
	private String EventKey;
	/**
	 * 二维码的ticket，可用来换取二维码图片 
	 */
	private String Ticket;
	
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
}
