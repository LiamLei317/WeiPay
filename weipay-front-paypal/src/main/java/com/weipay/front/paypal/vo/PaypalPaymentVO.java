package com.weipay.front.paypal.vo;

import com.weipay.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * PayPal 支付响应 VO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaypalPaymentVO extends BaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * PayPal 支付ID
     */
    private String paymentId;

    /**
     * PayPal 订单ID
     */
    private String orderId;

    /**
     * 审批链接（用于前端跳转）
     */
    private String approvalLink;

    /**
     * 支付金额
     */
    private String amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 支付状态
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
