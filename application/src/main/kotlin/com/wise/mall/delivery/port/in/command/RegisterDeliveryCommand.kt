package com.wise.mall.delivery.port.`in`.command

data class RegisterDeliveryCommand(
    val orderId: String,
    val courier: String,
    val trackNumber: String,
)
