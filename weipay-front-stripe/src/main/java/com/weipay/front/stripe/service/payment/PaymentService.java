package com.weipay.front.stripe.service.payment;

import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {


    private final PaymentStrategyFactory factory;

    public ChannelPaymentResponse pay(ChannelPaymentRequest request) {
        PaymentStrategy strategy = factory.get(request.getPaymentType());
        return strategy.pay(request);
    }
}
