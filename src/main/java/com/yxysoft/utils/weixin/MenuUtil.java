package com.yxysoft.utils.weixin;

import net.sf.json.JSONObject;

import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;

/**
 * ClassName: MenuUtil
 * @Description: 菜单处理工具类
 * @author 杨书元
 * @date Aug 4, 2015
 */
public class MenuUtil {
	/*
	 * 定义菜单创建接口地址常量
	 */
	public static final String  MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
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
	public static boolean createMenu(String json,String accessToken){
		boolean relust = false;
		/*
		 * 封装请求地址
		 */
		String requestUrl = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		//调用https接口
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",json);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		if(jsonobject!=null){
			int errcode = jsonobject.getInt("errcode");
			String errmsg = jsonobject.getString("errmsg");
			//log.info("菜单创建接口：errcode="+errcode+"--errmsg="+errmsg);
			if(errcode==0){//菜单创建成功
				relust = true;
			}
		}
		
		
		return relust;
	}
}
