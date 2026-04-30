package com.weipay.front.stripe.service.payment;

import com.weipay.common.enums.payment.PaymentType;
import com.weipay.common.payment.ChannelPaymentRequest;
import com.weipay.common.payment.ChannelPaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory paymentStrategyFactory;

    /**
     * 【上层业务真正调用的统一入口】
     * 不管是 普通支付 / 预授权 / 快捷支付 / 订阅
     * 全部走这一个方法
     */
    public ChannelPaymentResponse pay(ChannelPaymentRequest request) {
        // 获取支付类型
        PaymentType paymentType = request.getPaymentType();
        // 工厂自动找到对应策略
        PaymentStrategy strategy = paymentStrategyFactory.get(paymentType);
        // 执行支付（模板方法自动跑流程）
        return strategy.pay(request);
    }
}
