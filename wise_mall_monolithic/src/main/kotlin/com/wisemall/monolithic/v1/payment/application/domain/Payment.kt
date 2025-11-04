package com.wisemall.monolithic.v1.payment.application.domain

import com.wisemall.monolithic.v1.payment.application.enums.PaymentStatus
import com.wisemall.monolithic.v1.payment.application.enums.PaymentType

class Payment (
    val id: Long,
    val userId: Long,
    val orderId: Long,
    val amount: Double,
    val status: PaymentStatus,
    val paymentType: PaymentType,
    val transactionId: String,
) {
}