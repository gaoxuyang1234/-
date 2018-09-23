/**
 *  FileName��org.yangsy.weixin.util.SignUtil.java
 *  Description: 
 *  CreateDate: Jul 31, 2015
 *  @author ����Ԫ
 *  @version 0.9
*/
package com.yxysoft.utils.weixin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.yxysoft.utils.weixin.Global.ByteUtil;
/**
 * ClassName: SignUtil
 * @Description: 微信开发者模式认证工具类
 * @author yangsy
 * @date Jul 31, 2015
 */
public class SignUtil {
	/**
	 * 栖霞不见面公众号的APPID
	 */
	public static final String AppID = "wxd51eb96eb4d5299b";
	/**
	 * 栖霞不见面公众号的AppSecret
	 */
	public static final String AppSecret = "b8e50211616e7d1415d22ab55e29ce2a";
	/**
	 * 栖霞不见面开启开发者模式时设置的token-两个相同
	 */
	public static final String token = "zhengebang";
	/**
	 * 栖霞不见面开启开发者模式时设置的EncodingAESKey-两个相同
	 */
	public static final String EncodingAESKey = "z5Bv5khb09ZwpkRRKLmmkOUtTgBCOCpaNrjcmhkgLRZ";
	
	
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		boolean result = false;
		//
		String[] array = new String[]{token,timestamp,nonce};
		Arrays.sort(array);
		String str = array[0].concat(array[1]).concat(array[2]);
		String sha1Str = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(str.getBytes());
			sha1Str = ByteUtil.byte2Str(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(sha1Str!=null&&sha1Str.equals(signature)){
			result = true;
		}
		return result;
	}
}
