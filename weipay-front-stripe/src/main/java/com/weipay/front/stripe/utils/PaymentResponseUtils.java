package com.weipay.front.stripe.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.model.PaymentIntent;
import com.weipay.common.payment.ChannelPaymentResponse;
import com.weipay.front.stripe.enums.StripePaymentIntentStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class PaymentResponseUtils {

    private static ObjectMapper objectMapper;

    // 构造注入
    public PaymentResponseUtils(ObjectMapper objectMapper) {
        PaymentResponseUtils.objectMapper = objectMapper;
    }

    public static void processPaymentResult(PaymentIntent paymentIntent, ChannelPaymentResponse response) {
        // 状态映射
        handlePaymentIntentStatus(paymentIntent, response);
        Map<String, String> metadata = paymentIntent.getMetadata();
        response.setChannelOrderId(metadata.get("channelOrderId"));
        response.setChannelTransactionNo(paymentIntent.getId());
        response.setExtra(paymentIntent.toJson());
    }

    public static void handlePaymentIntentStatus(PaymentIntent paymentIntent, ChannelPaymentResponse response) {
        String status = paymentIntent.getStatus();
        if (StripePaymentIntentStatusEnum.SUCCEEDED.getCode().equals(status)) {
            response.setStatus(ChannelPaymentResponse.Status.SUCCEEDED);
        } else if (StripePaymentIntentStatusEnum.REQUIRES_PAYMENT_METHOD.getCode().equals(status)) {
            response.setStatus(ChannelPaymentResponse.Status.REQUIRES_PAYMENT_METHOD);
        } else if (StripePaymentIntentStatusEnum.REQUIRES_CAPTURE.getCode().equals(status)) {
            response.setStatus(ChannelPaymentResponse.Status.REQUIRES_CAPTURE);
        } else if (StripePaymentIntentStatusEnum.PENDING.getCode().equals(status)) {
            response.setStatus(ChannelPaymentResponse.Status.PENDING);
        } else {
            response.setStatus(ChannelPaymentResponse.Status.FAILED);
        }
    }


}
