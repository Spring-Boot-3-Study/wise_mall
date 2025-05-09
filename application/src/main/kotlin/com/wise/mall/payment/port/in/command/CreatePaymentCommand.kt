package com.wise.mall.payment.port.`in`.command

data class CreatePaymentCommand (
    val orderId : Long,
    val accountId : Long,
    val paymentCode: String,
    val method : String,
    val price : Int
)