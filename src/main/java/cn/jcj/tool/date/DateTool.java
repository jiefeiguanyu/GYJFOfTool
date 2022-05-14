package cn.jcj.tool.date;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2022/1/4 18:14   @author jcj  @version 1.00
 * Description 日期工具，操作Date和LocalDateTime
 */
public class DateTool {
    /**
     * 日期格式转换器
     *
     * @param date   指定日期
     * @param format 指定格式。如：yyyy-MM-dd  HH:mm:ss
     * @return 格式化完成后的日期字符串
     */
    public static String dateFormat(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.SIMPLIFIED_CHINESE);
        return dateFormat.format(date);
    }

    /**
     * 添加指定时期
     *
     * @param date   一个日期
     * @param num    要加多少个数
     * @param amount 选择一个要添加的单位
     * @return 添加完日期后的date
     */
    private static Date addDateTime(Date date, int num, int amount) {
        if (date == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(amount, num);
        return ca.getTime();
    }

    //加秒数
    public static Date addSecond(Date date, int num) {
        return addDateTime(date, num, Calendar.MINUTE);
    }

    //加分钟
    public static Date addMinute(Date date, int num) {
        return addDateTime(date, num, Calendar.MINUTE);
    }

    //加天数
    public static Date addDays(Date date, int num) {
        return addDateTime(date, num, Calendar.DATE);
    }

    //加星期数
    public static Date addWeek(Date date, int num) {
        return addDateTime(date, num, Calendar.WEEK_OF_MONTH);
    }

    //加月数
    public static Date addMonth(Date date, int num) {
        return addDateTime(date, num, Calendar.MONTH);
    }

    //加年数
    public static Date addYear(Date date, int num) {
        return addDateTime(date, num, Calendar.YEAR);
    }

    /**
     * dateFormat的重构
     *
     * @param LocalDateTime LocalDateTime
     * @param format        格式
     * @return 一个String
     */
    public static String dateFormat(LocalDateTime LocalDateTime, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format, Locale.SIMPLIFIED_CHINESE);
        return LocalDateTime.format(dateTimeFormatter);
    }

    /**
     * 添加时间
     *
     * @param date   LocalDateTime日期
     * @param num    数字
     * @param amount 单位
     * @return 一个LocalDateTime日期
     */
    private static LocalDateTime addDateTime(LocalDateTime date, int num, TemporalUnit amount) {
        if (date == null) {
            return null;
        }
        return date.plus(num, amount);
    }

    //加秒钟
    public static LocalDateTime addSecond(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.SECONDS);
    }

    //加分钟
    public static LocalDateTime addMinute(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.MINUTES);
    }

    //加天数
    public static LocalDateTime addDays(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.DAYS);
    }

    //加星期数
    public static LocalDateTime addWeek(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.WEEKS);
    }

    //加月数
    public static LocalDateTime addMonth(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.MONTHS);
    }

    //加年数
    public static LocalDateTime addYear(LocalDateTime date, int num) {
        return addDateTime(date, num, ChronoUnit.YEARS);
    }
    //生日距离现在有多少天 公历（下个版本加入）


}

/*
 *       更新日志 有BUG加Q2476535821
 *  1.00 2022/1/4
 *  创建DateTool类。
 *  加入dateFormat方法及一些重载
 *  加入addDateTime方法及一些重载
 *  加入addSecond方法及一些重载
 *  加入addMinute方法及一些重载
 *  加入addDays方法及一些重载
 *  加入addWeek方法及一些重载
 *  加入addMonth方法及一些重载
 *  加入addYear方法及一些重载
 */
