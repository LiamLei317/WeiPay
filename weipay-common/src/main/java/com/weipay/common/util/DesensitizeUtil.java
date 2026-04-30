package com.weipay.common.util;

/**
 * 脱敏工具类
 * 用于敏感信息脱敏处理
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public class DesensitizeUtil {

    /**
     * 手机号脱敏
     * 保留前3位和后4位，中间用*代替
     * 
     * @param phone 手机号
     * @return 脱敏后的手机号
     */
    public static String desensitizePhone(String phone) {
        if (phone == null || phone.length() < 11) {
            return phone;
        }
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }

    /**
     * 邮箱脱敏
     * 保留@前的第一个字符和@后的全部
     * 
     * @param email 邮箱
     * @return 脱敏后的邮箱
     */
    public static String desensitizeEmail(String email) {
        if (email == null || !email.contains("@")) {
            return email;
        }
        int atIndex = email.indexOf("@");
        String prefix = email.substring(0, atIndex);
        String suffix = email.substring(atIndex);
        if (prefix.length() <= 1) {
            return email;
        }
        return prefix.charAt(0) + "***" + suffix;
    }

    /**
     * 银行卡号脱敏
     * 保留前4位和后4位，中间用*代替
     * 
     * @param cardNo 银行卡号
     * @return 脱敏后的银行卡号
     */
    public static String desensitizeCardNo(String cardNo) {
        if (cardNo == null || cardNo.length() < 8) {
            return cardNo;
        }
        int length = cardNo.length();
        return cardNo.substring(0, 4) + "****" + cardNo.substring(length - 4);
    }

    /**
     * 身份证号脱敏
     * 保留前6位和后4位，中间用*代替
     * 
     * @param idCard 身份证号
     * @return 脱敏后的身份证号
     */
    public static String desensitizeIdCard(String idCard) {
        if (idCard == null || idCard.length() < 10) {
            return idCard;
        }
        return idCard.substring(0, 6) + "********" + idCard.substring(idCard.length() - 4);
    }

    /**
     * 姓名脱敏
     * 保留姓，名用*代替
     * 
     * @param name 姓名
     * @return 脱敏后的姓名
     */
    public static String desensitizeName(String name) {
        if (name == null || name.length() <= 1) {
            return name;
        }
        return name.charAt(0) + "*".repeat(name.length() - 1);
    }

    private DesensitizeUtil() {
    }
}
