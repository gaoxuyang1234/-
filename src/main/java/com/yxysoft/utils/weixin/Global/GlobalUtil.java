/**
 *  FileName：org.yangsy.weixin.util.Global.GlobalUtil.java
 *  Description: 
 *  CreateDate: Aug 3, 2015
 *  @author 杨书元
 *  @version 0.9
*/
package com.yxysoft.utils.weixin.Global;

import org.apache.commons.lang3.StringUtils;

import com.yxysoft.utils.weixin.WeiXinUtil;
import com.yxysoft.utils.weixin.beans.ticket.ReqTicket;
import com.yxysoft.utils.weixin.beans.ticket.RespTicket;

import net.sf.json.JSONObject;
/**
 * ClassName: GlobalUtil
 * @Description: TODO
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class GlobalUtil {
	/**
	 * MethodName: getTicketQRSCENE
	 * @Description: 创建二维码ticket
	 * @param qticket
	 * @param accessToken
	 * @return RespTicket  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-3-29 下午10:15:19
	 */
	public static RespTicket  getTicketQRSCENE(ReqTicket qticket,String accessToken){
		RespTicket respTicket = new RespTicket();
		String ticket = "";
		long expire_seconds = 0;
		String url = null;
		Integer errcode = 0;
		String errmsg = "";
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken;
		String reqStr = "";
		if(WeiXinUtil.QR_SCENE.equals(qticket.getAction_name())){//临时二维码
			reqStr = "{\"expire_seconds\": "+qticket.getExpire_seconds()+", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+qticket.getScene_id()+"}}}";
		}else {
			if(StringUtils.isNotBlank(qticket.getScene_str())){
				System.out.println("str====================="+qticket.getScene_str());
				reqStr = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+qticket.getScene_str()+"\"}}}";
			}else {
				reqStr = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+qticket.getScene_id()+"}}}";
			}
			
		}
		String json = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",reqStr);
		System.out.println("获取二维码="+json);
		JSONObject jsonobject = JSONObject.fromObject(json);
		if(json.contains("errcode")){
			errcode = jsonobject.getInt("errcode");
			errmsg = (String)jsonobject.get("errmsg");
		}else {
			ticket = jsonobject.getString("ticket");
			if(WeiXinUtil.QR_SCENE.equals(qticket.getAction_name())){
				expire_seconds = jsonobject.getLong("expire_seconds");
			}
			url = jsonobject.getString("url");
			
		}
		respTicket.setTicket(ticket);
		respTicket.setExpire_seconds(expire_seconds);
		respTicket.setUrl(url);
		respTicket.setErrcode(errcode+"");
		respTicket.setErrmsg(errmsg);
		return respTicket;
		
	}
	
}
