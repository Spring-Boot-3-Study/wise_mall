package com.wise.mall.payment.dto

import java.time.LocalDateTime

/**
 * DTO for Payment domain model
 */
data class PaymentDto(
    val id: Long? = null,
    val orderId: Long,
    val accountId: Long,
    val paymentCode: String,
    val price: Int,
    val status: String,
    val method: String,
    val createdAt: LocalDateTime? = null
)