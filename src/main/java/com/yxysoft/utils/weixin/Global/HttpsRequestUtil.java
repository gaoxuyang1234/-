package com.yxysoft.utils.weixin.Global;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.yxysoft.utils.weixin.MyX509TrustManager;

public class HttpsRequestUtil {

	/**
	 * @Title: HttpsRequest 
	 * @Description: 处理htpps的GET/POST请求
	 * @author 杨书元  
	 * @date Aug 4, 2015 3:55:53 PM 
	 * @version V1.0  
	 * @param @param reqUrl
	 * @param @param requestType GET/POST
	 * @param @param outputStr 往服务器会写的内容
	 * @param @return    
	 * @return String   
	 * @throws
	 */
	public static String HttpsRequest(String reqUrl,String requestType,String outputStr){
		StringBuffer buffer = null;
		try{
			// 创建SSLContext
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			TrustManager[] tm = { new MyX509TrustManager() };
			// 初始化
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 获取SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(reqUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod(requestType);
			// 设置当前实例使用的SSLSocketFactory
			conn.setSSLSocketFactory(ssf);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();
			
			//往服务器写内容
			if(outputStr!=null&&outputStr.length()>0){
				OutputStream out = conn.getOutputStream();
				out.write(outputStr.getBytes("utf-8"));
				out.close();
			}

			// 读取服务器端返回的内容
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
			        buffer.append(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
