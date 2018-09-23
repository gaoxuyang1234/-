package com.yxysoft.basic.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yxysoft.utils.DateUtil;

public class BjmUtils {

	
	
	/**
	 * Date转XMLGregorianCalendar类型
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        DatatypeFactory dtf = null;  
         try {  
            dtf = DatatypeFactory.newInstance();  
        } catch (DatatypeConfigurationException e) {  
        }  
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();  
        dateType.setYear(cal.get(Calendar.YEAR));  
        //由于Calendar.MONTH取值范围为0~11,需要加1  
        dateType.setMonth(cal.get(Calendar.MONTH)+1);  
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));  
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));  
        dateType.setMinute(cal.get(Calendar.MINUTE));  
        dateType.setSecond(cal.get(Calendar.SECOND));  
        return dateType;  
    }
	
	/** 
     * 将XMLGregorianCalendar转换为Date 
     * @param cal 
     * @return  
     */  
    public static Date xmlDate2Date(XMLGregorianCalendar cal){  
        return cal.toGregorianCalendar().getTime();  
    } 
    
    /**
     * 获取上传文件的byte[]字节数组
     * @param commonfil
     * @return
     */
	public static byte[] getByteArrays(CommonsMultipartFile commonfil) {
		InputStream input=null;
		ByteArrayOutputStream byArray=null;
		try {
			input= commonfil.getInputStream();
			byte[] by=new byte[1024];
			int len;
			byArray=new ByteArrayOutputStream();
			while((len=input.read(by))!=-1){
				byArray.write(by, 0, len);
			}
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byArray.toByteArray();
	}
	
	
	public static String  dateStr(){
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		String str= df.format(date);
		return str;
	}
	public static String filName(String fName,String fileName){
		int index= fName.lastIndexOf(".");
		String mill=System.currentTimeMillis()+"";
		mill= mill.substring(mill.length()-5);
		String houzhui= fName.substring(index);
//		String qianzhui= fName.substring(0,index);
		//return fileName+"_"+houzhui;
		return fileName+"_"+DateUtil.getCurrentTimeSSSAsNumber()+houzhui;
	}
	
	public static String filName2(String fName){
		int index= fName.lastIndexOf(".");
		String mill=System.currentTimeMillis()+"";
		mill= mill.substring(mill.length()-5);
		String houzhui= fName.substring(index);
		String qianzhui= fName.substring(0,index);
		return qianzhui+"_"+mill+houzhui;
	}
	
	 public static byte[] getByteData(InputStream in) throws Exception {
	       byte[] b = new byte[1024];
	       ByteArrayOutputStream bos = new ByteArrayOutputStream();
	       int len = 0;
	       while ((len = in.read(b)) != -1) {
	           bos.write(b, 0, len);
	       }
	       if(null!=bos){
	           bos.close();
	       }
	       return bos.toByteArray();
	   }
	
	

}
