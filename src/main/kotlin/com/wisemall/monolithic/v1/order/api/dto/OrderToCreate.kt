package com.wisemall.monolithic.v1.order.api.dto

import com.wisemall.monolithic.v1.global.vo.Address

data class OrderToCreate(
    val accountId: Long,
    val orderItem: List<OrderItemToCreate>,
    val address: Address,
) {
}