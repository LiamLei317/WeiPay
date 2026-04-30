package com.weipay.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 基础数据传输对象（DTO）
 * 用于接收前端请求参数
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;
}
