package com.piltover.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 时间日期工具类
 * 
 * @author maozili
 * 
 **/
public class DateUtils {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	/** 一小时对应的毫秒数 **/
	public static final long ONE_HOUR_MILL_SECONDS = 3600 * 1000;
	/** 一天对应的毫秒数 **/
	public static final long ONE_DAY_MILL_SECONDS = 24 * 3600 * 1000;
	/** 本地线程集合 **/
	private static Map<String, DateFormat> threadLocal = new HashMap<String, DateFormat>();
	
	public static String HOUR_OF_DAY = "00,01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23";

	/**
	 * 时间格式(yyyy-MM-dd)
	 */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/**
	 * 无分隔符日期格式 "yyyyMMddHHmmssSSS"
	 */
	public static String DATE_TIME_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";
	/**
	 * 时间格式(yyyy-MM-dd HH:mm:ss)
	 */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 时间格式(MM-dd)
	 */
	public final static String DATE_PATTERN_MMDD = "MM-dd";
	/**
	 * 时间格式(yyyyMMdd)
	 */
	public final static String DATE_PATTERN_YYYYMMDD= "yyyyMMdd";

	// 日期转换格式数组
	public static String[][] regularExp = new String[][] {

			// 默认格式
			{ "\\d{4}-((([0][1,3-9]|[1][0-2]|[1-9])-([0-2]\\d|[3][0,1]|[1-9]))|((02|2)-(([1-9])|[0-2]\\d)))\\s+([0,1]\\d|[2][0-3]|\\d):([0-5]\\d|\\d):([0-5]\\d|\\d)",
					DATE_TIME_PATTERN },
			// 仅日期格式 年月日
			{ "\\d{4}-((([0][1,3-9]|[1][0-2]|[1-9])-([0-2]\\d|[3][0,1]|[1-9]))|((02|2)-(([1-9])|[0-2]\\d)))",
					DATE_PATTERN },
			// 带毫秒格式
			{ "\\d{4}((([0][1,3-9]|[1][0-2]|[1-9])([0-2]\\d|[3][0,1]|[1-9]))|((02|2)(([1-9])|[0-2]\\d)))([0,1]\\d|[2][0-3])([0-5]\\d|\\d)([0-5]\\d|\\d)\\d{1,3}",
					DATE_TIME_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS } };

	/** 获取日期格式 **/
	public static synchronized DateFormat getDateTimeFormat(String formart) {
		DateFormat dateFormat = threadLocal.get(formart);
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat(formart);
			threadLocal.put(formart, dateFormat);
		}
		return dateFormat;
	}

	/** 获取当前日期时间(yyyyMMddHHmmss) **/
	public static String getCurrDateTime() {
		return getDateTimeFormat("yyyyMMddHHmmss").format(new Date());
	}

	/** 获取当前日期时间(yyyy-MM-dd HH:mm:sss) **/
	public static String getCurrDateTime2() {
		return getDateTimeFormat("yyyy-MM-dd HH:mm:sss").format(new Date());
	}

	/** 获取当前日期时间(yyyy年MM月dd日 HH时mm分ss秒SSS毫秒) **/
	public static String getCurrDateTime3() {
		return getDateTimeFormat("yyyy年MM月dd日  HH时mm分ss秒SSS毫秒").format(new Date());
	}

	/** 获取当前日期时间(yyyy-MM-dd HH:mm:ss) **/
	public static String getCurrDateTime4() {
		return getDateTimeFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/** 获取当前日期时间(yyyy/MM/dd HH:mm:ss) **/
	public static String getCurrDateTime5() {
		return getDateTimeFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
	}

	/** 获取当前日期时间(yyyyMMdd HHmmss) **/
	public static String getCurrDateTime6() {
		return getDateTimeFormat("yyyyMMdd HHmmss").format(new Date());
	}

	/** 获取当前日期时间(yyyy年MM月dd日 HH时mm分ss秒) **/
	public static String getCurrDateTime7() {
		return getDateTimeFormat("yyyy年MM月dd日  HH时mm分ss秒").format(new Date());
	}

	/** 获取当前日期时间(MMddHHmmss) **/
	public static String getCurrDateTime8() {
		return getDateTimeFormat("MMddHHmmss").format(new Date());
	}

	/** 获取当前日期时间(yyyy/MM/dd HH:mm:sss) **/
	public static String getCurrDateTime9() {
		return getDateTimeFormat("yyyy/MM/dd HH:mm:sss").format(new Date());
	}

	/** 获取当前日期(yyyyMMdd) **/
	public static String getCurrDate() {
		return getDateTimeFormat("yyyyMMdd").format(new Date());
	}

	/** 获取当前日期(yyyy年MM月dd) **/
	public static String getCurrDate2() {
		return getDateTimeFormat("yyyy年MM月dd").format(new Date());
	}

	/** 获取当前日期(yyyy-MM-dd) **/
	public static String getCurrDate3() {
		return getDateTimeFormat("yyyy-MM-dd").format(new Date());
	}

	/** 获取当前日期(MMdd) **/
	public static String getCurrDate4() {
		return getDateTimeFormat("MMdd").format(new Date());
	}

	/** 获取当前时间(HHmmss) **/
	public static String getCurrTime() {
		return getDateTimeFormat("HHmmss").format(new Date());
	}

	/** 获取当前时间(HH:mm:ss) **/
	public static String getCurrTime2() {
		return getDateTimeFormat("HH:mm:ss").format(new Date());
	}

	/** 获取当前时间(ss) **/
	public static String getCurrTime3() {
		return getDateTimeFormat("ss").format(new Date());
	}

	/** 解析当前日期时间(yyyy-MM-dd HH:mm:ss) **/
	public static Date parseCurrDate() throws ParseException {
		DateFormat dtf = getDateTimeFormat("yyyy-MM-dd HH:mm:ss");
		return dtf.parse(dtf.format(new Date()));
	}

	/** 解析日期时间(yyyyMMddHHmmss) **/
	public static Date parse(String dateTime) throws ParseException {
		return getDateTimeFormat("yyyyMMddHHmmss").parse(dateTime);
	}

	/** 解析日期时间(yyyy-MM-dd HH:mm:ss) **/
	public static Date parse2(String dateTime) throws ParseException {
		return getDateTimeFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
	}

	/**
	 * 字符串转化为日期
	 * 
	 * @param pattern 日期格式
	 * @param date    日期字符串
	 * @return Date
	 * 
	 **/
	public static Date parse2(String pattern, String date) throws ParseException {
		return getDateTimeFormat(pattern).parse(date);
	}

	/**
	 * 格式化日期时间
	 * 
	 * @param date    日期
	 * @param pattern 日期格式
	 * 
	 **/
	public static String format(String pattern, Date date) {
		return getDateTimeFormat(pattern).format(date);
	}

	/**
	 * 获取前几天的日期YYYYMMDD
	 * 
	 * @param days 若days为正数，则返回days天前的日期 若days为负数，则返回days天后的日期
	 * @return String
	 * 
	 **/
	public static String getXDaysAgo(int days) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, -days);
		return getDateTimeFormat("yyyyMMddHHmmss").format(ca.getTime()).substring(0, 8);
	}

	/** 获取昨天的日期YYYYMMDD **/
	public static String getYesterday() {
		return getXDaysAgo(1);
	}

	/** 获取前天的日期YYYYMMDD **/
	public static String getTheDayBeforeYesterday() {
		return getXDaysAgo(2);
	}

	/**
	 * 日期格式化
	 * 
	 * @param date 日期
	 * @return 格式：yyyy-MM-dd
	 */
	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	/**
	 * 日期格式化
	 * 
	 * @param date    日期
	 * @param pattern 自定义格式，例如：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss等等
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	public static String timeToStr(Long time, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		if (time.toString().length() < 13) {
			time = time * 1000L;
		}
		Date date = new Date(time);
		String value = dateFormat.format(date);
		return value;
	}

	public static long strToTime(String timeStr) {
		Date time = strToDate(timeStr);
		return time.getTime() / 1000;
	}

	/**
	 * 转换为时间类型格式
	 *
	 * @param strDate 日期
	 * @return
	 */
	public static Date strToDate(String strDate) {
		try {
			String strType = getDateFormat(strDate);
			SimpleDateFormat sf = new SimpleDateFormat(strType);
			return new Date((sf.parse(strDate).getTime()));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据传入的日期格式字符串，获取日期的格式
	 *
	 * @return 秒
	 */
	public static String getDateFormat(String date_str) {
		String style = null;
		if (StringUtils.isEmpty(date_str)) {
			return null;
		}
		boolean b = false;
		for (int i = 0; i < regularExp.length; i++) {
			b = date_str.matches(regularExp[i][0]);
			if (b) {
				style = regularExp[i][1];
			}
		}
		if (StringUtils.isEmpty(style)) {
			logger.info("date_str:" + date_str);
			logger.info("日期格式获取出错，未识别的日期格式");
		}
		return style;
	}

	/**
	 * 将字符串类型的转换成Date类型
	 *
	 * @param dateStr 字符串类型的日期 yyyy-MM-dd
	 * @return Date类型的日期
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String dateStr) {
		// 返回的日期
		Date resultDate = null;
		try {
			// 日期格式转换
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			resultDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
	 * 字符串特定日期之后几天日期的获取方法
	 * 
	 * @param specifiedDay
	 * @param afterDays
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int afterDays) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + afterDays);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	public static int daysOfTwoDate(String startDate, String endDate) {
		int cnt = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date firstdate = format.parse(startDate);
			Date seconddate = format.parse(endDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(firstdate);
			while (calendar.getTime().compareTo(seconddate) != 0) {
				calendar.add(Calendar.DATE, 1);
				cnt++;
			}
		} catch (Exception e) {
			cnt = -1;
			System.out.println(e);
		}
		return cnt;
	}

	public static int monthsOfTwoDate(String startDate, String endDate) {
		int cnt = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar bef = Calendar.getInstance();
			Calendar aft = Calendar.getInstance();
			bef.setTime(sdf.parse(endDate));
			aft.setTime(sdf.parse(startDate));
			int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
			int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
			int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
			surplus = surplus <= 0 ? 1 : 0;
			cnt = Math.abs(month + result) + surplus;
		} catch (Exception e) {
			cnt = -1;
			e.getStackTrace();
		}
		return cnt;
	}

	/**
	 * 判断是否为同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			return isSameDay(cal1, cal2);
		} else {
			throw new IllegalArgumentException("The date must not be null");
		}
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if (cal1 != null && cal2 != null) {
			return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
		} else {
			throw new IllegalArgumentException("The date must not be null");
		}
	}

	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean isAlong(Date nowTime, Date beginTime, Date endTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		if (date.after(begin) && date.before(end)) {
			return true;
		} else if (nowTime.compareTo(beginTime) == 0 || nowTime.compareTo(endTime) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 计算两个日期相隔天数（差）
	 * 
	 * @param startDate 开始日期（yyyy-MM-dd）
	 * @param endDate   结束日期（yyyy-MM-dd）
	 * @return 天数 = （结束日期 - 开始日期 ）+1
	 */
	public static int dateDiff(String startDate, String endDate) {
		try {
			return dateDiff(parse2(startDate), parse2(endDate));
		} catch (ParseException e) {
			logger.error("计算两个日期相隔天数出错:[" + e + "]");
		}
		return -1;
	}

	/**
	 * 计算两个日期相隔天数（差）
	 * 
	 * @param startDate 开始日期（yyyy-MM-dd）
	 * @param endDate   结束日期（yyyy-MM-dd）
	 * @return 天数 = （结束日期 - 开始日期 ）+1
	 */
	public static int dateDiff(Date startDate, Date endDate) {
		return (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
	}

	/**
	 * 指定日期往后加指定天数
	 * 
	 * @param date 日期（yyyy-MM-dd）
	 * @param day  往后加的天数
	 * @return 日期（yyyy-MM-dd）
	 */
	public static Date plus(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * 指定日期往前减指定天数
	 * 
	 * @param date 日期（yyyy-MM-dd）
	 * @param day  往前减的天数
	 * @return 日期（yyyy-MM-dd）
	 */
	public static Date minus(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -day);
		return c.getTime();
	}

	/**
	 * 按天取指定日期个数
	 * 
	 **/
	public static List<Date> getDayDates(Date startDate, int number) {
		List<Date> dateList = new ArrayList<Date>();
		for (int i = 0; i < number; i++) {
			Date pastDate = DateUtils.minus(startDate, i);
			dateList.add(pastDate);
		}
		return dateList;
	}

	/**
	 * 按周取指定日期个数
	 * 
	 **/
	public static List<Date> getWeekDates(Date startDate, int number) {
		List<Date> dateList = new ArrayList<Date>();
		for (int i = 0; i < number; i++) {
			Date pastDate = DateUtils.minus(startDate, i * 7);
			dateList.add(pastDate);
		}
		return dateList;
	}

	/**
	 * 按月取指定日期个数
	 * 
	 **/
	public static List<Date> getMonthDates(Date startDate, int number) {
		List<Date> dateList = new ArrayList<Date>();
		for (int i = 0; i < number; i++) {
			Date pastDate = DateUtils.minus(startDate, i * 30);
			dateList.add(pastDate);
		}
		return dateList;
	}

	/**
	 * 获取某段时间内的周一（二等等）的日期
	 * 
	 * @param dataBegin 开始日期
	 * @param dataEnd   结束日期
	 * @param weekDays  获取周几，1－6代表周一到周六。0代表周日
	 * @return 返回日期List
	 */
	public static List<String> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> dateResult = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		String[] dateInterval = { dataBegin, dataEnd };
		Date[] dates = new Date[dateInterval.length];
		for (int i = 0; i < dateInterval.length; i++) {
			String[] ymd = dateInterval[i].split("[^\\d]+");
			cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
			dates[i] = cal.getTime();
		}
		for (Date date = dates[0]; date.compareTo(dates[1]) <= 0;) {
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			date = cal.getTime();
			if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
				String format = sdf.format(date);
				dateResult.add(format);
			}
		}
		return dateResult;
	}

	/**
	 * 获取指定日期当月的第一天
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstDayOfGivenMonth(String dateStr, SimpleDateFormat sdf) throws ParseException {
		Date date = sdf.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 获取指定日期所有日期字符串
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static List<String> findDates(String dStart, String dEnd) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cStart = Calendar.getInstance();
		cStart.setTime(sdf.parse(dStart));
		List<String> dateList = new ArrayList<String>();
		dateList.add(dStart);
		while (sdf.parse(dEnd).after(cStart.getTime())) {
			cStart.add(Calendar.DAY_OF_MONTH, 1);
			dateList.add(sdf.format(cStart.getTime()));
		}
		return dateList;
	}


	//获取上周一日期
	public static Date geLastWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, -7);
		return cal.getTime();
	}

	//获取本周一日期
	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}

	//获取下周一日期
	public static Date getNextWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, 7);
		return cal.getTime();
	}

	public static List<String> convertWeekByDate(Date time) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
		if(1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}

		List<String>  dateList= new ArrayList<>();
		//System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期
		cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给传入日期减去星期几与一个星期第一天的差值
		String Monday = sdf.format(cal.getTime());
		dateList.add(Monday);
		//System.out.println("所在周星期一的日期："+Monday);
		cal.add(Calendar.DATE, 1);
		String Tuesday = sdf.format(cal.getTime());
		dateList.add(Tuesday);
		//System.out.println("所在周星期二的日期："+Tuesday);
		cal.add(Calendar.DATE, 1);
		String Wednesday = sdf.format(cal.getTime());
		dateList.add(Wednesday);
		//System.out.println("所在周星期三的日期："+Wednesday);
		cal.add(Calendar.DATE, 1);
		String Thursday = sdf.format(cal.getTime());
		dateList.add(Thursday);
		//System.out.println("所在周星期四的日期："+Thursday);
		cal.add(Calendar.DATE, 1);
		String Friday = sdf.format(cal.getTime());
		dateList.add(Friday);
		//System.out.println("所在周星期五的日期："+Friday);
		cal.add(Calendar.DATE, 1);
		String Saturday = sdf.format(cal.getTime());
		dateList.add(Saturday);
		//System.out.println("所在周星期六的日期："+Saturday);
		cal.add(Calendar.DATE, 1);
		String Sunday = sdf.format(cal.getTime());
		dateList.add(Sunday);
		//System.out.println("所在周星期日的日期："+Sunday);
		return dateList ;
	}
	
	
	/**
     * 获取指定日期所在的周的起始时间
     *  周日为第一天. 取时间的时候有问题,故时间需要向前平移一天
     * @param date
     * @return
     */
    public static Date getWeekStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }
    
    /**
     * 获取指定日期所在周的结束时间
     *
     * @param date
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getWeekStartDate(date));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        return cal.getTime();
    }
    
   //获取当天的开始时间
    public static java.util.Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    /**
	 * 获取上周周日日期
	 */
	public static Date getLastWeekSundayForRedPacket() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		if(date.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
			return date.getTime();
		}
		date.setFirstDayOfWeek(Calendar.MONDAY);
		date.add(Calendar.WEEK_OF_MONTH, -1);
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//设置周日
		return date.getTime();
	}


	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date beginWeek=getBeginDayOfWeek();
			Date getEndDayOfWeek=getEndDayOfWeek();
			Date getBeginDayOfMonth=getBeginDayOfMonth();
			Date getBeginDayOfLastMonth=getEndDayOfMonth();
			System.out.println("本周的开始时间"+sdf.format(beginWeek));
			System.out.println("本周的结束时间"+sdf.format(getEndDayOfWeek));
			System.out.println(sdf.format(geLastWeekMonday(new Date())));
			System.out.println("本月的开始时间"+sdf.format(getBeginDayOfMonth));
			System.out.println("本月的结束时间"+sdf.format(getBeginDayOfLastMonth));
			System.out.println("本周"+findDates(sdf.format(beginWeek),sdf.format(getEndDayOfWeek)).toString());
			System.out.println("本月"+findDates(sdf.format(getBeginDayOfMonth),sdf.format(getBeginDayOfLastMonth)).toString());
			System.out.println(JSON.toJSONString(getLastWeekDateList()));
			System.out.println("上周一"+sdf.format(getLastWeekMonday()));
			System.out.println("上周日"+sdf.format(getLastWeekSunday()));
			System.out.println("上月一"+sdf.format(getBeginDayOfLastMonth()));
			System.out.println("上月日"+sdf.format(getEndDayOfLastMonth()));
			System.out.println("昨日开始"+sdf.format(getBeginDayOfYesterday()));
			System.out.println("昨日结束"+sdf.format(getEndDayOfYesterDay()));
			
			System.out.println("获取上周和上上周日期Map"+ getLastWeekDate(minus(parseDate("2019-12-22", DATE_PATTERN), 1), 6));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(getYesterdayDate());
	}
	
	 //获取今年是哪一年
    public static Integer getNowYear() {
            Date date = new Date();
           GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
           gc.setTime(date);
           return Integer.valueOf(gc.get(1));
       }
    //获取本月是哪一月
    public static int getNowMonth() {
            Date date = new Date();
           GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
           gc.setTime(date);
           return gc.get(2) + 1;
       }
    
    /**
     * 获取时间 -1 就是前一天 1就是后一天
     *
     * @param dayNumber
     * @return 时间差
     */
    public static Date getBeginDate(int dayNumber) {
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, dayNumber);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
    
    /**
	 * 获取昨日的日期
	 */
	public static Date getYesterdayDate() {
		Calendar yesterday = Calendar.getInstance();
		yesterday.set(Calendar.HOUR_OF_DAY, 0);
		yesterday.set(Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);
		yesterday.set(Calendar.MILLISECOND, 0);
		yesterday.add(Calendar.DAY_OF_YEAR, -1);
		return yesterday.getTime();
	}
	
	 /**
	  * 根据传入的时间来获取前一天的时间
	  */
	 public static String getYesterdayDate(String time) {
		    Calendar yesterday = Calendar.getInstance();
			try  {
				yesterday.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
				yesterday.set(Calendar.HOUR_OF_DAY, 0);
				yesterday.set(Calendar.MINUTE, 0);
				yesterday.set(Calendar.SECOND, 0);
				yesterday.set(Calendar.MILLISECOND, 0);
				yesterday.add(Calendar.DAY_OF_YEAR, -1);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return new SimpleDateFormat("yyyy-MM-dd").format(yesterday.getTime());
		}
		
	 /**
	 * 获取本周的周一
	 */
	public static String getMonday(String date) {
		if (date == null || date.equals("")) {
			System.out.println("date is null or empty");
			return "0000-00-00 00:00:00";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try  {
			d = format.parse(date);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		//set the first day of the week is Monday
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
		return format.format(cal.getTime())+ " 00:00:00";
	}

	/**
	 * 获取上周周一日期
	 */
	public static Date getLastWeekMonday() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);
		date.add(Calendar.WEEK_OF_MONTH, -1);
		date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//设置周一
		return date.getTime();
	}
	
	/**
	 * 获取上周周日日期
	 */
	public static Date getLastWeekSunday() {
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);
		date.add(Calendar.WEEK_OF_MONTH, -1);
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//设置周日
		return date.getTime();
	}
	
	
	/**
     * 将日期转换为指定格式
     *
     * @param format 日期格式
     * @param date   日期
     * @return String
     */
    public static String parseDateStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }
    
    /**
     * 获取当天日历,当天开始时间
     *
     * @return
     */
    public static Calendar getCurrentCalendarBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }
    
    /**
     * 获取当天日历,当天结束时间
     *
     * @return
     */
    public static Calendar getCurrentCalendarEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal;
    }
    
    /**
     * 日期型字符串转化为日期 格式 不确定日期格式
     *
     * @param str
     * @return
     * @throws Exception 
     */
    public static Date parseDate(Object str, String format) throws Exception {
        if (str == null) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str.toString(), format);
        } catch (Exception e) {
            throw new Exception("解析时间异常,参数:" + JSON.toJSONString(str) + "格式:" + format);
        }
    }
    
  //获取昨天的开始时间
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    
    //获取昨天的结束时间
    public static Date getEndDayOfYesterDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
    
  //获取当天的结束时间
    public static java.util.Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }
    
  //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
 		return DateUtils.getWeekStartDate(new Date());
     }
    
     //获取本周的结束时间
     public static Date getEndDayOfWeek(){
 		return DateUtils.getWeekEndDate(new Date());
     }
     
     /**
 	 * 获得当前日期为每周的第几天,周一为第一天
 	 * @param pattern
 	 * @param dateTime
 	 * @return
 	 */
 	public static int getDayOfWeek(Date date) {
 		Calendar calendar = Calendar.getInstance();
 		calendar.setTime(date);
 		int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
 		if (weekOfDay == 0) {
 			weekOfDay = 7;
 		}
 		return weekOfDay;
 	}
 	
 	//获取本周一的日期
    public static int getThisWeekMondayAndInteger() {
    	Calendar cal = Calendar.getInstance(Locale.CHINA);
    	cal.setTime(getDayBegin());
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		Date thismondayDate =  cal.getTime();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		String res = simpleDateFormat.format(thismondayDate);

		Integer thismonday = Integer.parseInt(res);

		return thismonday;
	}
    
    /**
	 * 获得当天剩余的秒数
	 */
	public static long surplusTodaySencods() {
		Calendar calendar = Calendar.getInstance();
		long now = calendar.getTimeInMillis();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		long tomorrow = calendar.getTimeInMillis();
		return (tomorrow - now) / 1000;
	}
	
	//获取昨天的日期并转化为整形
    public static int getYesterdayDateAndToInteger() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date preDay = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String res = simpleDateFormat.format(preDay);
		Integer yesterday = Integer.parseInt(res);
        return yesterday;
    }
    
    //获取今天的日期并转化为整形
    public static int getTodayDateAndToInteger() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        Date todayDay = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String res = simpleDateFormat.format(todayDay);
		Integer today = Integer.parseInt(res);
        return today;
    }
    
  //上周一的日期并转为整数
    public static int getLastMondayDateAndToInteger() {
    	Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);
		date.add(Calendar.WEEK_OF_MONTH, -1);
		date.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//设置周一

        Date preDay = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		String res = simpleDateFormat.format(preDay);

		Integer lastMonday = Integer.parseInt(res);

        return lastMonday;
    }
    
  //上周日的日期并转为整数
    public static int getLastSundayDateAndToInteger() {
    	Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(Calendar.MONDAY);
		date.add(Calendar.WEEK_OF_MONTH, -1);
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//设置周一

        Date preDay = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		String res = simpleDateFormat.format(preDay);

		Integer lastMonday = Integer.parseInt(res);

        return lastMonday;
    }
    
    /**
     * 时间格式
     */
    public interface DateFormatI {

        String YYYY = "yyyy";

        String YYYY_MM = "yyyy-MM";

        String HH_MM = "HH:mm";

        String HH = "HH";

        String YYYY_MM_DD = "yyyy-MM-dd";

        String MM_DD = "MM-dd";

        String YYYYMMDD = "yyyyMMdd";

        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

        String YYYY_MM_DD_00_00_00 = "yyyy-MM-dd 00:00:00";

        String YYYY_MM_DD_23_59_59 = "yyyy-MM-dd 23:59:59";
    }
    
    public static Date addMonths(final Date date, final int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addDays(final Date date, final int amount) {
		return add(date, Calendar.DAY_OF_YEAR, amount);
	}

	public static Date addHours(final Date date, final int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	public static Date addMinutes(final Date date, final int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	public static Date addSeconds(final Date date, final int amount) {
		return add(date, Calendar.SECOND, amount);
	}
	
	private static Date add(final Date date, final int calendarField, final int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		final Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

    /**
     * 获取当前日期 date类型
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }
    
    /**
	 * 根据参数返回特定格式时间Map 
	 * @param number 1:今天 ,2:昨天,3:本周,4:上周,5:本月
	 * @return 
	 */
	public static Map<String,Object> getYYYYMMDDdateMap(int number){
		Map<String,Object> map = new HashMap<>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			if(1 == number) {
				//开始结束均为今天
				map.put("beginDate", sdfBegin.format(cal.getTime()));
				map.put("endDate", sdfEnd.format(cal.getTime()));
			}else if(2 == number) {
				//开始结束均为昨天
				cal.add(Calendar.DATE,-1);
				map.put("beginDate", sdfBegin.format(cal.getTime()));
				map.put("endDate", sdfEnd.format(cal.getTime()));
			}else if(3 == number) {
				//开始时间为周一,结束时间为今天
				map.put("beginDate", getYYYYMMDDdate(0));
				map.put("endDate", sdfEnd.format(cal.getTime()));
			}else if(4 == number) {
				//开始时间为上周一,结束时间为本周一0点
				map.put("beginDate", getYYYYMMDDdate(-7));
				map.put("endDate", getYYYYMMDDdate(0));
			}else if(5 == number) {
				//开始时间为本月1号,结束时间为今天
				map.put("endDate", sdfEnd.format(cal.getTime()));
				cal.add(Calendar.MONTH, 0);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				map.put("beginDate", sdfBegin.format(cal.getTime()));
			}
		} catch (Exception e) {
			//开始结束均为今天
			map.put("beginDate", sdfBegin.format(new Date()));
			map.put("endDate", sdfEnd.format(new Date()));
		}
		return map;
	}
	
	/**
	 * 获取单个日期
	 * @param number 0 本周一 ,-1 上周日,-7 上周一
	 * @return
	 * @throws Exception
	 */
	private static String getYYYYMMDDdate(int number)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		cal.setTime(cal.getTime());
		cal.add(Calendar.DATE, number);
		return sdf.format(cal.getTime());
	}
	
	// 获取本月的开始时间
	public static Date getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}
 
	// 获取本月的结束时间
	public static Date getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}
	
	// 获取某个日期的开始时间
		public static Timestamp getDayStartTime(Date d) {
			Calendar calendar = Calendar.getInstance();
			if (null != d)
				calendar.setTime(d);
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			return new Timestamp(calendar.getTimeInMillis());
		}
   
		
		// 获取某个日期的结束时间
		public static Timestamp getDayEndTime(Date d) {
			Calendar calendar = Calendar.getInstance();
			if (null != d)
				calendar.setTime(d);
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
					calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
			calendar.set(Calendar.MILLISECOND, 999);
			return new Timestamp(calendar.getTimeInMillis());
		}
		
		// 获取上周的开始时间
		@SuppressWarnings("unused")
		public static Date getBeginDayOfLastWeek() {
			Date date = new Date();
			if (date == null) {
				return null;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
			if (dayofweek == 1) {
				dayofweek += 7;
			}
			cal.add(Calendar.DATE, 2 - dayofweek - 7);
			return getDayStartTime(cal.getTime());
		}
	 
		// 获取上周的结束时间
		public static Date getEndDayOfLastWeek() {
			Calendar cal = Calendar.getInstance();
			cal.setTime(getBeginDayOfLastWeek());
			cal.add(Calendar.DAY_OF_WEEK, 6);
			Date weekEndSta = cal.getTime();
			return getDayEndTime(weekEndSta);
		}
		
		// 获取上月的开始时间
		public static Date getBeginDayOfLastMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 2, 1);
			return getDayStartTime(calendar.getTime());
		}
	 
		// 获取上月的结束时间
		public static Date getEndDayOfLastMonth() {
			Calendar calendar = Calendar.getInstance();
			calendar.set(getNowYear(), getNowMonth() - 2, 1);
			int day = calendar.getActualMaximum(5);
			calendar.set(getNowYear(), getNowMonth() - 2, day);
			return getDayEndTime(calendar.getTime());
		}


		/**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(String  date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	/**
	 * 获取最近一周开始日期列表
	 * @return
	 * @throws ParseException 
	 */
	public static List<String> getLastWeekDateList() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -6);
        return findDates(sdf.format(cal.getTime()),sdf.format(new Date()));
    }
	
	/**
	 * 获取时分数组  [HH:mm]
	 * @return
	 */
	public static String [] getDateArray(){
		String[] dataArray=new String[1440];
		int k=0;
		for (int i = 0; i < 24; i++) {
			String min="";
			if(i<10){
				min="0"+i;
			}else{
				min=i+"";
			}
			for (int j = 0; j < 60; j++) {
				String secod="";
				if(j<10){
					secod="0"+j;
				}else{
					secod=j+"";
				}
				dataArray[k]=min+":"+secod;
				k++;
			}
		}
		return dataArray;
	}
	
	//获取间隔之前的日期
		public static Date geLast30Day(Date date,int interval) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, -interval);
			return cal.getTime();
		}
		
		/**
		 * 获取上周和上上周起始时间
		 * @param date
		 * @param interval
		 * @return
		 * @throws Exception 
		 */
		public static Map<String, String> getLastWeekDate(Date date,int interval) throws Exception {
			Map<String, String> dateMap = new HashMap<>();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			dateMap.put("lastEndDate", format(date));
			cal.add(Calendar.DATE, -interval);
			dateMap.put("lastStartDate", format(cal.getTime()));
			cal.setTime(minus(parse2(DATE_PATTERN, dateMap.get("lastStartDate")), 1));
			dateMap.put("lastLastEndDate", format(cal.getTime()));
			cal.add(Calendar.DATE, -interval);
			dateMap.put("lastLastStartDate", format(cal.getTime()));
			return dateMap;
		}
}
