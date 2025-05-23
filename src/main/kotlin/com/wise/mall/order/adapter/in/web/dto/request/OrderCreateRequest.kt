package com.wise.mall.order.adapter.`in`.web.dto.request

import com.wise.mall.global.vo.Address
import com.wise.mall.order.application.command.OrderCreateCommand

data class OrderCreateRequest(
    val accountId: String,
    val orderItem: List<OrderItemRequest>,
    val address: Address,
) {

    fun toCommand(): OrderCreateCommand {
        return OrderCreateCommand(
            accountId = this.accountId,
            orderItem = this.orderItem.map { it.toCommand() },
            address = address
        )
    }
}
