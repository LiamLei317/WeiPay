package com.weipay.front.paypal.dto;

import com.weipay.common.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * PayPal 退款请求 DTO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaypalRefundDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * PayPal 捕获ID
     */
    private String captureId;

    /**
     * 退款金额
     */
    private BigDecimal amount;

    /**
     * 币种
     */
    private String currency;

    /**
     * 退款原因
     */
    private String reason;
}
