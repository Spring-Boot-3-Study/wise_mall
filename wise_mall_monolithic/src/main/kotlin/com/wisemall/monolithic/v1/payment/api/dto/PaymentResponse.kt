package com.wisemall.monolithic.v1.payment.api.dto

data class PaymentResponse (
    val id: Long,
    val orderId: Long,
    val amount: Double,
    val status: String,
    val paymentType: String,
    val transactionId: String,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String? = null,
) {
}