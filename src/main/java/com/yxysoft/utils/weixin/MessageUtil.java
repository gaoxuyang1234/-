/**
 *  FileName：org.yangsy.weixin.util.MessageUtil.java
 *  Description: 
 *  CreateDate: Aug 3, 2015
 *  @author 杨书元
 *  @version 0.9
*/
package com.yxysoft.utils.weixin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yxysoft.utils.weixin.beans.message.resp.image.ImageMessage;
import com.yxysoft.utils.weixin.beans.message.resp.music.Music;
import com.yxysoft.utils.weixin.beans.message.resp.music.MusicMessage;
import com.yxysoft.utils.weixin.beans.message.resp.news.Articles;
import com.yxysoft.utils.weixin.beans.message.resp.news.NewsMessage;
import com.yxysoft.utils.weixin.beans.message.resp.text.TextMessage;
import com.yxysoft.utils.weixin.beans.message.resp.video.VideoMessage;
import com.yxysoft.utils.weixin.beans.message.resp.voice.VoiceMessage;
import com.yxysoft.utils.weixin.dom4j.Dom4jUtil;
import com.yxysoft.utils.weixin.mp.aes.AesException;
import com.yxysoft.utils.weixin.mp.aes.WXBizMsgCrypt;
import com.yxysoft.utils.weixin.xstream.Xstream;

/**
 * ClassName: MessageUtil
 * @Description: TODO
 * @author 杨书元
 * @date Aug 3, 2015
 */
public class MessageUtil {
	/**
	 * 获取微信加解密对象
	 * @Title: getWXBizMsgCrypt 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @author 杨书元  
	 * @date Aug 4, 2015 1:51:01 PM 
	 * @version V1.0  
	 * @param @return    
	 * @return WXBizMsgCrypt   
	 * @throws
	 */
	public static WXBizMsgCrypt getWXBizMsgCrypt(){
		WXBizMsgCrypt pc = null;
		try {
			pc = new WXBizMsgCrypt(SignUtil.token, SignUtil.EncodingAESKey, SignUtil.AppID);
		} catch (AesException e) {
			e.printStackTrace();
		}
		return pc;
	}
	/**
	 * 定义请求消息类型，目前有7+1种
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT= "text";//文本消息
	public static final String REQ_MESSAGE_TYPE_IMAGE= "image";//图片消息
	public static final String REQ_MESSAGE_TYPE_VOICE= "voice";//语音消息
	public static final String REQ_MESSAGE_TYPE_VIDEO= "video";//视频消息
	public static final String REQ_MESSAGE_TYPE_SHORTVIDEO= "shortvideo";//小视频消息
	public static final String REQ_MESSAGE_TYPE_LOCATION= "location";//地理位置消息
	public static final String REQ_MESSAGE_TYPE_LINK= "link";//链接消息
	
	public static final String REQ_MESSAGE_TYPE_EVENT= "event";//响应事件
	/**
	 * 关注/取消关注事件-订阅
	 */
	public static final String EVENT_TYPE_SUBSCRIBE= "subscribe";
	/**
	 * 关注/取消关注事件-取消订阅
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE= "unsubscribe";	
	/**
	 * 扫描待参数的二维码
	 */
	public static final String EVENT_TYPE_SCAN= "SCAN";	
	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	public static final String EVENT_TYPE_VIEW= "VIEW";	
	/**
	 * 群发图文消息-推送群发结果事件
	 */
	public static final String EVENT_TYPE_MASSSENDJOBFINISH= "MASSSENDJOBFINISH";	
	/**
	 * 点击自定义菜单
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 定义响应消息类型，目前有6种
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT= "text";//文本消息
	public static final String RESP_MESSAGE_TYPE_IMAGE= "image";//图片消息
	public static final String RESP_MESSAGE_TYPE_VOICE= "voice";//语音消息
	public static final String RESP_MESSAGE_TYPE_VIDEO= "video";//视频消息
	public static final String RESP_MESSAGE_TYPE_MUSIC= "music";//音乐消息
	public static final String RESP_MESSAGE_TYPE_NEWS= "news";//图文消息
	
	/**
	 * 明文模式下解析请求报文
	 * @Title: paseXMl 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author 杨书元  
	 * @date Aug 4, 2015 11:56:42 AM 
	 * @version V1.0  
	 * @param @param request
	 * @param @return
	 * @param @throws Exception    
	 * @return HashMap<String,String>   
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public HashMap<String,String> paseXMl(HttpServletRequest request) throws Exception{
		HashMap<String,String> map = new HashMap<String,String>();
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(request.getInputStream());//文件
		Element rootElt = doc.getRootElement(); // 获取根节点
		Dom4jUtil dom4j = new Dom4jUtil();
		dom4j.recParserXml(rootElt,map);
		return map;
	}
	/**
	 * 密文模式下解析请求报文
	 * @Title: paseXMlCrypt 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author 杨书元  
	 * @date Aug 4, 2015 11:56:42 AM 
	 * @version V1.0  
	 * @param @param request
	 * @param @return
	 * @param @throws Exception    
	 * @return HashMap<String,String>   
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public HashMap<String,String> paseXMlCrypt(HttpServletRequest request) throws Exception{
		HashMap<String,String> map = new HashMap<String,String>();
		/**
		 * 第一步：从请求流里获取到请求报文字符串
		 */
		InputStream is =request.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		//每次读取一行
		String line = "";
		//定义存储请求报文字符串
		StringBuffer fromXMLText = new StringBuffer();
		while((line = bufferedReader.readLine())!=null){
			//line = bufferedReader.readLine();
			fromXMLText.append(line);
		}
		is.close();
		bufferedReader.close();
		/**
		 * 第二步：解密
		 */
		WXBizMsgCrypt pc = getWXBizMsgCrypt();
		String msgSignature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		//log.info("请求报文（密文）"+fromXMLText.toString());
		String fromXML = pc.decryptMsg(msgSignature, timestamp, nonce, fromXMLText.toString());
		/**
		 * 第三步：解析请求报文
		 */
		Document doc = DocumentHelper.parseText(fromXML);//文本字符串
		Element rootElt = doc.getRootElement(); // 获取根节点
		Dom4jUtil dom4j = new Dom4jUtil();
		dom4j.recParserXml(rootElt,map);
		return map;
	}
/**
 * @Title: paseRespXMlCrypt 
 * @Description: 对返回报文进行加密
 * @author 杨书元  
 * @date Aug 4, 2015 2:09:43 PM 
 * @version V1.0  
 * @param @param request
 * @param @param replyMsg
 * @param @return
 * @param @throws Exception    
 * @return String   
 * @throws
 */
	public static String paseRespXMlCrypt(HttpServletRequest request,String replyMsg) throws Exception{
		/**
		 * 加密密
		 */
		WXBizMsgCrypt pc = getWXBizMsgCrypt();
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		//log.info("返回报文（明文）"+replyMsg);
		String mingwen = pc.encryptMsg(replyMsg, timestamp, nonce);
		//log.info("返回报文（密文）"+mingwen);
		return mingwen;
	}
	@SuppressWarnings("static-access")
	public String messageToXML(TextMessage textMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", TextMessage.class);
		return xstream.xs.toXML(textMessage);
	}
	@SuppressWarnings("static-access")
	public String messageToXML(ImageMessage imageMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", ImageMessage.class);
		return xstream.xs.toXML(imageMessage);
	}
	@SuppressWarnings("static-access")
	public String messageToXML(MusicMessage musicMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", MusicMessage.class);
		xstream.xs.alias("Music", Music.class);
		return xstream.xs.toXML(musicMessage);
	}
	@SuppressWarnings("static-access")
	public String messageToXML(NewsMessage newsMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", NewsMessage.class);
		xstream.xs.alias("item", Articles.class);
		return xstream.xs.toXML(newsMessage);
	}
	@SuppressWarnings("static-access")
	public String messageToXML(VideoMessage videoMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", VideoMessage.class);
		return xstream.xs.toXML(videoMessage);
	}
	@SuppressWarnings("static-access")
	public String messageToXML(VoiceMessage voiceMessage){
		Xstream xstream = new Xstream();
		xstream.xs.alias("xml", VoiceMessage.class);
		return xstream.xs.toXML(voiceMessage);
	}
}
