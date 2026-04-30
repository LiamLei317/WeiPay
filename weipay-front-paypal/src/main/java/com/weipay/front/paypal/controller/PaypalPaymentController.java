package com.weipay.front.paypal.controller;

import com.weipay.front.paypal.dto.PaypalPaymentDTO;
import com.weipay.front.paypal.dto.PaypalRefundDTO;
import com.weipay.front.paypal.service.PaypalPaymentService;
import com.weipay.front.paypal.vo.PaypalPaymentVO;
import com.weipay.front.paypal.vo.PaypalRefundVO;
import com.weipay.common.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * PayPal 支付控制器
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/paypal/payment")
@RequiredArgsConstructor
public class PaypalPaymentController {

    private final PaypalPaymentService paypalPaymentService;

    /**
     * 创建支付订单
     * 
     * @param paymentDTO 支付请求DTO
     * @return 支付响应VO
     */
    @PostMapping("/create")
    public Result<PaypalPaymentVO> createPayment(@RequestBody PaypalPaymentDTO paymentDTO) {
        log.info("创建 PayPal 支付订单，paymentDTO: {}", paymentDTO);
        PaypalPaymentVO paymentVO = paypalPaymentService.createPayment(paymentDTO);
        return Result.success("创建成功", paymentVO);
    }

    /**
     * 执行支付
     * 
     * @param paymentId 支付ID
     * @param payerId 付款人ID
     * @return 支付响应VO
     */
    @PostMapping("/execute")
    public Result<PaypalPaymentVO> executePayment(
            @RequestParam String paymentId,
            @RequestParam String payerId) {
        log.info("执行 PayPal 支付，paymentId: {}, payerId: {}", paymentId, payerId);
        PaypalPaymentVO paymentVO = paypalPaymentService.executePayment(paymentId, payerId);
        return Result.success("支付成功", paymentVO);
    }

    /**
     * 查询支付状态
     * 
     * @param paymentId 支付ID
     * @return 支付响应VO
     */
    @GetMapping("/status/{paymentId}")
    public Result<PaypalPaymentVO> getPaymentStatus(@PathVariable String paymentId) {
        log.info("查询 PayPal 支付状态，paymentId: {}", paymentId);
        PaypalPaymentVO paymentVO = paypalPaymentService.getPaymentStatus(paymentId);
        return Result.success(paymentVO);
    }

    /**
     * 创建退款
     * 
     * @param refundDTO 退款请求DTO
     * @return 退款响应VO
     */
    @PostMapping("/refund/create")
    public Result<PaypalRefundVO> createRefund(@RequestBody PaypalRefundDTO refundDTO) {
        log.info("创建 PayPal 退款，refundDTO: {}", refundDTO);
        PaypalRefundVO refundVO = paypalPaymentService.createRefund(refundDTO);
        return Result.success("退款创建成功", refundVO);
    }

    /**
     * 查询退款状态
     * 
     * @param refundId 退款ID
     * @return 退款响应VO
     */
    @GetMapping("/refund/status/{refundId}")
    public Result<PaypalRefundVO> getRefundStatus(@PathVariable String refundId) {
        log.info("查询 PayPal 退款状态，refundId: {}", refundId);
        PaypalRefundVO refundVO = paypalPaymentService.getRefundStatus(refundId);
        return Result.success(refundVO);
    }
}
