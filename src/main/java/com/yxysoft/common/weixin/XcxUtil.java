package com.yxysoft.common.weixin;


import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.codehaus.xfire.util.Base64;

import com.yxysoft.common.weixin.Global.HttpsRequestUtil;

import net.sf.json.JSONObject;


/**
 * ClassName: XcxUtil 
 * @Description: 微信小程序工具类
 * @author yangsy
 * @date 2016-3-29
 */
public class XcxUtil {

	/**
	 * 政务不见面小程序APPID
	 */
	public static final String AppID = "wx415b379ee01a6014";
	/**
	 * 政务不见面小程序AppSecret
	 */
	public static final String AppSecret = "2561c35ff785b123cf9f1cf2aef4abb0";
	
	public static final String SessionKeyUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	

	/**
	 * @Title: getSessionKey
	 * @Description: 获取SessionKey
	 * @author 杨书元  
	 * @date Aug 4, 2018 4:31:26 PM 
	 * @version V1.0  
	 * @param @return    
	 * @return Token   
	 * @throws
	 */
	public static JSONObject getSessionKey(String code,String appid,String appsecret){
		String requestUrl = SessionKeyUrl.replace("APPID", AppID).replace("SECRET", AppSecret).replace("JSCODE", code);
		String json = HttpsRequestUtil.HttpsRequest(requestUrl,"GET",null);
		System.out.println("seesion_key==="+json);
		JSONObject jsonobject = JSONObject.fromObject(json);
		if(!jsonobject.has("errcode")){
			System.out.println("session_key==="+jsonobject.getString("session_key"));
			System.out.println("openid==="+jsonobject.getString("openid"));
		}
		return jsonobject;
	}
	/**
     * 解密用户敏感数据获取用户信息
     * @param sessionKey 数据进行加密签名的密钥
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv 加密算法的初始向量
     * @return
     */
    public static JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        
        try {
               // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.fromObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
