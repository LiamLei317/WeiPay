package com.weipay.front.stripe.config;

import com.stripe.Stripe;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Stripe 配置类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "stripe")
public class StripeConfig {

    /**
     * Stripe API 密钥
     */
    private String apiKey;

    /**
     * Stripe 公钥
     */
    private String publicKey;

    /**
     * Stripe Webhook 密钥
     */
    private String webhookSecret;

    /**
     * API 版本
     */
    private String apiVersion = "2024-06-20";

    /**
     * 初始化 Stripe
     */
    public void init() {
        if (apiKey != null && !apiKey.isEmpty()) {
            Stripe.apiKey = apiKey;
        }
    }
}
