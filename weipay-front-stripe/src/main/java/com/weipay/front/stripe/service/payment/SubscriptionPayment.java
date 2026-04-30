package com.weipay.front.stripe.service.payment;

import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.PaymentType;
import com.weipay.common.payment.ChannelPaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SubscriptionPayment extends AbstractPayment {

    public SubscriptionPayment(List<PaymentMethodBuilder> builders) {
        super(builders);
    }

    @Override
    protected boolean needConfirm() {
        return false;
    }

    @Override
    protected PaymentIntentCreateParams.Builder createBaseParamsBuilder(ChannelPaymentRequest request) {
        return null;
    }

    @Override
    protected PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest request) {
        return null;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.SUBSCRIPTION;
    }
}
