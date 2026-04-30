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
public class OneTimePayment extends AbstractPayment {
    public OneTimePayment(List<PaymentMethodBuilder> builders) {
        super(builders);
    }

    @Override
    protected boolean needConfirm() {
        return true;
    }

    @Override
    protected PaymentIntentCreateParams.Builder createBaseParamsBuilder(ChannelPaymentRequest request) {
        return PaymentIntentCreateParams.builder()
                .setAmount(request.getAmount().longValue())
                .setCurrency(request.getCurrency().toLowerCase())
                .setConfirm(false);
    }

    @Override
    protected PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest request) {
        return PaymentIntentConfirmParams.builder()
                .setPaymentMethod(request.getPaymentMethodId())
                .setReturnUrl(request.getReturnUrl())
                .build();
    }

    @Override
    public PaymentType getType() {
        return PaymentType.ONE_TIME;
    }
}
