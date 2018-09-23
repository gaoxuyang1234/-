package com.yxysoft.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yxysoft.basic.model.IdCardInfo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  
@SuppressWarnings("restriction")
public class ImageUtil {

	/** 
	   * @Title : GenerateImage 
	   * @功能描述:  base64 转图片
	   * @设定文件：@param imgStr	图片的base64
	   * @设定文件：@param imgFilePath 生成图片的地址
	   * @设定文件：@return 
	   * @返回类型：boolean 
	   * @throws ：
	   */
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
	    if (imgStr == null) // 图像数据为空
	      return false;
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {  
	      // Base64解码
	      byte[] bytes = decoder.decodeBuffer(imgStr);
	      for (int i = 0; i < bytes.length; ++i) {
	        if (bytes[i] < 0) {// 调整异常数据
	          bytes[i] += 256;
	        }
	      }
	      // 生成jpeg图片
	      OutputStream out = new FileOutputStream(imgFilePath);
	      out.write(bytes);
	      out.flush();
	      out.close();
	      return true;
	    } catch (Exception e) {
	      return false;
	    }
	 }
	  /** 
     * 将一张网络图片转化成Base64字符串 
    * @param imgURL 
    * @return 
    */  
   public static String GetImageStrFromUrl(String imgURL) {    
       ByteArrayOutputStream data = new ByteArrayOutputStream();  
        try {  
            // 创建URL  
            URL	 url = new URL(imgURL);  
            byte[] by = new byte[1024];  
            // 创建链接  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5000);  
            InputStream is = conn.getInputStream();  
            // 将内容读取内存中  
            int len = -1;  
            while ((len = is.read(by)) != -1) {  
                data.write(by, 0, len);  
            }  
            // 关闭流  
            is.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
       return encoder.encode(data.toByteArray());  
    } 
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String str = "{\"path\":\"\",\"cardno\":\"341222199605261019\",\"address\":\"安徽省太和县城关镇关北村委会陈大坑55号1户\",\"sex\":\"男\",\"folk\":\"汉\",\"birthday\":\"1996年05月26日\",\"name\":\"陈凯\"}";
		ObjectMapper ma = new ObjectMapper();
		try{
			IdCardInfo order = ma.readValue(str,IdCardInfo.class);
		}catch (Exception e) {
			System.out.println(e);
		}
	
	}
}
