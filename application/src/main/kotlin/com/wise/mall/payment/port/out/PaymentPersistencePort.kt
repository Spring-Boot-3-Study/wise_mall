package com.wise.mall.payment.port.out

import com.wise.mall.payment.model.Payment

interface PaymentPersistencePort {
    fun createPayment(payment: Payment)
}