package com.weipay.channel.vo;

import com.weipay.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 渠道VO
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ChannelVO extends BaseVO {

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
     * 渠道类型名称
     */
    private String channelTypeName;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
