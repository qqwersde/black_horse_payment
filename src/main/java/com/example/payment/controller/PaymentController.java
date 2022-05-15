package com.example.payment.controller;

import com.example.payment.service.PaymentRequest;
import com.example.payment.service.PaymentResponse;
import com.example.payment.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("")
    PaymentResponse payment(@RequestBody PaymentRequest paymentRequest){
        return  paymentService.payment(paymentRequest);
    }

    @GetMapping("")
    PaymentResponse searchPayment(@RequestParam("transactionNo") String transactionNo){
        return paymentService.searchPayment(transactionNo);
    }

    @PostMapping("/refund")
    PaymentResponse refundPayment(@RequestParam("transactionNo") String transactionNo){
        return paymentService.refund(transactionNo);
    }

}
