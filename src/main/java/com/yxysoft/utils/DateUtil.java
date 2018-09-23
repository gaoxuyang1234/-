package com.yxysoft.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yxysoft.common.constants.Symbol;


/**
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @author yangsy
 */
public abstract class DateUtil extends org.apache.commons.lang3.time.DateUtils {

    /**
     * @Fields SECOND : 1秒=多少毫秒
     */
    public static final long SECOND = 1000L;

    /**
     * @Fields MINUTE : 1分钟等于多少毫秒
     */
    public static final long MINUTE = 60L * SECOND;

    /**
     * @Fields HOUR : 一小时等于多少毫秒
     */
    public static final long HOUR = 60L * MINUTE;

    /**
     * @Fields DAY : 一天等于多少毫秒
     */
    public static final long DAY = 24L * HOUR;

    /**
     * @Fields WEEK : 一星期等于多少毫秒
     */
    public static final long WEEK = 7L * DAY;

    /**
     * @Fields YEAR_FORMAT : 年
     */
    public static final String YEAR_FORMAT = "yyyy";
    /**
     * @Fields MONTH_FORMAT : 年月
     */
    public static final String MONTH_FORMAT = "yyyy-MM";
    /**
     * @Fields DAY_FORMAT : 年月日
     */
    public static final String DAY_FORMAT = "yyyy-MM-dd";
    /**
     * @Fields HOUR_FORMAT : 年月日小时
     */
    public static final String HOUR_FORMAT = "yyyy-MM-dd HH";
    /**
     * @Fields MINUTE_FORMAT : 年月日小时分钟
     */
    public static final String MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    /**
     * @Fields SECOND_FORMAT : 年月日小时分钟秒
     */
    public static final String SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * @Fields MONTH_NUMBER_FORMAT : 年月
     */
    public static final String MONTH_NUMBER_FORMAT = "yyyyMM";
    /**
     * @Fields DAY_NUMBER_FORMAT : 年月日
     */
    public static final String DAY_NUMBER_FORMAT = "yyyyMMdd";
    /**
     * @Fields HOUR_NUMBER_FORMAT : 年月日小时
     */
    public static final String HOUR_NUMBER_FORMAT = "yyyyMMddHH";
    /**
     * @Fields MINUTE_NUMBER_FORMAT : 年月日小时分钟
     */
    public static final String MINUTE_NUMBER_FORMAT = "yyyyMMddHHmm";
    /**
     * @Fields SECOND_NUMBER_FORMAT : 年月日小时分钟秒
     */
    public static final String SECOND_NUMBER_FORMAT = "yyyyMMddHHmmss";

    /**
     * @Fields MILLI_SECOND_NUMBER_FORMAT : 年月日小时分钟秒毫秒
     */
    public static final String MILLI_SECOND_NUMBER_FORMAT = "yyyyMMddHHmmssSSS";

    /**
     * @Fields DEFAULT_PATTERN : 默认日期格式化类
     */
    public static final String DEFAULT_PATTERN = SECOND_FORMAT;

    /**
     * @Fields DAY_NUM_OF_WEEK : 一周有7天
     */
    public static final int DAY_NUM_OF_WEEK = 7;

    /**
     * @Fields WORKING_DAY_OF_WEEK : 一周有5个工作日
     */
    public static final int WORKING_DAY_OF_WEEK = 5;

    /**
     * @Fields FORMATS_CROSS_BAR_SPACE : 带横杠和空格的日期格式
     */
    private static final String[] FORMATS_CROSS_BAR_SPACE = { SECOND_FORMAT, MINUTE_FORMAT, HOUR_FORMAT, DAY_FORMAT, MONTH_FORMAT, YEAR_FORMAT };

    /**
     * @Fields FORMATS_NUMERIC : 全数字的日期格式
     */
    private static final String[] FORMATS_NUMERIC = { SECOND_NUMBER_FORMAT, MINUTE_NUMBER_FORMAT, HOUR_NUMBER_FORMAT, DAY_NUMBER_FORMAT,
        MONTH_NUMBER_FORMAT, YEAR_FORMAT, };

    /**
     * @Fields FORMATS_CROSS_BAR : 带横杠无空格的日期格式
     */
    private static final String[] FORMATS_CROSS_BAR = { DAY_FORMAT, MONTH_FORMAT, };

    // /**
    // * @Fields FORMATS_FORWARD_SPLASH_SPACE : 带斜杠和空格的日期格式
    // */
    // private static final String[] FORMATS_FORWARD_SPLASH_SPACE = { "yyyy/MM/dd HH:mm:ss.S", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
    // "MM/dd/yyyy HH:mm:ss.S", "MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy HH:mm", };
    // /**
    // * @Fields FORMATS_FORWARD_SPLASH : 带斜杠不带空格的日期格式
    // */
    // private static final String[] FORMATS_FORWARD_SPLASH = { "yyyy/MM/dd", "yyyy/MM", "MM/dd/yyyy", "MM/yyyy", };

    // /**
    // * @Fields FORMATS_COLON : 带冒号的日期格式
    // */
    // private static final String[] FORMATS_COLON = { "HH:mm:ss", "HH:mm", };

    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 存储SimpleDateFormat对应格式发的String类型
     */
    private static Map<String, SimpleDateFormat> map = new HashMap<String, SimpleDateFormat>();

    /**
     * @Title: getNow
     * @Description: 获取jvm当前时间
     * @return jvm的当前时间
     */
    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 通过时间格式化字符串获取SimpleDateFormat
     * @param parsePatterns 时间格式化
     * @return {@link SimpleDateFormat}
     */
    public static SimpleDateFormat getSimpleDateFormat(final String parsePatterns) {
        SimpleDateFormat dateFormat = null;
        if (map.containsKey(parsePatterns)) {
            dateFormat = map.get(parsePatterns);
        } else {
            dateFormat = new SimpleDateFormat(parsePatterns);
            map.put(parsePatterns, dateFormat);
        }
        return dateFormat;
    }

    /**
     * 格式化时间，返回格式化后的时间字符串
     * 
     * <pre>
     * 例子,如有一个Date = 2012-08-09:
     * DateUtils.format(date,"yyyy-MM-dd") = "2012-08-09"
     * DateUtils.format(date,"yyyy年MM月dd日") = "2012年08月09日"
     * DateUtils.format(date,"") = null
     * DateUtils.format(date,null) = null
     * </pre>
     * @param date 时间
     * @param parsePatterns 格式化字符串
     * @return String
     */
    public static String format(final Date date, final String parsePatterns) {
        if (StringUtils.isEmpty(parsePatterns) || date == null) {
            return null;
        }
        return getSimpleDateFormat(parsePatterns).format(date);
    }

    /**
     * 判断某个时间time2是否在另一个时间time1之前
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 时间time2是否在另一个时间time1之前;true:在时间上time2比time1晚
     */
    public static boolean beforeTime(final Date time1, final Date time2) {
        final Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);

        final Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);

        return calendar1.before(calendar2);
    }

    /**
     * @Title: getCurrentTimeAsNumber
     * @Description: 当前时间数字化输出yyyyMMddHHmmss
     * @return yyyyMMddHHmmss格式的当前时间
     */
    public static BigDecimal getCurrentTimeAsNumber() {
        String returnStr = null;
        final SimpleDateFormat f = new SimpleDateFormat(SECOND_NUMBER_FORMAT);
        returnStr = f.format(getNow());
        return new BigDecimal(returnStr);
    }
    /**
     * MethodName: getCurrentTimeSSSAsNumber(毫秒)
     * @Description: 当前时间数字化输出yyyyMMddHHmmssSSS
     * @return String  
     * @author yangsy
     * @version:0.1
     * @date 2015-10-28 上午9:14:49
     */
    public static String getCurrentTimeSSSAsNumber() {
        String returnStr = null;
        returnStr = new SimpleDateFormat(MILLI_SECOND_NUMBER_FORMAT) .format(new Date() );//当前时间到毫秒
        return returnStr;
    }

    /**
     * 简单转换日期类型到默认字符串格式 "yyyy-MM-dd HH:mm:ss"
     * @param date 日期
     * @return String 格式化好的日期字符串 "yyyy-MM-dd HH:mm:ss"
     */
    public static String format(final Date date) {
        return format(date, DEFAULT_PATTERN);
    }

    /**
     * 按指定格式将java.util.Date日期转换为字符串 例如:2009-10-01
     * @param date 要转换的时间
     * @return "yyyy-MM-dd"日期的字符串
     */
    public static String getDate(final java.util.Date date) {
        return getDateTime(DAY_FORMAT, date);
    }

    /**
     * 按指定格式将java.util.Date日期转换为字符串 例如:2009-01-01 15:02:01
     * @param date 要转换的时间
     * @return 例如:2009-01-01 15:02:01格式的时间字符串
     */
    public static String getDateTime(final java.util.Date date) {
        return getDateTime(SECOND_FORMAT, date);
    }

    /**
     * 按给定格式转换java.util.Date日期为字符串
     * @param pattern 指定日期格式
     * @param date 日期
     * @return 格式化后的时间
     */
    public static String getDateTime(final String pattern, final java.util.Date date) {
        if (date == null) {
            return "";
        }
        String formatPattern = pattern;
        if (pattern == null) {
            formatPattern = SECOND_FORMAT;
        }
        final SimpleDateFormat formatter = new SimpleDateFormat(formatPattern, Locale.getDefault());
        final String ret = formatter.format(date);
        return ret;
    }

    /**
     * 获取两个日期之间的天数
     * @param date1 开始时间
     * @param date2 结束时间
     * @return 两个日期之间的天数
     */
    public static int getDaysBetween(final Calendar date1, final Calendar date2) {
        Calendar startDate = date1;
        Calendar endDate = date2;
        if (startDate.after(endDate)) {
            final java.util.Calendar swap = startDate;
            startDate = endDate;
            endDate = swap;
        }
        int days = endDate.get(java.util.Calendar.DAY_OF_YEAR) - startDate.get(java.util.Calendar.DAY_OF_YEAR);
        final int y2 = endDate.get(java.util.Calendar.YEAR);
        if (startDate.get(java.util.Calendar.YEAR) != y2) {
            startDate = (java.util.Calendar) startDate.clone();
            do {
                days += startDate.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
                startDate.add(java.util.Calendar.YEAR, 1);
            } while (startDate.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 获取两个日期之间的天数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 间隔的天数
     */
    public static int getDaysBetween(final Date startDate, final Date endDate) {
        final Calendar cal1 = Calendar.getInstance();
        final Calendar cal2 = Calendar.getInstance();
        cal1.setTime(startDate);
        cal2.setTime(endDate);
        return getDaysBetween(cal1, cal2);
    }

    /**
     * 计算两个日期之间的假期天数（仅仅是正常休息日即周六周日）
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 中间的假期天数
     */
    public static int getHolidays(final Calendar startDate, final Calendar endDate) {
        return getDaysBetween(startDate, endDate) - getWorkingDay(startDate, endDate);
    }

    /**
     * 获得指定日期的下一个星期一的日期
     * @param date 日期
     * @return 下一个周一的日期
     */
    public static Calendar getNextMonday(final Calendar date) {
        Calendar result = date;
        do {
            result = (Calendar) result.clone();
            result.add(Calendar.DATE, 1);
        } while (result.get(Calendar.DAY_OF_WEEK) != 2);
        return result;
    }

    /**
     * @Title: getNowYearMonthDay
     * @Description: 获取当前纯数字的日期
     * @return yyyyMMdd格式的当前日期
     */
    public static int getNowYearMonthDay() {
        String returnStr = null;
        final SimpleDateFormat f = new SimpleDateFormat(DAY_NUMBER_FORMAT);
        returnStr = f.format(getNow());
        return Integer.parseInt(returnStr);
    }

    /**
     * 计算两个日期之间的工作天数
     * @param date1 开始日期
     * @param date2 结束日期
     * @return 两个日期之间的周一到周五天数
     */
    public static int getWorkingDay(final Calendar date1, final Calendar date2) {
        int result = -1;
        Calendar startDate = date1;
        Calendar endDate = date2;
        if (startDate.after(endDate)) {
            final java.util.Calendar swap = startDate;
            startDate = endDate;
            endDate = swap;
        }

        int chargeStartDate = 0;// 开始日期的日期偏移量
        int chargeEndDate = 0;// 结束日期的日期偏移量
        // 日期不在同一个日期内
        int stmp;
        int etmp;
        stmp = DAY_NUM_OF_WEEK - startDate.get(Calendar.DAY_OF_WEEK);
        etmp = DAY_NUM_OF_WEEK - endDate.get(Calendar.DAY_OF_WEEK);
        if (stmp != Calendar.SUNDAY - 1 && stmp != Calendar.SATURDAY - 1) {// 开始日期为星期六和星期日时偏移量为6和0
            chargeStartDate = stmp - 1;
        }
        if (stmp != Calendar.SUNDAY - 1 && stmp != Calendar.SATURDAY - 1) {// 结束日期为星期六和星期日时偏移量为6和0
            chargeEndDate = etmp - 1;
        }
        result = (getDaysBetween(getNextMonday(startDate), getNextMonday(endDate)) / DAY_NUM_OF_WEEK) * WORKING_DAY_OF_WEEK + chargeStartDate
            - chargeEndDate;
        return result;
    }

    /**
     * 计算两个日期之间的工作天数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 两个日期之间的工作日期
     */
    public static int getWorkingDay(final Date startDate, final Date endDate) {
        final Calendar cal1 = Calendar.getInstance();
        final Calendar cal2 = Calendar.getInstance();
        cal1.setTime(startDate);
        cal2.setTime(endDate);
        return getWorkingDay(cal1, cal2);
    }

    /**
     * @Title: getYearMonth
     * @Description: 获取年月yyyyMM格式数字
     * @param date 日期
     * @return 年月yyyyMM格式数字
     */
    public static int getYearMonth(final Date date) {
        final SimpleDateFormat formatter = new SimpleDateFormat(MONTH_NUMBER_FORMAT, Locale.getDefault());
        final String ret = formatter.format(date);
        return Integer.parseInt(ret);
    }

    /**
     * @Title: getYearMonthDay
     * @Description: 获取日期yyyyMMDD格式数字
     * @param date 日期
     * @return 日期yyyyMMDD格式数字
     */
    public static int getYearMonthDay(final Date date) {
        final SimpleDateFormat formatter = new SimpleDateFormat(DAY_NUMBER_FORMAT, Locale.getDefault());
        final String ret = formatter.format(date);
        return Integer.parseInt(ret);
    }

    /**
     * @Title: parseDate
     * @Description: 根据字符长度判断日期的格式化类型
     * @param dateStr 日期字符串
     * @return Date 日期
     */
    public static Date parse(final String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        String[] formats = null;
        if (RegexUtil.isNumeric(dateStr)) {// 全部是数字的情况
            formats = FORMATS_NUMERIC;
        } else if (dateStr.contains(Symbol.CROSS_BAR)) {
            if (dateStr.contains(Symbol.A_SPACE)) {
                formats = FORMATS_CROSS_BAR_SPACE;
            } else {
                formats = FORMATS_CROSS_BAR;
            }
        }
        // else if (dateStr.contains(Symbol.FORWARD_SLASH)) {
        // if (dateStr.contains(Symbol.A_SPACE)) {
        // formats = FORMATS_FORWARD_SPLASH_SPACE;
        // } else {
        // formats = FORMATS_FORWARD_SPLASH;
        // }
        // }
        // else if (dateStr.contains(Symbol.COLON)) {
        // formats = FORMATS_COLON;
        // }
        if (formats == null) {
            return null;
        } else {
            return parse(dateStr, formats);
        }
    }

    /**
     * @Title: parseDate
     * @Description: 根据格式列表，解析日期字符串
     * @param dateStr 日期字符串
     * @param formats 日期格式列表
     * @return 日期格式
     */
    public static Date parse(final String dateStr, final String[] formats) {
        SimpleDateFormat df = null;
        for (final String dateFormat : formats) {
            df = new SimpleDateFormat(dateFormat);
            try {
                return df.parse(dateStr);
            } catch (final ParseException e) {
                LOGGER.warn("Date {} does not match with the format {}", dateStr, dateFormat);
            }
        }
        return null;
    }

    /**
     * 求两个时间的毫秒值的差，第一个减去第二个为结果
     * @param date1 开始日期
     * @param date2 结束日期
     * @return 毫秒
     */
    public static long poor(final Date date1, final Date date2) {
        if (null == date1 || null == date2) {
            return 0;
        }
        final Calendar calendar1 = Calendar.getInstance();
        final Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        final long millisecond = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();
        return millisecond;
    }
    
    /**
     * 
     * MethodName: format
     * @Description: 将传入的String格式的日期按照formatStr格式转化为日期格式
     * @param date
     * @param formatStr 传入String的日期的格式
     * @return   
     * @return Date  
     * @author xup
     * @version:0.1
     * @date 2016-3-5 下午5:29:28
     */
    public static Date format(String date,String formatStr) {
		try {
			return DateUtil.parseDate(date,formatStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    /** 
     * 两个时间相差距离多少天多少小时多少分多少秒 
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return long[] 返回值为：{天, 时, 分, 秒} 
     */  
    public static long getDistanceTimes(String str1, String str2) {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date one;  
        Date two;  
//        long day = 0;  
//        long hour = 0;  
        long min = 0;  
//        long sec = 0;  
        try {  
            one = df.parse(str1);  
            two = df.parse(str2);  
            long time1 = one.getTime();  
            long time2 = two.getTime();  
            long diff ;  
            if(time1<time2) {  
                diff = time2 - time1;  
            } else {  
                diff = time1 - time2;  
            }  
//            day = diff / (24 * 60 * 60 * 1000);  
//            hour = (diff / (60 * 60 * 1000) - day * 24);  
//            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);  
//            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);  
            min = diff / (60*1000);
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        //long[] times = {day, hour, min, sec};  
        return min;  
    }  

}
