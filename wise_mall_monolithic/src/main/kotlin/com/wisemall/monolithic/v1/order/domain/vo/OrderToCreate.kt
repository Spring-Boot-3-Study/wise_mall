package com.wise.mall.v1.order.domain.vo

import com.wise.mall.v1.global.vo.Address

data class OrderToCreate(
    val accountId: String,
    val orderItem: List<OrderItemToCreate>,
    val address: Address,
) {
}