package com.wise.mall.v1.order.domain.vo

data class OrderItemToCreate(
    val productId: Long,
    val quantity: Int,
) {
}