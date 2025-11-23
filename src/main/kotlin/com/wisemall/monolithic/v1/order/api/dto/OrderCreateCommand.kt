package com.wisemall.monolithic.v1.order.api.dto

import com.wisemall.monolithic.v1.global.vo.Address

data class OrderCreateCommand(
    val accountId: Long,
    val orderItem: List<OrderItemCreateCommand>,
    val address: Address,
) {

}