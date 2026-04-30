package com.weipay.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 金额工具类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public class AmountUtil {

    /**
     * 金额精度（小数位数）
     */
    private static final int SCALE = 2;

    /**
     * 金额相加
     * 
     * @param amount1 金额1
     * @param amount2 金额2
     * @return 相加结果
     */
    public static BigDecimal add(BigDecimal amount1, BigDecimal amount2) {
        if (amount1 == null) {
            amount1 = BigDecimal.ZERO;
        }
        if (amount2 == null) {
            amount2 = BigDecimal.ZERO;
        }
        return amount1.add(amount2).setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 金额相减
     * 
     * @param amount1 被减数
     * @param amount2 减数
     * @return 相减结果
     */
    public static BigDecimal subtract(BigDecimal amount1, BigDecimal amount2) {
        if (amount1 == null) {
            amount1 = BigDecimal.ZERO;
        }
        if (amount2 == null) {
            amount2 = BigDecimal.ZERO;
        }
        return amount1.subtract(amount2).setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 金额相乘
     * 
     * @param amount1 金额1
     * @param amount2 金额2
     * @return 相乘结果
     */
    public static BigDecimal multiply(BigDecimal amount1, BigDecimal amount2) {
        if (amount1 == null) {
            amount1 = BigDecimal.ZERO;
        }
        if (amount2 == null) {
            amount2 = BigDecimal.ZERO;
        }
        return amount1.multiply(amount2).setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 金额相除
     * 
     * @param amount1 被除数
     * @param amount2 除数
     * @return 相除结果
     */
    public static BigDecimal divide(BigDecimal amount1, BigDecimal amount2) {
        if (amount1 == null) {
            amount1 = BigDecimal.ZERO;
        }
        if (amount2 == null || amount2.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return amount1.divide(amount2, SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 金额格式化（保留两位小数）
     * 
     * @param amount 金额
     * @return 格式化后的金额
     */
    public static BigDecimal format(BigDecimal amount) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return amount.setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 分转元
     * 
     * @param amount 分
     * @return 元
     */
    public static BigDecimal fenToYuan(Long amount) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(amount).divide(new BigDecimal(100), SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 元转分
     * 
     * @param amount 元
     * @return 分
     */
    public static Long yuanToFen(BigDecimal amount) {
        if (amount == null) {
            return 0L;
        }
        return amount.multiply(new BigDecimal(100)).setScale(0, RoundingMode.HALF_UP).longValue();
    }

    private AmountUtil() {
    }
}
