package com.wise.mall.order.adapter.`in`.web.dto.request

import com.wise.mall.global.vo.Address
import com.wise.mall.order.application.port.`in`.command.OrderCreateCommand

data class OrderCreateRequest(
    val customerId: String,
    val orderItem: List<OrderItemRequest>,
    val address: Address,
) {

    fun toCommand(): OrderCreateCommand {
        return OrderCreateCommand(
            customerId = this.customerId,
            orderItem = this.orderItem.map { it.toCommand() },
            address = address
        )
    }
}
