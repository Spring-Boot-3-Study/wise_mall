package com.wise.mall.payment.port.`in`.command

data class ApprovePaymentCommand(
    val paymentId: Long,
    val tid: String,
    val pgToken: String,
)
