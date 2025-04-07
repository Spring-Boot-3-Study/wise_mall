package com.wise.mall.order.adapter.`in`.web.dto.request

import com.wise.mall.order.application.port.`in`.command.OrderItemCreateCommand

data class OrderItemRequest( val productId: String,
                             val quantity: Int,
                             val subtotal: Int,
) {

    fun toCommand(): OrderItemCreateCommand {
        return OrderItemCreateCommand(
            productId = this.productId,
            quantity = this.quantity
        )
    }
}
