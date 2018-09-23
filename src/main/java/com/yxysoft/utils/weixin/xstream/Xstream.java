package com.yxysoft.utils.weixin.xstream;

import java.io.Writer;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.yxysoft.utils.weixin.MessageUtil;
import com.yxysoft.utils.weixin.beans.message.resp.text.TextMessage;

public class Xstream {

	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @author 杨书元  
	 * @date Jul 31, 2015 5:17:59 PM 
	 * @version V1.0  
	 * @param @param args    
	 * @return void   
	 * @throws 
	 */

	public static void main(String[] args) {
		TextMessage tm = new TextMessage();
		tm.setFromUserName("11");//此时发送消息的用户为请求里接收消息的用户
		tm.setToUserName("22");//此时接收消息的用户为请求里发送消息的用户
		tm.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		tm.setCreateTime(new Date().getTime());
		tm.setContent("33");
		
		//XStream xs = new XStream(new DomDriver());
		//设置别名
		//xs.setMode(XStream.ID_REFERENCES);
		xs.alias("xml", TextMessage.class);
		//对象转换xml
		String xml = xs.toXML(tm);
		System.out.println(xml);
//		//xml转对象
//		Person p1 = (Person)xs.fromXML(xml);
//		System.out.println(""+p1.getName()+"#"+p1.getMisn());
	}
	
	/**
	 * XStream扩展：CDATA
	 */
	@SuppressWarnings("rawtypes")
	public static XStream xs = new XStream(new DomDriver(){
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){
				//
				boolean cdata = true;
				public void startNode(String name,Class clazz){
					super.startNode(name,clazz);
				}
				protected void writeText(QuickWriter writer,String text){
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
		
	});
	

}
