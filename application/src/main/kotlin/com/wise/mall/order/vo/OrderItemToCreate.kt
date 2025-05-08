package com.wise.mall.order.vo

data class OrderItemToCreate(
    val productId: Long,
    val quantity: Int,
) {
}