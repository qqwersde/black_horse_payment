package com.example.payment.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String payerPhone;
    private String payerAccount;
    private String payerName;
    private double depositAmount;
    private String payNo;

}
