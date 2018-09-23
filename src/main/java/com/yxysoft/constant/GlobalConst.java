package com.yxysoft.constant;

/**
 * 返回代码
 * @author yangsy
 *
 */
public class GlobalConst {
	//用户状态
	public static final int USER_STATE_AUTH=0;
	public static final int USER_STATE_NOAUTH=1;
	public static final int USER_STATE_DONGJIE=2;
	public static final int USER_STATE_DEL=3;
	//文件地址
//
//	public static final String FIL_BASE= "D:/upload/qxzwonline/";
//	public static final String FIL_UP_URL= "D:/upload/qxzwonline/upload/street/";
//	public static final String FIL_BASE= "/usr/java/upload/qxzwonline/";
//	public static final String FIL_UP_URL= "/usr/java/upload/qxzwonline/upload/street/";

	public static final String FIL_BASE= "/zgb/application/upload/qxzwonline/";
	public static final String FIL_UP_URL= "/zgb/application/upload/qxzwonline/upload/street/";
//	
	//public static final String FIL_DO_URL= "D:/upload/栖霞不见面(下载)/街道/";
	//public static final String APPLY_X= "/申报须知";
	public static final String APPLY_B= "/table";
	public static final String APPLY_Z= "/certs";
	//public static final String APPLY_X_IMG="申报须知.jpg";
	public static final String APPLY_TEMP="TEMP/";
	public static final String APPLY_TEMPRAR="TEMPRAR/";
    //受理端发送回执路径
    public static final String ACCEPT_RECEIPT="receipt/";
	//用户注册时上传的附件地址
	public static final String REG_CARD= "register/";
	//用户刷脸登录时上传的附件地址
	public static final String LOGIN_FACE= "login/";
	//上传邮件图片
	public static final String STA_MAIL="mail/";
	//手机短信GET
	public static final String GSHORT_MESSAGE="http://222.190.145.130:8088/smsController/customSms?telNo={0}&content={1}";
	//手机短信POST
	public static final String SHORT_MESSAGE="http://222.190.145.130:8088/smsController/customSms";
}
