package com.dakun.jianzhong.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>User: wangjie
 * <p>Date: 8/16/2017
 */
public class DateUtils {

    public static Date now() {
        return new Date();
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     *获取某个日期一段时间之后的日期或一段时间之前的日期
     * @param date
     * @param field  Calendar.YEAR,MONTH,WEEK_OF_YEAR,WEEK_OF_MONTH,DATE 等等
     * @param amount  amount天前（<0）或者后(>0）
     * @return date之前或之后的日期
     */
    public static Date getIntervalDay(Date date,int field,int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field,amount);
        return calendar.getTime();
    }

    /**
     *获取某个日期一段时间之后的日期或一段时间之前的日期
     * @param date
     * @param fmt 日期字符串格式
     * @param field Calendar.YEAR,MONTH,WEEK_OF_YEAR,WEEK_OF_MONTH,DATE 等等
     * @param amount amount天前（<0）或者后(>0）
     * @return 字符串格式日期
     */
    public static String getIntervalDayFmt(Date date,String fmt,int field,int amount){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(field,amount);
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            return sdf.format(calendar.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
