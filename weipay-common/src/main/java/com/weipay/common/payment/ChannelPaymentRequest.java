package com.weipay.common.payment;

import com.weipay.common.enums.payment.CaptureMethod;
import com.weipay.common.enums.payment.PaymentMethodType;
import com.weipay.common.enums.payment.PaymentType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChannelPaymentRequest {

    private BigDecimal amount;
    private String currency;
    private String paymentMethodId;
    private String subAccountId;
    private String apiKey;
    private CaptureMethod captureMethod;
    private Boolean confirm;
    private String returnUrl;
    private PaymentType paymentType;
    private PaymentMethodType paymentMethodType;

}
