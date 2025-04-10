package com.wise.mall.payment.application.port.out

import com.wise.mall.payment.application.domain.model.Payment

interface PaymentPersistencePort {
    fun createPayment(payment: Payment)
}