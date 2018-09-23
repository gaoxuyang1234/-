package com.yxysoft.utils.weixin;

import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;
import com.yxysoft.utils.weixin.beans.Token;

import net.sf.json.JSONObject;

/**
 * ClassName: MediaUtil 
 * @Description: 素材
 * @author yangsy
 * @date 2016-10-10
 */
public class MediaUtil {
	/**
	 * 获取素材列表
	 */
	public static final String  GET_ALL_GROUP = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	
	/**
	 * MethodName: getAllMedia
	 * @Description: 获取永久素材的列表
	 * @param data
	 * @param token
	 * @return String  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:45:04
	 */
	public static String getAllMedia(String data,Token token){
        String requestUrl = GET_ALL_GROUP.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",data);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		System.out.println("uploadNews-------->"+jsonobject.toString());
        return jsonobject.toString();  
	}
}
