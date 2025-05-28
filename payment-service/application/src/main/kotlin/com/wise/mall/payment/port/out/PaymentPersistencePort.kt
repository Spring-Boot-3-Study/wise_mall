package com.wise.mall.payment.port.out

import com.wise.mall.payment.model.Payment
import com.wise.mall.payment.model.PaymentStatus

interface PaymentPersistencePort {
    fun createPayment(payment: Payment)
    fun updatePayment(paymentId: Long, paymentStatus: PaymentStatus, tid : String)
}