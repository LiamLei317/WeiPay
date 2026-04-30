package com.weipay.front.paypal.service;

import com.weipay.front.paypal.dto.PaypalPaymentDTO;
import com.weipay.front.paypal.dto.PaypalRefundDTO;
import com.weipay.front.paypal.vo.PaypalPaymentVO;
import com.weipay.front.paypal.vo.PaypalRefundVO;

/**
 * PayPal 支付服务接口
 * 
 * @author WeiPay
 * @since 1.0.0
 */
public interface PaypalPaymentService {

    /**
     * 创建支付订单
     * 
     * @param paymentDTO 支付请求DTO
     * @return 支付响应VO
     */
    PaypalPaymentVO createPayment(PaypalPaymentDTO paymentDTO);

    /**
     * 执行支付
     * 
     * @param paymentId 支付ID
     * @param payerId 付款人ID
     * @return 支付响应VO
     */
    PaypalPaymentVO executePayment(String paymentId, String payerId);

    /**
     * 查询支付状态
     * 
     * @param paymentId 支付ID
     * @return 支付响应VO
     */
    PaypalPaymentVO getPaymentStatus(String paymentId);

    /**
     * 创建退款
     * 
     * @param refundDTO 退款请求DTO
     * @return 退款响应VO
     */
    PaypalRefundVO createRefund(PaypalRefundDTO refundDTO);

    /**
     * 查询退款状态
     * 
     * @param refundId 退款ID
     * @return 退款响应VO
     */
    PaypalRefundVO getRefundStatus(String refundId);
}
