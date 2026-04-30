package com.weipay.common.constant;

/**
 * 状态常量类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public class StatusConstant {

    /**
     * 启用状态
     */
    public static final Integer ENABLED = 1;

    /**
     * 禁用状态
     */
    public static final Integer DISABLED = 0;

    /**
     * 删除状态 - 未删除
     */
    public static final Integer NOT_DELETED = 0;

    /**
     * 删除状态 - 已删除
     */
    public static final Integer DELETED = 1;

    private StatusConstant() {
    }
}
