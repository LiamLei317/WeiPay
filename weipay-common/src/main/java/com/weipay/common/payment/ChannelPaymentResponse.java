package com.weipay.common.payment;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;
import lombok.Getter;

@Data
public class ChannelPaymentResponse {

    private String channelTransactionNo;
    private Status status;
    private String channelOrderId;
    private String extra;


    @Getter
    public enum Status {
        SUCCEEDED("1", "payment success"),
        FAILED("2", "payment failed"),
        PENDING("3", "channel is processing"),
        REQUIRES_ACTION("4", "require customer's next action"),
        REQUIRES_PAYMENT_METHOD("5", "require payment method"),
        REQUIRES_CAPTURE("6", "require capture");

        private final String code;
        private final String desc;

        Status(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

}
