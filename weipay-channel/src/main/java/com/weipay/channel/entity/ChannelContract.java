package com.weipay.channel.entity;

import com.weipay.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 渠道签约信息实体类
 * 对应表：channel_contract
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelContract extends BaseDO {

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
     * 费率（百分比，如 1.5 表示 1.5%）
     */
    private BigDecimal feeRate;

    /**
     * 单笔最低手续费
     */
    private BigDecimal minFee;

    /**
     * 单笔最高手续费
     */
    private BigDecimal maxFee;

    /**
     * 结算周期（天）
     */
    private Integer settlementCycle;

    /**
     * 签约开始时间
     */
    private LocalDateTime contractStartTime;

    /**
     * 签约结束时间
     */
    private LocalDateTime contractEndTime;

    /**
     * 状态（0-禁用，1-启用）
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}
