package com.yxysoft.utils.weixin.dom4j;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * Dom4j 生成XML文档与解析XML文档
 */
public class Dom4jUtil implements XmlDocument {
	public void createXml(String fileName) {
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		Element employee = employees.addElement("employee");
		Element name = employee.addElement("name");
		name.setText("ddvip");
		Element sex = employee.addElement("sex");
		sex.setText("m");
		Element age = employee.addElement("age");
		age.setText("29");
		try {
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void parserXml(String xml) {
		//File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(new File(xml));//文件
			//Document doc = DocumentHelper.parseText(xml); //String
			Element rootElt = doc.getRootElement(); // 获取根节点
			HashMap<String,String> map = new HashMap<String,String>();
			recParserXml(rootElt,map);
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	public static Map<String,String> parsexmlToMap(String xml){
		Map<String,String> map = new HashMap<String,String>();

		SAXReader saxReader = new SAXReader();
		try {
			//Document doc = saxReader.read(new File(xml));//文件
			Document doc = DocumentHelper.parseText(xml); //String
			Element rootElt = doc.getRootElement(); // 获取根节点
			recParserXml(rootElt,map);
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	/**
	 * @Title: recParserXml 
	 * @Description: 递归xml节点,将所有节点放入map对象
	 * @author 杨书元  
	 * @date Jul 31, 2015 4:41:17 PM 
	 * @version V1.0  
	 * @param Element e
	 * @return void   
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public static void recParserXml(Element e,Map<String,String> map) throws DocumentException {
			if(e.elements().size()>0){//当前节点还有子节点时
				for (Iterator j = e.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					recParserXml(node,map);
				}
			}else{
				map.put(e.getName(), e.getText());
				//System.out.println(e.getName() + ":" + e.getText());
			}
			
	}
	
}