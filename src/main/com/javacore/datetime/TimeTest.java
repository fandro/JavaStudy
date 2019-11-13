package javacore.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * jdk 时间类。
 * <p>概念：instant-瞬时，duration-长短,日期，时间，时区和周期</p>
 * <p>方便的时间处理</p>
 * <p>线程安全，不可变类型</p>
 * <p>基于ISO标准日历系统，遵守ISO格式</p>
 * <pre>
 *     instant：瞬时实例,Instant本质上是一个数字时间戳，底层实际上是对System.currentTimeMillis()进行了包装。
 *     LocalDate：本地日期，2017-11-02
 *     LocalTime: 本地时间
 *     LocalDateTime: 组合了日期和时间，但不包含时差和时区
 *     ZoneDateTime：最完整的日期和时间，包含时区和相对UTC或格林威治的时差
 *     ZoneOffSet ZoneId：用于解决时差问题
 *     ZoneOffset：类来代表某个时区，OffSetDateTime主要是给机器来理解的，如果是给人看的，可以使用ZoneDateTime类
 *     Duration：Duration表示的是两个日期时间间隔的秒以及纳秒数。
 *     Period：代表的是两个日期之间的天、月、年数差值，当然，我们也可以直接使用日期中的until方法来完成同样的效果。
 *     格式化：java.time.format.DateTimeFormatter
 *          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
 *          LocalDate today = LocalDate.now();
 *          today.format(formatter)
 *     epoch: 纪元是从1970年1月1日开始
 *     the epoch of 1970-01-01T00:00:00Z.
 *     Java8的时间API，抽象了时间的概念，用Temporal和TemporalAccessor来定义了时间的基石，划分抽象了和基石相关的时间关系，时间单位TemporalUnit，时间字段TemporalField，时间量TemporalAmount，把这些抽象接口理顺了...会发现用Java8时间API几乎可以满足你任何时间计算，以上是个人理解，仅供参考
 **
 *     UTC ： Universal Time Coordinated，协调世界时，又称世界统一时间、世界标准时间、国际协调时间，UCT与格林尼治平均时(GMT, Greenwich Mean Time)一样，都与英国伦敦的本地时相同
 *     时区：地球上的区域使用同一个时间定义，全球划分为24个时区，东、西各12个时区，规定英国（格林尼治天文台旧址）为本初子午线，即零度经线。
 *     东时区比GMT时间超前所以数值为正，西时比GMT时间落后所以区为负，东八区：UTC+8，西五区：UTC-5
 * </pre>
 *
 * @author feako
 * @date 2017/11/16
 */
public class TimeTest {

    /**
     * date 转LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {

        return null;
    }

    public static LocalDate toLocalDate(Date date) {

        return null;
    }

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        //
        //
        //协调世界时，又称世界统一时间、世界标准时间、国际协调时间
        ZoneId zoneId2 = ZoneId.of("UTC+8");
        ZoneId zoneId3 = ZoneId.of("Asia/shanghai");
        ZoneId zoneId4 = ZoneId.of("+08:00");


        // 时区 ZoneOffset，LocalDateTime和这个偏移量创建出一个OffsetDateTime
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);

        // 时间戳
        long milli = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long l = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

        // LocalDateTime.parse
        LocalDate parse = LocalDate.parse("2017-01-11", DateTimeFormatter.ofPattern("yyyy-MM-DD"));

        // LocalDateTime --> LocalDate
        LocalDateTime nowDateTime1 = LocalDateTime.now();
        LocalDate nowDate = LocalDate.of(nowDateTime1.getYear(), nowDateTime1.getMonthValue(), nowDateTime1.getDayOfMonth());

        // LocalDate --> LocalDateTime
        LocalDate now1 = LocalDate.now();
        LocalDateTime.of(now1,LocalTime.of(0, 0));

        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取当前日期时间
        LocalDateTime nowDateTime = LocalDateTime.now();

        // 根据年月日取日期
        LocalDate double11 = LocalDate.of(2017, 11, 11);
        // 字符串转日期,严格按照ISO yyyy-MM-dd
        LocalDate birthDay = LocalDate.parse("2017-10-04");
        LocalDate date3 = LocalDate.ofEpochDay(180);

        //LocalDate birthDay = LocalDate.parse("2017.10.04", new DateTimeFormatter());
        // 获取年、月、日
        int year = today.getYear();
        Month month = today.getMonth();
        int monthValue = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();

        // 会编译异常
        //LocalDate errorParse = LocalDate.parse("2017.10.04");

        // ---- 日期转换 ----
        // 本月第1天
        LocalDate firstDayOnMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 本月第2天
        LocalDate secondDate = today.withDayOfMonth(2);
        // 本月最后一天
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 下一天
        LocalDate nextDay = today.plusDays(1);
        // 这个月第一个周一
        LocalDate firstMonday = today.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        //   LocalTime 只显示时间
        // 当前时间不含日期,包含毫秒. hh:mm:ss.nnn
        LocalTime now = LocalTime.now();
        // 清除毫秒
        LocalTime nowNoNano = LocalTime.now().withNano(0);
        // 构建时间,零点
        LocalTime zero = LocalTime.of(0, 0, 0);
        // 构建时间,编译(格式：12:02:32.123)
        LocalTime parseTime = LocalTime.parse("12:01:43");
        // 增加一小时
        LocalTime oneHourLocalTime = parseTime.plusHours(1);

        LocalTime time4 = LocalTime.ofSecondOfDay(60 * 60 * 2);

        // 判断日期是否相对
        LocalDate day1 = LocalDate.of(2017, 12, 12);
        LocalDate day2 = LocalDate.of(2017, 12, 12);
        boolean same = day1.equals(day2);

        // 周期性日期,MonthDay,YearMonth ：例如：每月10日发工资
        LocalDate happyDay = LocalDate.of(2017, 9, 16);
        MonthDay monthDay = MonthDay.of(happyDay.getMonthValue(), happyDay.getDayOfMonth());
        MonthDay todayDayofMonth = MonthDay.from(today);
        boolean isSameDayOfMonth = monthDay.equals(todayDayofMonth);


        // JDBC 时间对应: date --> LocalDate,time --> LocalTime, timestamp  -->  LocalDateTime

        // 计算1周后的时间
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        // 使用clock 时钟代替下面两个方法
        System.currentTimeMillis();
        TimeZone aDefault = TimeZone.getDefault();
        // 根据当前系统时钟，并设置成UTC格式
        Clock clock = Clock.systemUTC();
        Clock defaultZone = Clock.systemDefaultZone();

        // 日期比较前后
        LocalDate tomorrow = today.plusDays(1);
        boolean isAfter = tomorrow.isAfter(today);
        LocalDate yesterday = today.minusDays(1);
        boolean isBefore = yesterday.isBefore(today);

        // 计算时间间隔
        LocalDate someDay = LocalDate.of(2018, Month.NOVEMBER, 21);
        Period period = Period.between(today, someDay);
        int days = period.getDays();// 如果夸年就有问题

        long until = today.until(someDay, ChronoUnit.DAYS);

        //long hs = period.get(ChronoUnit.HOURS);
        //long l = period.get(ChronoUnit.SECONDS);
        List<TemporalUnit> units = period.getUnits();

        // 时区,Asia/shanghai,
        //ZoneId zoneId = ZoneId.of("Asia/shanghai");

        // 判断是否闰年
        boolean leapYear = today.isLeapYear();

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);

        Period period2 = Period.between(startDate, endDate);
        System.out.println("间隔的天数" + period2.getDays());
        System.out.println("间隔的月数:" + period2.getMonths());
        System.out.println("间隔的年数:" + period2.getYears());
        // 直接使用日期类中的方法计算日期间隔
        long days2 = startDate.until(endDate, ChronoUnit.DAYS);
        System.out.println("间隔的天数:" + days);
        long weeks = startDate.until(endDate, ChronoUnit.WEEKS);
        System.out.println("间隔的周数:" + weeks);

        //Duration表示的是两个日期时间间隔的秒以及纳秒数。
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(1);
        Duration duration = Duration.between(start, end);
        System.out.println("间隔的秒数:" + duration.get(ChronoUnit.SECONDS));
        System.out.println("间隔的纳秒数:" + duration.get(ChronoUnit.NANOS));

        Instant now10 = Instant.now();
        System.out.println(now.toString());
        // 毫秒
        System.out.println(now10.get(ChronoField.MILLI_OF_SECOND));
        // 微秒，只是用毫秒数除以1000
        System.out.println(now10.get(ChronoField.MICRO_OF_SECOND));
        // 纳秒，只是用毫秒数除以1000_000
        System.out.println(now10.get(ChronoField.NANO_OF_SECOND));
        // 毫秒转Instant
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now10, ZoneId.systemDefault());

        System.out.println(localDateTime);

        //  与data


        System.out.println(now.toString());
        // 毫秒
        System.out.println("ChronoField.MILLI_OF_SECOND= "+now.get(ChronoField.MILLI_OF_SECOND));
        System.out.println("ChronoField.MILLI_OF_SECOND= "+now.get(ChronoField.OFFSET_SECONDS));
    // 微秒，只是用毫秒数除以1000
        System.out.println("ChronoField.MICRO_OF_SECOND= " + now.get(ChronoField.MICRO_OF_SECOND));
    // 纳秒，只是用毫秒数除以1000_000
        System.out.println("ChronoField.NANO_OF_SECOND= " + now.get(ChronoField.NANO_OF_SECOND));
    // 毫秒转Instant
    //    LocalDateTime localDateTime12 = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
    // 2018-06-16T23:12:01
    //    System.out.println(localDateTime12);


        String startTime ="2016-11-13 23:59";
        String endtime = "2016-11-16 00:00";
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startLocalDate = LocalDateTime.parse(startTime, sf);
        LocalDateTime startLocalDate2 = LocalDateTime.parse(startTime, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDateTime mid = startLocalDate.plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime mid1 = startLocalDate.plusDays(2).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime mid2 = startLocalDate.plusDays(3).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endLocalDate = LocalDateTime.parse(endtime, sf);
        long sec =  ChronoUnit.SECONDS.between(startLocalDate, endLocalDate);
        long sec1 =  ChronoUnit.SECONDS.between(startLocalDate, mid);
        long sec2=  ChronoUnit.SECONDS.between(startLocalDate, mid1);
        long sec3 =  ChronoUnit.SECONDS.between(startLocalDate, mid2);
        if(sec<sec1){
            if(sec<60){
                System.out.println("刚刚");
            }else{
                System.out.println("今天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
            }
        }
        if(sec>=sec1 && sec<sec2){
            System.out.println("昨天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
        }
        if(sec>=sec2 && sec<sec3){
            System.out.println("前天"+startLocalDate.toString().substring(startLocalDate.toString().indexOf("T")+1));
        }
        if(sec>=sec3){
            System.out.println(startLocalDate.toString().replace("T", " "));
        }

    }


    // Java 8中 java.util.Date 类新增了两个方法，分别是from(Instant instant)和toInstant()方法
    // Obtains an instance of Date from an Instant object.
    public static Date from(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    // Converts this Date object to an Instant.
    /*public Instant toInstant() {
        return Instant.ofEpochMilli(getTime());
    }*/

    // 这两个方法使我们可以方便的实现将旧的日期类转换为新的日期类，具体思路都是通过Instant当中介，然后通过Instant来创建LocalDateTime（这个类可以很容易获取LocalDate和LocalTime），新的日期类转旧的也是如此，将新的先转成LocalDateTime，然后获取Instant，接着转成Date，具体实现细节如下：
    // 01. java.util.Date --> java.time.LocalDateTime
    public void UDateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public void UDateToLocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    public long toTimestamp(LocalDateTime locaDateTime) {
        locaDateTime = LocalDateTime.now();
        long milli = locaDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long l = locaDateTime.toEpochSecond(ZoneOffset.of("+8"));
        return milli;
    }

    /*
    LocalDate 常用方法
    方法名	返回值类型	对该方法的解释
    getYear()	int	获取当前日期的年份
    getMonth()	Month	获取当前日期的月份对象
    getMonthValue()	int	获取当前日期是第几月
    getDayOfWeek()	DayOfWeek	表示该对象表示的日期是星期几
    getDayOfMonth()	int	表示该对象表示的日期是这个月第几天
    getDayOfYear()	int	表示该对象表示的日期是今年第几天
    withYear(int year)	LocalDate	修改当前对象的年份
    withMonth(int month)	LocalDate	修改当前对象的月份
    withDayOfMonth(int dayOfMonth)	LocalDate	修改当前对象在当月的日期
    isLeapYear()	boolean	是否是闰年
    lengthOfMonth()	int	这个月有多少天
    lengthOfYear()	int	该对象表示的年份有多少天（365或者366）
    plusYears(long yearsToAdd)	LocalDate	当前对象增加指定的年份数
    plusMonths(long monthsToAdd)	LocalDate	当前对象增加指定的月份数
    plusWeeks(long weeksToAdd)	LocalDate	当前对象增加指定的周数
    plusDays(long daysToAdd)	LocalDate	当前对象增加指定的天数
    minusYears(long yearsToSubtract)	LocalDate	当前对象减去指定的年数
    minusMonths(long monthsToSubtract)	LocalDate	当前对象减去注定的月数
    minusWeeks(long weeksToSubtract)	LocalDate	当前对象减去指定的周数
    minusDays(long daysToSubtract)	LocalDate	当前对象减去指定的天数
    compareTo(ChronoLocalDate other)	int	比较当前对象和other对象在时间上的大小，返回值如果为正，则当前对象时间较晚，
    isBefore(ChronoLocalDate other)	boolean	比较当前对象日期是否在other对象日期之前
    isAfter(ChronoLocalDate other)	boolean	比较当前对象日期是否在other对象日期之后
    isEqual(ChronoLocalDate other)	boolean	比较两个日期对象是否相等
    */

    //http://blog.csdn.net/wl9739/article/details/51882913
}
