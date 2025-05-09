package com.wise.mall.order.web.dto.request

import com.wise.mall.order.command.OrderItemCreateCommand

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
