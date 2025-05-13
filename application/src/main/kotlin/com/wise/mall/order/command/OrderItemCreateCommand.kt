package com.wise.mall.order.command

data class OrderItemCreateCommand(
    val productId: Long,
    val quantity: Int,
) {
}