package com.wisemall.monolithic.v1.order.api.dto.request

import com.wisemall.monolithic.v1.global.vo.Address
import com.wisemall.monolithic.v1.order.api.dto.OrderCreateCommand

data class OrderCreateRequest(
    val accountId: Long,
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
