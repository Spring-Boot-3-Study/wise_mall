package com.wise.mall.v1.order.adapter.`in`.web.dto.request

import com.wise.mall.v1.order.application.command.OrderItemCreateCommand

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
