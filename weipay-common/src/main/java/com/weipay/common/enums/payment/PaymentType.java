package com.weipay.common.enums.payment;

import lombok.Getter;

@Getter
public enum PaymentType {
    ONE_TIME("one_time", ""),
    AUTHORIZATION("authorization", ""),
    SUBSCRIPTION("subscription", "")
    ;
    private final String code;
    private final String desc;

    PaymentType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
