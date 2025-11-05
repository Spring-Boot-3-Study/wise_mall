package com.wisemall.monolithic.v1.payment.api.dto

import com.wisemall.monolithic.v1.payment.application.enums.PaymentType

data class PaymentRequest (
    val orderId: Long,
    val accountId: Long,
    val paymentType: PaymentType,
    val amount: Int,
) {
}