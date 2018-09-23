/**  
 * @Title: AccessTokenThread.java
 * @Package com.yxysoft.utils.weixin.thread
 * @Description: 7000秒定时获取accessToken   
 * @author yangsy
 * @date 2016-4-21
 */
package com.yxysoft.utils.weixin.thread;

import com.yxysoft.utils.weixin.SignUtil;
import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;
import com.yxysoft.utils.weixin.beans.Token;

import net.sf.json.JSONObject;

/**
 * ClassName: AccessTokenThread 
 * @Description: 7000秒定时获取accessToken   
 * @author yangsy
 * @date 2016-4-21
 */
public class AccessTokenThread implements Runnable {
	public static Token accessToken = null;
	/**
	 * @MethodName:run
	 * @Description: 7000秒定时获取accessToken   
	 * @author yangsy
	 * @date 2016-4-21
	 */
	@Override
	public void run(){
	    while (true){
	      try{
	    	//System.out.println("线程运行");
	        //accessToken = this.getAccessToken();
	        if(null!=accessToken){
	          //System.out.println(accessToken.getAccess_token());
	          Thread.sleep(7000 * 1000); //获取到access_token 休眠7000秒
	  
	        }else{
		     
	          Thread.sleep(1000*30); //获取的access_token为空 休眠3秒
	        }
	      }catch(Exception e){
	        System.out.println("发生异常："+e.getMessage());
	        e.printStackTrace();
	        try{
	          Thread.sleep(1000*10); //发生异常休眠1秒
	        }catch (Exception e1){
	  
	        }
	      }
	    }
	  }

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
	public Token getAccessToken(){
		String access_token = null;
		int expires_in = 0;
		Token token = new Token();
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+SignUtil.AppID+"&secret="+SignUtil.AppSecret;
		String json = HttpsRequestUtil.HttpsRequest(requestUrl,"GET",null);
		JSONObject jsonobject = JSONObject.fromObject(json);
		access_token = jsonobject.getString("access_token");
		expires_in = jsonobject.getInt("expires_in");
		token.setAccess_token(access_token);
		token.setExpires_in(expires_in);
		return token;
	}

}
