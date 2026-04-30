package com.weipay.front.stripe.service.payment;

import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.PaymentMethodType;
import com.weipay.common.payment.ChannelPaymentRequest;

public interface PaymentMethodBuilder {
    // 给 PaymentIntent 追加支付方式专属参数
    PaymentIntentCreateParams.Builder apply(
            PaymentIntentCreateParams.Builder builder,
            ChannelPaymentRequest request
    );

    // 当前构建器支持哪种支付方式
    PaymentMethodType getMethodType();
}
