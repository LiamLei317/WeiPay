package com.weipay.front.stripe.service.payment;

import com.weipay.common.enums.payment.PaymentType;
import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;

public interface PaymentStrategy {

    // 所有支付类型统一入口
    ChannelPaymentResponse pay(ChannelPaymentRequest request);

    // 判断当前策略支持哪种支付类型
    PaymentType getType();
}
