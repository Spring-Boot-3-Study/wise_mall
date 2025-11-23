package com.wisemall.monolithic.v1.payment.api.dto

data class PaymentResponse (
    val orderId: Long,
    val amount: Int,
    val status: String,
) {
}