package com.weipay.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public class DateUtil {

    /**
     * 默认日期时间格式
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 格式化日期时间
     * 
     * @param localDateTime 日期时间
     * @return 格式化后的字符串
     */
    public static String formatDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    /**
     * 格式化日期时间（自定义格式）
     * 
     * @param localDateTime 日期时间
     * @param pattern 格式
     * @return 格式化后的字符串
     */
    public static String formatDateTime(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间字符串
     * 
     * @return 当前时间字符串
     */
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    private DateUtil() {
    }
}
