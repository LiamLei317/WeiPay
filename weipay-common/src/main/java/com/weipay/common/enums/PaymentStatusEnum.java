package com.weipay.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付状态枚举
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum PaymentStatusEnum {

    /**
     * 待支付
     */
    PENDING(0, "待支付"),

    /**
     * 支付中
     */
    PROCESSING(1, "支付中"),

    /**
     * 支付成功
     */
    SUCCESS(2, "支付成功"),

    /**
     * 支付失败
     */
    FAILED(3, "支付失败"),

    /**
     * 已取消
     */
    CANCELLED(4, "已取消"),

    /**
     * 退款中
     */
    REFUNDING(5, "退款中"),

    /**
     * 已退款
     */
    REFUNDED(6, "已退款");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述
     */
    private final String desc;

    /**
     * 根据状态码获取枚举
     * 
     * @param code 状态码
     * @return 支付状态枚举
     */
    public static PaymentStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PaymentStatusEnum statusEnum : values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }
}
