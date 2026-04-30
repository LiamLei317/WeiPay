package com.weipay.front.stripe.service.stripe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.model.PaymentIntent;
import com.stripe.model.StripeCollection;
import com.stripe.param.PaymentIntentCancelParams;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentIncrementAuthorizationParams;
import com.stripe.param.PaymentIntentListParams;
import com.stripe.param.PaymentIntentUpdateParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Stripe PaymentIntent 服务类
 * 专门用于调用 Stripe 的 PaymentIntent API
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@Service
public class StripePaymentIntentService extends AbstractCommonStripeService {

    @Autowired
    private ObjectMapper objectMapper;

    public PaymentIntent createPaymentIntent(String apikey, PaymentIntentCreateParams params) {
        log.info("create payment intent params:{}", params);
        try {
            PaymentIntent paymentIntent = super.getStripeClient(apikey).v1().paymentIntents().create(params);
            if (ObjectUtils.isEmpty(paymentIntent)) {
                throw new RuntimeException("create payment intent is null");
            }
            return paymentIntent;
        } catch (Exception e) {
            log.error("创建 PaymentIntent 失败", e);
            throw new RuntimeException("创建 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    public PaymentIntent confirmPaymentIntent(String apiKey, String paymentIntentId, PaymentIntentConfirmParams params) {
        log.info("confirm payment intent params:{}", params);
        try {
            PaymentIntent confirm = super.getStripeClient(apiKey).v1().paymentIntents().confirm(paymentIntentId, params);
            return confirm;
        } catch (Exception e) {
            log.error("确认 PaymentIntent 失败", e);
            throw new RuntimeException("确认 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    public PaymentIntent retrievePaymentIntent(String apiKey, String paymentIntentId) {
        log.info("retrieve PaymentIntent，paymentIntentId: {}", paymentIntentId);
        try {
            return super.getStripeClient(apiKey).v1().paymentIntents().retrieve(paymentIntentId);
        } catch (Exception e) {
            log.error("查询 PaymentIntent 失败", e);
            throw new RuntimeException("查询 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    /**
     * 更新 PaymentIntent
     *
     * @param apiKey Stripe API Key
     * @param paymentIntentId PaymentIntent ID
     * @param params 更新参数
     * @return PaymentIntent
     */
    public PaymentIntent updatePaymentIntent(String apiKey, String paymentIntentId, PaymentIntentUpdateParams params) {
        log.info("更新 PaymentIntent，paymentIntentId: {}, params: {}", paymentIntentId, params);
        try {
            PaymentIntent paymentIntent = super.getStripeClient(apiKey).v1().paymentIntents().update(paymentIntentId, params);
            if (ObjectUtils.isEmpty(paymentIntent)) {
                throw new RuntimeException("update payment intent is null");
            }
            return paymentIntent;
        } catch (Exception e) {
            log.error("更新 PaymentIntent 失败", e);
            throw new RuntimeException("更新 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    /**
     * 取消 PaymentIntent
     *
     * @param apiKey Stripe API Key
     * @param paymentIntentId PaymentIntent ID
     * @param params 取消参数
     * @return PaymentIntent
     */
    public PaymentIntent cancelPaymentIntent(String apiKey, String paymentIntentId, PaymentIntentCancelParams params) {
        log.info("取消 PaymentIntent，paymentIntentId: {}, params: {}", paymentIntentId, params);
        try {
            PaymentIntent paymentIntent = super.getStripeClient(apiKey).v1().paymentIntents().cancel(paymentIntentId, params);
            if (ObjectUtils.isEmpty(paymentIntent)) {
                throw new RuntimeException("cancel payment intent is null");
            }
            return paymentIntent;
        } catch (Exception e) {
            log.error("取消 PaymentIntent 失败", e);
            throw new RuntimeException("取消 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    /**
     * 捕获 PaymentIntent（用于手动捕获模式）
     *
     * @param apiKey Stripe API Key
     * @param paymentIntentId PaymentIntent ID
     * @return PaymentIntent
     */
    public PaymentIntent capturePaymentIntent(String apiKey, String paymentIntentId) {
        log.info("捕获 PaymentIntent，paymentIntentId: {}", paymentIntentId);
        try {
            PaymentIntent paymentIntent = super.getStripeClient(apiKey).v1().paymentIntents().capture(paymentIntentId);
            if (ObjectUtils.isEmpty(paymentIntent)) {
                throw new RuntimeException("capture payment intent is null");
            }
            return paymentIntent;
        } catch (Exception e) {
            log.error("捕获 PaymentIntent 失败", e);
            throw new RuntimeException("捕获 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    /**
     * 列出 PaymentIntent
     *
     * @param apiKey Stripe API Key
     * @param params 列表查询参数
     * @return PaymentIntentCollection
     */
    public List<PaymentIntent> listPaymentIntents(String apiKey, PaymentIntentListParams params) {
        log.info("列出 PaymentIntent，params: {}", params);
        try {
            StripeCollection<PaymentIntent> list = super.getStripeClient(apiKey).v1().paymentIntents().list();
            return list.getData();
        } catch (Exception e) {
            log.error("列出 PaymentIntent 失败", e);
            throw new RuntimeException("列出 PaymentIntent 失败: " + e.getMessage(), e);
        }
    }

    /**
     * 增加 PaymentIntent 授权金额
     *
     * @param apiKey Stripe API Key
     * @param paymentIntentId PaymentIntent ID
     * @param params 增加授权金额参数
     * @return PaymentIntent
     */
    public PaymentIntent incrementAuthorization(String apiKey, String paymentIntentId, PaymentIntentIncrementAuthorizationParams params) {
        log.info("增加 PaymentIntent 授权金额，paymentIntentId: {}, params: {}", paymentIntentId, params);
        try {
            PaymentIntent paymentIntent = super.getStripeClient(apiKey).v1().paymentIntents().incrementAuthorization(paymentIntentId, params);
            if (ObjectUtils.isEmpty(paymentIntent)) {
                throw new RuntimeException("increment authorization is null");
            }
            return paymentIntent;
        } catch (Exception e) {
            log.error("增加 PaymentIntent 授权金额失败", e);
            throw new RuntimeException("增加 PaymentIntent 授权金额失败: " + e.getMessage(), e);
        }
    }
}
