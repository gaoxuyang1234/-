package com.yxysoft.utils.weixin;

import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;
import com.yxysoft.utils.weixin.beans.Token;

import net.sf.json.JSONObject;

/**
 * ClassName: UserGroupUtil 
 * @Description: 高级群发结单
 * @author yangsy
 * @date 2016-10-10
 */
public class UserGroupUtil {
	/**
	 * 获取公众号已创建的标签
	 */
	public static final String  GET_ALL_GROUP = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
	
	/**
	 * MethodName: getAllGroup
	 * @Description: 获取公众号已创建的标签
	 * @param data
	 * @param token
	 * @return String  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:45:04
	 */
	public static String getAllGroup(Token token){
        String requestUrl = GET_ALL_GROUP.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",null);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		System.out.println("uploadNews-------->"+jsonobject.toString());
        return jsonobject.toString();  
	}
}
