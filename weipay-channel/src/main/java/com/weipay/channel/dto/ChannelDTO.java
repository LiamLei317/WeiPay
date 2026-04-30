package com.weipay.channel.dto;

import com.weipay.common.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 渠道DTO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道类型
     */
    private Integer channelType;

    /**
     * 卡组织
     */
    private String cardOrganization;

    /**
     * 支持的币种
     */
    private String supportedCurrencies;

    /**
     * 状态
     */
    private Integer status;
}
