package com.weipay.front.stripe.utils;

import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.CaptureMethod;
import com.weipay.common.payment.ChannelPaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BuildStripeRequestParamsUtils {

    public PaymentIntentCreateParams buildCreateParams(ChannelPaymentRequest request) {
        PaymentIntentCreateParams.Builder builder = PaymentIntentCreateParams.builder()
                .setAmount(request.getAmount().longValue())
                .setConfirm(request.getConfirm())
                .setCurrency(request.getCurrency());
        if (null != request.getCaptureMethod()) {
            builder.setCaptureMethod(convertCaptureMethod(request.getCaptureMethod()));
        }
        return builder.build();
    }

    public PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest channelPaymentRequest) {
        return PaymentIntentConfirmParams.builder()
                .setPaymentMethod(channelPaymentRequest.getPaymentMethodId())
                .setReturnUrl(channelPaymentRequest.getReturnUrl())
                .build();
    }

    public static PaymentIntentCreateParams.CaptureMethod convertCaptureMethod(CaptureMethod captureMethod) {
        if (captureMethod == CaptureMethod.manual) {
            return PaymentIntentCreateParams.CaptureMethod.MANUAL;
        } else {
            return PaymentIntentCreateParams.CaptureMethod.AUTOMATIC;
        }
    }
}
