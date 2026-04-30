package com.weipay.channel.vo;

import com.weipay.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 渠道签约VO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelContractVO extends BaseVO {

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
     * 渠道名称
     */
    private String channelName;

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
     * 单笔最低手续费
     */
    private BigDecimal minFee;

    /**
     * 单笔最高手续费
     */
    private BigDecimal maxFee;

    /**
     * 结算周期
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
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
