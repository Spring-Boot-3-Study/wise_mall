package com.wise.mall.delivery.application.domain.model.simulation

import java.time.LocalDateTime

data class Shipping(
    val trackingNumber: String,

    val orderId: String,

    var status: String,

    val createdAt: LocalDateTime,

    var updatedAt: LocalDateTime
){

}
