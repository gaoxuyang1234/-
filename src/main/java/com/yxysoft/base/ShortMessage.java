package com.yxysoft.base;


public class ShortMessage {

	/**
	 * 已受理
	 * @return
	 */
	public static String Receipt_04(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好,您于{1}申请的{2}业务,已经受理完成,请及时登录微信小程序[栖霞区不见面审批服务]进行查询");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	/**
	 * 受理驳回(补正)
	 * @return
	 */
	public static String Receipt_05(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好，您于{1}申请的{2}业务，经过核查，材料存在缺失，请及时登录微信小程序[栖霞区不见面审批服务]进行查询补正");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	/**
	 * 审批通过
	 * @return
	 */
	public static String Receipt_00(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好,您于{1}申请的{2}业务,已经审批通过,请及时登录微信小程序[栖霞区不见面审批服务]进行查询");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	/**
	 * 审批驳回
	 * @return
	 */
	public static String Receipt_07(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好，您于{1}申请的{2}业务，已被审批驳回，请登录微信小程序[栖霞区不见面审批服务]进行查询");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	/**
	 * 通知受理
	 * @param uName
	 * @param aTime
	 * @param sName
	 * @return
	 */
	public static String AcceptNotice(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好,您于{1}申请的{2}业务,正准备受理,请在[一分钟]内及时登录微信小程序[栖霞区不见面审批服务]进行受理");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	/**
	 * 通知过号
	 * @param uName
	 * @param aTime
	 * @param sName
	 * @return
	 */
	public static String AcceptNotice_1(String uName,String aTime,String sName){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好，您于{1}申请的{2}业务，因为呼叫未通，已被做过号处理，请及时登录微信小程序[栖霞区不见面审批服务]重新申请");
		String str= sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName);
		return str;
	}
	
	public static String AcceptNotice_2(String uName,String aTime,String sName,String state){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好,您于{1}申请的[{2}]业务,{3}");
		String str=sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName).replace("{3}", state);
		return str;
	}
	
	public static String AcceptNotice_3(String uName,String aTime,String sName,String state){
		StringBuffer sbu=new StringBuffer();
		sbu.append("尊敬的{0}您好,您于{1}申请的[{2}]业务,{3}");
		String str=sbu.toString().replace("{0}",uName).replace("{1}",aTime).replace("{2}",sName).replace("{3}", state);
		return str;
	}
	
	
	//XML信息
	public static String Acept_web(){
		StringBuilder sub=new StringBuilder();
		sub.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sub.append("<registerType type=\"{0}\">");
		sub.append("<person>");
		sub.append("<aId>{18}</aId>");
		sub.append("<name>{1}</name>");        			//姓名
		sub.append("<birthday></birthday>");   			//出生年月
		sub.append("<malename></malename>");   			//配偶姓名
		sub.append("<malebirthday></malebirthday>");	//配偶出生年月
		sub.append("<sex></sex>	");						//性别
		sub.append("<nation></nation>");				//民族
		sub.append("<cardid>{7}</cardid>	");         //身份证号码
		sub.append("<areaid>{8}</areaid>");				//区域id
		sub.append("<address></address>	");				//住址
		sub.append("<street>{10}</street>");			//街道
		sub.append("<cdrmd></cdrmd>	");					//查档目的
		sub.append("<cdrdh></cdrdh>	");					//查档人电话号码 
		sub.append("<cym></cym>	");						//曾用名
		sub.append("<accuracy>{14}</accuracy> ");		//精准度 
		sub.append("<identitycard>");
		sub.append("<filename></filename>");			
		sub.append("<content>{16}</content>");          //身份证照片，以Base64编码字符串存储 
		sub.append("</identitycard>");			    
		sub.append("<phead>");
		sub.append("<filename></filename>");
		sub.append("<content>{17}</content>");			//头像证明材料		
		sub.append("</phead>");
		sub.append("</person>");
		sub.append("<materials>");
	    sub.append("<material>");
		sub.append("<name></name>");	
        sub.append("<images>");
		sub.append("<content></content>");		    //证明材料照片，以Base64编码字符串存储 				
		sub.append("</images>");					
		sub.append("</material>");					
		sub.append("</materials>");			
		sub.append("</registerType>");							
	   return sub.toString();							
							
	}
	
}
