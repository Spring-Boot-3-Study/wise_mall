package com.wisemall.monolithic.v1.order.api.dto.request

import com.wisemall.monolithic.v1.order.api.dto.OrderItemCreateCommand

data class OrderItemRequest(
    val productId: Long,
    val quantity: Int,
) {

    fun toCommand(): OrderItemCreateCommand {
        return OrderItemCreateCommand(
            productId = this.productId,
            quantity = this.quantity
        )
    }
}
