package com.weipay.front.stripe.service.payment;

import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;
import com.weipay.front.stripe.service.stripe.StripePaymentIntentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定义支付公共步骤
 */
@Slf4j
@Component
public abstract class AbstractPayment implements PaymentStrategy {

    @Autowired
    private StripePaymentIntentService stripePaymentIntentService;

    @Override
    public ChannelPaymentResponse pay(ChannelPaymentRequest request) {
        // 构建参数（子类自己实现）
        PaymentIntentCreateParams params = buildParams(request);
        // 创建 PaymentIntent（公共逻辑）
        PaymentIntent pi = stripePaymentIntentService.createPaymentIntent(request.getApiKey(), params);

        // 确认支付（公共逻辑）
        PaymentIntentConfirmParams confirmParams = buildConfirmParams(request);
        pi = stripePaymentIntentService.confirmPaymentIntent(pi.getId(), pi.getId(), confirmParams);

        // 4. 统一结果处理（公共逻辑）
        return buildResponse(pi);
    }

    protected abstract PaymentIntentCreateParams buildParams(ChannelPaymentRequest request);
    protected abstract PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest request);
    private ChannelPaymentResponse buildResponse(PaymentIntent paymentIntent) {
        return new ChannelPaymentResponse();
    }
}
