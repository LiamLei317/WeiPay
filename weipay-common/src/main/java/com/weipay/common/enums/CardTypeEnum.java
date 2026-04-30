package com.weipay.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 卡类型枚举
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CardTypeEnum {

    /**
     * 信用卡
     */
    CREDIT_CARD("CREDIT", "信用卡"),

    /**
     * 借记卡
     */
    DEBIT_CARD("DEBIT", "借记卡"),

    /**
     * 预付卡
     */
    PREPAID_CARD("PREPAID", "预付卡");

    /**
     * 卡类型代码
     */
    private final String code;

    /**
     * 卡类型描述
     */
    private final String desc;

    /**
     * 根据代码获取枚举
     * 
     * @param code 卡类型代码
     * @return 卡类型枚举
     */
    public static CardTypeEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (CardTypeEnum cardTypeEnum : values()) {
            if (cardTypeEnum.getCode().equals(code)) {
                return cardTypeEnum;
            }
        }
        return null;
    }
}
