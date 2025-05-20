package com.wise.mall.order.web.dto.request


import com.wise.mall.common.vo.Address
import com.wise.mall.order.command.OrderCreateCommand

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
