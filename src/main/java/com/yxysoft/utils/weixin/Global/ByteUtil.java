package com.yxysoft.utils.weixin.Global;

public class ByteUtil {
/**
 * @Title: byte2Str 
 * @Description: 数组处理类
 * @date Jul 31, 2015 2:31:11 PM 
 * @version V1.0  
 * @param @param array
 * @param @return    
 * @return String   
 * @throws
 */
	public static String byte2Str(byte[] array){
		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for(int i=0;i<array.length;i++){
			shaHex = Integer.toHexString(array[i]&0xFF);
			if(shaHex.length()<2){
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}
}
