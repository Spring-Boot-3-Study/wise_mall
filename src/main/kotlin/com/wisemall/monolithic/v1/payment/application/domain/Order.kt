package com.wisemall.monolithic.v1.payment.application.domain

data class Order (
    val orderId: Long,
    val accountId: Long,
    val amount: Int,
    val status: String
)