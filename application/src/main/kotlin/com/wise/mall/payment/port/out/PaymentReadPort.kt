package com.wise.mall.payment.port.out

import com.wise.mall.payment.application.domain.model.Payment

interface PaymentReadPort {
    fun getPaymentById(paymentId : Long) : Payment
    fun getPaymentsByAccountId(accountId : Long) : List<Payment>
}