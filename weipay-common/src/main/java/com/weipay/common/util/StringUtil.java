package com.weipay.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * 
     * @param str 字符串
     * @return true-空，false-非空
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     * 
     * @param str 字符串
     * @return true-非空，false-空
     */
    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    /**
     * 判断字符串是否为空白
     * 
     * @param str 字符串
     * @return true-空白，false-非空白
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * 判断字符串是否非空白
     * 
     * @param str 字符串
     * @return true-非空白，false-空白
     */
    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    /**
     * 字符串截取
     * 
     * @param str 字符串
     * @param start 开始位置
     * @return 截取后的字符串
     */
    public static String substring(String str, int start) {
        return StringUtils.substring(str, start);
    }

    /**
     * 字符串截取
     * 
     * @param str 字符串
     * @param start 开始位置
     * @param end 结束位置
     * @return 截取后的字符串
     */
    public static String substring(String str, int start, int end) {
        return StringUtils.substring(str, start, end);
    }

    /**
     * 生成随机字符串
     * 
     * @param length 长度
     * @return 随机字符串
     */
    public static String randomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * 生成订单号
     * 
     * @return 订单号
     */
    public static String generateOrderNo() {
        return System.currentTimeMillis() + randomString(6);
    }

    private StringUtil() {
    }
}
