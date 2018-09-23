package com.yxysoft.utils.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.github.pagehelper.util.StringUtil;
import com.yxysoft.utils.MD5Util;

public class HongBaoUtil {
	public static final String MCH_ID = "1484284522";                   //商户号  
    public static final String WXAPPID = "wxd51eb96eb4d5299b";             //公众账号appid  
    public static final String NICK_NAME = "栖霞不见面";            //提供方名称  
    public static final String SEND_NAME = "栖霞不见面";             //商户名称  
    public static final int HONGBAO_MIN_VALUE = 50;               //红包最小金额 单位:分  
    public static final int HONGBAO_MAX_VALUE = 50;              //红包最大金额 单位:分  
    public static final int TOTAL_NUM = 1;                         //红包发放人数  
    public static final String WISHING = "领红包啦";   //红包祝福语  
    public static final String CLIENT_IP = "127.0.0.1";            //调用接口的机器IP  
    public static String ACT_NAME = "提米提现领红包";                  //活动名称  
    public static String REMARK = "提米提现领红包";                    //备注  
    public static final String KEY = "MFLT3SaO8aGjtPIUGwH5TGv6FlC0yMCc"; //秘钥  

    public static final int SUCCESS = 0; //领取成功  
    public static final int FAIL = 1;    //领取失败  
    public static final int LOCK = 2;    //已在余额表中锁定该用户的余额,防止领取的红包金额大于预算  x

    public static final int HB_TYPE_RES = 1; //红包类型:1-首次注册红包；2-首次办件红包
    public static final int HB_TYPE_DEAL = 2; //红包类型:1-首次注册红包；2-首次办件红包
    public static final int SEND_STATUE_NO = 1; //发送状态 1未发送；2发送成功；3发送失败
    public static final int SEND_STATUE_SUCCESS = 2; //发送状态 1未发送；2发送成功；3发送失败
    public static final int SEND_STATUE_FAIL = 3; //发送状态 1未发送；2发送成功；3发送失败
    
    public static final List<Integer> cashList = Arrays.asList(100,110,120,130,140,150
    		,160,170,180,190,200);

    public static final List<Integer> cashList1 = Arrays.asList(200,210,220,230,240,260,270,280,290,300,200,210,220,230,240,260,270,280,290,300);
    
      
    /** 
     * 对请求参数名ASCII码从小到大排序后签名 
     * @param openid 
     * @param userId 
     * @return 
     */  
    public static void sign(SortedMap<String, String> params){  
        Set<Entry<String,String>> entrys=params.entrySet();    
        Iterator<Entry<String,String>> it=entrys.iterator();    
        String result = "";  
        while(it.hasNext())    
        {    
           Entry<String,String> entry=it.next();    
           if(StringUtil.isNotEmpty(entry.getValue())){
        	   result +=entry.getKey()+"="+entry.getValue()+"&";  
           }
        }    
        System.out.println("result=="+result);
        result +="key="+KEY;  
        System.out.println("result=="+result);
        String sign = null;  
        try {  
            sign = MD5Util.MD5(result,"UTF-8").toUpperCase();  
            System.out.println("sign=="+sign);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        params.put("sign", sign);  
    }  
    /**
     * MethodName: getRequestXml
     * @Description: 生成发送红包报文
     * @param params
     * @return String  
     * @author yangsy
     * @version:0.1
     * @date 2016-4-21 上午9:21:49
     */
    @SuppressWarnings("rawtypes")
	public static String getRequestXml(SortedMap<String,String> params){  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = params.entrySet();  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            String v = (String)entry.getValue();  
            if ("nick_name".equalsIgnoreCase(k)||"send_name".equalsIgnoreCase(k)||"wishing".equalsIgnoreCase(k)||"act_name".equalsIgnoreCase(k)||"remark".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {  
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");  
            }else {  
                sb.append("<"+k+">"+v+"</"+k+">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
    /**
     * MethodName: createMap
     * @Description: 拼装发送红包参数
     * @param billNo 订单号
     * @param openid 接收微信号
     * @param amount 红包金额
     * @param wishing 红包祝福语
     * @param act_name 红点名称
     * @param remark 备注
     * @return SortedMap<String,String>  
     * @author yangsy
     * @version:0.1
     * @date 2016-4-22 下午5:52:48
     */
    public static SortedMap<String, String> createMap(String billNo,String openid,int amount,
    		String wishing,String act_name,String remark){  
    	System.out.println("act_name=="+act_name);
        SortedMap<String, String> params = new TreeMap<String, String>(); 
        params.put("act_name", act_name);  
        params.put("client_ip", CLIENT_IP);  
        params.put("mch_billno",billNo);  
        params.put("mch_id", MCH_ID);   
        params.put("nonce_str",createNonceStr());  
        params.put("re_openid", openid);   
        params.put("remark", remark);  
        params.put("send_name", SEND_NAME); 
        params.put("total_amount", amount+""); 
        params.put("total_num", TOTAL_NUM+"");  
        params.put("wishing", wishing);  
        params.put("nick_name", NICK_NAME);   
        params.put("min_value", amount+"");  
        params.put("max_value", amount+"");  
        params.put("wxappid",WXAPPID);  
        return params;  
    }  
    /** 
     * 生成随机字符串 
     * @return 
     */  
    public static String createNonceStr() {  
                return UUID.randomUUID().toString().toUpperCase().replace("-", "");  
        }  
    /** 
     * 生成商户订单号 
     * @param mch_id  商户号 
     * @param userId  该用户的userID 
     * @return 
     */  
    public static String createBillNo(String cashId){  
        //组成： mch_id+yyyymmdd+10位一天内不能重复的数字  
        //10位一天内不能重复的数字实现方法如下:  
        //因为每次提现的cashId不同,加上随机生成的(10-length(userId))可保证这10位数字不一样  
        Date dt=new Date();  
        SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");  
        String nowTime= df.format(dt);  
        int length = 10 - cashId.length();  
        return MCH_ID + nowTime + cashId + getRandomNum(length);  
    }  
    /** 
     * 生成特定位数的随机数字 
     * @param length 
     * @return 
     */  
    public static String getRandomNum(int length) {  
        String val = "";  
        Random random = new Random();  
        for (int i = 0; i < length; i++) {  
            val += String.valueOf(random.nextInt(10));  
        }  
        return val;  
    }  
    /**
     * MethodName: post
     * @Description: 发送Post请求，后台调用发送红包接口
     * @param requestXML
     * @param instream
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     * @throws KeyManagementException
     * @throws UnrecoverableKeyException
     * @throws KeyStoreException   
     * @return String  
     * @author yangsy
     * @version:0.1
     * @date 2016-3-29 上午11:28:12
     */
    public static String post(String requestXML,InputStream instream) throws NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException, UnrecoverableKeyException, KeyStoreException{  
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");  
        try {  
            keyStore.load(instream, MCH_ID.toCharArray());  
        }  finally {  
            instream.close();  
        }  
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, MCH_ID.toCharArray()).build();  
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(  
                sslcontext,  
                new String[] { "TLSv1" },  
                null,  
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);  
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();  
        String result = "";  
        try {  
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");  
            StringEntity  reqEntity  = new StringEntity(requestXML,"UTF-8");  
            // 设置类型   
            reqEntity.setContentType("application/x-www-form-urlencoded");   
            httpPost.setEntity(reqEntity);  
            CloseableHttpResponse response = httpclient.execute(httpPost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));  
                    String text;  
                    while ((text = bufferedReader.readLine()) != null) {  
                        result +=text;  
                        System.out.println(text);  
                    }  
                }  
                EntityUtils.consume(entity);  
            } finally {  
                response.close();  
            }  
        } finally {  
            httpclient.close();  
        }  
        return result;  
    }  
    /**
     * 根据红包类型，产生随机红包；首次首次1块到2块；首次有效办件1-3块
     * @param hbType
     * @return 随机红包
     */
    public static Integer getHbCash(Integer hbType){
    	int sj = 0;
    	Integer cash = 0;
    	if(hbType==HongBaoUtil.HB_TYPE_RES){//取 0-9随机数
    		int max = 9;
    		int min = 0;
    		Random random = new Random();
    		sj = (int)random.nextInt(max)%(max-min+1) + min;
    		cash = cashList.get(sj);
    	}else{
    		int max = 19;
    		int min = 0;
    		Random random = new Random();
    		sj = (int)random.nextInt(max)%(max-min+1) + min;
    		cash = cashList1.get(sj);
    	}
    	//System.out.println(cashList.get(sj));
    	return cash;
    }
    
}
