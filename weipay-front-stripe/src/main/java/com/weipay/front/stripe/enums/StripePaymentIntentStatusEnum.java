package com.weipay.front.stripe.enums;

import lombok.Getter;

@Getter
public enum StripePaymentIntentStatusEnum {
    REQUIRES_PAYMENT_METHOD("requires_payment_method", "The PaymentAttempt has been created upon request."),
    REQUIRES_CUSTOMER_ACTION("requires_customer_action", "The PaymentAttempt is waiting for further customer action of authentication, e.g. 3DS verification and QR code scan."),
    REQUIRES_CAPTURE("requires_capture", "The PaymentAttempt authorization request has been accepted and is pending the final result from the provider."),
    PENDING("pending", "The PaymentAttempt has been successfully authorized. It will be captured automatically or require manual capture to complete the payment."),
    SUCCEEDED("succeeded", "The PaymentAttempt has been successfully requested for capture. The payment is complete."),
    CANCELLED("cancelled", "The PaymentAttempt expired after the allowed payment time. Please create a new PaymentAttempt to retry."),
            ;
    private final String code;
    private final String desc;

    StripePaymentIntentStatusEnum(String key, String desc) {
        this.code = key;
        this.desc = desc;
    }

    public String getKey() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
