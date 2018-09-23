package com.yxysoft.utils.weixin.dom4j;

/**
 * * *
 * 
 * @author hongliang.dinghl * 定义XML文档建立与解析的接口
 */
public interface XmlDocument {
	/**
	 * * 建立XML文档 *
	 * 
	 * @param fileName
	 *            文件全路径名
	 */
	public void createXml(String fileName);

	/**
	 * * 解析XML文档 *
	 * 
	 * @param fileName
	 *            文件全路径名
	 */
	public void parserXml(String fileName);
}
