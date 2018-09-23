package com.yxysoft.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class HttpClientPost {
    
    public static final String POST_URL =
        "https://v2-auth-api.visioncloudapi.com/identity/idnumber_verification/stateless";
    @SuppressWarnings({ "unchecked", "unused" })
	public static String HttpClientPost(String username,String id_number,String filepath, Map<String, Object> map2) 
    		throws ClientProtocolException, IOException {
        @SuppressWarnings("resource")
		HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost(POST_URL);
        StringBody name = new StringBody(username, Charset.forName("UTF-8"));
        StringBody number = new StringBody(id_number);
        FileBody fileBody = new FileBody(new File(filepath));
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("name", name);
        entity.addPart("idnumber", number);
        entity.addPart("image_file", fileBody);
        post.setEntity(entity);
        HttpClientPostUtils httpClientPostUtils = new HttpClientPostUtils();
        String Authorization = null;
        try{
             Authorization = HttpClientPostUtils.
                     genHeaderParam("2c3140a628954276a2cbe1d6e60da390",
                     "ed0dc5b4d6b2437f8faca54ddcd2cc34");
        }catch (Exception e){}
        post.setHeader("Authorization", Authorization);//请将AUTHORIZATION替换为根据API_KEY和API_SECRET得到的签名认证串
        HttpResponse response = httpclient.execute(post);
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<String,Object>();
        String statusCode = "";
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entitys = response.getEntity();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(entitys.getContent()));
            String line = reader.readLine();
            System.out.println("状态码："+line);
            map = mapper.readValue(line, Map.class);
            map2.put("result", line);
            if(map.containsKey("verification_score") ){
            	double verification_score = (Double) map.get("verification_score");
            	String dobToString = String.valueOf(verification_score);
            	String str = dobToString.substring(2,3);
            	int i=Integer.parseInt(str);
            	System.out.println("人脸比对结果:"+i);
            	if(i>=6){
            		return "success,得分:"+dobToString;
	            }
	    		}else{
	    			return line;
	    		}
            
            
        }else{
            HttpEntity r_entity = response.getEntity();
            String responseString = EntityUtils.toString(r_entity);
            //System.out.println("错误码是："+response.getStatusLine().getStatusCode()+" "+
            //      response.getStatusLine().getReasonPhrase());
            
            //System.out.println("出错原因是："+responseString);
            
            statusCode = "bad";
            //你需要根据出错的原因判断错误信息，并修改
        }
        httpclient.getConnectionManager().shutdown();
        //返回错误的信息
        return statusCode;
    }
}