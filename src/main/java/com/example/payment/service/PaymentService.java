package com.example.payment.service;

import com.example.payment.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public PaymentResponse payment(PaymentRequest paymentRequest) {
        if(paymentRequest.getPayerPhone().length()!=11){
            throw new BusinessException("payer phone is wrong", HttpStatus.BAD_REQUEST);
        }else {
            return PaymentResponse.builder().paymentId("P001").payNo(paymentRequest.getPayNo()).code(0).msg("success").build();
        }
    }

    public PaymentResponse searchPayment(String transactionNo) {
        if(!transactionNo.equals("P001")){
            return PaymentResponse.builder().paymentId("P002").payNo(transactionNo).code(-1).msg("failed").build();
        }else {
            return PaymentResponse.builder().paymentId("P001").payNo(transactionNo).code(0).msg("success").build();
        }
    }

    public PaymentResponse refund(String transactionNo) {
        return PaymentResponse.builder().paymentId("P001").payNo(transactionNo).code(0).msg("success").build();
    }
}
