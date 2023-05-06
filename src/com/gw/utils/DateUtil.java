package com.gw.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * ClassName: DateUtil
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.4.29 下午 10:52
 * @Version: 1.0
 */
public class DateUtil {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 转化java.sql.TimeStamp为日期的时间的字符串
     */

    public static String convertTimeStamp2Str(Timestamp timestamp) {
        Instant instant = new Date(timestamp.getTime()).toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return formatter.format(localDateTime);
    }

    /**
     * 符合formatter格式的字符串转换为Date
     */

    public static Date convertStr2Date(String str){
        LocalDateTime localDateTime = LocalDateTime.parse(str, formatter);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static String convertDate2Str(Date birthDay){
        Instant instant = birthDay.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
        return formatter.format(localDateTime);
    }







}
