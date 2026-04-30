package com.weipay.channel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 卡组织枚举
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CardOrganizationEnum {

    /**
     * VISA
     */
    VISA("VISA", "VISA"),

    /**
     * MasterCard
     */
    MASTER("MASTER", "MasterCard"),

    /**
     * American Express
     */
    AMEX("AMEX", "American Express"),

    /**
     * JCB
     */
    JCB("JCB", "JCB"),

    /**
     * Discover
     */
    DISCOVER("DISCOVER", "Discover"),

    /**
     * UnionPay
     */
    UNIONPAY("UNIONPAY", "银联");

    /**
     * 卡组织代码
     */
    private final String code;

    /**
     * 卡组织名称
     */
    private final String name;

    /**
     * 根据代码获取枚举
     * 
     * @param code 卡组织代码
     * @return 卡组织枚举
     */
    public static CardOrganizationEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (CardOrganizationEnum organizationEnum : values()) {
            if (organizationEnum.getCode().equals(code)) {
                return organizationEnum;
            }
        }
        return null;
    }
}
