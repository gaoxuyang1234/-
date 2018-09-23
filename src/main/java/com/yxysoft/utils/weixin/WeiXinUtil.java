/**
 *  FileName��org.yangsy.weixin.util.SignUtil.java
 *  Description: 
 *  CreateDate: Jul 31, 2015
 *  @author ����Ԫ
 *  @version 0.9
*/
package com.yxysoft.utils.weixin;

import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;
import com.yxysoft.utils.weixin.beans.Token;

import net.sf.json.JSONObject;


/**
 * ClassName: WeiXinUtil 
 * @Description: 微信工具类
 * @author yangsy
 * @date 2016-3-29
 */
public class WeiXinUtil {
	/**
	 * 真格邦微信公众号id
	 */
	public static String ZGB_OPEN_ID = "gh_83487aed2963";
	
	public static String ACCESS_TOKEN = "123";
	/**
	 * 临时二维码
	 */
	public static final String QR_SCENE = "QR_SCENE";
	/**
	 * 永久二维码
	 */
	public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
	/**
	 * 永久的字符串参数值 传字符串参数
	 */
	public static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
	

	/**
	 * @Title: getAccessToken 
	 * @Description: 获取access token
	 * @author 杨书元  
	 * @date Aug 4, 2015 4:31:26 PM 
	 * @version V1.0  
	 * @param @return    
	 * @return Token   
	 * @throws
	 */
	public static Token getAccessToken(Token token){
		String access_token = null;
		int expires_in = 0;
		String appid = "";
		String secret = "";
		appid = SignUtil.AppID;
		secret = SignUtil.AppSecret;
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
		String json = HttpsRequestUtil.HttpsRequest(requestUrl,"GET",null);
		JSONObject jsonobject = JSONObject.fromObject(json);
		access_token = jsonobject.getString("access_token");
		expires_in = jsonobject.getInt("expires_in");
		token.setAccess_token(access_token);
		token.setExpires_in(expires_in);
		return token;
	}
	/**
	 * MethodName: getWeiXinName
	 * @Description: 因为目前是多个公众号共用一个后台，所以需要动态区分公众号名称
	 * @param openId
	 * @return String  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-11 下午2:11:15
	 */
	public static String getWeiXinName(String openId){
		String weiXinName = "真格邦";
		return weiXinName;
	}
	/**
	 * MethodName: getPartnerId
	 * @Description: 因第一期物料做的不合理，需要将某些供应商编码组合
	 * @param partnerId
	 * @return Integer  
	 * @author yangsy
	 * @version:0.1
	 * @date 2017-2-21 上午9:35:51
	 */
	public static Integer getPartnerId(Integer partnerId){
		if(partnerId!=null){
			if(partnerId==10009){//10009-->10020
				partnerId = 10020;
			}else if(partnerId==10011){//10011-->10004
				partnerId = 10004;
			}else if(partnerId==10014){//10014-->10008
				partnerId = 10008;
			}else if(partnerId==10015){//10015-->10005
				partnerId = 10005;
			}else if(partnerId==10016){//10016-->10006
				partnerId = 10006;
			}else if(partnerId==10017){//10017-->10007
				partnerId = 10007;
			}else if(partnerId==10023){//10023-->10030
				partnerId = 10030;
			}else if(partnerId==10024){//10024-->10029
				partnerId = 10029;
			}else if(partnerId==10025){//10025-->10027
				partnerId = 10027;
			}else if(partnerId==10026){//10026-->10027
				partnerId = 10027;
			}else if(partnerId==10043){//10043-->10045
				partnerId = 10045;
			}else if(partnerId==10044){//10044-->10046
				partnerId = 10046;
			}else if(partnerId==10035||partnerId==10036||partnerId==10037
					||partnerId==10038||partnerId==10039){
				partnerId = 10010;
			}
		}
		return partnerId;
	}
}
