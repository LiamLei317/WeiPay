package com.weipay.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未授权"),

    /**
     * 禁止访问
     */
    FORBIDDEN(403, "禁止访问"),

    /**
     * 资源不存在
     */
    NOT_FOUND(404, "资源不存在"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(500, "系统错误"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR(1000, "业务异常"),

    /**
     * 渠道不可用
     */
    CHANNEL_UNAVAILABLE(1001, "渠道不可用"),

    /**
     * 签约信息不存在
     */
    CONTRACT_NOT_FOUND(1002, "签约信息不存在"),

    /**
     * 支付订单不存在
     */
    PAYMENT_ORDER_NOT_FOUND(1003, "支付订单不存在");

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误描述
     */
    private final String message;
}
