package com.weipay.common.exception;

import com.weipay.common.enums.ErrorCodeEnum;
import lombok.Getter;

/**
 * 业务异常类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    public BusinessException(String message) {
        super(message);
        this.code = ErrorCodeEnum.BUSINESS_ERROR.getCode();
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String message) {
        super(message);
        this.code = errorCodeEnum.getCode();
        this.message = message;
    }
}
