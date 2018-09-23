package com.yxysoft.utils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;

public class HttpClientPostUtils {
    private static final String HASH_ALGORITHM = "HmacSHA256";
    static String timestamp = Long.toString(System.currentTimeMillis());
    static String nonce = SpellComparator.getUUID();
    
    /**
     * @param api_key
     * @return 排序
     */
    public static String genOriString(String api_key){
        ArrayList<String> beforeSort = new ArrayList<String>();
        beforeSort.add(api_key);
        beforeSort.add(timestamp);
        beforeSort.add(nonce);
        Collections.sort(beforeSort, new SpellComparator());
        StringBuffer afterSort = new StringBuffer();
        for (int i = 0; i < beforeSort.size(); i++) {
            afterSort.append(beforeSort.get(i));
        }
        String OriString = afterSort.toString();
        return OriString;
    }
    /**
     * @param genOriString
     * @param api_secret
     * @return 返回 key
     * @throws SignatureException
     */
    public static String genEncryptString(String genOriString, String api_secret)throws SignatureException {
        try{
            Key sk = new SecretKeySpec(api_secret.getBytes(), HASH_ALGORITHM);
            Mac mac = Mac.getInstance(sk.getAlgorithm());
            mac.init(sk);
            final byte[] hmac = mac.doFinal(genOriString.getBytes());
            StringBuilder sb = new StringBuilder(hmac.length * 2);
            @SuppressWarnings("resource")
            Formatter formatter = new Formatter(sb);
            for (byte b : hmac) {
                formatter.format("%02x", b);
            }
            String EncryptedString = sb.toString();
            return EncryptedString;
        }catch (NoSuchAlgorithmException e1){
            throw new SignatureException("error building signature, no such algorithm in device "+ HASH_ALGORITHM);
        }catch (InvalidKeyException e){
            throw new SignatureException("error building signature, invalid key " + HASH_ALGORITHM);
        }
    }
    
    /**
     * @param api_key
     * @param api_secret
     * @return 最终返回的key
     * @throws SignatureException
     */
    public static String genHeaderParam(String api_key, String api_secret) throws SignatureException{
        String GenOriString = genOriString(api_key);
        String EncryptedString = genEncryptString(GenOriString, api_secret);
        String HeaderParam = "key=" + api_key
                +",timestamp=" + timestamp
                +",nonce=" + nonce
                +",signature=" + EncryptedString;
        //System.out.println("key==="+HeaderParam);
        return HeaderParam;
    }
}

