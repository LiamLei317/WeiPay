package com.weipay.common.enums.payment;

import lombok.Getter;

@Getter
public enum PaymentMethodType {
    CARD,           // 卡
    APPLE_PAY,      // ApplePay
    GOOGLE_PAY,     // GooglePay
    LINK,           // Stripe Link
    ALIPAY,         // 支付宝
    WECHAT,         // 微信
    KLARNA,         // 分期
    PAYPAL          // PayPal
}
