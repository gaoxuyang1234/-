package com.yxysoft.utils.baidu;


import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import net.sf.json.JSONArray;

/**
* 人脸对比
*/
public class FaceMatch {

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String match(String accessToken,String param) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {

            //String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
           // String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);

            Double score = 0.0;
    		try {
    			JSONObject jsonObject = new JSONObject(result);
    	        int error_code = jsonObject.getInt("error_code");
    	        if(error_code==0){
    	        	JSONObject result1 = jsonObject.getJSONObject("result");
    	        	score = result1.getDouble("score");
    	        }
    		} catch (JSONException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		if(score>60.0){
    			result = "success";
    	        System.out.println("成功");
    	        System.out.println(score);
    		}else{
    			result = "bad";
    	        System.out.println("失败");
    	        System.out.println(score);
    			
    		}
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
    	String param = "";
    	imageModel m1 = new imageModel();
    	m1.setImage("http://source.tanyangnet.com/register/412326198208190312/head.jpg");
    	m1.setImage_type("URL");
    	m1.setFace_type("LIVE");
    	m1.setQuality_control("LOW");
    	m1.setLiveness_control("NONE");
    	imageModel m2 = new imageModel();
    	m2.setImage("http://source.tanyangnet.com/register/412326198208190312/frot.jpg");
    	m2.setImage_type("URL");
    	m2.setFace_type("CERT");
    	m2.setQuality_control("LOW");
    	m2.setLiveness_control("NONE");
    	List<imageModel> list = new ArrayList<imageModel>();
    	list.add(m1);
    	list.add(m2);
    	JSONArray json = JSONArray.fromObject(list);  
    	param = json.toString();
        String res = FaceMatch.match(AuthService.getAuth(),param);
        System.out.println("结果====="+res);
    }
}
