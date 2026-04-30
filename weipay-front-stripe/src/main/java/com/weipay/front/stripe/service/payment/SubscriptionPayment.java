package com.weipay.front.stripe.service.payment;

import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.PaymentType;
import com.weipay.common.payment.ChannelPaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscriptionPayment extends AbstractPayment {

    @Override
    protected PaymentIntentCreateParams buildParams(ChannelPaymentRequest request) {
        return null;
    }

    @Override
    protected PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest request) {
        return null;
    }

    @Override
    public PaymentType getType() {
        return null;
    }
}
