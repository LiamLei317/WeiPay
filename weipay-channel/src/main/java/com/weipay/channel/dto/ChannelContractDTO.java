package com.weipay.channel.dto;

import com.weipay.common.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 渠道签约DTO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelContractDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 签约ID
     */
    private Long contractId;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 商户号
     */
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 签约币种
     */
    private String currency;

    /**
     * 费率
     */
    private BigDecimal feeRate;

    /**
     * 状态
     */
    private Integer status;
}
