package javacore.datetime;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * 时间工具类
 * 
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static final String F_YYYY年MM月DD日 = "yyyy年MM月dd日";

	public static final String F_YYYYMMDD = "yyyyMMdd";
	public static final String F_YYYYMMDDHHMM = "yyyyMMddHHmm";
	public static final String F_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String F_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String[] PATTERN_ARRAY_NO_SEPARATOR = {F_YYYYMMDD, F_YYYYMMDDHHMM, F_YYYYMMDDHHMMSS, F_YYYYMMDDHHMMSSSSS};

	public static final String F_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String F_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String F_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String F_YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";
	public static final String F_YYYY_MM_DD_HH_MM_SS_SS = "yyyy-MM-dd HH:mm:ss.SS";
	public static final String F_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String[] PATTERN_ARRAY_SEPARATOR_HYPHEN = {F_YYYY_MM_DD, F_YYYY_MM_DD_HH_MM, F_YYYY_MM_DD_HH_MM_SS,
											F_YYYY_MM_DD_HH_MM_SS_S, F_YYYY_MM_DD_HH_MM_SS_SS, F_YYYY_MM_DD_HH_MM_SS_SSS};

	public static final String F_YYYY_P_MM_P_DD = "yyyy.MM.dd";
	public static final String F_YYYY_P_MM_P_DD_HH_MM = "yyyy.MM.dd HH:mm";
	public static final String F_YYYY_P_MM_P_DD_HH_MM_SS = "yyyy.MM.dd HH:mm:ss";
	public static final String F_YYYY_P_MM_P_DD_HH_MM_SS_S = "yyyy.MM.dd HH:mm:ss.S";
	public static final String F_YYYY_P_MM_P_DD_HH_MM_SS_SS = "yyyy.MM.dd HH:mm:ss.SS";
	public static final String F_YYYY_P_MM_P_DD_HH_MM_SS_SSS = "yyyy.MM.dd HH:mm:ss.SSS";
	public static final String[] PATTERN_ARRAY_SEPARATOR_POINT = {F_YYYY_P_MM_P_DD, F_YYYY_P_MM_P_DD_HH_MM, F_YYYY_P_MM_P_DD_HH_MM_SS,
			F_YYYY_P_MM_P_DD_HH_MM_SS_S, F_YYYY_P_MM_P_DD_HH_MM_SS_SS, F_YYYY_P_MM_P_DD_HH_MM_SS_SSS};

	public final static DateFormat YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(F_YYYY_MM_DD_HH_MM_SS);
	public final static DateFormat YYYY_MM_DD = new SimpleDateFormat(F_YYYY_MM_DD);
	public final static DateFormat YYYYMMDDMMHHSSSSS = new SimpleDateFormat(F_YYYYMMDDHHMMSSSSS);
	public final static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat(F_YYYYMMDDHHMMSS);
	public final static DateFormat YYYYMMDDHHMM = new SimpleDateFormat(F_YYYYMMDDHHMM);
	public static final DateFormat YYYYMMDD = new SimpleDateFormat(F_YYYYMMDD);
	public static final DateFormat YYYYyearMMmonthDDday = new SimpleDateFormat(F_YYYY年MM月DD日);

	public static final int oneDayMillis = 1000 * 60 * 60 * 24;

	/**
	 * -------------------------- jdk 1.8 LocalDate LocalDateTime ----------------------------
	 */

	/**
	 * 转换日期格式: yyyyMMdd --> yyyy-MM-dd.
	 * <pre>
	 *     格式A ：yyyy-MM-dd
	 *     格式B ：yyyyMMdd
	 * </pre>
	 *
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd
	 */
	public static String toAPatternDate(String dateStr) {
		return toDateTime(dateStr, F_YYYY_MM_DD);
	}

	/**
	 * 转换日期格式: 时间戳 --> yyyy-MM-dd.
	 * <pre>
	 *     格式A ：yyyy-MM-dd
	 *     格式B ：yyyyMMdd
	 * </pre>
	 *
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd
	 */
	public static String toAPatternDate(long timeStamp) {
		LocalDateTime localDateTime = toLocalDateTime(timeStamp);
		return formatLocalDateTime(localDateTime, F_YYYY_MM_DD);
	}

	/**
	 * 转换日期格式: yyyyMMddHHmmss --> yyyy-MM-dd HH:mm:ss
	 * <pre>
	 *     格式A ：yyyy-MM-dd HH:mm:ss
	 *     格式B ：yyyyMMddHHmmss
	 * </pre>
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String toAPatternDateTime(String dateTimeStr) {
		return toDateTime(dateTimeStr, F_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 转换日期格式: 时间戳 --> yyyy-MM-dd HH:mm:ss
	 * <pre>
	 *     格式A ：yyyy-MM-dd HH:mm:ss
	 *     格式B ：yyyyMMddHHmmss
	 * </pre>
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String toAPatternDateTime(long timeStamp) {
		LocalDateTime localDateTime = toLocalDateTime(timeStamp);
		return formatLocalDateTime(localDateTime, F_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 日期时间转换为时间戳,例如：2017-10-10 --> 91948492874
	 * @author feako
	 * @param dateTime 时间
	 */
	public static String toTimestamp(String dateTime) {
		LocalDateTime localDateTime = dateStrToLocalDateTime(dateTime);
		long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		return String.valueOf(milli);
	}

	/**
	 * 日期时间转换为时间戳
	 * @author feako
	 * @param dateTime 时间
	 */
	public static long toTimestampLong(String dateTime) {
		LocalDateTime localDateTime = dateStrToLocalDateTime(dateTime);
		long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
		return milli;
	}

	/**
	 * 转换日期格式: yyyy-MM-dd --> yyyyMMdd
	 * <pre>
	 *     格式A ：yyyy-MM-dd
	 *     格式B ：yyyyMMdd
	 * </pre>
	 *
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd
	 */
	public static String toBPatternDate(String dateStr) {
		return toDateTime(dateStr, F_YYYYMMDD);
	}

	/**
	 * 转换日期格式: yyyy-MM-dd HH:mm:ss --> yyyyMMddHHmmss
	 * <pre>
	 *     格式A ：yyyy-MM-dd HH:mm:ss
	 *     格式B ：yyyyMMddHHmmss
	 * </pre>
	 * @author feako
	 * @return 默认格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String toBPatternDateTime(String dateTimeStr) {
		return toDateTime(dateTimeStr, F_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 日期时间转换
	 * <b>
	 *    toDateTime("20171010", "yyyy-MM-dd") = 2017-10-10
	 *    toDateTime("201710101212", "yyyy-MM-dd HH:mm") = 2017-10-10 12:12
	 *    toDateTime("20171010121200", "yyyy-MM-dd HH:mm:ss") = 2017-10-10 12:12:00
	 * </b>
	 * @param dateTimeStr
	 * @param targetPattern
	 * @return
	 */
	public static String toDateTime(String dateTimeStr, String targetPattern) {
		if (StringUtils.isBlank(dateTimeStr)) {
			return StringUtils.EMPTY;
		}

		String pattern = selectPattern(dateTimeStr);
		// 没匹配的格式 或 格式相同则返回
		if (StringUtils.isBlank(pattern) || StringUtils.equals(pattern, targetPattern) ) {
			return dateTimeStr;
		}

		LocalDateTime localDateTime = dateStrToLocalDateTime(dateTimeStr);
		if (pattern.length() <= 10) {
			LocalDate source = localDateTime.toLocalDate();
			return formatLocalDate(source, targetPattern);
		} else {
			return formatLocalDateTime(localDateTime, targetPattern);
		}
	}

	/**
	 * 获取今天的日期(yyyy-MM-dd)
	 * @author feako
	 * @return 今天的日期
	 */
	public static String getTodayStr() {
		return getTodayStr(F_YYYY_MM_DD);
	}

	/**
	 * 获取今天的日期
	 * <p>pattern格式:  DateUtil.F_YYYYMMDD, DateUtil.F_YYYY_MM_DD</p>
	 * @author feako
	 * @param pattern 使用DateUtil.F_YYYYMMDD，或DateUtil.F_YYYY_MM_DD
	 * @return 今天的日期
	 */
	public static String getTodayStr(String pattern) {
		if (StringUtils.isBlank(pattern)) {
			pattern = F_YYYY_MM_DD;
		}
		return formatLocalDate(LocalDate.now(), pattern);
	}

	/**
	 * 获取当前日期和时间(yyyy-MM-dd HH:mm:ss)
	 * @author feako
	 * @return 当前日期和时间(yyyy-MM-dd HH:mm:ss)
	 */
	public static String getNowStr() {
		return getNowStr(F_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 获取当前日期和时间
	 * @author feako
	 * @param pattern 使用DateUtil.F_YYYY_MM_DD_HH_MM_SS，或DateUtil.F_YYYY_P_MM_P_DD_HH_MM_SS
	 * @return
	 */
	public static String getNowStr(String pattern) {
		if (StringUtils.isBlank(pattern)) {
			pattern = F_YYYY_MM_DD_HH_MM_SS;
		}
		return formatLocalDateTime(LocalDateTime.now(), pattern);
	}

	/**
	 * 判断时间是否在当前时间之前。
	 * <pre>
	 *     假设当前时间 20171111120411
	 *     isBeforeNow("20171010120411") = true
	 *     isBeforeNow("20171212120411") = false
	 * </pre>
	 * @author fwb
	 * @param dateStr 时间，格式: yyyyMMddHHmmss
	 * @return
	 */
	public static boolean isBeforeNow(String dateStr) {
		LocalDateTime localDateTime = dateStrToLocalDateTime(dateStr);
		if (localDateTime == null) {
			return false;
		}
		return localDateTime.isBefore(LocalDateTime.now());
	}
	/**
	 * 判断时间是否在当前时间之前。
	 * <pre>
	 *     假设当前时间 20171111120411
	 *     isAfterNow("20171010120411") = false
	 *     isAfterNow("20171212120411") = true
	 * </pre>
	 * @author fwb
	 * @param dateStr 时间，格式: yyyyMMddHHmmss
	 * @return
	 */
	public static boolean isAfterNow(String dateStr) {

		LocalDateTime localDateTime = dateStrToLocalDateTime(dateStr);
		if (localDateTime == null) {
			return false;
		}
		return localDateTime.isAfter(LocalDateTime.now());
	}

	/**
	 * 判断 sourceDate 是否在 targetDate 之前,sourceDate < targetDate
	 * <br/>日期格式 任意格式
	 * <p>
	 *     isBefore('2018-01-01', '2018-01-02') = true
	 * </p>
	 * @param sourceDate 原日期
	 * @param targetDate 目标日期
	 * @param formatStr 日期格式
	 * @return
	 */
	public static boolean isBefore(String sourceDate,String targetDate) {
		LocalDateTime source = dateStrToLocalDateTime(sourceDate);
		LocalDateTime target = dateStrToLocalDateTime(targetDate);
		if(sourceDate==null || targetDate==null){
			return false;
		}
		return source.isBefore(target);
	}

	/**
	 * 判断sourceDate是否在targetDate之后
	 * 日期格式:yyyy-MM-dd
	 * @param sourceDate 原日期
	 * @param targetDate 目标日期
	 * @return
	 */
	public static boolean isAfter(String sourceDate,String targetDate) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern(F_YYYY_MM_DD);
		//LocalDate source = LocalDate.parse(sourceDate);
		//LocalDate target = LocalDate.parse(targetDate);
		LocalDateTime source = dateStrToLocalDateTime(sourceDate);
		LocalDateTime target = dateStrToLocalDateTime(targetDate);
		if(sourceDate==null || targetDate==null){
			return false;
		}
		return source.isAfter(target);
	}

	/**
	 * 判断sourceDate是否在targetDate之后
	 * 日期格式:yyyy-MM-dd
	 * @param sourceDate 原日期
	 * @param targetDate 目标日期
	 * @param formatStr 日期格式
	 * @return
	 */
	public static boolean isAfter(String sourceDate,String targetDate,String formatStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatStr);
		LocalDateTime source = LocalDateTime.parse(sourceDate,formatter);
		LocalDateTime target = LocalDateTime.parse(targetDate,formatter);
		if(sourceDate==null || targetDate==null){
			return false;
		}
		return source.isAfter(target);
	}

	/**
	 * 计算当前时间到指定时间之间的剩余时间(单位是：毫秒)。
	 *  <br/> 指定的时间 - 当前时间 = 剩余的毫秒数
	 * <pre>
	 *   now = '201711290008'
	 *   remainTimeWithMillisStr('201711290009') = 60000
	 *   remainTimeWithMillisStr('201711290007') = 0 //小于当前时间，则为0
	 * </pre>
	 * @author fwb
	 * @param endDateTime dateTime 指定的时间
	 * @return
	 */
	public static String remainTimeWithMillisStr(String endDateTime) {
		return String.valueOf(remainTimeWithMillis(endDateTime));
	}

	/**
	 * 计算当前时间到指定时间之间的剩余时间(单位是：毫秒)。
	 *  <br/>指定的时间 - 当前时间 = 剩余的毫秒数
	 * <pre>
	 *   now = '201711290008'
	 *   remainTimeWithMillisStr('201711290009') = 60000
	 *   remainTimeWithMillisStr('201711290007') = 0 //小于当前时间，则为0
	 * </pre>
	 * @author fwb
	 * @param endDateTime dateTime 指定的时间
	 * @return
	 */
	public static Long remainTimeWithMillis(String endDateTime) {
		if (StringUtils.isBlank(endDateTime)) {
			return 0L;
		}

		String now = formatLocalDateTime(LocalDateTime.now(), F_YYYYMMDDHHMMSS);
		long millis = diffDateTimeWithMillis(now, endDateTime);
		return millis > 0 ? millis : 0;
	}

	/**
	 * 计算当前时间到指定时间之间的剩余时间(单位是：天)。
	 *  <br/> 指定的时间 - 当前时间 = 剩余的天数
	 * @author fwb
	 * @param endDateTime dateTime 指定的时间
	 * @return
	 */
	public static long remainTimeWithDays(String endDateTime) {
		if (StringUtils.isBlank(endDateTime)) {
			return 0L;
		}
		String now = formatLocalDateTime(LocalDateTime.now(), F_YYYYMMDDHHMMSS);
		long days = diffDateTimeWithDays(now, endDateTime);
		return days > 0 ? days : 0;
	}

	/**
	 * 计算指定时间到当前时间到过去的时间(单位是：天)。
	 *  <p> 当前时间 - 指定的时间  = 已经过去的天数</p>
	 * @author fwb
	 * @param endDateTime dateTime 指定的时间
	 * @return
	 */
	//exceed
	public static long passedTimeWithDays(String endDateTime) {
		if (StringUtils.isBlank(endDateTime)) {
			return 0L;
		}

		String now = formatLocalDateTime(LocalDateTime.now(), F_YYYYMMDDHHMMSS);
		long days = diffDateTimeWithDays(endDateTime, now);
		return days > 0 ? days : 0;
	}

	/**
	 * 计算时间之间的差值(单位是：毫秒)
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static long diffDateTimeWithMillis(String dt1, String dt2) {
		return diffDateTime(dt1, dt2, ChronoUnit.MILLIS);
	}

	/**
	 * 计算日期之间的差值(单位是：天)
	 * <p> 日期比较时不包含 时分秒。</p>
	 * @author fwb
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static long diffDateTimeWithDays(String dt1, String dt2) {
		return diffDateTime(dt1, dt2, ChronoUnit.DAYS);
	}

	/**
	 * 计算日期时间之间的差值。
	 * @author fwb
	 * @param start 开始日期时间
	 * @param end 结束日期时间
	 * @param chronoUnit ChronoUnit 指定时间单位
	 * @return Duration
	 */
	private static long diffDateTime(String start, String end, ChronoUnit chronoUnit) {
		// 转换成时间格式
		LocalDateTime startTime = dateStrToLocalDateTime(start);
		LocalDateTime endTime = dateStrToLocalDateTime(end);
		if (startTime == null || endTime == null) {
			return 0l;
		}
		// 两时间比较
		return startTime.until(endTime, chronoUnit);
	}

	//---------------------- 时间格式转换 ---------------------------------

	/**
	 * 计算小时
	 * @param dateTimeStr
	 * @param n 正直增加数值，负数为减少数值
	 * @return
	 */
	public static String addHours(String dateTimeStr, int n) {
		return addDateTime(dateTimeStr, n, ChronoUnit.HOURS);
	}

	/**
	 * 计算天数
	 * @param dateTimeStr
	 * @param n 正直增加数值，负数为减少数值
	 * @return
	 */
	public static String addDays(String dateTimeStr, int n) {
		return addDateTime(dateTimeStr, n, ChronoUnit.DAYS);
	}

	/**
	 * 计算年数
	 * @param dateTimeStr
	 * @param n 正直增加数值，负数为减少数值
	 * @return
	 */
	public static String addYears(String dateTimeStr, int n) {
		return addDateTime(dateTimeStr, n, ChronoUnit.YEARS);
	}

	/**
	 * 时间计算，添加日期和时间
	 * @param dateTimeStr 时间字符串，支持 日期 和日期时间格式
	 * @param n 正直增加数值，负数为减少数值
	 * @param unit ChronoUnit 中的枚举值
	 * @return
	 */
	public static String addDateTime(String dateTimeStr, int n, TemporalUnit unit) {
		String pattern = selectPattern(dateTimeStr);
		if (StringUtils.isBlank(pattern)) {
			return StringUtils.EMPTY;
		}
		LocalDateTime localDateTime = dateStrToLocalDateTime(dateTimeStr);
		if (localDateTime != null) {
			LocalDateTime plugLocalDateTime = localDateTime.plus(n, unit);
			if (pattern.length() <= 10) {
				LocalDate source = plugLocalDateTime.toLocalDate();
				return formatLocalDate(source, pattern);
			} else {
				return formatLocalDateTime(plugLocalDateTime, pattern);
			}
		}

		return StringUtils.EMPTY;
	}

	/**
	 * 时间戳转换为LocalDateTime
	 * @param timeStamp
	 * @return
	 */
	private static LocalDateTime toLocalDateTime(long timeStamp) {
		Instant instant = Instant.ofEpochMilli(timeStamp);
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}

	/**
	 * 日期字符串 转换为 java.time.LocalDateTime
	 * @author fwb
	 * @param dateStr 时间字符串，格式: yyyyMMddHHmmss
	 * @return
	 */
	public static LocalDateTime dateStrToLocalDateTime(String dateStr) {
		String pattern = selectPattern(dateStr);
		if (StringUtils.isBlank(pattern)) {
			return null;
		}
		LocalDateTime localDateTime = null;
		try {
			if (pattern.length() <= 10) {
				LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
				localDateTime = toLocalDateTime(localDate);
			} else {
				localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
			}
		} catch (Exception e) {
			// TODO 添加日志

		}
		return localDateTime;
	}

	/**
	 * java.util.data 转换为 java.time.LocalDateTime
	 * @author fwb
	 * @param date
	 * @return
	 */
	public static LocalDateTime dateToLocalDateTime(Date date) {
		if (date == null) {
			return null;
		}

		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
		return localDateTime;
	}


	/**
	 * 格式化LocalDate
	 * @param date LocalDate
	 * @param pattern 时间格式，例如: yyyyMMdd, yyyy-MM-dd
	 * @return 格式化的字符串
	 */
	private static String formatLocalDate(LocalDate date, String pattern) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		return date.format(DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 格式化LocalDateTime
	 * @param dateTime LocalDateTime
	 * @param pattern 时间格式，例如: yyyyMMdd, yyyyMMddHHmmss
	 * @return 格式化的字符串
	 */
	public static String formatLocalDateTime(LocalDateTime dateTime, String pattern) {
		if (dateTime == null) {
			return StringUtils.EMPTY;
		}
		return dateTime.format(DateTimeFormatter.ofPattern(pattern));
	}

	/**
	 * 根据日期选择日期格式
	 * @author fwb
	 * @param dateStr 日期
	 * @return
	 */
	private static String selectPattern(String dateStr) {
		if (StringUtils.isBlank(dateStr)) {
			return StringUtils.EMPTY;
		}
		dateStr = dateStr.trim();
		int length = dateStr.length();

		// 无分割符
		if (StringUtils.isNumeric(dateStr)) {
			for (String pattern : PATTERN_ARRAY_NO_SEPARATOR) {
				if (length == pattern.length()) {
					return pattern;
				}
			}
		}

		// 分隔符：-
		boolean hasHyphen = StringUtils.contains(dateStr, "-");
		if (hasHyphen) {
			for (String pattern : PATTERN_ARRAY_SEPARATOR_HYPHEN) {
				if (length == pattern.length()) {
					return pattern;
				}
			}
		}

		// 分隔符：.
		boolean hasPoint = StringUtils.contains(dateStr, ".");
		if (hasPoint) {
			for (String pattern : PATTERN_ARRAY_SEPARATOR_POINT) {
				if (length == pattern.length()) {
					return pattern;
				}
			}
		}

		return StringUtils.EMPTY;
	}

	/**
	 * LocalDate 转成 LocalDateTime
	 * @author feako
	 * @param localDate
	 * @return
	 */
	private static LocalDateTime toLocalDateTime(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return LocalDateTime.of(localDate, LocalTime.of(0,0));
	}

	public static void main(String[] args) {

		String startTime = "2018-04-13 01:01:01";
		String oldProcotolDate = "2018-04-04";
		String newProcotolDate = "2018-04-13";
		String latestTemplateTag = "";
		if (DateUtil.isBefore(startTime, oldProcotolDate)) {
			latestTemplateTag = "0";
		} else if (DateUtil.isAfter(startTime, oldProcotolDate) && DateUtil.isBefore(startTime, newProcotolDate)) {
			latestTemplateTag = "1";
		} else {
			latestTemplateTag = "2";
		}

		String s5 = selectPattern("2015-11-23 11:53:18.0");
		boolean afterNow = isAfterNow("2015-11-23 11:53:18.0");

		boolean after = isAfter("2015-11-23 11:53:18.0", "2015-11-24");
        String s3 = addDateTime("20171010", 1, ChronoUnit.DAYS);
		String s4 = addDateTime("20171010", 1, ChronoUnit.YEARS);

		String s1 = toDateTime("20171010", F_YYYY_MM_DD);
		String s2 = toDateTime("20171010121200", F_YYYY_MM_DD_HH_MM_SS);

		System.out.println("s1=" + s1 + ",s2=" + s2);

		LocalDateTime localDateTime = toLocalDateTime(System.currentTimeMillis());
		String localDateTime01 = formatLocalDateTime(localDateTime, F_YYYY_MM_DD);
		System.out.println("--->"+localDateTime01);

		System.out.println(DateUtil.isBefore("2016-11-09", "2018-03-10") ? "new" : "old");
		System.out.println("isBeforeNow="+isBeforeNow("2017-07-20"));
		String s = toAPatternDate("20180319");
		System.out.println("toAPatternDate = "+s);
		String stime = toAPatternDateTime("20180319185430");
		System.out.println("toAPatternDateTime = "+stime);

		String nowStr = getNowStr();
		String todayStr = getNowStr(F_YYYY_MM_DD_HH_MM_SS);
		String dt1 = "20171203";
		long l1 = remainTimeWithDays("20171206");
		long l2 = diffDateTimeWithDays("20171206", "20171206");
		long l3 = diffDateTimeWithDays(formatLocalDateTime(LocalDateTime.now(), F_YYYYMMDD), "20171205");
		LocalDateTime localDateTime1 = dateStrToLocalDateTime("20171203");
		LocalDateTime localDateTime2 = dateStrToLocalDateTime("201712030405");
		LocalDateTime localDateTime3 = dateStrToLocalDateTime("20171203040506");

		LocalDateTime localDateTime4 = dateStrToLocalDateTime("2017-12-03");
		LocalDateTime localDateTime5 = dateStrToLocalDateTime("2017-12-03 04:05");
		LocalDateTime localDateTime6 = dateStrToLocalDateTime("2017.12.03");
		LocalDateTime localDateTime7 = dateStrToLocalDateTime("2017.12.03 04:05");


		long time = remainTimeWithDays("20180204");
		long l = diffDateTimeWithMillis("20171203", "20171204");

		System.out.println(time);
		long d2 = diffDateTimeWithDays("20171201", "20171203");
		System.out.println(d2);
		long p = passedTimeWithDays("20171129");
		System.out.println("passed=" + p);
	}

}
