package com.wisemall.monolithic.v1.order.api.dto

data class OrderItemCreateCommand(
    val productId: Long,
    val quantity: Int,
) {
}