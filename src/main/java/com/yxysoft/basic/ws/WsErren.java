package com.yxysoft.basic.ws;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.yxysoft.basic.model.ErrenSheQu;
import com.yxysoft.utils.Dom4jUtil;

public class WsErren {
	private static String LogonServiceUrl="http://192.168.0.98:8181/qxda/services/LogonService";
	private static String SearchArchivesServiceUrl="http://192.168.0.98:8181/qxda/services/SearchArchivesService";
	public static void main(String[] args) {
		//登录
		try {
			//SendMASMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 登录
	 * @return
	 */

	public static String logon() throws Exception{
		String result=null;
		Service service= new Service();
		Call call=(Call) service.createCall();
		call.setTargetEndpointAddress(new URL(LogonServiceUrl));
		call.setOperationName("logon");
		call.addParameter("user",XMLType.XSD_STRING,ParameterMode.IN);
		call.addParameter("password",XMLType.XSD_STRING,ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);
		QName qName=new QName("http://impl.service.transfer.apps.seeyon.com","logon"); 
		result=(String) call.invoke(qName,new Object[]{"bjmspuser", "123456"});
		//logoff(result);
		return result;
	}
	/**
	 * 登出
	 * @param seesion
	 * @return
	 */
	public static void logoff(String seesion)throws Exception{

		Service service= new Service();
		Call call=(Call) service.createCall();
		call.setTargetEndpointAddress(new URL(LogonServiceUrl));
		call.setOperationName("logoff");
		call.addParameter("sessionid",XMLType.XSD_STRING,ParameterMode.IN);
		QName qName=new QName("http://impl.service.transfer.apps.seeyon.com","logoff"); 
		call.invoke(qName,new Object[]{seesion});
	}
	/**
	 * 根据街道编码，获取社区信息
	 * @param session
	 * @param streetid
	 * @return
	 */
	public static List<ErrenSheQu> sheQuList = new ArrayList<ErrenSheQu>();
	public String listAreas(String session,Long streetid)throws Exception{
		String xml = "";
		String res ="";
		Service service= new Service();
		Call call=(Call) service.createCall();
		call.setTargetEndpointAddress(new URL(SearchArchivesServiceUrl));
		call.setOperationName("listAreas");
		call.addParameter("session",XMLType.XSD_STRING,ParameterMode.IN);
		call.addParameter("streetid",XMLType.XSD_STRING,ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);
		QName qName=new QName("http://impl.service.transfer.apps.seeyon.com","listAreas"); 
		xml=(String) call.invoke(qName,new Object[]{session,streetid+""});
	     WsErren.sheQuList.clear();
	     Dom4jUtil dom4j =  new Dom4jUtil();
	     try {
			res = dom4j.Dom4jListAreas(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	/**
	 * 查档等级
	 * @param session
	 * @param data
	 */
	public void addApplyInfo(String session,String data)throws Exception{
		Service service= new Service();
		Call call=(Call) service.createCall();
		call.setTargetEndpointAddress(new URL(SearchArchivesServiceUrl));
		call.setOperationName("addApplyInfo");
		call.addParameter("session",XMLType.XSD_STRING,ParameterMode.IN);
		call.addParameter("xml",XMLType.XSD_STRING,ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);
		QName qName=new QName("http://impl.service.transfer.apps.seeyon.com","addApplyInfo"); 
		call.invoke(qName,new Object[]{session,data});
	}
}
