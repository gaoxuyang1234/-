package com.yxysoft.basic.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

public class Base64Doc {
	
	//此为测试数据,源头转换成Base64前是doc文件即可
	public static void saveDoc(String fileNo,byte[] content) throws IOException{
		String filName=fileNo+".doc";
	       File outFile = new File("C:/analyze");
	       //System.out.println(!outFile.exists());
	       if(!outFile.exists()){
	    	   outFile.mkdir();}
	       OutputStream outs=new FileOutputStream("C:/analyze/"+filName);
	       outs.write(content);
	       outs.flush();
	       outs.close();
	       //System.out.println("完毕");		
	}
	/**
	 * @param path 图片转字节
	 * @return
	 * @throws Exception
	 */
	public static byte[] image2byte(String path)throws Exception{
	      byte[] bytes = null;
	      FileImageInputStream input = null;
	      input = new FileImageInputStream(new File(path));
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      byte[] buf = new byte[1024*1024*10];
	      int numBytesRead = 0;
	      while ((numBytesRead = input.read(buf)) != -1) {
	      output.write(buf, 0, numBytesRead);
	      }
	      bytes = output.toByteArray();
	      output.close();
	      input.close();
	      return bytes;
	  }
//	字节转图片
	public static String base64StringToImage(byte[] b,String file) throws IOException {  
		if(b!=null && b.length>0){
        ByteArrayInputStream bais = new ByteArrayInputStream(b);  
        BufferedImage bi1 = ImageIO.read(bais);
        //图片格式以是jpg,png,gif格式
        File f = new File(file);
        ImageIO.write(bi1, "png", f);// 不管输出什么格式图片，此处不需改动  
		}
		return file;
	}  
	
	  //byte数组到图片
	public static void byte2image2(byte[] data,String path) throws FileNotFoundException, UnsupportedEncodingException{
	    if(data.length<3||path.equals("")) return;
	    try{
	    FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
	    imageOutput.write(data, 0, data.length);
	    imageOutput.close();
	    } catch(Exception ex) {
	      System.out.println("Exception: " + ex);
	      ex.printStackTrace();
	    }
	  }
	 //byte数组到图片
	 public static String byte2image(byte[] data,String path){
		 if(data.length<3||!path.equals("")) 
		 try{
			 FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
			 imageOutput.write(data, 0, data.length);
			 imageOutput.close();
		 } catch(Exception ex) {
			 ex.printStackTrace();
		 }
		 return path;
	 }
	
	
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> jsonToMap(Object object) {
	    Map<String, Object> data = new HashMap<String, Object>();
	    // 将json字符串转换成jsonObject
	    JSONObject jsonObject = JSONObject.fromObject(object);
	    Iterator ite = jsonObject.keys();
	    // 遍历jsonObject数据,添加到Map对象
	    while (ite.hasNext()) {
	        String key = ite.next().toString();
	        String value = jsonObject.get(key).toString();
	        data.put(key, value);
	    }
	    // 或者直接将 jsonObject赋值给Map
	    // data = jsonObject;
	    return data;
	}
	
	/**
	 * @param base64String
	 * @return
	 * @throws IOException
	 */
	public static byte[] stringToByte(String base64String) throws IOException {
        BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        return base64String != null ? decoder.decodeBuffer(base64String) : null;
    }
	
	/**
	 * @param strTime
	 * @return  String转java.sql.Date
	 * @throws ParseException
	 */
	public static java.sql.Date stringToDate(String strTime) throws ParseException{
		SimpleDateFormat bartDateFormat =  
	        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			String reStr = strTime.replaceAll("T", " ");
	        java.util.Date date = bartDateFormat.parse(reStr);  
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        return sqlDate;
	}
}
