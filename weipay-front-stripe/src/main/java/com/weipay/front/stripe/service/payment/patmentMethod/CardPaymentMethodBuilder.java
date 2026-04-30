package com.weipay.front.stripe.service.payment.patmentMethod;

import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.PaymentMethodType;
import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.front.stripe.service.payment.PaymentMethodBuilder;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentMethodBuilder implements PaymentMethodBuilder {
    @Override
    public PaymentIntentCreateParams.Builder apply(PaymentIntentCreateParams.Builder builder, ChannelPaymentRequest request) {
        return builder;
    }

    @Override
    public PaymentMethodType getMethodType() {
        return PaymentMethodType.CARD;
    }
}
