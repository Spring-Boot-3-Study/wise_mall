package com.wise.mall.order.domain.vo

data class OrderItemToCreate(
    val productId: Long,
    val quantity: Int,
) {
}