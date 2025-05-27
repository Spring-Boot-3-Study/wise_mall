package com.wise.mall.payment.web.dto.request

data class ApprovePaymentRequestDto(
    val orderId : Long,
    val accountId : Long,
    val paymentCode: String,
    val method : String,
    val price : Int,
)
