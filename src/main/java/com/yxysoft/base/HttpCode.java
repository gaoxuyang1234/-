package com.yxysoft.base;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class HttpCode {
	
	
	public static void main(String[] args) throws Exception {
				Map<String,Object> map= postHttp("http://192.168.0.115:3001/in","我知道了","12344");
				System.out.println(map.get("JSON"));
	}	
	
	/**
	 * 发送HTTP Post请求
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> postHttp(String urls,String content,String mobile) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		URL url=new URL(urls);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	conn.setDoOutput(true);                 
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.connect(); 
        DataOutputStream out = new DataOutputStream(conn  
                .getOutputStream());
        out.writeBytes("telNo="+mobile+"&content="+URLEncoder.encode(content, "utf-8"));
        out.flush();
        out.close();
        Integer code= conn.getResponseCode();
        InputStream is = null;  
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        if (code == 200) {  
            is = conn.getInputStream(); 
        }else {  
            is = conn.getErrorStream();
        }
        byte[] by=new byte[1024];
        int len;
        while((len=is.read(by))!=-1){
        	byteArray.write(by,0,len);
        }
        byte[] bys=byteArray.toByteArray();
        map.put("CHECK",code+"");
        map.put("JSON", new String(bys,"UTF-8"));
        return map;
	}
	
	
	
	/**
	 * 发送HTTP Get请求
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> getHttp(String urls) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		URL url=new URL(urls);
   	    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
   	    conn.setDoOutput(false);                 
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.connect(); 
        Integer code= conn.getResponseCode();
        InputStream is = null;  
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
       if (code == 200) {  
           is = conn.getInputStream(); 
           
       }else {  
           is = conn.getErrorStream();
       }
       byte[] by=new byte[1024];
       int len;
       while((len=is.read(by))!=-1){
       	byteArray.write(by,0,len);
       }
       byte[] bys=byteArray.toByteArray();
       map.put("CHECK",code+"");
       map.put("JSON", new String(bys,"UTF-8"));
       return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	 }

