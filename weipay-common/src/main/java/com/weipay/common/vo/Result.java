package com.weipay.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.weipay.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回结果类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 成功返回（无数据）
     */
    public static <T> Result<T> success() {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 成功返回（有数据）
     * 
     * @param data 数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), data, System.currentTimeMillis());
    }

    /**
     * 成功返回（自定义消息）
     * 
     * @param message 消息
     */
    public static <T> Result<T> success(String message) {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), message, null, System.currentTimeMillis());
    }

    /**
     * 成功返回（自定义消息和数据）
     * 
     * @param message 消息
     * @param data 数据
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ErrorCodeEnum.SUCCESS.getCode(), message, data, System.currentTimeMillis());
    }

    /**
     * 失败返回（默认错误）
     */
    public static <T> Result<T> error() {
        return new Result<>(ErrorCodeEnum.SYSTEM_ERROR.getCode(), ErrorCodeEnum.SYSTEM_ERROR.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 失败返回（自定义消息）
     * 
     * @param message 消息
     */
    public static <T> Result<T> error(String message) {
        return new Result<>(ErrorCodeEnum.SYSTEM_ERROR.getCode(), message, null, System.currentTimeMillis());
    }

    /**
     * 失败返回（错误码枚举）
     * 
     * @param errorCodeEnum 错误码枚举
     */
    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum) {
        return new Result<>(errorCodeEnum.getCode(), errorCodeEnum.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 失败返回（自定义错误码和消息）
     * 
     * @param code 错误码
     * @param message 消息
     */
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null, System.currentTimeMillis());
    }

    /**
     * 判断是否成功
     * 
     * @return true-成功，false-失败
     */
    public boolean isSuccess() {
        return ErrorCodeEnum.SUCCESS.getCode().equals(this.code);
    }
}
