package com.wise.mall.payment.model

import java.time.LocalDateTime

data class Payment (
    val id: Long? = null,

    val orderId : Long,

    val accountId : Long,

    var paymentCode: String,

    var price: Int,

    var status: PaymentStatus,

    var method: String,

    var createdAt: LocalDateTime ?= null,

    var tid : String ?= null,

    var approvedAt: LocalDateTime ?= null,
)
enum class PaymentStatus{
    SUCCESS,
    FAILED,
    PENDING,
    CANCELLED;
    companion object {
        fun fromPgCode(code: String): PaymentStatus {
            return when (code){
                "SUCCESS" -> SUCCESS
                "FAILED" -> FAILED
                "CANCELLED" -> CANCELLED
                "PENDING" -> PENDING
                else -> throw Exception("Unknown PG Code: $code")
            }
        }
    }
}