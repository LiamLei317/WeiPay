package com.weipay.channel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 渠道类型枚举
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ChannelTypeEnum {

    /**
     * 卡组织
     */
    CARD_ORGANIZATION(1, "卡组织"),

    /**
     * 第三方支付
     */
    THIRD_PARTY_PAYMENT(2, "第三方支付");

    /**
     * 类型码
     */
    private final Integer code;

    /**
     * 类型描述
     */
    private final String desc;

    /**
     * 根据代码获取枚举
     * 
     * @param code 类型码
     * @return 渠道类型枚举
     */
    public static ChannelTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (ChannelTypeEnum typeEnum : values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
