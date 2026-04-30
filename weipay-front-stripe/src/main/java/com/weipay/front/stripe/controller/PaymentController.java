package com.weipay.front.stripe.controller;

import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;
import com.weipay.common.vo.Result;
import com.weipay.front.stripe.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Stripe 支付控制器
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/payment_intents")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public Result<ChannelPaymentResponse> createPaymentIntent(@RequestBody ChannelPaymentRequest request) {
        log.info("支付参数: {}", request);
        ChannelPaymentResponse paymentResponse = paymentService.pay(request);
        return Result.success(paymentResponse);
    }
}
