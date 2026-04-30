package com.weipay.front.paypal.service.impl;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.weipay.common.exception.BusinessException;
import com.weipay.front.paypal.dto.PaypalPaymentDTO;
import com.weipay.front.paypal.dto.PaypalRefundDTO;
import com.weipay.front.paypal.service.PaypalPaymentService;
import com.weipay.front.paypal.vo.PaypalPaymentVO;
import com.weipay.front.paypal.vo.PaypalRefundVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * PayPal 支付服务实现
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PaypalPaymentServiceImpl implements PaypalPaymentService {

    private final APIContext apiContext;

    @Override
    public PaypalPaymentVO createPayment(PaypalPaymentDTO paymentDTO) {
        log.info("创建 PayPal 支付订单，paymentDTO: {}", paymentDTO);
        try {
            Amount amount = new Amount();
            amount.setCurrency(paymentDTO.getCurrency());
            amount.setTotal(paymentDTO.getAmount().toString());

            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setDescription(paymentDTO.getDescription());

            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);

            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);

            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setCancelUrl(paymentDTO.getCancelUrl());
            redirectUrls.setReturnUrl(paymentDTO.getReturnUrl());
            payment.setRedirectUrls(redirectUrls);

            Payment createdPayment = payment.create(apiContext);

            PaypalPaymentVO vo = new PaypalPaymentVO();
            vo.setPaymentId(createdPayment.getId());
            vo.setStatus(createdPayment.getState());
            vo.setAmount(paymentDTO.getAmount().toString());
            vo.setCurrency(paymentDTO.getCurrency());
            vo.setCreateTime(LocalDateTime.now());

            // 获取审批链接
            for (Links link : createdPayment.getLinks()) {
                if ("approval_url".equals(link.getRel())) {
                    vo.setApprovalLink(link.getHref());
                }
            }

            return vo;
        } catch (PayPalRESTException e) {
            log.error("创建 PayPal 支付订单失败", e);
            throw new BusinessException("创建支付订单失败: " + e.getMessage());
        }
    }

    @Override
    public PaypalPaymentVO executePayment(String paymentId, String payerId) {
        log.info("执行 PayPal 支付，paymentId: {}, payerId: {}", paymentId, payerId);
        try {
            Payment payment = new Payment();
            payment.setId(paymentId);

            PaymentExecution paymentExecution = new PaymentExecution();
            paymentExecution.setPayerId(payerId);

            Payment executedPayment = payment.execute(apiContext, paymentExecution);

            PaypalPaymentVO vo = new PaypalPaymentVO();
            vo.setPaymentId(executedPayment.getId());
            vo.setStatus(executedPayment.getState());
            vo.setCreateTime(LocalDateTime.now());

            if (executedPayment.getTransactions() != null && !executedPayment.getTransactions().isEmpty()) {
                Transaction transaction = executedPayment.getTransactions().get(0);
                if (transaction.getAmount() != null) {
                    vo.setAmount(transaction.getAmount().getTotal());
                    vo.setCurrency(transaction.getAmount().getCurrency());
                }
            }

            return vo;
        } catch (PayPalRESTException e) {
            log.error("执行 PayPal 支付失败", e);
            throw new BusinessException("执行支付失败: " + e.getMessage());
        }
    }

    @Override
    public PaypalPaymentVO getPaymentStatus(String paymentId) {
        log.info("查询 PayPal 支付状态，paymentId: {}", paymentId);
        try {
            Payment payment = Payment.get(apiContext, paymentId);

            PaypalPaymentVO vo = new PaypalPaymentVO();
            vo.setPaymentId(payment.getId());
            vo.setStatus(payment.getState());

            if (payment.getTransactions() != null && !payment.getTransactions().isEmpty()) {
                Transaction transaction = payment.getTransactions().get(0);
                if (transaction.getAmount() != null) {
                    vo.setAmount(transaction.getAmount().getTotal());
                    vo.setCurrency(transaction.getAmount().getCurrency());
                }
            }

            return vo;
        } catch (PayPalRESTException e) {
            log.error("查询 PayPal 支付状态失败", e);
            throw new BusinessException("查询支付状态失败: " + e.getMessage());
        }
    }

    @Override
    public PaypalRefundVO createRefund(PaypalRefundDTO refundDTO) {
        log.info("创建 PayPal 退款，refundDTO: {}", refundDTO);
        try {
            Amount amount = new Amount();
            amount.setCurrency(refundDTO.getCurrency());
            amount.setTotal(refundDTO.getAmount().toString());

            RefundRequest refundRequest = new RefundRequest();
            refundRequest.setAmount(amount);

            // 注意：这里需要先获取捕获ID，实际使用时需要根据业务逻辑获取
            Captured captured = new Captured();
            captured.setId(refundDTO.getCaptureId());
            
            Refund refund = captured.refund(apiContext, refundRequest);

            PaypalRefundVO vo = new PaypalRefundVO();
            vo.setRefundId(refund.getId());
            vo.setCaptureId(refundDTO.getCaptureId());
            vo.setStatus(refund.getState());
            vo.setAmount(refundDTO.getAmount().toString());
            vo.setCurrency(refundDTO.getCurrency());
            vo.setReason(refundDTO.getReason());
            vo.setCreateTime(LocalDateTime.now());

            return vo;
        } catch (PayPalRESTException e) {
            log.error("创建 PayPal 退款失败", e);
            throw new BusinessException("创建退款失败: " + e.getMessage());
        }
    }

    @Override
    public PaypalRefundVO getRefundStatus(String refundId) {
        log.info("查询 PayPal 退款状态，refundId: {}", refundId);
        try {
            Refund refund = Refund.get(apiContext, refundId);

            PaypalRefundVO vo = new PaypalRefundVO();
            vo.setRefundId(refund.getId());
            vo.setStatus(refund.getState());
            vo.setCreateTime(LocalDateTime.now());

            if (refund.getAmount() != null) {
                vo.setAmount(refund.getAmount().getTotal());
                vo.setCurrency(refund.getAmount().getCurrency());
            }

            return vo;
        } catch (PayPalRESTException e) {
            log.error("查询 PayPal 退款状态失败", e);
            throw new BusinessException("查询退款状态失败: " + e.getMessage());
        }
    }
}
