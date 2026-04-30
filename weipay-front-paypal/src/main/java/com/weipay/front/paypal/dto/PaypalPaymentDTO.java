package com.weipay.front.paypal.dto;

import com.weipay.common.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * PayPal 支付请求 DTO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaypalPaymentDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 支付描述
     */
    private String description;

    /**
     * 客户邮箱
     */
    private String customerEmail;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品数量
     */
    private Integer itemQuantity;

    /**
     * 回调地址
     */
    private String returnUrl;

    /**
     * 取消地址
     */
    private String cancelUrl;
}
