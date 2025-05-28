package com.wise.mall.payment.web.dto.request

data class ApprovePaymentRequestDto(
    val paymentId: Long,
    val tid: String,
    val pgToken: String,
)
