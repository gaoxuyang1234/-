package com.yxysoft.utils.weixin.Global;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	/**
	 * @Title: getStrByteSize 
	 * @Description:得到字符串所占字节数 
	 * @author 杨书元  
	 * @date Aug 3, 2015 10:57:47 PM 
	 * @version V1.0  
	 * @param @param content
	 * @param @return    
	 * @return int   
	 * @throws
	 */
	public static int getStrByteSize(String content){
		int size = 0;
		if(null!=content){
			try {
				size = content.getBytes("utf-8").length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return size;
	}
	/**
	 * @Title: EmojiToStr 
	 * @Description: Emoji表情(符号表情)转字符串 
	 * @author 杨书元  
	 * @date Aug 4, 2015 8:21:13 AM 
	 * @version V1.0  
	 * @param @param emoji
	 * @param @return    
	 * @return String   
	 * @throws
	 */
	public static String EmojiToStr(int emoji){
		return String.valueOf(Character.toChars(emoji));
	}
}
