package com.wisemall.monolithic.v1.order.adapter.`in`.web.dto.request

import com.wisemall.monolithic.v1.global.vo.Address
import com.wisemall.monolithic.v1.order.api.dto.OrderCreateCommand

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
