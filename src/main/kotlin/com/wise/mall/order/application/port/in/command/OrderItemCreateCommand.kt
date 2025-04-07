package com.wise.mall.order.application.port.`in`.command

data class OrderItemCreateCommand(
    val productId: String,
    val quantity: Int,
) {
}