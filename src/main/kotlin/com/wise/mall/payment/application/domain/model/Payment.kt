package com.wise.mall.payment.application.domain.model

import java.time.LocalDateTime

data class Payment (
    val id: Long? = null,

    val orderId : Long,

    val accountId : Long,

    var paymentCode: String,

    var price: Int,

    var status: Char,

    var method: String,

    var createdAt: LocalDateTime ?= null,


)