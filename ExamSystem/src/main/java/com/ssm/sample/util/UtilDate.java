package com.ssm.sample.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 时间辅助类 <br/>
 * 时间转换格式化的总体原则：format开头的为格式化，返回String；get开头的转化时间，返回Date
 * 
 * @author Administrator
 *
 */
public class UtilDate {
	public final static String strYear = "yyyy";
	public final static SimpleDateFormat sdfYear = new SimpleDateFormat(strYear);

	public final static String strMonth = "yyyyMM";
	public final static SimpleDateFormat sdfYearMonth = new SimpleDateFormat(strMonth);

	public final static String strDay = "yyyy-MM-dd";
	public final static SimpleDateFormat sdfDay = new SimpleDateFormat(strDay);

	public final static String strTime = "yyyy-MM-dd HH:mm:ss";
	public final static SimpleDateFormat sdfTime = new SimpleDateFormat(strTime);

	public final static String DEFAULT_STARTTIME = "1980-01-01 00:00:00";
	public final static String DEFAULT_ENDTIME = "2099-12-31 23:59:59";

	/**
	 * 按照参数format的格式，日期转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2String(Date date, SimpleDateFormat format) {
		if (date != null) {
			return format.format(date);
		} else {
			return "";
		}
	}

	/**
	 * 按照参数format的格式，日期转字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return date2String(date, sdf);
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date string2Date(String date, SimpleDateFormat format) {
		if (StringUtils.isNotBlank(date)) {
			try {
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		} else {
			return null;
		}
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date string2Date(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return string2Date(date, sdf);
	}

	/**
	 * 获取默认结束时间yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date getDefaultEndtime() {
		return string2Date(DEFAULT_ENDTIME, sdfTime);
	}

	/**
	 * 格式化当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String formatNow(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 格式化当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String formatNow(SimpleDateFormat format) {
		return format.format(new Date());
	}

	/**
	 * 获取当前时间YYYY格式
	 * 
	 * @return
	 */
	public static String formatNowYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取当前时间YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String formatNowDay() {
		return sdfDay.format(new Date());
	}

	/**
	 * 获取当前时间YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String formatNowTime() {
		return sdfTime.format(new Date());
	}

	/**
	 * 转化日期yyyy-MM-dd
	 * 
	 * @return
	 */
	public static Date getDateDay(String date) {
		try {
			return sdfDay.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 转化日期yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Date getDateTime(String date) {
		try {
			return sdfTime.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatDateTime(String date) {
		try {
			return sdfTime.format(sdfTime.parse(date));
		} catch (ParseException e) {
			return "";
		}
	}

	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatDateTime(Date date) {
		return sdfTime.format(date);
	}
	
	/**
	 * 格式化日期yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatDateDay(Date date) {
		return sdfDay.format(date);
	}

	/**
	 * 格式化日期 FOR ORACLE TIMESTAMP
	 * 
	 * @return
	 */
	public static String formatTimestamp(Object date, SimpleDateFormat format) {
		if (date instanceof Timestamp) {
			return format.format(formatDateTime(date.toString()));
		}
		return date == null ? "" : date.toString();
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		try {
			sdfDay.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	/**
	 * 把时间根据时、分、秒转换为时间段
	 * 
	 * @param StrDate
	 */
	public static String getTimes(String StrDate) {
		String resultTimes = "";
		java.util.Date now;
		try {
			now = new Date();
			java.util.Date date = sdfTime.parse(StrDate);
			long times = now.getTime() - date.getTime();
			long day = times / (24 * 60 * 60 * 1000);
			long hour = (times / (60 * 60 * 1000) - day * 24);
			long min = ((times / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long sec = (times / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

			StringBuffer sb = new StringBuffer();
			// sb.append("发表于：");
			if (hour > 0) {
				sb.append(hour + "小时前");
			} else if (min > 0) {
				sb.append(min + "分钟前");
			} else {
				sb.append(sec + "秒前");
			}
			resultTimes = sb.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return resultTimes;
	}

	/**
	 * @Title: compareDate
	 * @Description: (日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (getDateDay(s) == null || getDateDay(e) == null) {
			return false;
		}
		return getDateDay(s).getTime() >= getDateDay(e).getTime();
	}

	/**
	 * 得到相差年数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// long aa = 0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到某个日期的前一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeforeDayDate(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
			date = sdfd.parse(strDate);
			Calendar canlendar = Calendar.getInstance(); // java.util包
			canlendar.setTime(date);
			canlendar.add(Calendar.DATE, -1); // 向前减一天
			date = canlendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到某个日期的前几天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeforeNumDayDate(Date date, int num) {
		try {
			Calendar canlendar = Calendar.getInstance(); // java.util包
			canlendar.setTime(date);
			canlendar.add(Calendar.DATE, -num); // 向前减一天
			canlendar.set(Calendar.HOUR_OF_DAY, 23);
			canlendar.set(Calendar.MINUTE, 59);
			canlendar.set(Calendar.SECOND, 59);
			date = canlendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到某个日期的 前/后 几个月
	 * 
	 * @param date
	 * @return
	 */
	public static String addMonths(String strDate, int months) {
		Date date = null;
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdfd.parse(strDate);
			Calendar canlendar = Calendar.getInstance(); // java.util包
			canlendar.setTime(date);
			canlendar.add(Calendar.MONTH, months); // 向前减一天
			date = canlendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdfd.format(date);
	}

	/**
	 * 日期加减
	 * 
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public static String getDateAddDays(String dateStr, int days) throws ParseException {
		Calendar canlendar = Calendar.getInstance();
		Date date = sdfDay.parse(dateStr);
		canlendar.setTime(date);
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		date = canlendar.getTime();
		dateStr = sdfDay.format(date);
		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动		
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 时间比较， dateA>dateB 返回1 dateA<dateB 返回-1 dateA=dateB 返回0
	 * 
	 * @param date
	 * @return
	 */
	public static Integer dateCompare(String dateA, String dateB) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateA).compareTo(dateFormat.parse(dateB));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取某月的最后一天 @Title:getLastDayOfMonth @Description: @param:@param
	 * year @param:@param month @param:@return @return:String @throws
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	/**
	 * 获取当月的最后一天 @Title:getLastDayOfMonth @Description: @param:@param
	 * year @param:@param month @param:@return @return:String @throws
	 */
	public static String getLastDayOfCurrentMonth() {

		Calendar cal = Calendar.getInstance();

		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	/**
	 * 获取上个月的最后一天的最后一秒
	 */
	public static String getFirstTimeOfLastMonth() {

		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, -1);
		cale.set(Calendar.DAY_OF_MONTH, 1);

		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(strTime);
		String lastTimeOfLastMonth = sdf.format(cale.getTime());
		return lastTimeOfLastMonth;
	}

	/**
	 * 获取上个月的最后一天的最后一秒
	 */
	public static String getLastTimeOfLastMonth() {

		Calendar cale = Calendar.getInstance();
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(strTime);
		String firstTimeOfLastMonth = sdf.format(cale.getTime());
		return firstTimeOfLastMonth;
	}

	/**
	 * 获取今天的最后一秒
	 */
	public static String getLastTimeOfToday() {

		Calendar cale = Calendar.getInstance();
		cale = Calendar.getInstance();
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat(strTime);
		String getLastTimeOfToday = sdf.format(cale.getTime());
		return getLastTimeOfToday;
	}

	/**
	 * 获取今天的最后一秒
	 */
	public static Date getLastTimeOfToday(Date date) {

		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.set(Calendar.HOUR_OF_DAY, 23);
		cale.set(Calendar.MINUTE, 59);
		cale.set(Calendar.SECOND, 59);
		return cale.getTime();
	}

	/**
	 * 获取今天的最后一秒
	 */
	public static Date getFirstTimeOfToday(Date date) {

		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		return cale.getTime();
	}

	/**
	 * 判断日期是否在当月
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean isInCurrentMonth(String strDate) throws ParseException {

		String currentMonth = sdfYearMonth.format(new Date());
		String datDate = sdfYearMonth.format(sdfDay.parse(strDate));

		return currentMonth.equals(datDate);
	}
	
	/**
	 * 格式化日期（String转换成Date）
	 * @param args
	 * @throws ParseException
	 */
	public static Date stringToDate(String date) {
		int length = date.length();
		Date date2;
		if (length > 11) {
			date2 = getDateTime(date);
		}else {
			date2 = getDateDay(date);
		}
		return date2;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(sdfDay.parse("2017-06-18 15:01:18.0"));
		// System.out.println(getAfterDayWeek("3"));

		// String lastDayOfCurMonthTX =
		// UtilDate.getDateAddDays(getLastDayOfCurrentMonth(), -3);
		//
		// System.out.println(lastDayOfCurMonthTX);
		//
		// System.out.println(isInCurrentMonth("2016-07-02"));
		//
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
		// HH:mm:ss");
		// String firstday, lastday;
		// Calendar cale = Calendar.getInstance();
		// cale.add(Calendar.MONTH, -1);
		// cale.set(Calendar.DAY_OF_MONTH, 1);
		//
		// cale.set(Calendar.HOUR, -12);
		// cale.set(Calendar.MINUTE, 0);
		// cale.set(Calendar.SECOND, 0);
		// firstday = format.format(cale.getTime());
		// // 获取前月的最后一天
		// cale = Calendar.getInstance();
		// cale.add(Calendar.MONTH, 0);
		// cale.set(Calendar.DAY_OF_MONTH, 0);
		// cale.set(Calendar.HOUR, 11);
		// cale.set(Calendar.MINUTE, 59);
		// cale.set(Calendar.SECOND, 59);
		// lastday = format.format(cale.getTime());
		// System.out.println(firstday + "###########" + lastday);

	}

}
