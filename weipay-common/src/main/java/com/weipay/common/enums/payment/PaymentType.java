package com.weipay.common.enums.payment;

import lombok.Getter;

@Getter
public enum PaymentType {
    ONE_TIME("one_time", ""),
    PRE_AUTH("pre_auth", ""),
    SUBSCRIPTION("subscription", ""),
    SETUP("setup", ""),
    EXPRESS_LINK("express_link", "")
    ;
    private final String code;
    private final String desc;

    PaymentType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
