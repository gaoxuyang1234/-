package com.yxysoft.utils;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.yxysoft.basic.model.ErrenSheQu;
import com.yxysoft.basic.ws.WsErren;

public class Dom4jUtil {
	public String  Dom4jListAreas(String xml) throws Exception{  
	    SAXReader sax=new SAXReader();//创建一个SAXReader对象  
	    Document document=sax.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));//获取document对象,如果文档无节点，则会抛出Exception提前结束  
	    Element root = document.getRootElement();//获取根节点  
	    StringBuffer res = new StringBuffer();
	    res.append("[");
	    this.getNodesListAreas(root,res);//从根节点开始遍历所有节点  

	    res.append("]");
	    return res.toString().replace("},]", "}]");
	  
	}  
	 /** 
	 * 从指定节点开始,递归遍历所有子节点 
	 * @author chenleixing 
	 */  
	public void getNodesListAreas(Element node,StringBuffer res){  
	    System.out.println("--------------------");  
	     String name = node.getName();
	     String value = node.getTextTrim();
	     ErrenSheQu info = new ErrenSheQu();
	     if(StringUtil.isNotBlank(name)&&"areaid".equalsIgnoreCase(name)){
	    	 info.setAreaid(value);
	    	 res.append("{");
	    	 res.append("\"areaid\":\""+value+"\",");
	     }
	     if(StringUtil.isNotBlank(name)&&"mc".equalsIgnoreCase(name)){
	    	 info.setMc(value);
	    	 res.append("\"mc\":\""+value+"\"");
	    	 res.append("},");
	     }
	     WsErren.sheQuList.add(info);
	    //递归遍历当前节点所有的子节点  
	    List<Element> listElement=node.elements();//所有一级子节点的list  
	    for(Element e:listElement){//遍历所有一级子节点  
	        this.getNodesListAreas(e,res);//递归  
	    }  
	}  
}
