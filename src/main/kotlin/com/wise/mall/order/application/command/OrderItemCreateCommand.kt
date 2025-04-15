package com.wise.mall.order.application.command

data class OrderItemCreateCommand(
    val productId: Long,
    val quantity: Int,
) {
}