package com.wise.mall.payment.adapter.`in`.web.dto.request

data class CreatePaymentRequestDto (
    val orderId : Long,
    val accountId : Long,
    val paymentCode: String,
    val method : String,
    val price : Int,
)