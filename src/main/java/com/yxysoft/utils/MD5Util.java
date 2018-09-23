package com.yxysoft.utils;

import java.security.MessageDigest;

public class MD5Util {

	/**
     * MD5加密
     * @param str 内容       
     * @param charset 编码方式
	 * @throws Exception 
     */
	public static String MD5(String str, String charset) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    if(StringUtil.isBlank(charset)){
	    	charset = "UTF-8";
	    }
	    md.update(str.getBytes(charset));
	    byte[] result = md.digest();
	    StringBuffer sb = new StringBuffer(32);
	    for (int i = 0; i < result.length; i++) {
	        int val = result[i] & 0xff;
	        if (val <= 0xf) {
	            sb.append("0");
	        }
	        sb.append(Integer.toHexString(val));
	    }
	    return sb.toString().toLowerCase();
	}
	
}
