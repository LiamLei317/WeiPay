package com.weipay.front.stripe.vo;

import com.weipay.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Stripe 退款响应 VO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StripeRefundVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * 退款ID
     */
    private String refundId;

    /**
     * 支付意图ID
     */
    private String paymentIntentId;

    /**
     * 退款金额（单位：分）
     */
    private Long amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 退款状态
     */
    private String status;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 创建时间
     */
    private LocalDateTime created;
}
