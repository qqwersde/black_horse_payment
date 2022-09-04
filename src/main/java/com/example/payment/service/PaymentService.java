package com.example.payment.service;

import com.example.payment.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public PaymentResponse payment(PaymentRequest paymentRequest) {
        if(paymentRequest.getPayerAccount().equals("runTimeAccount")){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(paymentRequest.getPayerAccount().equals("wrongPayAccount")){
            throw new BusinessException("pay account is wrong", HttpStatus.BAD_REQUEST);
        }
        if(paymentRequest.getPayerPhone().length()!=11){
            throw new BusinessException("payer phone is wrong", HttpStatus.BAD_REQUEST);
        }else {
            return PaymentResponse.builder().paymentId("1").transactionNo(paymentRequest.getTransactionNo())
                    .code(0).msg("success").build();
        }
    }

    public PaymentResponse searchPayment(String transactionNo) {
        if(!transactionNo.equals("P001")){
            return PaymentResponse.builder().paymentId("2").transactionNo(transactionNo).code(-1).msg("failed").build();
        }else {
            return PaymentResponse.builder().paymentId("3").transactionNo(transactionNo).code(0).msg("success").build();
        }
    }

    public PaymentResponse refund(String transactionNo) {
        return PaymentResponse.builder().paymentId("P001").transactionNo(transactionNo).code(0).msg("success").build();
    }
}
