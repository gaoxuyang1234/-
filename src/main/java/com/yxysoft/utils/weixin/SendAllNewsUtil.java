package com.yxysoft.utils.weixin;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.yxysoft.utils.FileUtil;
import com.yxysoft.utils.weixin.Global.HttpsRequestUtil;
import com.yxysoft.utils.weixin.beans.Token;

import net.sf.json.JSONObject;

/**
 * ClassName: SendAllNewsUtil 
 * @Description: 高级群发结单
 * @author yangsy
 * @date 2016-10-10
 */
public class SendAllNewsUtil {
	/**
	 * 上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】
	 */
	public static final String  UPLOAD_IMG_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=image";
	/**
	 * 上传图文消息素材URL【订阅号与服务号认证后均可用】
	 */
	public static final String  UPLOAD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
	/**
	 * 群发URL
	 */
	public static final String  SEND_ALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
	/**
	 * 删除群发【订阅号与服务号认证后均可用】群发之后，随时可以通过该接口删除群发。
	 */
	public static final String  DELETE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
	/**
	 * 预览接口【订阅号与服务号认证后均可用】
	 * 开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
	 */
	public static final String  PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
	
	/**
	 * MethodName: uploadImg
	 * @Description: 模拟form表单的形式 ，上传文件 以输出流的形式把文件写入到url中，然后用输入流来获取url的响应 
	 * @param filePath
	 * @param token
	 * @throws IOException   
	 * @return String  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:33:17
	 */
	public static String uploadImg(String filePath,Token token) throws IOException{
		String localPath = FileUtil.saveToFile(filePath);
		 String result = null;  
	        File file = new File(localPath);  
	        if (!file.exists() || !file.isFile()) {  
	            throw new IOException("文件不存在");  
	        }  
	        /** 
	         * 第一部分 
	         */  
	        String url = UPLOAD_IMG_URL.replace("ACCESS_TOKEN", token.getAccess_token());
	        URL urlObj = new URL(url);
	        // 连接  
	        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();  
	        /** 
	         * 设置关键值 
	         */  
	        con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式  
	        con.setDoInput(true);  
	        con.setDoOutput(true);  
	        con.setUseCaches(false); // post方式不能使用缓存  
	        // 设置请求头信息  
	        con.setRequestProperty("Connection", "Keep-Alive");  
	        con.setRequestProperty("Charset", "UTF-8");  
	        // 设置边界  
	        String BOUNDARY = "---------------------------" + System.currentTimeMillis();  
	        con.setRequestProperty("Content-Type", "multipart/form-data; boundary="  
	                + BOUNDARY);  
	        // 请求正文信息  
	        // 第一部分：  
	        StringBuilder sb = new StringBuilder();  
	        sb.append("--"); // 必须多两道线  
	        sb.append(BOUNDARY);  
	        sb.append("\r\n");  
	        sb.append("Content-Disposition: form-data;name=\"media\";filename=\""  
	                + file.getName() + "\"\r\n");  
	        sb.append("Content-Type:application/octet-stream\r\n\r\n");  
	        byte[] head = sb.toString().getBytes("utf-8");  
	        // 获得输出流  
	        OutputStream out = new DataOutputStream(con.getOutputStream());  
	        // 输出表头  
	        out.write(head);  
	        // 文件正文部分  
	        // 把文件已流文件的方式 推入到url中  
	        DataInputStream in = new DataInputStream(new FileInputStream(file));  
	        int bytes = 0;  
	        byte[] bufferOut = new byte[1024];  
	        while ((bytes = in.read(bufferOut)) != -1) {  
	            out.write(bufferOut, 0, bytes);  
	        }  
	        in.close();  
	        // 结尾部分  
	        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
	        out.write(foot);  
	        out.flush();  
	        out.close();  
	        StringBuffer buffer = new StringBuffer();  
	        BufferedReader reader = null;  
	        try {  
	            // 定义BufferedReader输入流来读取URL的响应  
	            reader = new BufferedReader(new InputStreamReader(  
	                    con.getInputStream()));  
	            String line = null;  
	            while ((line = reader.readLine()) != null) {  
	                buffer.append(line);  
	            }  
	            if (result == null) {  
	                result = buffer.toString();  
	            }  
	        } catch (IOException e) {  
	            System.out.println("发送POST请求出现异常！" + e);  
	            e.printStackTrace();  
	            throw new IOException("数据读取异常");  
	        } finally {  
	            if (reader != null) {  
	                reader.close();  
	            }  
	        }  
	        JSONObject jsonobject = JSONObject.fromObject(result);
	        /**
	         * 返回结果中获取media_id作为后面图文消息里的thumb_media_id
	         */
	        String media_id = jsonobject.getString("media_id");
	        if(media_id==null){
	        	media_id = "";
	        }
	        System.out.println("media_id=========================="+media_id);
	        return media_id;  
	}
	/**
	 * MethodName: uploadNews
	 * @Description: 上传图文素材
	 * @param data
	 * @param token
	 * @return String  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:45:04
	 */
	public static String uploadNews(String data,Token token){

        String requestUrl = UPLOAD_NEWS_URL.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",data);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		System.out.println("uploadNews-------->"+jsonobject.toString());
        /**
         * 返回结果中获取media_id
         */
        String media_id = jsonobject.getString("media_id");
		System.out.println("media_id-------->"+media_id);
        if(media_id==null){
        	media_id = "";
        }
        return media_id;  
	}
	/**
	 * MethodName: sendAll
	 * @Description: sendAll
	 * @param data
	 * @param token
	 * @return msgId  执行群发指令是否成功，此时只意味着群发任务提交成功，并不意味着此时群发已经结束，所以，仍有可能在后续的发送过程中出现异常情况导致用户未收到消息，如消息有时会进行审核、服务器不稳定等。此外，群发任务一般需要较长的时间才能全部发送完毕，请耐心等待
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:49:10
	 */
	public static int sendAll(String data,Token token){
        String requestUrl = SEND_ALL_URL.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",data);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		int msgId =0;
		if(jsonobject!=null){
			msgId = jsonobject.getInt("msg_id");
		}
        return msgId;  
	}
	/**
	 * MethodName: deleteNews
	 * @Description: 删除群发消息
	 *  1、只有已经发送成功的消息才能删除
		2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
		3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
		4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
	 * @param data
	 * @param token
	 * @return boolean  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:52:22
	 */
	public static boolean deleteNews(String data,Token token){
		boolean relust = false;
        String requestUrl = DELETE_URL.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",data);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		if(jsonobject!=null){
			int errcode = jsonobject.getInt("errcode");
			if(errcode==0){//菜单创建成功
				relust = true;
			}
		}
        return relust;  
	}
	/**
	 * MethodName: previewNews
	 * @Description: 预览图文消息
	 * @param data
	 * @param token
	 * @return boolean  
	 * @author yangsy
	 * @version:0.1
	 * @date 2016-10-10 下午5:54:46
	 */
	public static boolean previewNews(String data,Token token){
		boolean relust = false;
		System.out.println("previewNews--data"+data);
        String requestUrl = PREVIEW_URL.replace("ACCESS_TOKEN", token.getAccess_token());
		String createRelust = HttpsRequestUtil.HttpsRequest(requestUrl,"POST",data);
		JSONObject jsonobject = JSONObject.fromObject(createRelust);
		System.out.println("previewNews-------->"+jsonobject.toString());
		if(jsonobject!=null){
			int errcode = jsonobject.getInt("errcode");
			if(errcode==0){//菜单创建成功
				relust = true;
			}
		}
        return relust;  
	}
}
