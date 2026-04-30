package com.weipay.front.stripe.service.payment;

import com.weipay.common.enums.payment.PaymentType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {

    private final Map<PaymentType, PaymentStrategy> strategyMap;

    // Spring 自动注入所有策略
    public PaymentStrategyFactory(List<PaymentStrategy> list) {
        strategyMap = list.stream().collect(Collectors.toMap(PaymentStrategy::getType, Function.identity()));
    }

    public PaymentStrategy get(PaymentType type) {
        return strategyMap.get(type);
    }
}
