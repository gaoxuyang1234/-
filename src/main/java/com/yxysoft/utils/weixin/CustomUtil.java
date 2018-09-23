package com.yxysoft.utils.weixin;

import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;

import net.sf.json.JSONObject;

/**
 * ClassName: CustomUtil
 * @Description: 客服接口处理工具类
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class CustomUtil {
	/*
	 * 定义菜单创建接口地址常量
	 */
	public static final String  CUSTOM_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	/**
	 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	 */
	/**
	 * 
	 */
	public static final String MSG_TYPE_TEXT= "text";
	public static final String MSG_TYPE_IMAGE= "image";
	public static final String MSG_TYPE_VOICE= "voice";
	public static final String MSG_TYPE_MUSIC= "music";
	public static final String MSG_TYPE_NEWS= "news";
	public static final String MSG_TYPE_MPNEWS= "mpnews";
	public static final String MSG_TYPE_WXCARD= "wxcard";
	/**
	 * @Title: createMenu 
	 * @Description: 创建菜单
	 * @author 杨书元  
	 * @date Aug 4, 2015 11:35:11 PM 
	 * @version V1.0  
	 * @param @param json-菜单结构
	 * @param @param accessToken 访问凭证
	 * @param @return    
	 * @return boolean   
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static boolean sendText(String json,String accessToken){
		boolean relust = false;
		/*
		 * 封装请求地址
		 */
		String requestUrl = CUSTOM_URL.replace("ACCESS_TOKEN", accessToken);
		//调用https接口
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",json);
		System.out.println("调用客服接口返回结果：===="+createRelust);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		if(jsonobject!=null){
			int errcode = jsonobject.getInt("errcode");
			String errmsg = jsonobject.getString("errmsg");
			if(errcode==0){//发送成功
				relust = true;
			}
		}
		
		
		return relust;
	}
}
