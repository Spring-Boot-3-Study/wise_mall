package com.wise.mall.payment.application.domain.model

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

)
enum class PaymentStatus{
    SUCCESS,
    FAILED,
    CANCELLED;
    companion object {
        fun fromPgCode(code: String): PaymentStatus {
            return when (code){
                "SUCCESS" -> SUCCESS
                "FAILED" -> FAILED
                "CANCELLED" -> CANCELLED
                else -> throw Exception("Unknown PG Code: $code")
            }
        }
    }
}