package com.weipay.front.stripe.service.payment;

import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.weipay.common.enums.payment.PaymentMethodType;
import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;
import com.weipay.front.stripe.service.stripe.StripePaymentIntentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.weipay.front.stripe.utils.PaymentResponseUtils.handlePaymentIntentStatus;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.toMap;

/**
 * 定义支付公共步骤
 */
@Slf4j
@Component
public abstract class AbstractPayment implements PaymentStrategy {

    @Autowired
    private StripePaymentIntentService stripePaymentIntentService;
    private final Map<PaymentMethodType, PaymentMethodBuilder> builderMap;
    public AbstractPayment(List<PaymentMethodBuilder> builders) {
        builderMap = builders.stream().collect(
                toMap(PaymentMethodBuilder::getMethodType, identity())
        );
    }

    @Override
    public ChannelPaymentResponse pay(ChannelPaymentRequest request) {
        // 构建参数（子类自己实现）
        PaymentIntentCreateParams.Builder builder = createBaseParamsBuilder(request);

        PaymentMethodType methodType = request.getPaymentMethodType();
        PaymentMethodBuilder methodBuilder = builderMap.get(methodType);
        if (methodBuilder != null) {
            builder = methodBuilder.apply(builder, request);
        }

        // 3. 构建最终参数
        PaymentIntentCreateParams params = builder.build();
        // 创建 PaymentIntent（公共逻辑）
        PaymentIntent pi = stripePaymentIntentService.createPaymentIntent(request.getApiKey(), params);

        // 确认支付（公共逻辑）
        if (needConfirm()) {
            PaymentIntentConfirmParams confirmParams = buildConfirmParams(request);
            pi = stripePaymentIntentService.confirmPaymentIntent(request.getApiKey(), pi.getId(), confirmParams);
        }
        // 统一结果处理（公共逻辑）
        return buildResponse(pi);
    }

    protected abstract boolean needConfirm();
    protected abstract PaymentIntentCreateParams.Builder createBaseParamsBuilder(ChannelPaymentRequest request);
    protected abstract PaymentIntentConfirmParams buildConfirmParams(ChannelPaymentRequest request);
    private ChannelPaymentResponse buildResponse(PaymentIntent paymentIntent) {
        ChannelPaymentResponse response = new ChannelPaymentResponse();
        response.setChannelTransactionNo(paymentIntent.getId());
        handlePaymentIntentStatus(paymentIntent, response);
        return response;
    }
}
