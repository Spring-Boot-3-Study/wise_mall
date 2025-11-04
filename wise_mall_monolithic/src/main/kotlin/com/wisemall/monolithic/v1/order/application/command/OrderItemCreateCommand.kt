package com.wise.mall.v1.order.application.command

data class OrderItemCreateCommand(
    val productId: Long,
    val quantity: Int,
) {
}