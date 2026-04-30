package com.weipay.channel.entity;

import com.weipay.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 渠道信息实体类
 * 对应表：channel_chan_info
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Channel extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 渠道编码（如 VISA、MASTER、LINK）
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 渠道类型（1-卡组织，2-第三方支付）
     */
    private Integer channelType;

    /**
     * 卡组织（VISA、MASTER、AMEX、JCB等）
     */
    private String cardOrganization;

    /**
     * 支持的币种（逗号分隔，如 USD,EUR,GBP）
     */
    private String supportedCurrencies;

    /**
     * 接入地址
     */
    private String apiUrl;

    /**
     * 回调地址
     */
    private String callbackUrl;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 状态（0-禁用，1-启用）
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 备注
     */
    private String remark;
}
