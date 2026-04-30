package com.weipay.front.stripe.service.stripe;

import com.stripe.StripeClient;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stripe 抽象公共服务类
 * 提供 Stripe 全局配置和 API Key 管理
 * @author WeiPay
 */
@Slf4j
public abstract class AbstractCommonStripeService {

    private final Map<String, StripeClient> clientMap = new ConcurrentHashMap<>();

    public StripeClient getStripeClient(String apiKey) {
        // 线程安全
        return clientMap.computeIfAbsent(apiKey, StripeClient::new);
    }

}
