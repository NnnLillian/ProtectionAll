package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeUtils {
	private static TimeUtils tu = null;

	private TimeUtils() {
	}

	public static TimeUtils getInstance() {
		if (tu == null) {
			tu = new TimeUtils();
		}
		return tu;
	}

	/**
	 * 字符串转Date
	 * 
	 * @param str
	 *            时间字符串，如"2017-08-07 12:00:00"
	 * @param pattern
	 *            时间字符串的格式，与str匹配，如"yyyy-MM-dd HH-mm-ss"
	 * @return Date 时间对象
	 */
	public static Date string2date(String str, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (null == pattern || "".equals(pattern))
				return sdf.parse(str);
			sdf.applyPattern(pattern);
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化输出时间
	 * 
	 * @param format
	 *            格式化字符串
	 * 
	 * @param date
	 *            Date对象
	 * @return 格式化后的时间
	 */
	public static String formatDate(String format, Date date) {
		if (null == format || "".equals(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (null == date) {
			return sdf.format(new Date());
		}
		return sdf.format(date);
	}

	/**
	 * 格式化输出时间（时间戳）
	 * 
	 * @param format
	 *            格式化字符串
	 * @param millis
	 *            时间戳
	 * @return 格式化后的时间
	 */
	public static String formatDateWithMilis(String format, long millis) {
		if (null == format || "".equals(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(millis);
	}

	/**
	 * 取指定日期的时间戳
	 * 
	 * @param dateString
	 *            日期字符串(yyyy-mm-dd HH:mm:ss)
	 * @return 时间戳
	 */
	public static long getDateMillis(String dateString) {
		return getDateMillis(dateString, null);
	}

	/**
	 * 取指定日期的时间戳
	 * 
	 * @param dateString
	 *            日期字符串
	 * @param pattern
	 *            日期字符串格式，默认"yyyy-MM-dd HH:mm:ss"
	 * @return 时间戳
	 */
	public static long getDateMillis(String dateString, String pattern) {
		if (null == pattern || pattern.equals("")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}

	/**
	 * 取当前时间戳
	 * 
	 * @return 当前时间戳值
	 */
	public static long getCurrentTimeInMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 取多少天后的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param days
	 *            多少天后，如果为负数，则为多少天前，如果为0，则为当天
	 * @return 时间戳
	 */
	public static long getDaysMillis(long criterion, int days) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		criterion = criterion + 28800000;
		long result = criterion + (days * 86400000) - 28800000;
		return result;
	}

	/**
	 * 取基准时间多少天后的0点的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param days
	 *            多少天后，如果为负数，则为多少天前，如果为0，则为当天
	 * @return 时间戳
	 */
	public static long getDaysZeroMillis(long criterion, int days) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		criterion = criterion + 28800000;
		long result = criterion - (criterion % 86400000) + (days * 86400000) - 28800000;
		return result;
	}

	/**
	 * 取多少个月后的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param months
	 *            多少月后，如果为负数，则为多少月前，如果为0，则为当前时间
	 * @return 时间戳
	 */
	public static long getMonthsMillis(long criterion, int months) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		String criterionStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(criterion);
		String[] dateArray = criterionStr.split("-");
		int y = Integer.valueOf(dateArray[0]);
		int m = Integer.valueOf(dateArray[1]);
		m += months;
		if (m > 12) {
			y += m / 12;
			m = m % 12;
		} else if (m < 0) {
			y -= Math.abs(m) / 12 + 1;
			m = 12 - Math.abs(m) % 12;
		}
		String mStr = m < 10 ? "0" + m : "" + m;
		String targetDate = y + "-" + mStr + "-" + dateArray[2];
		long millis = getDateMillis(targetDate);
		return millis;
	}

	/**
	 * 取多少个月后第一天的0点的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param months
	 *            多少月后，如果为负数，则为多少月前，如果为0，则为当前时间
	 * @return 时间戳
	 */
	public static long getMonthsFirstDayZeroMillos(long criterion, int months) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		String criterionStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(criterion);
		criterionStr = criterionStr.replace(" ", "-");
		criterionStr = criterionStr.replace(":", "-");
		String[] dateArray = criterionStr.split("-");
		int y = Integer.valueOf(dateArray[0]);
		int m = Integer.valueOf(dateArray[1]);
		m += months;
		if (m > 12) {
			y += m / 12;
			m = m % 12;
		} else if (m < 0) {
			y -= Math.abs(m) / 12 + 1;
			m = 12 - Math.abs(m) % 12;
		}
		String mStr = m < 10 ? "0" + m : "" + m;
		String targetDate = y + "-" + mStr + "-" + "01" + " " + "00:00:00";
		long millis = getDateMillis(targetDate);
		return millis;
	}

	/**
	 * 生成月份的列表，如201309、201310、201311
	 * 
	 * @param monthLen
	 *            月份数量
	 * @return 月分列表
	 */
	public static List<String> getMonthList(int monthLen) {
		List<String> result = new ArrayList<String>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String temp = "";

		while (result.size() < monthLen) {
			if (month < 10) {
				temp = year + "0" + month;
			} else {
				temp = year + "" + month;
			}
			result.add(temp);

			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}

		return result;
	}

	/**
	 * 取多少年后的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param years
	 *            多少年后，如果为负数，则为多少年前，如果为0，则为当前时间
	 * @return 时间戳
	 */
	public static long getYearsMillis(long criterion, int years) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		String criterionStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(criterion);
		String[] dateArray = criterionStr.split("-");
		int y = Integer.valueOf(dateArray[0]);
		y += years;
		String targetDate = y + "-" + dateArray[1] + "-" + dateArray[2];
		long millis = getDateMillis(targetDate);
		return millis;
	}

	/**
	 * 取多少个年后第一天的0点的时间戳
	 * 
	 * @param criterion
	 *            基准时间，如果为不大于0，取当前时间
	 * @param years
	 *            多少年后，如果为负数，则为多少月前，如果为0，则为当前时间
	 * @return 时间戳
	 */
	public static long getYearsFirstDayZeroMillos(long criterion, int years) {
		if (criterion <= 0) {
			criterion = System.currentTimeMillis();
		}
		String criterionStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(criterion);
		criterionStr = criterionStr.replace(" ", "-");
		criterionStr = criterionStr.replace(":", "-");
		String[] dateArray = criterionStr.split("-");
		int y = Integer.valueOf(dateArray[0]);
		y += years;
		String targetDate = y + "-01-01" + " " + "00:00:00";
		long millis = getDateMillis(targetDate);
		return millis;
	}

	/**
	 * 获取年份，从今年到往后len年
	 * 
	 * @param len
	 *            多少年
	 * @return 年份列表
	 */
	public static List<Integer> getYears(int len) {
		List<Integer> result = new ArrayList<Integer>();
		Calendar cal = null;
		for (int i = 0; i < len; i++) {
			cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, i);
			result.add(cal.get(Calendar.YEAR));
		}
		return result;
	}

	/**
	 * 取时间差，与目标时间的时间差
	 * 
	 * @param source
	 *            原时间，时间戳
	 * @param target
	 *            目标时间，时间戳
	 * @param showSecond
	 *            是否显示秒
	 * @return 时间差
	 */
	public static String getTimeInterval(long source, long target, boolean showSecond) {
		if (0 >= source || 0 >= target)
			return "";
		StringBuffer buf = new StringBuffer();
		long time = Math.abs(source - target);
		// day
		long day = time / (24 * 60 * 60 * 1000L);
		// hour
		time = time - day * 24 * 60 * 60 * 1000L;
		long hour = time / (60 * 60 * 1000L);
		// minute
		time = time - hour * 60 * 60 * 1000L;
		long minute = time / (60 * 1000L);
		// second
		time = time - minute * 60 * 1000L;
		long second = time / 1000L;
		if (day != 0) {
			buf.append(day + "天");
		}
		if (hour != 0) {
			buf.append(hour + "时");
		}
		if (minute != 0) {
			buf.append(minute + "分");
		}
		if (showSecond || buf.length() == 0) {
			if (second != 0) {
				buf.append(second + "秒");
			}
		}
		return buf.toString();
	}

	/**
	 * 从身份证中取出生日
	 * 
	 * @param idcard
	 *            身份证号码
	 * @return 出生日期
	 */
	public static Date getBirthdayFromIdcard(String idcard) {
		if (null == idcard || idcard.length() != 18) {
			return null;
		}
		String dateStr = idcard.substring(6, 14);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 从身份证中取出生日(时间戳)
	 * 
	 * @param idcard
	 *            身份证号码
	 * @return 出生日期时间戳
	 */
	public static long getBirthdayMillisFromIdcard(String idcard) {
		if (null == idcard || idcard.length() != 18) {
			return 0L;
		}
		String dateStr = idcard.substring(6, 14);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
}
