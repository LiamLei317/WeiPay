package com.weipay.front.stripe.vo;

import com.weipay.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Stripe 支付响应 VO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StripePaymentVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * Stripe 支付意图ID
     */
    private String paymentIntentId;

    /**
     * 支付金额（单位：分）
     */
    private Long amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 客户端密钥（用于前端确认支付）
     */
    private String clientSecret;

    /**
     * 支付方式
     */
    private String paymentMethod;

    /**
     * 创建时间
     */
    private LocalDateTime created;
}
