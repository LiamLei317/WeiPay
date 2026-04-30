package com.weipay.front.paypal.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * PayPal 配置类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "paypal")
public class PaypalConfig {

    /**
     * PayPal 客户端ID
     */
    private String clientId;

    /**
     * PayPal 客户端密钥
     */
    private String clientSecret;

    /**
     * PayPal 模式（sandbox/live）
     */
    private String mode = "sandbox";

    /**
     * PayPal API 基础URL
     */
    private String apiUrl;

    /**
     * PayPal Webhook ID
     */
    private String webhookId;

    /**
     * 创建 PayPal API 上下文
     * 
     * @return APIContext
     * @throws PayPalRESTException PayPal 异常
     */
    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        Map<String, String> sdkConfig = new HashMap<>();
        sdkConfig.put("mode", mode);
        
        if ("sandbox".equals(mode)) {
            sdkConfig.put("service.Endpoint", "https://api-m.sandbox.paypal.com");
        } else {
            sdkConfig.put("service.Endpoint", "https://api-m.paypal.com");
        }
        
        OAuthTokenCredential tokenCredential = new OAuthTokenCredential(clientId, clientSecret, sdkConfig);
        String accessToken = tokenCredential.getAccessToken();
        
        return new APIContext(accessToken, clientId, mode);
    }
}
