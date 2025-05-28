package com.wise.mall.payment.port.out

import com.wise.mall.payment.model.PaymentStatus

interface PGPaymentClient {
    fun approvePayment(tid: String, pgToken: String): PaymentStatus
}