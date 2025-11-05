package com.wisemall.monolithic.v1.order.api.dto

data class OrderItemToCreate(
    val productId: Long,
    val quantity: Int,
) {
}