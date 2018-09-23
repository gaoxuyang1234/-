package com.yxysoft.utils;

import java.util.Comparator;
import java.util.UUID;
/**
 * 转换字符编码
 */
public class SpellComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        try{
            String s1 = new String(o1.toString().getBytes("GB2312"), "ISO-8859-1");
            String s2 = new String(o2.toString().getBytes("GB2312"), "ISO-8859-1");
            return s1.compareTo(s2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    /**
     * 创建uuid
     */
    public static synchronized String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String nonce=str.replace("-", "");
        return nonce;
    }
}