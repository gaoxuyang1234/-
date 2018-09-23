package com.yxysoft.utils.weixin;

import com.yxysoft.utils.http.otherlogin.WeixinUserInfo;
import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: MenuUtil
 * @Description: 菜单处理工具类
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class UnionIDUtil {
	/*
	 * 定义菜单创建接口地址常量
	 */
	public static final String  UNIONID_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	/**
	 * MethodName: getUnionID
	 * @Description: 获取UnionID
	 * @param openId
	 * @param accessToken
	 * @return boolean  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-4-24 下午9:42:11
	 */
	public static WeixinUserInfo getUnionID(String openId,String accessToken){
		WeixinUserInfo info = new WeixinUserInfo();
		/*
		 * 封装请求地址
		 */
		String requestUrl = UNIONID_CREATE_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		//调用https接口
		String jsonRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"GET",null);
		JSONObject jsonobject = JSONObject.fromObject(jsonRelust);
		System.out.println("jsonRelust========"+jsonRelust);
		if(jsonobject!=null){
			if(jsonobject.has("openid")){
				info.setOpenid(jsonobject.getString("openid"));
			}
			if(jsonobject.has("subscribe")){
				info.setSubscribe(jsonobject.getInt("subscribe"));
			}
			if(jsonobject.has("subscribe_time")){
				info.setSubscribe_time(jsonobject.getString("subscribe_time"));
			}
			if(jsonobject.has("nickname")){
				info.setNickname(jsonobject.getString("nickname"));
			}
			if(jsonobject.has("sex")){
				info.setSex(jsonobject.getInt("sex"));
			}
			if(jsonobject.has("country")){
				info.setCountry(jsonobject.getString("country"));
			}
			if(jsonobject.has("province")){
				info.setProvince(jsonobject.getString("province"));
			}
			if(jsonobject.has("city")){
				info.setCity(jsonobject.getString("city"));
			}
			if(jsonobject.has("language")){
				info.setLanguage(jsonobject.getString("language"));
			}
			if(jsonobject.has("headimgurl")){
				info.setHeadimgurl(jsonobject.getString("headimgurl"));
			}
			if(jsonobject.has("unionid")){
				info.setUnionid(jsonobject.getString("unionid"));
			}
			if(jsonobject.has("remark")){
				info.setRemark(jsonobject.getString("remark"));
			}
			if(jsonobject.has("groupid")){
				info.setGroupid(jsonobject.getString("groupid"));
			}
		}
		return info;
	}
}
